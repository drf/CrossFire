package gui;

import gameLogic.Game;
import gameLogic.GamePhaseChangedEvent;
import gameLogic.GamePhaseChangedListener;
import gameLogic.Game.GamePhase;
import gameLogic.GameSetupEvent;
import gameLogic.GameSetupListener;

import java.awt.BorderLayout;

import javax.swing.ActionMap;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;


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
/**
 * 
 */

public class CrossFireApplication extends SingleFrameApplication 
	implements GamePhaseChangedListener, GameSetupListener {
	
    private JMenuBar menuBar;
    private JPanel topPanel;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem1;
    private JMenu fileMenu;
    private JPanel contentPanel;
    private ManagerCharacter characterFrame;
    private ManagerPlayers playerFrame;
    
    @Action
    public void open() {
    }

    @Action
    public void save() {
    }

    @Action
    public void newFile() {
    }

    private ActionMap getAppActionMap() {
        return Application.getInstance().getContext().getActionMap(this);
    }

    @Override
    protected void startup() {
        {
            topPanel = new JPanel();
            BorderLayout panelLayout = new BorderLayout();
            topPanel.setLayout(panelLayout);
            topPanel.setPreferredSize(new java.awt.Dimension(500, 300));
            {
                contentPanel = new JPanel();
                topPanel.add(contentPanel, BorderLayout.CENTER);
            }
        }
        menuBar = new JMenuBar();
        {
            fileMenu = new JMenu();
            menuBar.add(fileMenu);
            fileMenu.setName("fileMenu");
        {
                jMenuItem1 = new JMenuItem();
                fileMenu.add(jMenuItem1);
                jMenuItem1.setAction(getAppActionMap().get("newFile"));
            }
            {
                jMenuItem2 = new JMenuItem();
                fileMenu.add(jMenuItem2);
                jMenuItem2.setAction(getAppActionMap().get("open"));
            }
            {
                jMenuItem3 = new JMenuItem();
                fileMenu.add(jMenuItem3);
                jMenuItem3.setAction(getAppActionMap().get("save"));
            }
        }
        getMainFrame().setJMenuBar(menuBar);
        Game.getInstance().addGameChangedEventListener(this);
        Game.getInstance().setState(GamePhase.None);
        show(topPanel);
    }

    public static void main(String[] args) {

    	launch(CrossFireApplication.class, args);
    }

    public void GameSetupStateChanged (GameSetupEvent evt)
    {
    	switch(evt.getPhase()) {
    	case AddedPlayer:
    		
    		break;
    	case AddedCharacter:
    		characterFrame.dispose();
    		break;
    	
    	case AddCharacter:
			characterFrame = new ManagerCharacter();
			characterFrame.getCharacterWidget().addGameSetupListener(this);
			characterFrame.getCharacterWidget().addGameSetupListener(playerFrame.getPlayerWidget());
			characterFrame.setVisible(true);
			break;
    		
    	}
    }
 
  
    public void GamePhaseChanged(GamePhaseChangedEvent e) {
		
		switch (e.getPhase()) {
		case SetupDone:
			break;
			
		case EndGame:
			break;
			
		case GameCreation:
			contentPanel.removeAll();
			contentPanel.validate();
			playerFrame = new ManagerPlayers();
			playerFrame.getPlayerWidget().addGameSetupListener(this);
			playerFrame.setVisible(true);
			break;
			
		case None:
			contentPanel.removeAll();
			contentPanel.validate();
			contentPanel.add(new MainPanel());
			contentPanel.validate();
			break;
		case Turn:
			break;
		default:
			break;
		}
	}

}
