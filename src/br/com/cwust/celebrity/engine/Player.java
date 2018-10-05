package br.com.cwust.celebrity.engine;

import br.com.cwust.celebrity.engine.dto.PlayerInfo;

public class Player {
	private String playerId;
	private String name;
	private Team team;
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}
	
	public PlayerInfo convertToPlayerInfoDTO() {
		PlayerInfo playerInfo = new PlayerInfo();
		
		playerInfo.setPlayerId(this.playerId);
		playerInfo.setName(this.name);
		playerInfo.setReady(this.ready);

		return playerInfo;
	}
	
	public void leaveTeam() {
		
	}
}
