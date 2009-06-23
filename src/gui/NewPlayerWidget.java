package gui;
import characters.Character;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import gameLogic.Game;
import gameLogic.GameSetupEvent;
import gameLogic.GameSetupListener;
import gameLogic.Game.GamePhase;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.WindowConstants;
import org.jdesktop.application.Application;

import player.Player;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
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
public class NewPlayerWidget extends javax.swing.JPanel implements GameSetupListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 763238634689294973L;
	private JLabel jLabel1;
	private JButton PlayersCreatedButton;
	private JTextField nameBox;
	private JLabel jLabel2;
	private JButton jButton1;
	private JLabel jLabel3;
	private JList characterList;
	private JButton manageCharacterButton;
	private JButton removeButton;
	private JComboBox controllerCombo;
	private EventListenerList eventListeners = new EventListenerList();
	private Player player;
	private ArrayList<Character> charList;


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
	
	public void addGameSetupListener(GameSetupListener listener) {
		eventListeners.add(GameSetupListener.class, listener);
	}

	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(500, 300));
			{
				PlayersCreatedButton = new JButton();
				this.add(PlayersCreatedButton, new AnchorConstraint(848, 977, 961, 767, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				PlayersCreatedButton.setPreferredSize(new java.awt.Dimension(105, 34));
				PlayersCreatedButton.setName("PlayersCreatedButton");
				PlayersCreatedButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						PlayersCreatedButtonMouseClicked(evt);
					}
				});
			}
			{
				jButton1 = new JButton();
				this.add(jButton1, new AnchorConstraint(545, 691, 658, 525, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton1.setPreferredSize(new java.awt.Dimension(83, 34));
				jButton1.setName("jButton1");
				jButton1.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jButton1MouseClicked(evt);
					}
				});
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3, new AnchorConstraint(155, 857, 193, 714, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel3.setPreferredSize(new java.awt.Dimension(105, 14));
				jLabel3.setName("jLabel3");
			}
			{
				ListModel playerListModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				characterList = new JList();
				this.add(characterList, new AnchorConstraint(212, 981, 770, 714, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				characterList.setModel(playerListModel);
				characterList.setPreferredSize(new java.awt.Dimension(196, 203));
			}
			{
				manageCharacterButton = new JButton();
				this.add(manageCharacterButton, new AnchorConstraint(405, 686, 482, 534, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				manageCharacterButton.setPreferredSize(new java.awt.Dimension(112, 28));
				manageCharacterButton.setName("manageCharacterButton");
				manageCharacterButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						manageCharacterButtonMouseClicked(evt);
					}
				});
			}
			{
				removeButton = new JButton();
				this.add(removeButton, new AnchorConstraint(212, 686, 289, 534, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				removeButton.setPreferredSize(new java.awt.Dimension(112, 28));
				removeButton.setName("removeButton");
			}
			{
				ComboBoxModel controllerComboModel = 
					new DefaultComboBoxModel(
							new String[] { "Human", "Computer", "Monster" });
				controllerCombo = new JComboBox();
				this.add(controllerCombo, new AnchorConstraint(405, 524, 482, 86, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				controllerCombo.setModel(controllerComboModel);
				controllerCombo.setPreferredSize(new java.awt.Dimension(322, 28));
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2, new AnchorConstraint(305, 181, 545, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel2.setPreferredSize(new java.awt.Dimension(133, 77));
				jLabel2.setName("jLabel2");
			}
			{
				nameBox = new JTextField();
				this.add(nameBox, new AnchorConstraint(212, 524, 289, 86, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				nameBox.setPreferredSize(new java.awt.Dimension(322, 28));
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
	
	private void manageCharacterButtonMouseClicked(MouseEvent evt) {
		GameSetupEvent e = new GameSetupEvent(this, GameSetupEvent.SetupPhase.AddCharacter);
		
		Object[] listeners = eventListeners.getListenerList();
        
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == GameSetupListener.class) {
                ((GameSetupListener)listeners[i+1]).GameSetupStateChanged(e);
            }
        }		

	}
	
	private void jButton1MouseClicked(MouseEvent evt) {
		boolean isHuman;
		
		if(controllerCombo.getSelectedIndex() == 0)
			isHuman = true;
		else
			isHuman = false;
		
		player = Game.getInstance().createNewPlayer(nameBox.getText(), isHuman);
		for(Character c: charList)
			Game.getInstance().assignCharacter(player, c);

		GameSetupEvent e = new GameSetupEvent(this, GameSetupEvent.SetupPhase.AddedPlayer, player);
		
		Object[] listeners = eventListeners.getListenerList();
        
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == GameSetupListener.class) {
                ((GameSetupListener)listeners[i+1]).GameSetupStateChanged(e);
            }
        }		

	}

	public void GameSetupStateChanged(GameSetupEvent evt) {
	   	
		switch(evt.getPhase()) {
    	case AddedPlayer:
    		
    		break;
    	case AddedCharacter:
    		Character addedChar = evt.getAddedCharacter();
    		Game.getInstance().assignCharacter(player, addedChar);
    		charList.add(addedChar);
    		jButton1.setEnabled(true);
    		//TODO add to Jlist
    		
    		break;
    	case AddCharacter:
    		break;
    	}

		
	}
	
	private void PlayersCreatedButtonMouseClicked(MouseEvent evt) {
		Game.getInstance().setState(GamePhase.SetupDone);
	}

}
