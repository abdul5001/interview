package com.interview.websoc.service;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocketexample")
public class WebSocketExample {
	@OnOpen
	public void onOpen(Session session) {
		System.err.println("Open connection.....");
	}	
	
	@OnMessage
	public String onMessage(String message) {
		System.err.println("receive from client .." + message);
		String replyMsg = "echo " + message;
		System.err.println("Send to client : " + replyMsg);
		return replyMsg;
	} 	
		
	@OnClose
	public void onClose() {
		System.err.println("Client is disconnected...");
	}
	
	@OnError
	public void onError(Throwable t) {
		t.printStackTrace();
	}

}
