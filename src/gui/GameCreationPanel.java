package gui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import org.jdesktop.application.Application;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
public class GameCreationPanel extends javax.swing.JPanel {
	private JLabel jLabel1;
	private JPanel widgetsPanel;
	private JButton addButton;
	private JButton nextButton;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new GameCreationPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public GameCreationPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(400, 300));
			{
				nextButton = new JButton();
				this.add(nextButton, new AnchorConstraint(891, 963, 961, 796, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				nextButton.setPreferredSize(new java.awt.Dimension(67, 21));
				nextButton.setName("nextButton");
			}
			{
				addButton = new JButton();
				this.add(addButton, new AnchorConstraint(188, 963, 281, 763, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				addButton.setPreferredSize(new java.awt.Dimension(80, 28));
				addButton.setName("addButton");
				addButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						addButtonMouseClicked(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1, new AnchorConstraint(18, 763, 65, 198, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setName("jLabel1");
				jLabel1.setPreferredSize(new java.awt.Dimension(226, 14));
			}
			{
				widgetsPanel = new JPanel();
				BoxLayout widgetsPanelLayout = new BoxLayout(widgetsPanel, javax.swing.BoxLayout.Y_AXIS);
				widgetsPanel.setLayout(widgetsPanelLayout);
				this.add(widgetsPanel, new AnchorConstraint(98, 636, 961, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				widgetsPanel.setPreferredSize(new java.awt.Dimension(242, 259));
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addButtonMouseClicked(MouseEvent evt) {
		System.out.println("addButton.mouseClicked, event="+evt);
		NewPlayerWidget widget = new NewPlayerWidget();
		widgetsPanel.add(widget);
		widgetsPanel.validate();
	}

}
