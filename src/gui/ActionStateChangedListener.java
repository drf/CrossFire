package gui;

import java.util.EventListener;

public interface ActionStateChangedListener extends EventListener {
	public void ActionStateChanged(ActionStateChangedEvent evt);
}
