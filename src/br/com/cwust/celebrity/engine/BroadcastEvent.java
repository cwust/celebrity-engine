package br.com.cwust.celebrity.engine;

public enum BroadcastEvent {
	GAME_CONFIG_CHANGED(1);

	private int id;

	private BroadcastEvent(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}

