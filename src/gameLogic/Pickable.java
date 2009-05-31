package gameLogic;

import globals.BaseAttributes;
import globals.Modifier;

public interface Pickable {
	public BaseAttributes getMaximumRequirements();
	public BaseAttributes getMinimumRequirements();
	
	public Modifier getModifier();
}
