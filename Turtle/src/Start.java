import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import logic.Parser;
import logic.Position;


/**
 * Start JFrame with paintPane, workingPane and statusPane inside
 * @author Benjamin Dähn
 */

public class Start {

	/**
	 * Paints turtle
	 */
	public static PanelWest paintPane = new PanelWest();

	/**
	 * Input from User
	 */
	public static PanelEast workingPane = new PanelEast();
	
	/**
	 * Shows status and counter
	 */
	public static PanelSouth statusPane = new PanelSouth();

	/**
	 * Ground Frame
	 * @param args
	 */
	public static void main(String[] args)  {
		
		
		JFrame ground = new JFrame();
		ground.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		Dimension windowSize = new Dimension(800, 600);
		
		ground.setSize(windowSize);
		ground.setResizable(false);
		
		ground.setTitle("Turtle by Dähn & Rohde");
		ground.getContentPane().add(workingPane, BorderLayout.EAST);
		ground.getContentPane().add(statusPane, BorderLayout.SOUTH);
		ground.getContentPane().add(paintPane, BorderLayout.CENTER);
		
				
		ground.setVisible(true);
		}

		
	}
		