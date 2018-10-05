package br.com.cwust.celebrity.engine.dto;

import java.io.Serializable;

public class PlayerInfo  implements Serializable {
	private static final long serialVersionUID = -5124240115185924896L;

	private String playerId;
	private String name;
	private boolean ready;

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}
}
