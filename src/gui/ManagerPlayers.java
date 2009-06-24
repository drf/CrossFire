package gui;
import gameLogic.Game;
import gameLogic.GameSetupEvent;
import gameLogic.GameSetupListener;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import characters.Character;


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
public class ManagerPlayers extends javax.swing.JFrame implements GameSetupListener{
	private JPanel jPanel1;
	private NewPlayerWidget playerWidget;
	private ManagePlayerList playerList;
	private NewCharacterWidget characterWidget;
	

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManagerPlayers inst = new ManagerPlayers();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ManagerPlayers() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				playerWidget = new NewPlayerWidget();
				playerList = new ManagePlayerList();
				characterWidget = new NewCharacterWidget();
				playerWidget.addGameSetupListener(this);
				playerList.addGameSetupListener(this);
				characterWidget.addGameSetupListener(this);
				
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.add(playerList);
				jPanel1.validate();
			}
			pack();
			setSize(500, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GameSetupStateChanged(GameSetupEvent evt) {
	   	
		switch(evt.getPhase()) {
    	case AddedPlayer:
    		jPanel1.removeAll();
    		jPanel1.validate();
    		jPanel1.add(playerList);
    		jPanel1.validate();
    		jPanel1.updateUI();
    		playerList.updateList(evt.getAddedPlayer());
    		break;
 
    	case AddPlayer:
    		jPanel1.removeAll();
    		jPanel1.validate();
    		jPanel1.add(playerWidget);
    		jPanel1.validate();
    		jPanel1.updateUI();
    		break;
    		
    	case AddedCharacter:  
    		jPanel1.removeAll();
    		jPanel1.validate();
    		jPanel1.add(playerWidget);
    		jPanel1.validate();
    		jPanel1.updateUI();
    		playerWidget.updateList(evt.getAddedCharacter());
    		break;
    		
    	case AddCharacter:
    		jPanel1.removeAll();
    		jPanel1.validate();
    		jPanel1.add(characterWidget);
    		jPanel1.validate();
    		jPanel1.updateUI();
    		break;
    	}

		
	}

}
