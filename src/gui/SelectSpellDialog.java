package gui;
import java.awt.Dimension;

import gameLogic.CanMagicAttack;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.application.Application;

import spells.Spell;

import characters.Wizard;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import com.sun.org.apache.xml.internal.security.c14n.CanonicalizerSpi;

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
public class SelectSpellDialog extends javax.swing.JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7318512858787587112L;
	
	private JList spellList;
	private JLabel costLabel;
	private JLabel jLabel1;
	private JLabel descLabel;
	private JLabel jl1;
	private JButton okButton;
	private CanMagicAttack caster;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				SelectSpellDialog inst = new SelectSpellDialog(frame, new Wizard("culo"));
				inst.setVisible(true);
			}
		});
	}
	
	public SelectSpellDialog(JFrame frame, CanMagicAttack caster) {
		super(frame);
		this.caster = caster;
		initGUI();
		DefaultListModel model = new DefaultListModel();
		int index = 0;
		for (Spell spell : caster.getAvailableSpells()) {
			model.add(index, spell.getName());
			++index;
		}
		spellList.setModel(model);
	}
	
	private void initGUI() {
		try {
			{
				AnchorLayout thisLayout = new AnchorLayout();
				getContentPane().setLayout(thisLayout);
			}
			{
				ListModel spellListModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				spellList = new JList();
				getContentPane().add(spellList, new AnchorConstraint(45, 343, 798, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				spellList.setModel(spellListModel);
				spellList.setPreferredSize(new java.awt.Dimension(122, 208));
				spellList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent evt) {
						spellListValueChanged(evt);
					}
				});
			}
			{
				okButton = new JButton();
				getContentPane().add(okButton, new AnchorConstraint(846, 614, 919, 392, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				okButton.setName("okButton");
				okButton.setPreferredSize(new java.awt.Dimension(99, 27));
			}
			{
				jl1 = new JLabel();
				getContentPane().add(jl1, new AnchorConstraint(45, 615, 96, 423, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jl1.setName("jl1");
				jl1.setPreferredSize(new java.awt.Dimension(75, 14));
			}
			{
				descLabel = new JLabel();
				getContentPane().add(descLabel, new AnchorConstraint(44, 974, 464, 646, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				descLabel.setName("descLabel");
				descLabel.setPreferredSize(new java.awt.Dimension(146, 154));
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, new AnchorConstraint(545, 494, 596, 423, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setName("jLabel1");
				jLabel1.setPreferredSize(new java.awt.Dimension(28, 14));
			}
			{
				costLabel = new JLabel();
				getContentPane().add(costLabel, new AnchorConstraint(546, 974, 595, 646, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				costLabel.setName("costLabel");
				costLabel.setPreferredSize(new java.awt.Dimension(146, 18));
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void spellListValueChanged(ListSelectionEvent evt) {
		int index = 0;
		for (Spell spell : caster.getAvailableSpells()) {
			if (spellList.getSelectedIndex() == index) {
				descLabel.setText(spell.getDescription());
				costLabel.setText(Integer.toBinaryString(spell.getCost()));
			}
			++index;
		}
	}

}
