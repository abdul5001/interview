<HTML>
<HEAD>

<title>INTERVIEWS</title>
<style>

</style>
<script>

</script>

</HEAD>
<BODY leftmargin="0" rightmargin="0" topmargin="0" marginheight="0">
	<table>
	<tr>
		<td><input type="text" id="txtMessage" value="" size="30"/></td>
		<td><input type="button" name="btnSend" value=" Send " size="15" onClick="sendMessage();"/></td>
		<td><input type="button" name="btnClose" value=" Close " size="15" onClick="closeMessage();"/></td>
	</tr>
	<tr>
		<td>
		<textarea rows="10" cols="40" id="msgHistory"></textarea>
		</td>
	</tr>
	</table>
	
	<script type="text/javascript">
		var webSocket = new WebSocket("ws://localhost:8084/interview/websocketexample");
		var msgHistory = document.getElementById("msgHistory");
		var txtMessage = document.getElementById("txtMessage");
		
		webSocket.onopen = function (message) {	processOpen(message); };
		webSocket.onmessage = function (message) { processMessage(message);	};
		webSocket.onclose = function (message) { processClose(message); };
		webSocket.onerror = function (message) { processError(message);	};
		
		function closeMessage() {
			msgHistory.value = msgHistory.value + "Closed connection.. \n";
			webSocket.close();
		}
		
		function sendMessage() {
			msgHistory.value = msgHistory.value + "Sending data.."+ txtMessage.value + " \n";
			webSocket.send(txtMessage.value);
		}
		
		function processOpen(message) {
			msgHistory.value = msgHistory.value + "Server connect....\n";
		}
		
		function processMessage(message) {
			msgHistory.value = msgHistory.value + "Received from server..." + message.data+"\n";
		}
		
		function processClose(message) {
			msgHistory.value = msgHistory.value + "Client disconnected...\n";
		}
		
		function processError(message) {
			msgHistory.value = msgHistory.value + "Server error...\n";
		}
	</script>
</BODY>
</HTML>
