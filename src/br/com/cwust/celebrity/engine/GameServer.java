package br.com.cwust.celebrity.engine;

import java.io.Serializable;
import java.util.List;

public class GameServer {
	private String thisPlayerId;
	private List<String> otherPlayerIds;

	public void broadcastMessageToAll(BroadcastEvent event, Serializable payload) {
		System.out.printf("broadcastMessageToAll:Event=%s;payload=%s%n", event.toString(), payload.toString());
	}
}
