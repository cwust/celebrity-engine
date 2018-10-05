package br.com.cwust.celebrity.engine.dto;

import java.io.Serializable;

public class TeamInfo implements Serializable {
	private static final long serialVersionUID = -7204327900021108031L;
	
	private int teamNumber;
	private PlayerInfo[] players;

	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	public PlayerInfo[] getPlayers() {
		return players;
	}

	public void setPlayers(PlayerInfo[] players) {
		this.players = players;
	}

}
