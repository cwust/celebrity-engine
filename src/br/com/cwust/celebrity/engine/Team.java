package br.com.cwust.celebrity.engine;

import java.util.LinkedHashSet;
import java.util.Set;

import br.com.cwust.celebrity.engine.dto.TeamInfo;

public class Team {
	private int teamNumber;
	private Set<Player> players;

	public Team(int teamNumber) {
		this.teamNumber = teamNumber;
		this.players = new LinkedHashSet<>(); //to keep order
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public TeamInfo convertToTeamInfoDTO() {
		TeamInfo teamInfo = new TeamInfo();
		teamInfo.setTeamNumber(this.teamNumber);
		
		teamInfo.setPlayers(Util.toArrayConverted(this.getPlayers(), Player::convertToPlayerInfoDTO));
		
		return teamInfo;
	}
	
	public void removePlayer(Player player) {
		boolean removed = this.getPlayers().remove(player);
		if (!removed) {
			throw new CelebrityException(String.format("Could not remove player %s from team %d", player.getPlayerId(),
					this.getTeamNumber()));
		}
	}
	
	public void addPlayer(Player player) {
		boolean added = this.getPlayers().add(player);
		if (!added) {
			throw new CelebrityException(String.format("Player %s was already added to team %d", player.getPlayerId(),
					this.getTeamNumber()));
		}
	}
}
