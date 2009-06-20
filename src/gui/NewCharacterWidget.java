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
public class NewCharacterWidget extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7287597263958530429L;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JButton jButton1;
	private JLabel jLabel5;
	private JTextField nameText;
	private JButton jButton10;
	private JTextField jTextField4;
	private JButton jButton9;
	private JLabel jLabel8;
	private JButton jButton8;
	private JTextField jTextField3;
	private JButton jButton7;
	private JLabel jLabel7;
	private JButton jButton6;
	private JTextField jTextField2;
	private JButton jButton5;
	private JLabel jLabel6;
	private JButton jButton4;
	private JTextField jTextField1;
	private JButton jButton3;
	private JButton jButton2;
	private JTextField strengthModifier;
	private JComboBox raceCombo;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new NewCharacterWidget());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public NewCharacterWidget() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(500, 300));
			{
				ComboBoxModel raceComboModel = 
					new DefaultComboBoxModel(
							new String[] { "Human", "Orc", "Elf", "Wizard" });
				raceCombo = new JComboBox();
				this.add(raceCombo, new AnchorConstraint(198, 827, 286, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				raceCombo.setModel(raceComboModel);
				raceCombo.setPreferredSize(new java.awt.Dimension(164, 24));
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2, new AnchorConstraint(187, 257, 290, 35, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel2.setPreferredSize(new java.awt.Dimension(78, 28));
				jLabel2.setName("jLabel2");
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1, new AnchorConstraint(56, 149, 191, 35, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setPreferredSize(new java.awt.Dimension(40, 37));
				jLabel1.setName("jLabel1");
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3, new AnchorConstraint(330, 987, 381, 69, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel3.setName("jLabel3");
				jLabel3.setPreferredSize(new java.awt.Dimension(322, 14));
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4, new AnchorConstraint(432, 360, 490, 123, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel4.setName("jLabel4");
				jLabel4.setPreferredSize(new java.awt.Dimension(83, 16));
			}
			{
				jButton1 = new JButton();
				this.add(jButton1, new AnchorConstraint(425, 411, 501, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton1.setName("jButton1");
				jButton1.setPreferredSize(new java.awt.Dimension(18, 21));
			}
			{
				strengthModifier = new JTextField();
				this.add(strengthModifier, new AnchorConstraint(425, 465, 501, 425, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				strengthModifier.setName("strengthModifier");
				strengthModifier.setPreferredSize(new java.awt.Dimension(14, 21));
			}
			{
				jButton2 = new JButton();
				this.add(jButton2, new AnchorConstraint(425, 551, 501, 482, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton2.setName("jButton2");
				jButton2.setPreferredSize(new java.awt.Dimension(24, 21));
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5, new AnchorConstraint(527, 360, 585, 123, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel5.setName("jLabel5");
				jLabel5.setPreferredSize(new java.awt.Dimension(83, 16));
			}
			{
				jButton3 = new JButton();
				this.add(jButton3, new AnchorConstraint(520, 411, 596, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton3.setName("jButton3");
				jButton3.setPreferredSize(new java.awt.Dimension(18, 21));
			}
			{
				jTextField1 = new JTextField();
				this.add(jTextField1, new AnchorConstraint(520, 465, 596, 425, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField1.setName("jTextField1");
				jTextField1.setPreferredSize(new java.awt.Dimension(14, 21));
			}
			{
				jButton4 = new JButton();
				this.add(jButton4, new AnchorConstraint(520, 551, 596, 482, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton4.setName("jButton4");
				jButton4.setPreferredSize(new java.awt.Dimension(24, 21));
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6, new AnchorConstraint(622, 360, 680, 123, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel6.setName("jLabel6");
				jLabel6.setPreferredSize(new java.awt.Dimension(83, 16));
			}
			{
				jButton5 = new JButton();
				this.add(jButton5, new AnchorConstraint(614, 411, 691, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton5.setName("jButton5");
				jButton5.setPreferredSize(new java.awt.Dimension(18, 21));
			}
			{
				jTextField2 = new JTextField();
				this.add(jTextField2, new AnchorConstraint(614, 465, 691, 425, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField2.setName("jTextField2");
				jTextField2.setPreferredSize(new java.awt.Dimension(14, 21));
			}
			{
				jButton6 = new JButton();
				this.add(jButton6, new AnchorConstraint(614, 551, 691, 482, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton6.setName("jButton6");
				jButton6.setPreferredSize(new java.awt.Dimension(24, 21));
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7, new AnchorConstraint(717, 360, 775, 123, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel7.setName("jLabel7");
				jLabel7.setPreferredSize(new java.awt.Dimension(83, 16));
			}
			{
				jButton7 = new JButton();
				this.add(jButton7, new AnchorConstraint(709, 411, 786, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton7.setName("jButton7");
				jButton7.setPreferredSize(new java.awt.Dimension(18, 21));
			}
			{
				jTextField3 = new JTextField();
				this.add(jTextField3, new AnchorConstraint(709, 465, 786, 425, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField3.setName("jTextField3");
				jTextField3.setPreferredSize(new java.awt.Dimension(14, 21));
			}
			{
				jButton8 = new JButton();
				this.add(jButton8, new AnchorConstraint(709, 551, 786, 482, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton8.setName("jButton8");
				jButton8.setPreferredSize(new java.awt.Dimension(24, 21));
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8, new AnchorConstraint(812, 360, 870, 123, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel8.setName("jLabel8");
				jLabel8.setPreferredSize(new java.awt.Dimension(83, 16));
			}
			{
				jButton9 = new JButton();
				this.add(jButton9, new AnchorConstraint(804, 411, 881, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton9.setName("jButton9");
				jButton9.setPreferredSize(new java.awt.Dimension(18, 21));
			}
			{
				jTextField4 = new JTextField();
				this.add(jTextField4, new AnchorConstraint(804, 465, 881, 425, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField4.setName("jTextField4");
				jTextField4.setPreferredSize(new java.awt.Dimension(14, 21));
			}
			{
				jButton10 = new JButton();
				this.add(jButton10, new AnchorConstraint(804, 551, 881, 482, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton10.setName("jButton10");
				jButton10.setPreferredSize(new java.awt.Dimension(24, 21));
			}
			{
				nameText = new JTextField();
				this.add(nameText, new AnchorConstraint(74, 827, 151, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				nameText.setName("nameText");
				nameText.setPreferredSize(new java.awt.Dimension(164, 21));
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
