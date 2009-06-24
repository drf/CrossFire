package gui;

import gameChart.BidimensionalChart;
import gameChart.Box;
import gameChart.BoxBusyException;
import gameChart.City;
import gameChart.Hill;
import gameChart.Plain;
import gameChart.RectangularChart;
import gameLogic.EntityEvent;
import gameLogic.EntityListener;
import gameLogic.Game;
import gameLogic.TurnEvent;
import gameLogic.TurnEvent.TypeEvent;
import globals.Entity;
import globals.Pair;
import globals.PlayableEntity;
import gui.GamePanel.ActionState;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
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
public class ChartWidget extends javax.swing.JPanel implements EntityListener, ActionStateChangedListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9112439029483183330L;
	
	private BidimensionalChart chart;
	private int multiplier = 40;
	private int XPosition = 100;
	private int YPosition = 100;
	private int lastXMouseOffset;
	private int lastYMouseOffset;
	private int mouseXPosition;
	private int mouseYPosition;
	private boolean streamClickEvent = false;
	private BufferedImage plainTexture;
	private BufferedImage hillTexture;
	private BufferedImage cityTexture;
	private AffineTransform baseTransform;
	private ActionState actionState;
	private int distanceRange;
	private int targetRange;
	private PlayableEntity onTurn;
	private EventListenerList eventListeners = new EventListenerList();
	HashSet<Pair<Integer>> targetCoordinates = new HashSet<Pair<Integer>>();
	private Color greenFill = new Color(120, 125, 0, 128);
	private Color redFill = new Color(255, 0, 0, 128);
	
	
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ChartWidget(new RectangularChart(10,15), null));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ChartWidget(BidimensionalChart chart, GamePanel parent) {
		super();
		this.chart = chart;
		parent.addActionStateChangedEventListener(this);
		
		actionState = ActionState.OnNavigate;
		
		for (PlayableEntity ent : Game.getInstance().getEntities()) {
			ent.addEntityEventListener(this);
		}
		
		for (PlayableEntity ent : Game.getInstance().getNPCS()) {
			ent.addEntityEventListener(this);
		}
		
		baseTransform = AffineTransform.getRotateInstance(-0.91, XPosition + (chart.getWidth() * multiplier)/2 ,
														  YPosition + (chart.getHeight() * multiplier)/2);
		baseTransform.shear(0, .3);
		baseTransform.translate(-50, 0);
		
		try {
			plainTexture = ImageIO.read(ClassLoader.getSystemResource("resources/Terrain2-00.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			hillTexture = ImageIO.read(ClassLoader.getSystemResource("resources/Terrain2-11.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cityTexture = ImageIO.read(ClassLoader.getSystemResource("resources/FlrTle2-07.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent evt) {
						thisMouseReleased(evt);
					}
					public void mousePressed(MouseEvent evt) {
						thisMousePressed(evt);
					}
				});
			}
			{
				this.addMouseMotionListener(new MouseMotionAdapter() {
					public void mouseMoved(MouseEvent evt) {
						thisMouseMoved(evt);
					}
					public void mouseDragged(MouseEvent evt) {
						thisMouseDragged(evt);
					}
				});
			}
			{
				this.addMouseWheelListener(new MouseWheelListener() {
					public void mouseWheelMoved(MouseWheelEvent evt) {
						thisMouseWheelMoved(evt);
					}
				});
			}
			
			setPreferredSize(new Dimension(chart.getWidth()*multiplier, chart.getHeight()*multiplier));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintInDeviceCoords(g);
	}
	
	public Point2D getPointAtIndex(int width, int height) {
		return baseTransform.transform(new Point2D.Double((double)(XPosition + multiplier + width * multiplier - multiplier/4), 
														  (double)(YPosition + height * multiplier - multiplier/4)), 
														  null);
	}

	private void paintInDeviceCoords(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		g2.transform(baseTransform);
		
		for (int i = 0; i < chart.getWidth(); i++) {
			for (int j = 0; j < chart.getHeight(); j++) {
				
				// Draw the rectangle
				
		        Rectangle2D rectangle = new Rectangle2D.Float(XPosition + i * multiplier, YPosition + j * multiplier, multiplier, multiplier);
		        g2.draw(rectangle);
		        
		        // Paint with the correct texture
		        paintBox(g2, i, j);
		        

		        // Check for mouse hover effect
		        try {
		        	if (rectangle.contains(baseTransform.inverseTransform(new Point2D.Double((double)mouseXPosition, (double)mouseYPosition), null))) {
		        		if (streamClickEvent) {
		        			// Stream the event
		        			BoxClickedEvent evt = new BoxClickedEvent(chart.getBoxAt(i, j));
		        			
		        			Object[] listeners = eventListeners.getListenerList();
		        	        
		        	        for (int k = 0; k < listeners.length; k += 2) {
		        	            if (listeners[k] == BoxClickedListener.class) {
		        	            	((BoxClickedListener)listeners[k+1]).BoxClicked(evt);
		        	            }
		        	        }
		        		}
		        		
		        		
		        		g2.fillRoundRect(XPosition + i * multiplier, YPosition + j * multiplier, multiplier, multiplier, multiplier/8, multiplier/8);
		        	}
		        } catch (NoninvertibleTransformException e) {
		        	e.printStackTrace();
		        }
		        
			}
		}
		
		if (actionState != GamePanel.ActionState.OnNavigate) {
			for (Pair<Integer> i : targetCoordinates) {
				g2.fillRect(XPosition + i.getFirst() * multiplier, YPosition + i.getSecond() * multiplier, multiplier, multiplier);
			}
		}
        	
		
		// Paint the entities (they should be on top view)
		paintEntities(g2);
		// Sorry mate
		streamClickEvent = false;
	}
	
	private void paintBox(Graphics2D g2, int i, int j) {
		// Draw texture
		if (chart.getBoxAt(i, j) instanceof Plain) {
			g2.drawImage(plainTexture, XPosition + i * multiplier, YPosition + j * multiplier, multiplier, multiplier, null);
		}
        
        if (chart.getBoxAt(i, j) instanceof Hill) {
			g2.drawImage(hillTexture, XPosition + i * multiplier, YPosition + j * multiplier, multiplier, multiplier, null);
		}
        
        if (chart.getBoxAt(i, j) instanceof City) {
			g2.drawImage(cityTexture, XPosition + i * multiplier, YPosition + j * multiplier, multiplier, multiplier, null);
		}
	}
	
	private void paintEntities(Graphics2D g2) {
		g2.setTransform(new AffineTransform());
		// Draw entities
		for (int i = 0; i < chart.getWidth(); i++) {
			for (int j = 0; j < chart.getHeight(); j++) {
				for (Entity item : chart.getEntitiesOn(chart.getBoxAt(i, j))) {
					
					Point2D pt = getPointAtIndex(i, j);
					g2.drawImage(item.getImage(), (int)(pt.getX() - multiplier/6), (int)(pt.getY() - multiplier/6), (int)(multiplier), (int)(multiplier), null);
					
				}
			}
		}
		g2.setTransform(baseTransform);
	}
	
	private void thisMouseWheelMoved(MouseWheelEvent evt) {
		if (evt.getWheelRotation() > 0) {
			// Avoid getting reversed
			if (multiplier > 1) {
				--multiplier;
			}
			updateUI();
		} else {
			++multiplier;
			updateUI();
		}
	}
	
	private void thisMouseDragged(MouseEvent evt) {
		if (actionState == GamePanel.ActionState.OnNavigate) {

			XPosition -= lastXMouseOffset - evt.getX();
			YPosition -= lastYMouseOffset - evt.getY();

			lastXMouseOffset = evt.getX();
			lastYMouseOffset = evt.getY();

			updateUI();
		}
	}
	
	private void thisMousePressed(MouseEvent evt) {
		lastXMouseOffset = evt.getX();
		lastYMouseOffset = evt.getY();

		if (actionState != GamePanel.ActionState.OnNavigate) {
			streamClickEvent = true;
			updateUI();
		} else {
			setCursor(new Cursor(Cursor.MOVE_CURSOR));
		}
	}
	
	private void thisMouseMoved(MouseEvent evt) {
		
		if (Math.abs(mouseXPosition - evt.getX()) > 10 || Math.abs(mouseYPosition - evt.getY()) > 10) {
			mouseXPosition = evt.getX();
			mouseYPosition = evt.getY();

			updateUI();
		}
	}

	public void EntityEventOccurred(EntityEvent e) {
		if (e instanceof TurnEvent) {
			TurnEvent t = (TurnEvent)e;
			if (t.getType() == TypeEvent.Started) {
				onTurn = t.getEntity();
			}
		}
		
		updateUI();
	}
	
	public void addBoxClickedEventListener(BoxClickedListener listener) {
		eventListeners.add(BoxClickedListener.class, listener);
	}


	public void ActionStateChanged(ActionStateChangedEvent evt) {
		System.out.println("action");
		actionState = evt.getState();
		targetRange = evt.getTargetRange();
		distanceRange = evt.getDistanceRange();
		targetCoordinates.clear();
		// Check the range
		for (int i = 0; i < chart.getWidth(); i++) {
			for (int j = 0; j < chart.getHeight(); j++) {
				if (chart.getEntitiesOn(chart.getBoxAt(i, j)).contains(onTurn)) {
					for (Box box : chart.getBoxesInRange(chart.getBoxAt(i, j), distanceRange)) {
						targetCoordinates.add(chart.getBoxPosition(box));
					}
				}
			}
		}
		
		if (actionState != GamePanel.ActionState.OnNavigate) {
			((Graphics2D)getGraphics()).setPaint(redFill);
		} else {
			((Graphics2D)getGraphics()).setPaint(greenFill);
			
		}
		
		updateUI();
	}
	
	private void thisMouseReleased(MouseEvent evt) {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

}
