package gameLogic;

import java.util.EventListener;

public interface EntityListener extends EventListener {
	public void EntityEventOccurred(EntityEvent e);
}
