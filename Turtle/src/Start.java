import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;




public class Start {


	public static PanelWest paintPane = new PanelWest();
	public static PanelEast workingPane = new PanelEast();
	public static PanelSouth statusPane = new PanelSouth();

	public static void main(String[] args) {
		
		
		
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
		