package gui;
import characters.Dragon;
import characters.Fighter;
import characters.God;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import gameChart.BidimensionalChart;
import gameChart.BoxBusyException;
import gameChart.RectangularChart;
import gameLogic.Attackable;
import gameLogic.CanAttack;
import gameLogic.CanMagicAttack;
import gameLogic.CanMeleeAttack;
import gameLogic.CanPick;
import gameLogic.CanRangedAttack;
import gameLogic.CombatEvent;
import gameLogic.CombatHandler;
import gameLogic.CombatListener;
import gameLogic.DeathEvent;
import gameLogic.EntityEvent;
import gameLogic.EntityListener;
import gameLogic.Game;
import gameLogic.MoveEvent;
import gameLogic.PickEvent;
import gameLogic.Pickable;
import gameLogic.Turn;
import gameLogic.TurnEvent;
import globals.Entity;
import globals.Modifier;
import globals.PlayableEntity;

import items.Bomb;
import items.LongSword;
import items.SpellBook;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;

import javax.swing.JToggleButton;

import javax.swing.WindowConstants;
import org.jdesktop.application.Application;

import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;
import spells.Spell;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.event.EventListenerList;

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
public class GamePanel extends javax.swing.JPanel implements EntityListener, CombatListener, BoxClickedListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7718056154119235638L;
	private JTextArea gameLogger;
	private JPanel actionPanel;
	private JPanel showDataPanel;
	private ChartWidget chartArea;
	private JToggleButton moveButton;
	private JButton pickButton;
	private JTextPane descriptionText;
	private JButton skipButton;
	private JToggleButton spellButton;
	private JToggleButton rangedButton;
	private JToggleButton meleeButton;
	private PlayableEntity onTurn;
	private ActionState state;
	private EventListenerList eventListeners = new EventListenerList();
	private Spell currentSpell;

	public enum ActionState {
		OnNavigate,
		OnMove,
		OnMeleeAttack,
		OnRangedAttack,
		OnSpellCasting,
	}
	
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		Game.getInstance().setChart(new RectangularChart(10,10));
		Player p1 = Game.getInstance().createNewPlayer("Test1", true);
		Player p2 = Game.getInstance().createNewPlayer("Test2", true);
		ComputerPlayer p3 = (ComputerPlayer)(Game.getInstance().createNewPlayer("TestPC", false));
		Game.getInstance().assignCharacter(p1, Game.getInstance().createCharacter(characters.Character.Race.Human, new Modifier(), "cicci"));
		Game.getInstance().assignCharacter(p2, Game.getInstance().createCharacter(characters.Character.Race.Wizard, new Modifier(), "picci"));
		Game.getInstance().assignCharacter(p2, new God());
		Game.getInstance().assignNPC(p3, new Dragon());
		Game.getInstance().assignNPC(p3, new Dragon());
		try {
			Game.getInstance().getChart().place((Entity)(Game.getInstance().getEntities().toArray()[0]), ((BidimensionalChart)(Game.getInstance().getChart())).getBoxAt(3, 7));
			Game.getInstance().getChart().place((Entity)(Game.getInstance().getEntities().toArray()[1]), ((BidimensionalChart)(Game.getInstance().getChart())).getBoxAt(3, 9));
			Game.getInstance().getChart().place((Entity)(Game.getInstance().getEntities().toArray()[2]), ((BidimensionalChart)(Game.getInstance().getChart())).getBoxAt(9, 9));
			Game.getInstance().getChart().place((Entity)(Game.getInstance().getNPCS().toArray()[0]), ((BidimensionalChart)(Game.getInstance().getChart())).getBoxAt(4, 7));
			Game.getInstance().getChart().place((Entity)(Game.getInstance().getNPCS().toArray()[1]), ((BidimensionalChart)(Game.getInstance().getChart())).getBoxAt(6, 9));
			Game.getInstance().getChart().place(new SpellBook(), ((BidimensionalChart)(Game.getInstance().getChart())).getBoxAt(3, 7));
			Game.getInstance().getChart().place(new LongSword(), ((BidimensionalChart)(Game.getInstance().getChart())).getBoxAt(3, 6));
			Game.getInstance().getChart().place(new Bomb(), ((BidimensionalChart)(Game.getInstance().getChart())).getBoxAt(4, 8));
		} catch (BoxBusyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame();
		frame.getContentPane().add(new GamePanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		Game.getInstance().setState(Game.GamePhase.Turn);
		Game.getInstance().performNextTurn();
	}
	
	public GamePanel() {
		super();
		CombatHandler.getInstance().addCombatListener(this);
		for (PlayableEntity ent : Game.getInstance().getEntities()) {
			ent.addEntityEventListener(this);
		}
		
		for (PlayableEntity ent : Game.getInstance().getNPCS()) {
			ent.addEntityEventListener(this);
		}
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 300));
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			{
				gameLogger = new JTextArea();
				gameLogger.setName("gameLogger");
				gameLogger.setPreferredSize(new java.awt.Dimension(387, 70));
				gameLogger.setDefaultLocale(new java.util.Locale("en", "GB"));
				JScrollPane pScroll = new JScrollPane(gameLogger, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				this.add(pScroll, new AnchorConstraint(751, 986, 985, 18, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			}
			{
				actionPanel = new JPanel();
				AnchorLayout actionPanelLayout = new AnchorLayout();
				actionPanel.setLayout(actionPanelLayout);
				this.add(actionPanel, new AnchorConstraint(1, 1000, 366, 739, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				actionPanel.setPreferredSize(new java.awt.Dimension(186, 149));
				{
					moveButton = new JToggleButton();
					actionPanel.add(moveButton, new AnchorConstraint(515, 816, 641, 252, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					moveButton.setName("moveButton");
					moveButton.setPreferredSize(new java.awt.Dimension(66, 16));
					moveButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							moveButtonMouseClicked(evt);
						}
					});
				}
				{
					meleeButton = new JToggleButton();
					actionPanel.add(meleeButton, new AnchorConstraint(4, 814, 142, 252, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					meleeButton.setName("meleeButton");
					meleeButton.setPreferredSize(new java.awt.Dimension(59, 15));
					meleeButton.setBounds(26, 0, 59, 15);
					meleeButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							meleeButtonMouseClicked(evt);
						}
					});
				}
				{
					rangedButton = new JToggleButton();
					actionPanel.add(rangedButton, new AnchorConstraint(161, 816, 303, 252, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					rangedButton.setName("rangedButton");
					rangedButton.setPreferredSize(new java.awt.Dimension(66, 18));
					rangedButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							rangedButtonMouseClicked(evt);
						}
					});
				}
				{
					spellButton = new JToggleButton();
					actionPanel.add(spellButton, new AnchorConstraint(342, 816, 476, 252, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					spellButton.setName("spellButton");
					spellButton.setPreferredSize(new java.awt.Dimension(66, 17));
					spellButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							spellButtonMouseClicked(evt);
						}
					});
				}
				{
					skipButton = new JButton();
					actionPanel.add(skipButton, new AnchorConstraint(877, 824, 1003, 260, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					skipButton.setName("skipButton");
					skipButton.setPreferredSize(new java.awt.Dimension(66, 16));
					skipButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							skipButtonMouseClicked(evt);
						}
					});
				}
				{
					pickButton = new JButton();
					actionPanel.add(pickButton, new AnchorConstraint(681, 816, 791, 252, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					pickButton.setName("pickButton");
					pickButton.setPreferredSize(new java.awt.Dimension(66, 14));
					pickButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							pickButtonMouseClicked(evt);
						}
					});
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
					showDataPanel.add(descriptionText, new AnchorConstraint(4, 1004, 1004, 61, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					descriptionText.setName("descriptionText");
					descriptionText.setPreferredSize(new java.awt.Dimension(99, 106));
				}
			}
			{
				chartArea = new ChartWidget((BidimensionalChart)Game.getInstance().getChart(), this);
				this.add(chartArea, new AnchorConstraint(13, 755, 736, 7, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				chartArea.setPreferredSize(new java.awt.Dimension(532, 295));
				chartArea.addBoxClickedEventListener(this);
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void EntityEventOccurred(EntityEvent e) {
		
		System.out.println("start");
		if (e instanceof MoveEvent) {
			MoveEvent m = (MoveEvent)e;
			gameLogger.setText(gameLogger.getText() + ((Entity)m.getSource()).getName() +
					           " has moved to " + m.getDestinationBox()+ '\n');
		} else if (e instanceof PickEvent) {
			PickEvent p = (PickEvent)e;
			gameLogger.setText(gameLogger.getText() + ((Entity)p.getPicker()).getName() +
			           		   " has picked " + ((Entity)p.getPicked()).getName() + '\n');
		} else if (e instanceof DeathEvent) {
			gameLogger.setText(gameLogger.getText() + ((Entity)e.getSource()).getName() +
			           		   " was killed!!\n");
		} else if (e instanceof TurnEvent) {
			TurnEvent t = (TurnEvent)e;
			switch (t.getType()) {
			case Started:
				// Log it
				onTurn = t.getEntity();
				gameLogger.setText(gameLogger.getText() + (t.getPlayer()).getName() +
		           		   		   ", it's " + ((Entity)t.getEntity()).getName() +
		           		   		   " turn" + '\n');
				descriptionText.setText(((Entity)t.getEntity()).getName() + "\n\nHP: " +
										((Fighter)t.getEntity()).getHp() + "\nMP:" +
										((Fighter)t.getEntity()).getMp() + "\nDexterity: " +
										((Fighter)t.getEntity()).getDexterity() + "\nIntelligence: " +
										((Fighter)t.getEntity()).getIntelligence() + "\nStrength:" +
										((Fighter)t.getEntity()).getStrength() + "\nLuck:" +
										((Fighter)t.getEntity()).getLuck() + "\nMagic Skill:" +
										((Fighter)t.getEntity()).getMagicSkill());
				if (t.getPlayer() instanceof HumanPlayer) {
					// Then we need to manage it
					
				} else {
					// Then let it pass
					meleeButton.setEnabled(false);
					rangedButton.setEnabled(false);
					spellButton.setEnabled(false);
					skipButton.setEnabled(false);
					pickButton.setEnabled(false);
					moveButton.setEnabled(false);
					break;
				}
			case Changed:
				// Update the buttons
				
				meleeButton.setEnabled(false);
				rangedButton.setEnabled(false);
				spellButton.setEnabled(false);
				moveButton.setEnabled(false);
				pickButton.setEnabled(false);
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
				
				if (t.getEntity().getCurrentTurn().availableActions().contains(Turn.Action.Move)) {
					moveButton.setEnabled(true);
				}
				
				if (t.getEntity() instanceof CanPick) {
					for (Entity ent : t.getEntity().getBox().getChart().getEntitiesOn(t.getEntity().getBox())) {
						if (ent instanceof Pickable) {
							if (((CanPick)t.getEntity()).canPick((Pickable)ent)) {
								pickButton.setEnabled(true);
							}
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
				moveButton.setEnabled(false);
				pickButton.setEnabled(false);
				skipButton.setEnabled(false);
				break;			
			}
		}
	}


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
					if (e.getDamage() > 0) {
						gameLogger.setText(gameLogger.getText() + ((Entity)e.getAttacker()).getName() +
								" casted " + e.getSpell().getName() + " on " +
								((Entity)e.getAttacked()).getName() + " causing " +
								e.getDamage() + " damage" + '\n');
					} else {
						gameLogger.setText(gameLogger.getText() + ((Entity)e.getAttacker()).getName() +
								" casted " + e.getSpell().getName() + " on " +
								((Entity)e.getAttacked()).getName() + " healing him for " +
								-e.getDamage() + " HP" + '\n');
					}
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


	public void BoxClicked(BoxClickedEvent evt) {
		System.out.println("A box got clicked");
		switch (state) {
		case OnMeleeAttack:
			if (onTurn.getBox().getAdjacentBoxes().contains(evt.getBox())) {
				// Perform the attack
				for (Entity ent : evt.getBox().getChart().getEntitiesOn(evt.getBox())) {
					if (ent instanceof Attackable) {
						onTurn.performTurnAction(Turn.Action.Attack);
						CombatHandler.getInstance().meleeAttack((CanMeleeAttack)onTurn, (Attackable)ent);
						meleeButton.setSelected(false);
						setNewActionState(ActionState.OnNavigate, 0, 0);
						return;
					}
				}
			}
			gameLogger.setText(gameLogger.getText() + "You cannot perform a melee attack on this target\n");
			break;
		case OnRangedAttack:
			if (onTurn.getBox().getChart().getBoxesInRange(onTurn.getBox(), 10).contains(evt.getBox())) {
				// Perform the attack
				for (Entity ent : evt.getBox().getChart().getEntitiesOn(evt.getBox())) {
					if (ent instanceof Attackable) {
						onTurn.performTurnAction(Turn.Action.Attack);
						CombatHandler.getInstance().rangedAttack((CanRangedAttack)onTurn, (Attackable)ent);
						rangedButton.setSelected(false);
						setNewActionState(ActionState.OnNavigate, 0, 0);
						return;
					}
				}
			}
			gameLogger.setText(gameLogger.getText() + "You cannot perform a ranged attack on this target\n");
			break;
		case OnMove:
			if (onTurn.getBox().getAdjacentBoxes().contains(evt.getBox())) {
				// Move it
				for (Entity ent : evt.getBox().getChart().getEntitiesOn(evt.getBox())) {
					if (ent instanceof PlayableEntity) {
						gameLogger.setText(gameLogger.getText() + "You cannot move here\n");
						return;
					}
				}
				onTurn.move(evt.getBox());
				moveButton.setSelected(false);
				setNewActionState(ActionState.OnNavigate, 0, 0);
				return;
			}
			gameLogger.setText(gameLogger.getText() + "You cannot move here\n");
			break;
		case OnSpellCasting:
			if (onTurn.getBox().getChart().getBoxesInRange(onTurn.getBox(), currentSpell.getDistanceRange()).contains(evt.getBox())) {
				// Perform the attack
				for (Entity ent : evt.getBox().getChart().getEntitiesOn(evt.getBox())) {
					if (ent instanceof Attackable) {
						if (!CombatHandler.canCastSpell((CanMagicAttack)onTurn, (Attackable)ent, currentSpell)) {
							continue;
						}
						onTurn.performTurnAction(Turn.Action.Attack);
						CombatHandler.getInstance().magicAttack((CanMagicAttack)onTurn, (Attackable)ent, currentSpell);
						currentSpell = null;
						spellButton.setSelected(false);
						setNewActionState(ActionState.OnNavigate, 0, 0);
						return;
					}
				}
			}
			gameLogger.setText(gameLogger.getText() + "You cannot cast this spell on this target\n");
			
		}
	}
	
	private void meleeButtonMouseClicked(MouseEvent evt) {
		if (meleeButton.isSelected()) {
			setNewActionState(ActionState.OnMeleeAttack, 0, 1);
		} else {
			setNewActionState(ActionState.OnNavigate, 0, 0);
		}
	}
	
	private void rangedButtonMouseClicked(MouseEvent evt) {
		if (rangedButton.isSelected()) {
			setNewActionState(ActionState.OnRangedAttack, 0, 10);
		} else {
			setNewActionState(ActionState.OnNavigate, 0, 0);
		}
	}
	
	private void spellButtonMouseClicked(MouseEvent evt) {
		if (spellButton.isSelected()) {
			HashSet<String> possibilities = new HashSet<String>();
			for (Spell spell : ((CanMagicAttack)onTurn).getAvailableSpells()) {
				if (CombatHandler.canCastSpell((CanMagicAttack)onTurn, spell)) {
					possibilities.add(spell.getName());
				}
			}
			String s = (String)JOptionPane.showInputDialog(
			                    this,
			                    "Select a spell.",
			                    "Select a spell",
			                    JOptionPane.PLAIN_MESSAGE,
			                    null,
			                    possibilities.toArray(),
			                    "ham");

			//If a string was returned, say so.
			if ((s != null) && (s.length() > 0)) {
				for (Spell spell : ((CanMagicAttack)onTurn).getAvailableSpells()) {
					if (spell.getName() == s) {
						currentSpell = spell;
						setNewActionState(ActionState.OnSpellCasting, spell.getTargetRange(), spell.getDistanceRange());
					}
				}
			}
		} else {
			setNewActionState(ActionState.OnNavigate, 0, 0);
		}
	}
	
	private void moveButtonMouseClicked(MouseEvent evt) {
		if (moveButton.isSelected()) {
			setNewActionState(ActionState.OnMove, 0, 1);
		} else {
			setNewActionState(ActionState.OnNavigate, 0, 0);
		}
	}
	
	private void skipButtonMouseClicked(MouseEvent evt) {
		// Let's skip the turn
		((HumanPlayer)(onTurn.getPlayer())).skipTurn();
	}
	
	private void setNewActionState(ActionState state, int tr, int dr) {
		this.state = state;
		
		// Stream the event
		ActionStateChangedEvent evt = new ActionStateChangedEvent(this, state, tr, dr);
		
		Object[] listeners = eventListeners.getListenerList();
        
        for (int k = 0; k < listeners.length; k += 2) {
            if (listeners[k] == ActionStateChangedListener.class) {
            	((ActionStateChangedListener)listeners[k+1]).ActionStateChanged(evt);
            }
        }
	}
	
	public void addActionStateChangedEventListener(ActionStateChangedListener listener) {
		eventListeners.add(ActionStateChangedListener.class, listener);
	}
	
	private void pickButtonMouseClicked(MouseEvent evt) {
		if (onTurn instanceof CanPick) {
			for (Entity ent : onTurn.getBox().getChart().getEntitiesOn(onTurn.getBox())) {
				if (ent instanceof Pickable) {
					if (((CanPick)onTurn).canPick((Pickable)ent)) {
						((CanPick)onTurn).pick((Pickable)ent);
					}
				}
			}
		}
		pickButton.setEnabled(false);
	}

}
