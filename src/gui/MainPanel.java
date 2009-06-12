package gui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import gameLogic.Game;
import gameLogic.Game.GamePhase;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import org.jdesktop.application.Application;
import javax.swing.JFrame;
import javax.swing.JLabel;


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
public class MainPanel extends javax.swing.JPanel {
	private JLabel introLabel;
	private JButton quitButton;
	private JButton loadButton;
	private JButton newButton;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new MainPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public MainPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(400, 300));
			{
				quitButton = new JButton();
				this.add(quitButton, new AnchorConstraint(671, 906, 841, 578, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				quitButton.setPreferredSize(new java.awt.Dimension(131, 51));
				quitButton.setName("quitButton");
				quitButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						quitButtonMouseClicked(evt);
					}
				});
			}
			{
				loadButton = new JButton();
				this.add(loadButton, new AnchorConstraint(445, 906, 631, 578, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				loadButton.setPreferredSize(new java.awt.Dimension(131, 56));
				loadButton.setName("loadButton");
				loadButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						loadButtonMouseClicked(evt);
					}
				});
			}
			{
				newButton = new JButton();
				this.add(newButton, new AnchorConstraint(238, 906, 405, 578, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				newButton.setPreferredSize(new java.awt.Dimension(131, 50));
				newButton.setName("newButton");
				newButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						newButtonMouseClicked(evt);
					}
				});
			}
			{
				introLabel = new JLabel();
				this.add(introLabel, new AnchorConstraint(41, 431, 198, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				introLabel.setName("introLabel");
				introLabel.setPreferredSize(new java.awt.Dimension(160, 47));
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadButtonMouseClicked(MouseEvent evt) {
		System.out.println("loadButton.mouseClicked, event="+evt);
		//TODO add your code for loadButton.mouseClicked
	}
	
	private void quitButtonMouseClicked(MouseEvent evt) {
		System.out.println("quitButton.mouseClicked, event="+evt);
		Application.getInstance().quit(null);
	}
	
	private void newButtonMouseClicked(MouseEvent evt) {
		System.out.println("newButton.mouseClicked, event="+evt);
		Game.getInstance().setState(GamePhase.GameCreation);
	}

}
