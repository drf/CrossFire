package gui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import gameChart.RectangularChart;
import gameLogic.CanAttack;
import gameLogic.CombatEvent;
import gameLogic.CombatHandler;
import gameLogic.CombatListener;
import gameLogic.EntityEvent;
import gameLogic.EntityListener;
import gameLogic.MoveEvent;
import gameLogic.PickEvent;
import gameLogic.Turn;
import gameLogic.TurnEvent;
import globals.Entity;

import java.awt.Dimension;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import org.jdesktop.application.Application;

import player.HumanPlayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

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
public class GamePanel extends javax.swing.JPanel implements EntityListener, CombatListener {
	private JTextPane gameLogger;
	private JPanel actionPanel;
	private JPanel showDataPanel;
	private JPanel chartArea;
	private JTextPane descriptionText;
	private JButton skipButton;
	private JButton spellButton;
	private JButton rangedButton;
	private JButton meleeButton;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new GamePanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public GamePanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 300));
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			{
				gameLogger = new JTextPane();
				this.add(gameLogger, new AnchorConstraint(751, 1000, 1001, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				gameLogger.setName("gameLogger");
				gameLogger.setPreferredSize(new java.awt.Dimension(711, 102));
			}
			{
				actionPanel = new JPanel();
				AnchorLayout actionPanelLayout = new AnchorLayout();
				actionPanel.setLayout(actionPanelLayout);
				this.add(actionPanel, new AnchorConstraint(1, 1000, 366, 739, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				actionPanel.setPreferredSize(new java.awt.Dimension(186, 149));
				{
					meleeButton = new JButton();
					actionPanel.add(meleeButton, new AnchorConstraint(3, 782, 144, 271, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					meleeButton.setName("meleeButton");
					meleeButton.setPreferredSize(new java.awt.Dimension(95, 21));
				}
				{
					rangedButton = new JButton();
					actionPanel.add(rangedButton, new AnchorConstraint(211, 819, 352, 250, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					rangedButton.setName("rangedButton");
					rangedButton.setPreferredSize(new java.awt.Dimension(106, 21));
				}
				{
					spellButton = new JButton();
					actionPanel.add(spellButton, new AnchorConstraint(426, 739, 567, 330, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					spellButton.setName("spellButton");
					spellButton.setPreferredSize(new java.awt.Dimension(76, 21));
				}
				{
					skipButton = new JButton();
					actionPanel.add(skipButton, new AnchorConstraint(640, 717, 781, 330, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					skipButton.setName("skipButton");
					skipButton.setPreferredSize(new java.awt.Dimension(72, 21));
				}
			}
			{
				showDataPanel = new JPanel();
				AnchorLayout showDataPanelLayout = new AnchorLayout();
				showDataPanel.setLayout(showDataPanelLayout);
				this.add(showDataPanel, new AnchorConstraint(381, 1000, 736, 739, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				showDataPanel.setPreferredSize(new java.awt.Dimension(186, 145));
				{
					descriptionText = new JTextPane();
					AnchorLayout descriptionTextLayout = new AnchorLayout();
					descriptionText.setLayout(descriptionTextLayout);
					showDataPanel.add(descriptionText, new AnchorConstraint(4, 1004, 1004, 4, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					descriptionText.setName("descriptionText");
					descriptionText.setPreferredSize(new java.awt.Dimension(105, 106));
				}
			}
			{
				chartArea = new ChartWidget(new RectangularChart(10,10));
				this.add(chartArea, new AnchorConstraint(13, 755, 736, 7, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				chartArea.setPreferredSize(new java.awt.Dimension(532, 295));
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void EntityEventOccurred(EntityEvent e) {
		if (e instanceof MoveEvent) {
			MoveEvent m = (MoveEvent)e;
			gameLogger.setText(gameLogger.getText() + ((Entity)m.getSource()).getName() +
					           " has moved to " + m.getDestinationBox()+ '\n');
		} else if (e instanceof PickEvent) {
			PickEvent p = (PickEvent)e;
			gameLogger.setText(gameLogger.getText() + ((Entity)p.getPicker()).getName() +
			           		   " has picked " + ((Entity)p.getPicked()).getName() + '\n');
		} else if (e instanceof TurnEvent) {
			TurnEvent t = (TurnEvent)e;
			switch (t.getType()) {
			case Started:
				// Log it
				gameLogger.setText(gameLogger.getText() + (t.getPlayer()).getName() +
		           		   		   ", it's " + ((Entity)t.getEntity()).getName() +
		           		   		   " turn" + '\n');
				if (t.getPlayer() instanceof HumanPlayer) {
					// Then we need to manage it
					
				} else {
					// Then let it pass
					meleeButton.setEnabled(false);
					rangedButton.setEnabled(false);
					spellButton.setEnabled(false);
					skipButton.setEnabled(false);
					break;
				}
			case Changed:
				// Update the buttons
				
				meleeButton.setEnabled(false);
				rangedButton.setEnabled(false);
				spellButton.setEnabled(false);
				skipButton.setEnabled(true);
				
				if (t.getEntity().getCurrentTurn().availableActions().contains(Turn.Action.Attack)) {
					if (t.getEntity() instanceof CanAttack) {
						if (CombatHandler.canPerformAttack(((CanAttack)t.getEntity()), CombatHandler.AttackType.Melee)) {
							meleeButton.setEnabled(true);
						}
						
						if (CombatHandler.canPerformAttack(((CanAttack)t.getEntity()), CombatHandler.AttackType.Ranged)) {
							rangedButton.setEnabled(true);
						}
						
						if (CombatHandler.canPerformAttack(((CanAttack)t.getEntity()), CombatHandler.AttackType.Magic)) {
							spellButton.setEnabled(true);
						}
					}
				}
				break;
				
			case Finished:
				// Log it
				gameLogger.setText(gameLogger.getText() + (t.getPlayer()).getName() +
		           		   		   ", " + ((Entity)t.getEntity()).getName() +
		           		   		   "'s turn has ended." + '\n');
				// Deactivate all
				meleeButton.setEnabled(false);
				rangedButton.setEnabled(false);
				spellButton.setEnabled(false);
				skipButton.setEnabled(false);
				break;			
			}
		}
	}

	@Override
	public void CombatEventOccurred(CombatEvent e) {
		switch (e.getAttackType()) {
		case Melee:
		case Ranged:
			if (e.isSuccess()) {
				gameLogger.setText(gameLogger.getText() + ((Entity)e.getAttacker()).getName() +
				                   " inflicts " + e.getDamage() + " damage to " +
				                   ((Entity)e.getAttacked()).getName() + '\n');
			} else {
				gameLogger.setText(gameLogger.getText() + ((Entity)e.getAttacked()).getName() +
		                   		   " evaded " + ((Entity)e.getAttacker()).getName() +
		                   		   "'s attack!" + '\n');
			}
			break;
		case Magic:
			if (e.isSuccess()) {
				if (e.getSpell().dealsDamage()) {
					gameLogger.setText(gameLogger.getText() + ((Entity)e.getAttacker()).getName() +
					                   " casted " + e.getSpell().getName() + " on " +
					                   ((Entity)e.getAttacked()).getName() + " causing " +
					                   e.getDamage() + " damage" + '\n');
				} else {
					gameLogger.setText(gameLogger.getText() + ((Entity)e.getAttacker()).getName() +
					                   " casted " + e.getSpell().getName() + " on " +
					                   ((Entity)e.getAttacked()).getName() + '\n');
				}
			} else {
				gameLogger.setText(gameLogger.getText() + ((Entity)e.getAttacked()).getName() +
		                   		   " failed to cast " + e.getSpell().getName() + " on " +
		                   		   ((Entity)e.getAttacker()).getName() + "!\n");
			}
			break;
		}
	}

}
