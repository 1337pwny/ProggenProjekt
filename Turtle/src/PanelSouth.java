import java.awt.BorderLayout;


import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSouth extends JPanel{
	private  static final long serialVersionUID = 1L;
	
	JLabel status = new JLabel("Ready");
	public PanelSouth() {


		
		this.setLayout(new BorderLayout());

		this.add(new JLabel("  Status:  "), BorderLayout.WEST);



		this.add(status, BorderLayout.CENTER);
		status.setForeground(Color.green);


		
		/*	
		switch (statusWert){
		
		case (0):
		status.setText("Ready");
		status.setForeground(Color.green);
		
		case (1):
		status.setText("Load Successful");
		status.setForeground(Color.green);
		}
	/*	status.setText("Working");
		status.setForeground(Color.yellow);
	
		
		
		status.setText("Error");
		status.setForeground(Color.red);
		
		status.setText("Error - Parser not found");
		status.setForeground(Color.red);
		
		status.setText("Error - Variable already in use");
		status.setForeground(Color.red);			
		
		status.setText("Error - Variable not found");
		status.setForeground(Color.red);			

	*/
		}

	public void counter(int counterStep){
	this.add(new JLabel("Step counter:  " + counterStep + "   "),BorderLayout.EAST);
	}
	
	}
