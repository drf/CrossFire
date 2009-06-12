package gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ManageCharactersDialog extends javax.swing.JDialog {

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				ManageCharactersDialog inst = new ManageCharactersDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public ManageCharactersDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
