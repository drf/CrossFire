package gui;
import characters.Character;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import gameLogic.Game;
import gameLogic.GameSetupEvent;
import gameLogic.GameSetupListener;
import gameLogic.Game.GamePhase;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import org.jdesktop.application.Application;

import player.Player;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.EventListenerList;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ManagePlayerList extends javax.swing.JPanel {
	private JButton addPlayer;
	private JButton close;
	private JButton removePlayer;
	private JLabel jLabel1;
	/**
	 * @uml.property  name="playersList"
	 * @uml.associationEnd  
	 */
	private MutableList playersList;
	private ArrayList<Player> playersArray = new ArrayList<Player>();
	private EventListenerList eventListeners = new EventListenerList();


	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ManagePlayerList());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ManagePlayerList() {
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
			setPreferredSize(new Dimension(400, 300));
			{
				removePlayer = new JButton();
				this.add(removePlayer, new AnchorConstraint(348, 331, 481, 53, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				removePlayer.setPreferredSize(new java.awt.Dimension(111, 40));
				removePlayer.setName("removePlayer");
				removePlayer.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						removePlayerMouseClicked(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1, new AnchorConstraint(65, 698, 115, 528, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setPreferredSize(new java.awt.Dimension(68, 15));
				jLabel1.setName("jLabel1");
			}
			{
				close = new JButton();
				this.add(close, new AnchorConstraint(811, 946, 961, 668, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				close.setPreferredSize(new java.awt.Dimension(111, 45));
				close.setName("close");
				close.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						closeActionPerformed(evt);
					}
				});
				close.setEnabled(false);
			}
			{
				addPlayer = new JButton();
				this.add(addPlayer, new AnchorConstraint(155, 331, 308, 53, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				addPlayer.setPreferredSize(new java.awt.Dimension(111, 46));
				addPlayer.setName("addPlayer");
				addPlayer.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						addPlayerMouseClicked(evt);
					}
				});
			}
			{
				playersList = new MutableList();
				this.add(playersList, new AnchorConstraint(155, 946, 745, 528, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				playersList.setModel(playersList.getModel());
				playersList.setPreferredSize(new java.awt.Dimension(167, 177));
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	private void removePlayerMouseClicked(MouseEvent evt) {
		String name;
		int index = playersList.getSelectedIndex();
		if( index != -1) {
			name = (String) playersList.getContents().get(index);
			for(Player p: playersArray) {
				if(p.getName().equals(name)) {
					playersArray.remove(p);
					Game.getInstance().removePlayer(p);
					playersList.getContents().remove(index);
				}
			}
		}		
	}

	public void updateList(Player p) {
		playersArray.add(p);
		playersList.getContents().addElement(p.getName());
		close.setEnabled(true);
	}
		
	
	private void addPlayerMouseClicked(MouseEvent evt) {
		GameSetupEvent e = new GameSetupEvent(this, GameSetupEvent.SetupPhase.AddPlayer);
		
		Object[] listeners = eventListeners.getListenerList();
        
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == GameSetupListener.class) {
                ((GameSetupListener)listeners[i+1]).GameSetupStateChanged(e);
            }
        }		

		
	}
	
	private void closeActionPerformed(ActionEvent evt) {
		Game.getInstance().setState(GamePhase.SetupDone);
		
	}

}
