import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import logic.Position;

/**
 * Variable homeX and homeY are the home position. Variable startX and startY
 * are for the line start. Variable endX and endY are the end position. Set
 * layout and background for the center/west Pane.
 * 
 * @author Bejamin Dähn
 */
public class PanelWest extends JPanel {

	private static final long serialVersionUID = 1L;
	Position[] pos;
	boolean posSet;
	boolean paintLine = true;
	int homeX = 205;
	int startX = 205;
	int endX = 205;

	int homeY = 280;
	int startY = 280;
	int endY = 280 - 1;// to look north

	int colorInt = 0;

	public void setPos(Position[] pos){
		this.pos=pos;
		posSet=true;
	}
	public PanelWest() {

		posSet=false;
		this.setLayout(null);
		this.setBackground(Color.WHITE);

		/**
		 * It paints the turtle line. Set the end position to the start
		 * position.
		 */
	}

	public void paint(Graphics g) {
		this.paintComponent(g);
		if(posSet){
			for(int i=0;i<pos.length-1;i++){
				if(pos[i].getPenState()){
					
					switch (pos[i].getColor()) {

					case 0:
						g.setColor(Color.black);
						break;
					case 1:
						g.setColor(Color.blue);
						break;
					case 2:
						g.setColor(Color.red);
						break;
					case 3:
						g.setColor(Color.green);
						break;
					default:
						g.setColor(Color.black);
						break;
					}
					g.drawLine(homeX+pos[i].getPositionX(), homeY+pos[i].getPositionY(), homeX+pos[i+1].getPositionX(), homeY+pos[i+1].getPositionY());
				}
				g.drawOval(homeX+pos[pos.length-1].getPositionX()-5, homeY+pos[pos.length-1].getPositionY()-5, 10, 10);
			}
			
		}
		
		startX = endX;
		startY = endY;
	}

}