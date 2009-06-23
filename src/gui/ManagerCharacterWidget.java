package gui;

import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import org.jdesktop.application.Application;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;


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
public class ManagerCharacterWidget extends javax.swing.JPanel {
	private JList playerList;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ManagerCharacterWidget());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ManagerCharacterWidget() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 300));
			this.setLayout(null);
			{
				ListModel playerListModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				playerList = new JList();
				this.add(playerList);
				playerList.setModel(playerListModel);
				playerList.setBounds(21, 35, 196, 196);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setBounds(287, 84, 98, 28);
				jButton1.setName("jButton1");
			}
			{
				jButton2 = new JButton();
				this.add(jButton2);
				jButton2.setBounds(287, 238, 98, 42);
				jButton2.setName("jButton2");
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setBounds(21, 14, 84, 14);
				jLabel1.setName("jLabel1");
			}
			{
				jButton3 = new JButton();
				this.add(jButton3);
				jButton3.setBounds(287, 49, 98, 28);
				jButton3.setName("jButton3");
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
