package globals;

import player.Player;

public abstract class PlayableEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3398477358319337273L;
	
	private Player player;

	public PlayableEntity() {}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
