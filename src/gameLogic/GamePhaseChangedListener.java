package gameLogic;

import java.util.EventListener;

public interface GamePhaseChangedListener extends EventListener {
	public void GamePhaseChanged(GamePhaseChangedEvent e);
}
