package com.interview.websoc.service;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocketexample2")
public class WebSocketExample2 {
	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	static ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void onOpen(Session session) {
		System.err.println("Open connection.....");
		clients.add(session);
	}

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.err.println("onMessage().....");
		synchronized (clients) {
			// Iterate over the connected sessions
			// and broadcast the received message
			for (Session client : clients) {
				if (!client.equals(session)) {
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}

	@OnClose
	public void onClose(Session session) {
		System.err.println("Client is disconnected...");
		clients.remove(session);
	}

	@OnError
	public void onError(Throwable t) {
		t.printStackTrace();
	}

}
