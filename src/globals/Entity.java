package globals;

import java.awt.image.BufferedImage;

import javax.swing.event.EventListenerList;

import gameChart.Box;
import gameChart.BoxBusyException;
import gameLogic.DeathEvent;
import gameLogic.EntityListener;
import gameLogic.Movable;
import gameLogic.MoveEvent;
import gameLogic.Turn;

/**
 * 
 * <b>Entity</b> represents an abstract class which must be implemented in a subclass. The idea behind this class
 * is to give a spatial consciousness to a {@link Character} or {@link Item}. In fact it contains a {@link Box}
 * to know the position it has on the chart. 
 * 
 * The attributes are: 
 * <ul>
 * <li>box it represents the position on the game chart. 
 * </ul>
 * 
 * Each attribute has a getter/setter.
 * 
 * @author	Dario Freddi
 * @author	Vincenzo Iozzo
 */

public abstract class Entity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 602249422396237313L;
	private Box box;
	private BufferedImage image;
	private String name;
	
	private EventListenerList eventListeners = new EventListenerList();
	
	public Entity() {}
	
	public Entity(String name) {
		this.name = name;
	}
	
	public Box getBox() {
		return this.box;
	}
	
	public void setBox(Box box) {
		if (this instanceof Movable) {
			((Movable)this).boxChanged(this.box, box);
		}
		this.box = box;
	}
	
	/**
	 * This method is responsible to do all the needed checks before performing a real move.
	 * We need to make sure that this Entity is capable of moving and that the box we are moving to is
	 * near the current box.
	 * 
	 * This method always returns immediately. 
	 *
	 * @param  toBox  the box to move to.
	 * @exception BoxBusyException if the box we are moving to is already occupied 
	 * @return     void
	 */
	public void move(Box toBox) {
		if (!(this instanceof gameLogic.Movable)) {
			return;
		}
		
		if (!getBox().isAdjacentTo(toBox)) {
			return;
		}
		
		Box oldBox = getBox();
		
		try {
			getBox().getChart().place(this, toBox);
		} catch (BoxBusyException e) {
			return;
			// TODO: handle exception
		}
		
		// Stream the event
		MoveEvent evt = new MoveEvent((Movable)this, oldBox, toBox);
		
		Object[] listeners = getListeners().getListenerList();
        
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == EntityListener.class) {
            	((EntityListener)listeners[i+1]).EntityEventOccurred(evt);
            }
        }
        
        // If it has a turn, process it
        if (this instanceof PlayableEntity) {
        	if (((PlayableEntity)this).isOnTurn()) {
        		((PlayableEntity)this).performTurnAction(Turn.Action.Move);
        	}
        }
	}

	public BufferedImage getImage() {
		return image;
	}

	protected void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void addEntityEventListener(EntityListener listener) {
		eventListeners.add(EntityListener.class, listener);
	}
	
	protected EventListenerList getListeners() {
		return eventListeners;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void onDeath() {
		// Stream the event
		DeathEvent evt = new DeathEvent(this);
		
		Object[] listeners = getListeners().getListenerList();
        
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == EntityListener.class) {
            	((EntityListener)listeners[i+1]).EntityEventOccurred(evt);
            }
        }
	}
	
	
}
