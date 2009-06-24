package gameLogic;

import globals.PlayableEntity;

import player.Player;

/**
 * @author  drf
 */
public class TurnEvent extends EntityEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3489809130829416521L;
	
	/**
	 * @uml.property  name="entity"
	 * @uml.associationEnd  
	 */
	private PlayableEntity entity;
	/**
	 * @uml.property  name="player"
	 * @uml.associationEnd  
	 */
	private Player player;
	/**
	 * @uml.property  name="type"
	 * @uml.associationEnd  
	 */
	private TypeEvent type;
	
	/**
	 * @author   drf
	 */
	public enum TypeEvent {
		/**
		 * @uml.property  name="started"
		 * @uml.associationEnd  
		 */
		Started,
		/**
		 * @uml.property  name="changed"
		 * @uml.associationEnd  
		 */
		Changed,
		/**
		 * @uml.property  name="finished"
		 * @uml.associationEnd  
		 */
		Finished
	}

	public TurnEvent(Player player, PlayableEntity source, TypeEvent type) {
		super(source);
		entity = source;
		this.player = player;
		this.type = type;
	}

	/**
	 * @return  the entity
	 * @uml.property  name="entity"
	 */
	public PlayableEntity getEntity() {
		return entity;
	}

	/**
	 * @return  the player
	 * @uml.property  name="player"
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return  the type
	 * @uml.property  name="type"
	 */
	public TypeEvent getType() {
		return type;
	}

	
}
