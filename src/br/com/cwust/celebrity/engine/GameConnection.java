package br.com.cwust.celebrity.engine;

import java.util.List;
import java.util.function.Consumer;

import br.com.cwust.celebrity.engine.dto.GameConfiguration;
import br.com.cwust.celebrity.engine.dto.PlayerInfo;

public interface GameConnection {
	public void onRoomConnected(Consumer<List<PlayerInfo>> callback);
	public void onGameSetupUpdated(Consumer<GameConfiguration> callback);
	public void onGameSetupCompleted(Consumer<GameConfiguration> callback);
	
	public void sendChooseMyTeam(int teamNumber);
	public void sendImReady(boolean isReady);
	
}
