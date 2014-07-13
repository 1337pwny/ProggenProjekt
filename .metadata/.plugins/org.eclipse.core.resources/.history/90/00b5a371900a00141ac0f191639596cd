import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Variable homeX and homeY are the home position. Variable startX and startY
 * are for the line start. Variable endX and endY are the end position. Set
 * layout and background for the center/west Pane.
 */
public class PanelWest extends JPanel {

	private static final long serialVersionUID = 1L;

	boolean paintLine = true;
	int homeX = 205;
	int startX = 205;
	int endX = 205;

	int homeY = 280;
	int startY = 280;
	int endY = 280 - 1;// to look north

	int colorInt = 0;

	public PanelWest() {

		this.setLayout(null);
		this.setBackground(Color.WHITE);

		/**
		 * It paints the turtle line. Set the end position to the start
		 * position.
		 */
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (paintLine) {

			if (colorInt == 0) {

				g.setColor(Color.black);
			} else if (colorInt == 1) {
				g.setColor(Color.blue);
			} else if (colorInt == 2) {
				g.setColor(Color.red);
			} else if (colorInt == 3) {
				g.setColor(Color.green);
			}
		}
		g.drawLine(startX, startY, endX, endY);

		double lengthArrow = 10;

		double a = Math.PI / 4 - Math.atan2((endY - startY), (endX - startX));
		double c = Math.cos(a) * lengthArrow;
		double s = Math.sin(a) * lengthArrow;
		g.drawLine(endX, endY, (int) (endX - s), (int) (endY - c));
		g.drawLine(endX, endY, (int) (endX - c), (int) (endY + s));

	}
	// startX = endX;
	// startY = endY;

}
