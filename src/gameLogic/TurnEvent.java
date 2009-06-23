package gameLogic;

import globals.PlayableEntity;

import player.Player;

public class TurnEvent extends EntityEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3489809130829416521L;
	
	private PlayableEntity entity;
	private Player player;
	private TypeEvent type;
	
	public enum TypeEvent {
		Started,
		Changed,
		Finished
	}

	public TurnEvent(Player player, PlayableEntity source, TypeEvent type) {
		super(source);
		entity = source;
		this.player = player;
		this.type = type;
	}

	/**
	 * @return the entity
	 */
	public PlayableEntity getEntity() {
		return entity;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the type
	 */
	public TypeEvent getType() {
		return type;
	}

	
}
