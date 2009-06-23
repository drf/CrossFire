package player;

import globals.Entity;
import globals.PlayableEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 
 * <b>Player</b> is an abstract class. The main aim of this class is to provide a way to handle multiple characters, 
 * either by the computer or by an human player.
 * The attributes are: 
 * <ul>
 * <li>name the name of the player
 * <li>entities an array which contains all the characters of type {@link Entity} that the player handles
 * </ul>
 * Each attribute has a getter/setter.
 * @author	Dario Freddi
 * @author	Vincenzo Iozzo
 */

public abstract class Player implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2965714766005181669L;
	String name;
	ArrayList<PlayableEntity> entities;
	
	public Player() {}
	
	public void handleTurn(PlayableEntity entity, int token) {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method adds a new {@link Entity}�to the list they player handles
	 * 
	 * This method always returns immediately. 
	 *
	 * @param  entity  the entity we want to add
	 * @return      void
	 * 
	 */

	public void addNewPlayableEntity(PlayableEntity entity) {
		entities.add(entity);
	}
	
	/**
	 * This method removes an {@link Entity}�from the list they player handles
	 * 
	 * This method always returns immediately. 
	 *
	 * @param  entity  the entity we want to remove
	 * @return      void
	 * 
	 */
	public void removeEntity(PlayableEntity c) {
		entities.remove(c);
	}
	
	public ArrayList<PlayableEntity> getEntities() {
		return entities;
	}
	
	/**
	 * This method is capable of loading a serialized player from a file.
	 * 
	 * This method always returns immediately. 
	 *
	 * @param  path  the path to the file containing the serialized player
	 * @return A {@link Player} instance
	 * 
	 */
	public static Player loadPlayerFromFile(String path) {
		try {
			// Deserialize from a file
	        File file = new File(path);
	        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
	        // Deserialize the object
	        Player player = (Player) in.readObject();
	        in.close();
	        return player;
		} catch (ClassNotFoundException e) {
			return null;
	    } catch (IOException e) {
	    	return null;
	    }
	}
	
	/**
	 * This method is capable of saving a player to a file.
	 * 
	 * This method always returns immediately. 
	 *
	 * @param  path  the path to the file we want to serialized the player
	 * @return <b>true</b> if the save was successful, <b>false</b> otherwise
	 * 
	 */
	public boolean saveToFile(String path) {
		try {
	        // Serialize to a file
	        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(path));
	        out.writeObject(this);
	        out.close();
	        return true;
	    } catch (IOException e) {
	    	return false;
	    }
	}
	
}
