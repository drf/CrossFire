package gameLogic;

public class PickEvent extends EntityEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6890734211916087157L;
	
	private CanPick picker;
	private Pickable picked;

	public PickEvent(CanPick source, Pickable picked) {
		super(source);
		// TODO Auto-generated constructor stub
		this.picker = source;
		this.picked = picked;
	}

	/**
	 * @return the picker
	 */
	public CanPick getPicker() {
		return picker;
	}

	/**
	 * @return the picked
	 */
	public Pickable getPicked() {
		return picked;
	}

	
}
