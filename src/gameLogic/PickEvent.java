package gameLogic;

/**
 * @author  drf
 */
public class PickEvent extends EntityEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6890734211916087157L;
	
	/**
	 * @uml.property  name="picker"
	 * @uml.associationEnd  
	 */
	private CanPick picker;
	/**
	 * @uml.property  name="picked"
	 * @uml.associationEnd  
	 */
	private Pickable picked;

	public PickEvent(CanPick source, Pickable picked) {
		super(source);
		// TODO Auto-generated constructor stub
		this.picker = source;
		this.picked = picked;
	}

	/**
	 * @return  the picker
	 * @uml.property  name="picker"
	 */
	public CanPick getPicker() {
		return picker;
	}

	/**
	 * @return  the picked
	 * @uml.property  name="picked"
	 */
	public Pickable getPicked() {
		return picked;
	}

	
}
