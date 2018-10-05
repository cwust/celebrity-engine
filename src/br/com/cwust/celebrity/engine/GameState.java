package br.com.cwust.celebrity.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.cwust.celebrity.engine.dto.GameConfiguration;


public class GameState {
	private GameServer server;
	private Map<String, Player> playersMap;
	private List<Player> unassignedPlayers;
	private List<Team> teams;
	
	public void init(GameServer server, List<Player> players) {
		this.server = server;
		this.playersMap = players.stream()
				.collect(Collectors.toMap(
						Player::getPlayerId, 
						Function.identity()));
		this.unassignedPlayers = new ArrayList<>(players);
		this.teams = new ArrayList<>();
	}
	
	public Team createTeam() {
		Team team = new Team(this.teams.size() + 1);
		this.teams.add(team);
		return team;
	}
	
	private GameConfiguration convertToGameConfigurationDTO() {
		GameConfiguration gameConfig = new GameConfiguration();
		
		gameConfig.setUnassignedPlayers(Util.toArrayConverted(this.unassignedPlayers, Player::convertToPlayerInfoDTO));
		gameConfig.setTeams(Util.toArrayConverted(this.teams, Team::convertToTeamInfoDTO));
		
		return gameConfig;
	}
	
	private void broadcastGameConfigurationChanged() {
		this.server.broadcastMessageToAll(
				BroadcastEvent.GAME_CONFIG_CHANGED,
				this.convertToGameConfigurationDTO());
	}
	
	public void chooseTeam(String playerId, int teamNumber) {
		Player player = this.getPlayer(playerId);
		
		if (player.getTeam() == null) {
			boolean removed = this.unassignedPlayers.remove(player);
			if (!removed) {
				throw new CelebrityException(String.format("Could not choose team: player %s was not in unassignedPlayers", playerId));
			}
		} else {
			player.getTeam().removePlayer(player);
		}
		
		Team newTeam = this.teams.get(teamNumber - 1);
		newTeam.addPlayer(player);
		player.setTeam(newTeam);
		
		broadcastGameConfigurationChanged();
	}
	
	private Player getPlayer(String playerId) {
		Player player = this.playersMap.get(playerId);
		
		if (player == null) {
			throw new CelebrityException(String.format("Could not find player %s", playerId));
		} else {
			return player;
		}
	}
	
	public void setReady(String playerId, boolean ready) {
		Player player = this.getPlayer(playerId);
		player.setReady(ready);
		broadcastGameConfigurationChanged();
	}
}
