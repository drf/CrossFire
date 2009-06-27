package gui;

import gameChart.CircolarChart;
import gameChart.LinearChart;
import gameChart.RectangularChart;
import gameLogic.Game;
import gameLogic.GamePhaseChangedEvent;
import gameLogic.GamePhaseChangedListener;
import gameLogic.Game.GamePhase;

import javax.swing.ActionMap;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */

public class CrossFireApplication extends SingleFrameApplication 
	implements GamePhaseChangedListener{
	
    private JMenuBar menuBar;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem1;
    private JMenu fileMenu;
    /**
	 * @uml.property  name="playerFrame"
	 * @uml.associationEnd  
	 */
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
        show(getMainFrame());
    }

    public static void main(String[] args) {

    	launch(CrossFireApplication.class, args);
    }

  
    private void selectChart() {
    	Object[] possibilities = {"Circolar", "Rectangular", "Linear"};
    	String s = (String)JOptionPane.showInputDialog(
    	                    getMainFrame(),
    	                    "Choose the chart type:\n",
    	                    "Chart Shape",
    	                    JOptionPane.PLAIN_MESSAGE,
    	                    null,
    	                    possibilities,
    	                    "Rectangular");
    	
        String X = JOptionPane.showInputDialog(getMainFrame(), "Select Chart Width");
        String Y = JOptionPane.showInputDialog(getMainFrame(), "Select Chart Height");
        
        
    	if ((s != null) && (s.length() > 0)) {
    		if(s.equals("Circolar"))
    			try {
    			Game.getInstance().setChart(new CircolarChart(Integer.parseInt(X),Integer.parseInt(Y)));
    			}
    			catch (Exception e) {
        			Game.getInstance().setChart(new CircolarChart(10, 10));
				}
    		else if(s.equals("Rectangular"))
    			try {
    			Game.getInstance().setChart(new RectangularChart(Integer.parseInt(X),Integer.parseInt(Y)));
    			}
    			catch (Exception e) {
        			Game.getInstance().setChart(new RectangularChart(10,10));
    			}
    		else {
    			try {
    			Game.getInstance().setChart(new LinearChart(Integer.parseInt(X)));
    			}
    			catch (Exception e) {
        			Game.getInstance().setChart(new LinearChart(20));

				}
    		}
    	}
    	
    }
    
    public void GamePhaseChanged(GamePhaseChangedEvent e) {
		
		switch (e.getPhase()) {
		case SetupDone:
			playerFrame.dispose();
			selectChart();
			Game.getInstance().randomlyPlaceEntities();
			Game.getInstance().randomlyPlaceItems();
			getMainFrame().getContentPane().removeAll();
			getMainFrame().getContentPane().add(new GamePanel());
			getMainFrame().pack();
			Game.getInstance().setState(Game.GamePhase.Turn);
			Game.getInstance().performNextTurn();
			break;
			
		case EndGame:
			JOptionPane.showMessageDialog(getMainFrame(), "Player " + Game.getInstance().getWinner().getName() + " won the game!", "We have a winner!", JOptionPane.INFORMATION_MESSAGE);
			Game.resetGame();
			Game.getInstance().addGameChangedEventListener(this);
	        Game.getInstance().setState(GamePhase.None);
			break;
			
		case GameCreation:
			getMainFrame().getContentPane().removeAll();
			getMainFrame().pack();
			playerFrame = new ManagerPlayers();
			playerFrame.setVisible(true);
			break;
			
		case None:
			getMainFrame().getContentPane().removeAll();
			getMainFrame().getContentPane().add(new MainPanel());
			getMainFrame().pack();
			break;
		case Turn:
			break;
		default:
			break;
		}
	}

}
