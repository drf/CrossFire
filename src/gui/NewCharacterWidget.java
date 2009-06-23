package gui;
import characters.Character;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import gameLogic.CombatEvent;
import gameLogic.CombatListener;
import gameLogic.Game;
import gameLogic.GameSetupEvent;
import gameLogic.GameSetupListener;
import gameLogic.CombatHandler.AttackType;
import gameLogic.Game.GamePhase;
import globals.Modifier;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.WindowConstants;
import org.jdesktop.application.Application;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
public class NewCharacterWidget extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7287597263958530429L;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JButton strengthButtonMinus;
	private JLabel jLabel5;
	private JTextField nameText;
	private JTextField jTextField4;
	private JButton luckButtonMinus;
	private JLabel jLabel8;
	private JButton luckButtonPlus;
	private JButton jButton11;
	private JButton dexterityButtonPlus;
	private JTextField jTextField3;
	private JButton dexterityButtonMinus;
	private JLabel jLabel7;
	private JButton msButtonPlus;
	private JTextField jTextField2;
	private JButton msButtonMinus;
	private JLabel jLabel6;
	private JButton intelligenceButtonPlus;
	private JTextField jTextField1;
	private JButton intelligenceButtonMinus;
	private JButton strengthButtonPlus;
	private JTextField strengthModifier;
	private JComboBox raceCombo;
	private EventListenerList eventListeners = new EventListenerList();


	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new NewCharacterWidget());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public NewCharacterWidget() {
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
				jButton11 = new JButton();
				this.add(jButton11, new AnchorConstraint(827, 978, 958, 776, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton11.setName("jButton11");
				jButton11.setBounds(392, 273, 98, 42);
				jButton11.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jButton11MouseClicked(evt);
					}
				});
			}
			{
				ComboBoxModel raceComboModel = 
					new DefaultComboBoxModel(
							new String[] { "Human", "Orc", "Elf", "Wizard" });
				raceCombo = new JComboBox();
				this.add(raceCombo, new AnchorConstraint(197, 596, 284, 124, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				raceCombo.setModel(raceComboModel);
				raceCombo.setPreferredSize(new java.awt.Dimension(294, 28));
				raceCombo.setBounds(62, 59, 236, 26);
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2, new AnchorConstraint(187, 257, 290, 35, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel2.setPreferredSize(new java.awt.Dimension(78, 28));
				jLabel2.setName("jLabel2");
				jLabel2.setBounds(17, 56, 111, 31);
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1, new AnchorConstraint(56, 149, 191, 35, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setPreferredSize(new java.awt.Dimension(40, 37));
				jLabel1.setName("jLabel1");
				jLabel1.setBounds(17, 16, 57, 41);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3, new AnchorConstraint(330, 987, 381, 69, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel3.setName("jLabel3");
				jLabel3.setPreferredSize(new java.awt.Dimension(322, 14));
				jLabel3.setBounds(34, 99, 459, 15);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4, new AnchorConstraint(432, 360, 490, 123, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel4.setName("jLabel4");
				jLabel4.setPreferredSize(new java.awt.Dimension(83, 16));
				jLabel4.setBounds(61, 129, 119, 18);
			}
			{
				strengthButtonMinus = new JButton();
				this.add(strengthButtonMinus, new AnchorConstraint(425, 411, 501, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				strengthButtonMinus.setPreferredSize(new java.awt.Dimension(18, 21));
				strengthButtonMinus.setBounds(180, 127, 25, 23);
				strengthButtonMinus.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						strengthButtonMinusMouseClicked(evt);
					}
				});
			}
			{
				strengthModifier = new JTextField();
				this.add(strengthModifier, new AnchorConstraint(425, 465, 501, 425, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				strengthModifier.setName("strengthModifier");
				strengthModifier.setPreferredSize(new java.awt.Dimension(14, 21));
				strengthModifier.setBounds(212, 127, 20, 23);
			}
			{
				strengthButtonPlus = new JButton();
				this.add(strengthButtonPlus, new AnchorConstraint(425, 551, 501, 482, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				strengthButtonPlus.setPreferredSize(new java.awt.Dimension(24, 21));
				strengthButtonPlus.setBounds(241, 127, 34, 23);
				strengthButtonPlus.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						strengthButtonPlusMouseClicked(evt);
					}
				});
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5, new AnchorConstraint(527, 360, 585, 123, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel5.setName("jLabel5");
				jLabel5.setPreferredSize(new java.awt.Dimension(83, 16));
				jLabel5.setBounds(61, 158, 119, 17);
			}
			{
				intelligenceButtonMinus = new JButton();
				this.add(intelligenceButtonMinus, new AnchorConstraint(520, 411, 596, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				intelligenceButtonMinus.setName("intelligenceButtonMinus");
				intelligenceButtonMinus.setPreferredSize(new java.awt.Dimension(18, 21));
				intelligenceButtonMinus.setBounds(180, 156, 25, 22);
				intelligenceButtonMinus.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						intelligenceButtonMinusMouseClicked(evt);
					}
				});
			}
			{
				jTextField1 = new JTextField();
				this.add(jTextField1, new AnchorConstraint(520, 465, 596, 425, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField1.setName("jTextField1");
				jTextField1.setPreferredSize(new java.awt.Dimension(14, 21));
				jTextField1.setBounds(212, 156, 20, 22);
			}
			{
				intelligenceButtonPlus = new JButton();
				this.add(intelligenceButtonPlus, new AnchorConstraint(520, 551, 596, 482, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				intelligenceButtonPlus.setPreferredSize(new java.awt.Dimension(24, 21));
				intelligenceButtonPlus.setBounds(241, 156, 34, 22);
				intelligenceButtonPlus.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						intelligenceButtonPlusMouseClicked(evt);
					}
				});
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6, new AnchorConstraint(622, 360, 680, 123, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel6.setName("jLabel6");
				jLabel6.setPreferredSize(new java.awt.Dimension(83, 16));
				jLabel6.setBounds(61, 186, 119, 18);
			}
			{
				msButtonMinus = new JButton();
				this.add(msButtonMinus, new AnchorConstraint(614, 411, 691, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				msButtonMinus.setPreferredSize(new java.awt.Dimension(18, 21));
				msButtonMinus.setBounds(180, 184, 25, 23);
				msButtonMinus.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						msButtonMinusMouseClicked(evt);
					}
				});
			}
			{
				jTextField2 = new JTextField();
				this.add(jTextField2, new AnchorConstraint(614, 465, 691, 425, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField2.setName("jTextField2");
				jTextField2.setPreferredSize(new java.awt.Dimension(14, 21));
				jTextField2.setBounds(212, 184, 20, 23);
			}
			{
				msButtonPlus = new JButton();
				this.add(msButtonPlus, new AnchorConstraint(614, 551, 691, 482, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				msButtonPlus.setPreferredSize(new java.awt.Dimension(24, 21));
				msButtonPlus.setBounds(241, 184, 34, 23);
				msButtonPlus.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						msButtonPlusMouseClicked(evt);
					}
				});
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7, new AnchorConstraint(717, 360, 775, 123, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel7.setName("jLabel7");
				jLabel7.setPreferredSize(new java.awt.Dimension(83, 16));
				jLabel7.setBounds(61, 215, 119, 17);
			}
			{
				dexterityButtonMinus = new JButton();
				this.add(dexterityButtonMinus, new AnchorConstraint(709, 411, 786, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				dexterityButtonMinus.setName("dexterityButtonMinus");
				dexterityButtonMinus.setPreferredSize(new java.awt.Dimension(18, 21));
				dexterityButtonMinus.setBounds(180, 212, 25, 23);
				dexterityButtonMinus.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						dexterityButtonMinusMouseClicked(evt);
					}
				});
			}
			{
				jTextField3 = new JTextField();
				this.add(jTextField3, new AnchorConstraint(709, 465, 786, 425, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField3.setName("jTextField3");
				jTextField3.setPreferredSize(new java.awt.Dimension(14, 21));
				jTextField3.setBounds(212, 212, 20, 23);
			}
			{
				dexterityButtonPlus = new JButton();
				this.add(dexterityButtonPlus, new AnchorConstraint(709, 551, 786, 482, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				dexterityButtonPlus.setPreferredSize(new java.awt.Dimension(24, 21));
				dexterityButtonPlus.setBounds(241, 212, 34, 23);
				dexterityButtonPlus.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						dexterityButtonPlusMouseClicked(evt);
					}
				});
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8, new AnchorConstraint(812, 360, 870, 123, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel8.setName("jLabel8");
				jLabel8.setPreferredSize(new java.awt.Dimension(83, 16));
				jLabel8.setBounds(61, 243, 119, 18);
			}
			{
				luckButtonMinus = new JButton();
				this.add(luckButtonMinus, new AnchorConstraint(804, 411, 881, 360, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				luckButtonMinus.setPreferredSize(new java.awt.Dimension(18, 21));
				luckButtonMinus.setBounds(180, 241, 25, 23);
				luckButtonMinus.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						luckButtonMinusMouseClicked(evt);
					}
				});
			}
			{
				jTextField4 = new JTextField();
				this.add(jTextField4, new AnchorConstraint(804, 465, 881, 425, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField4.setName("jTextField4");
				jTextField4.setPreferredSize(new java.awt.Dimension(14, 21));
				jTextField4.setBounds(212, 241, 20, 23);
			}

			{
				nameText = new JTextField();
				this.add(nameText, new AnchorConstraint(66, 596, 153, 124, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				nameText.setName("nameText");
				nameText.setPreferredSize(new java.awt.Dimension(294, 28));
				nameText.setBounds(62, 19, 236, 26);
			}

			{
				luckButtonPlus = new JButton();
				this.add(luckButtonPlus, new AnchorConstraint(818, 547, 888, 477, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				luckButtonPlus.setPreferredSize(new java.awt.Dimension(35, 21));
				luckButtonPlus.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						luckButtonPlusMouseClicked(evt);
					}
				});
			}
			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButton11MouseClicked(MouseEvent evt) {
		String characterName = nameText.getText();
		Character.Race charRace = null;
		Modifier charModifier = new Modifier();
		Character newCharacter; 
		
		switch(raceCombo.getSelectedIndex())
		{
			case 0:
				charRace = Character.Race.Human;
				break;
			case 1:
				charRace = Character.Race.Orc;
				break;
			case 2: 
				charRace = Character.Race.Elf;
				break;
			case 3:
				charRace = Character.Race.Wizard;
				break;
			default:
				charRace = Character.Race.Human;
				break;
		}
		
		charModifier.setDexterity(Integer.parseInt(jTextField3.getText()));
		charModifier.setIntelligence(Integer.parseInt(jTextField1.getText()));
		charModifier.setLuck(Integer.parseInt(jTextField4.getText()));
		charModifier.setMagicSkill(Integer.parseInt(jTextField2.getText()));
		charModifier.setStrength(Integer.parseInt(strengthModifier.getText()));

		newCharacter = Game.getInstance().createCharacter(charRace, charModifier, characterName);
		GameSetupEvent e = new GameSetupEvent(this, GameSetupEvent.SetupPhase.AddedCharacter, newCharacter);
		
		Object[] listeners = eventListeners.getListenerList();
        
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == GameSetupListener.class) {
                ((GameSetupListener)listeners[i+1]).GameSetupStateChanged(e);
            }
        }		
	}
	
	private void strengthButtonPlusMouseClicked(MouseEvent evt) {

		Integer newValue = Integer.parseInt(strengthModifier.getText()) +1;
		int bonusSum = Integer.parseInt(jTextField3.getText()) + Integer.parseInt(jTextField1.getText()) + Integer.parseInt(jTextField4.getText()) + Integer.parseInt(jTextField2.getText()) + Integer.parseInt(strengthModifier.getText());
		if(bonusSum <5)
			strengthModifier.setText(newValue.toString());

	}
	
	private void intelligenceButtonPlusMouseClicked(MouseEvent evt) {
		
		Integer newValue = Integer.parseInt(jTextField1.getText()) +1;
		int bonusSum = Integer.parseInt(jTextField3.getText()) + Integer.parseInt(jTextField1.getText()) + Integer.parseInt(jTextField4.getText()) + Integer.parseInt(jTextField2.getText()) + Integer.parseInt(strengthModifier.getText());
		if(bonusSum <5)
			jTextField1.setText(newValue.toString());
	}
	
	private void msButtonPlusMouseClicked(MouseEvent evt) {
		
		Integer newValue = Integer.parseInt(jTextField2.getText()) +1;
		int bonusSum = Integer.parseInt(jTextField3.getText()) + Integer.parseInt(jTextField1.getText()) + Integer.parseInt(jTextField4.getText()) + Integer.parseInt(jTextField2.getText()) + Integer.parseInt(strengthModifier.getText());
		if(bonusSum <5)
			jTextField2.setText(newValue.toString());
	}
	
	private void dexterityButtonPlusMouseClicked(MouseEvent evt) {
		
		Integer newValue = Integer.parseInt(jTextField3.getText()) +1;
		int bonusSum = Integer.parseInt(jTextField3.getText()) + Integer.parseInt(jTextField1.getText()) + Integer.parseInt(jTextField4.getText()) + Integer.parseInt(jTextField2.getText()) + Integer.parseInt(strengthModifier.getText());
		if(bonusSum <5)
			jTextField3.setText(newValue.toString());
	}
	
	
	private void strengthButtonMinusMouseClicked(MouseEvent evt) {
		Integer newValue = Integer.parseInt(strengthModifier.getText()) -1;
		int bonusSum = Integer.parseInt(jTextField3.getText()) + Integer.parseInt(jTextField1.getText()) + Integer.parseInt(jTextField4.getText()) + Integer.parseInt(jTextField2.getText()) + Integer.parseInt(strengthModifier.getText());
		if(bonusSum > 0 && newValue >= 0)
			strengthModifier.setText(newValue.toString());
	}
	
	private void intelligenceButtonMinusMouseClicked(MouseEvent evt) {
		Integer newValue = Integer.parseInt(jTextField1.getText()) -1;
		int bonusSum = Integer.parseInt(jTextField3.getText()) + Integer.parseInt(jTextField1.getText()) + Integer.parseInt(jTextField4.getText()) + Integer.parseInt(jTextField2.getText()) + Integer.parseInt(strengthModifier.getText());
		if(bonusSum > 0 && newValue >= 0)
			jTextField1.setText(newValue.toString());
		
	}
	
	private void msButtonMinusMouseClicked(MouseEvent evt) {
		Integer newValue = Integer.parseInt(jTextField2.getText()) -1;
		int bonusSum = Integer.parseInt(jTextField3.getText()) + Integer.parseInt(jTextField1.getText()) + Integer.parseInt(jTextField4.getText()) + Integer.parseInt(jTextField2.getText()) + Integer.parseInt(strengthModifier.getText());
		if(bonusSum > 0 && newValue >= 0)
			jTextField2.setText(newValue.toString());
	}
	
	private void dexterityButtonMinusMouseClicked(MouseEvent evt) {
		Integer newValue = Integer.parseInt(jTextField3.getText()) -1;
		int bonusSum = Integer.parseInt(jTextField3.getText()) + Integer.parseInt(jTextField1.getText()) + Integer.parseInt(jTextField4.getText()) + Integer.parseInt(jTextField2.getText()) + Integer.parseInt(strengthModifier.getText());
		if(bonusSum > 0 && newValue >= 0)
			jTextField3.setText(newValue.toString());

	}
	
	private void luckButtonMinusMouseClicked(MouseEvent evt) {
		Integer newValue = Integer.parseInt(jTextField4.getText()) -1;
		int bonusSum = Integer.parseInt(jTextField3.getText()) + Integer.parseInt(jTextField1.getText()) + Integer.parseInt(jTextField4.getText()) + Integer.parseInt(jTextField2.getText()) + Integer.parseInt(strengthModifier.getText());
		if(bonusSum > 0 && newValue >= 0)
			jTextField4.setText(newValue.toString());
	}
	
	private void luckButtonPlusMouseClicked(MouseEvent evt) {
		Integer newValue = Integer.parseInt(jTextField4.getText()) +1;
		int bonusSum = Integer.parseInt(jTextField3.getText()) + Integer.parseInt(jTextField1.getText()) + Integer.parseInt(jTextField4.getText()) + Integer.parseInt(jTextField2.getText()) + Integer.parseInt(strengthModifier.getText());
		if(bonusSum <5)
			jTextField4.setText(newValue.toString());
	}

}
