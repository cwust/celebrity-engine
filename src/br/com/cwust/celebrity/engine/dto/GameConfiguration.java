package br.com.cwust.celebrity.engine.dto;

import java.io.Serializable;

public class GameConfiguration implements Serializable{
	private static final long serialVersionUID = 361397605703759504L;

	private PlayerInfo[] unassignedPlayers;
	private TeamInfo[] teams;

	public PlayerInfo[] getUnassignedPlayers() {
		return unassignedPlayers;
	}

	public void setUnassignedPlayers(PlayerInfo[] unassignedPlayers) {
		this.unassignedPlayers = unassignedPlayers;
	}

	public TeamInfo[] getTeams() {
		return teams;
	}

	public void setTeams(TeamInfo[] teams) {
		this.teams = teams;
	}

}
