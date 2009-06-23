package gameLogic;

import java.util.EventListener;

public interface CombatListener extends EventListener {
	public void CombatEventOccurred(CombatEvent e);
}
