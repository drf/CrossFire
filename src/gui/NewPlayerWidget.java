package gui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.Dimension;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.WindowConstants;
import org.jdesktop.application.Application;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class NewPlayerWidget extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 763238634689294973L;
	private JLabel jLabel1;
	private JTextField nameBox;
	private JLabel jLabel2;
	private JButton manageCharacterButton;
	private JButton removeButton;
	private JComboBox controllerCombo;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new NewPlayerWidget());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public NewPlayerWidget() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(400, 300));
			{
				manageCharacterButton = new JButton();
				this.add(manageCharacterButton, new AnchorConstraint(529, 825, 795, 603, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				manageCharacterButton.setPreferredSize(new java.awt.Dimension(139, 85));
				manageCharacterButton.setName("manageCharacterButton");
			}
			{
				removeButton = new JButton();
				this.add(removeButton, new AnchorConstraint(126, 820, 382, 603, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				removeButton.setPreferredSize(new java.awt.Dimension(136, 82));
				removeButton.setName("removeButton");
			}
			{
				ComboBoxModel controllerComboModel = 
					new DefaultComboBoxModel(
							new String[] { "Human", "Computer", "Monster" });
				controllerCombo = new JComboBox();
				this.add(controllerCombo, new AnchorConstraint(529, 552, 823, 109, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				controllerCombo.setModel(controllerComboModel);
				controllerCombo.setPreferredSize(new java.awt.Dimension(278, 94));
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2, new AnchorConstraint(556, 181, 801, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel2.setPreferredSize(new java.awt.Dimension(67, 24));
				jLabel2.setName("jLabel2");
			}
			{
				nameBox = new JTextField();
				this.add(nameBox, new AnchorConstraint(126, 547, 382, 104, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				nameBox.setPreferredSize(new java.awt.Dimension(278, 82));
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1, new AnchorConstraint(127, 165, 382, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setPreferredSize(new java.awt.Dimension(61, 25));
				jLabel1.setName("jLabel1");
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
