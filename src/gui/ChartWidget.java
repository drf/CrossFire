package gui;

import gameChart.BidimensionalChart;
import gameChart.BoxBusyException;
import gameChart.City;
import gameChart.Hill;
import gameChart.Plain;
import gameChart.RectangularChart;
import globals.Entity;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import javax.imageio.ImageIO;
import javax.swing.WindowConstants;
import javax.swing.JFrame;

import characters.Dragon;


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
public class ChartWidget extends javax.swing.JPanel {

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
	private boolean draggingMode = true;
	private BufferedImage plainTexture;
	private BufferedImage hillTexture;
	private BufferedImage cityTexture;
	private AffineTransform baseTransform;
	
	
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ChartWidget(new RectangularChart(10,15)));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ChartWidget(BidimensionalChart chart) {
		super();
		this.chart = chart;
		try {
			chart.place(new Dragon(), chart.getBoxAt(0,0));
			chart.place(new Dragon(), chart.getBoxAt(6,8));
		} catch (BoxBusyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
			{
				this.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent evt) {
						thisKeyReleased(evt);
					}
					public void keyPressed(KeyEvent evt) {
						thisKeyPressed(evt);
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
		        		g2.fillRect(XPosition + i * multiplier, YPosition + j * multiplier, multiplier, multiplier);
		        	}
		        } catch (NoninvertibleTransformException e) {
		        	e.printStackTrace();
		        }
		        
			}
		}
		
		// Paint the entities (they should be on top view)
		paintEntities(g2);
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
	
	private void thisKeyPressed(KeyEvent evt) {
		System.out.println("this.keyPressed, event="+evt);
		
		if (evt.getKeyCode() == KeyEvent.VK_CONTROL) {
			draggingMode = true;
			setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		}
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
		System.out.println("this.mouseDragged, event="+evt);
		//TODO add your code for this.mouseDragged
		
		if (draggingMode) {

			XPosition -= lastXMouseOffset - evt.getX();
			YPosition -= lastYMouseOffset - evt.getY();

			lastXMouseOffset = evt.getX();
			lastYMouseOffset = evt.getY();

			updateUI();
		}
	}
	
	private void thisMousePressed(MouseEvent evt) {
		System.out.println("this.mousePressed, event="+evt);
		lastXMouseOffset = evt.getX();
		lastYMouseOffset = evt.getY();
	}
	
	private void thisKeyReleased(KeyEvent evt) {
		System.out.println("this.keyReleased, event="+evt);
		
		if (evt.getKeyCode() == KeyEvent.VK_CONTROL) {
			draggingMode = false;
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}
	
	private void thisMouseMoved(MouseEvent evt) {
		
		mouseXPosition = evt.getX();
		mouseYPosition = evt.getY();
		
		updateUI();
	}

}
