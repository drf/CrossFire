package gameLogic;

import java.util.EventListener;

public interface GameSetupListener extends EventListener{
	public void GameSetupStateChanged(GameSetupEvent evt);
}
