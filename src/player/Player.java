package player;

import globals.PlayableEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public abstract class Player implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2965714766005181669L;
	String name;
	ArrayList<PlayableEntity> entities;
	
	public Player() {}
	
	public abstract void handleTurn(PlayableEntity entity);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addNewPlayableEntity(PlayableEntity entity) {
		entities.add(entity);
	}
	
	public void removeEntity(PlayableEntity c) {
		entities.remove(c);
	}
	
	public ArrayList<PlayableEntity> getEntities() {
		return entities;
	}
	
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
