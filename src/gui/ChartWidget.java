package gui;

import gameChart.BidimensionalChart;
import gameChart.RectangularChart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.WindowConstants;
import javax.swing.JFrame;


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

	private BidimensionalChart chart;
	private int multiplier = 20;
	private int XBounds = 100;
	private int YBounds = 100;
	
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ChartWidget());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ChartWidget() {
		super();
		chart = new RectangularChart(15, 10);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.addMouseMotionListener(new MouseMotionAdapter() {
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
					public void keyPressed(KeyEvent evt) {
						thisKeyPressed(evt);
					}
				});
			}
			setPreferredSize(new Dimension(chart.getWidth()*20, chart.getHeight()*20));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		paintInDeviceCoords(g);
	}

	public void paintInDeviceCoords(Graphics g)
	{
		int width = chart.getWidth() * multiplier;
		int heigth = chart.getHeight() * multiplier;
		
		AffineTransform at = AffineTransform.getRotateInstance(-0.91, XBounds + width/2 , YBounds + heigth/2);
		at.shear(0, .3);
		at.translate(-50, 0);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.transform(at);
		for (int i = 0; i < chart.getWidth(); i++) {
			for (int j = 0; j < chart.getHeight(); j++) {
		        Rectangle2D rectangle = new Rectangle2D.Float(XBounds + i * multiplier, YBounds + j * multiplier, multiplier, multiplier);
		        g2.draw(rectangle);
			}
		}
		
		
		
	}
	
	private void thisKeyPressed(KeyEvent evt) {
		System.out.println("this.keyPressed, event="+evt);
		
		if (evt.getKeyChar() == 'a') {
			multiplier += 1;
		}
	}
	
	private void thisMouseWheelMoved(MouseWheelEvent evt) {
		System.out.println("this.mouseWheelMoved, event="+evt);
		//TODO add your code for this.mouseWheelMoved
		if (evt.getWheelRotation() > 0) {
			multiplier++;
			updateUI();
		} else {
			multiplier--;
			updateUI();
		}
	}
	
	private void thisMouseDragged(MouseEvent evt) {
		System.out.println("this.mouseDragged, event="+evt);
		//TODO add your code for this.mouseDragged
		XBounds = evt.getX();
		YBounds = evt.getY();
		updateUI();
	}

}
