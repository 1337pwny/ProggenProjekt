import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.Timer;
/**
 * 
 * @author Benjamin Dähn
 *
 */
public class PanelEast extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	JTextArea inputManual = new JTextArea(27, 0);
	JSlider sliderSpeed = new JSlider();
	int counter;
	int iStep = 0;
	Timer runTimer;
	Exchange exchange;

	public PanelEast() {
		// Layout in east

		this.setLayout(new BorderLayout());

		JPanel inEastUp = new JPanel();
		this.add(inEastUp, BorderLayout.PAGE_START);
		inEastUp.setLayout(new BorderLayout());

		JScrollPane scrollpaneInputManual = new JScrollPane(inputManual);
		inEastUp.add(scrollpaneInputManual);

		JPanel inEastCenter = new JPanel();
		this.add(inEastCenter, BorderLayout.CENTER);

		JButton run = new JButton("Run");
		JButton step = new JButton("Step");
		JButton newStart = new JButton("New");
		JButton load = new JButton("Load");
		JButton save = new JButton("Save");
		JButton reset = new JButton("Reset");
		JButton help = new JButton("Help");

		sliderSpeed.setMajorTickSpacing(1000);
		sliderSpeed.setMaximum(5000);
		sliderSpeed.setMinimum(0);
		sliderSpeed.setPaintTicks(true);
		sliderSpeed.setPaintLabels(true);
		
		sliderSpeed.setLabelTable(sliderSpeed.createStandardLabels(1000));

		run.addActionListener(this);
		step.addActionListener(this);
		newStart.addActionListener(this);
		load.addActionListener(this);
		save.addActionListener(this);
		reset.addActionListener(this);
		help.addActionListener(this);

		inEastCenter.add(new JLabel("Speed:"));
		inEastCenter.add(sliderSpeed);
		inEastCenter.add(run);
		inEastCenter.add(step);

		JPanel inEastDown = new JPanel();

		this.add(inEastDown, BorderLayout.PAGE_END);

		inEastDown.add(newStart);
		inEastDown.add(load);
		inEastDown.add(save);
		inEastDown.add(reset);
		inEastDown.add(help);
	}

	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		/**
		 * It will paint the complete turtle line with the insert information.
		 */

		if (action.equals("Run")) {
			System.out.println(sliderSpeed.getValue());
			runTimer = new Timer(sliderSpeed.getValue(), new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Exchange exchange = new Exchange();

					exchange.newPaint(iStep);

				}
			});
			runTimer.start();
		}
		/**
		 * It will paint one step of the turtle line.
		 */

		else if (action.equals("Step")) {
			Exchange exchange = new Exchange();

			exchange.newPaint(iStep);

		}
		/**
		 * It clean the text area and set the turtle in home position.
		 */
		else if (action.equals("New")) {

			int newStart = JOptionPane.showConfirmDialog(null,
					"New clears the editor!", "New", JOptionPane.YES_NO_OPTION);
			System.out.println(newStart);

			if (newStart == 0) {
				inputManual.setText("");
				Start.statusPane.status.setText("New");
				Start.statusPane.status.setForeground(Color.green);
			} else {
				System.out.println("New - command cancelled by user.");
			}

		}
		/**
		 * It load a file. Reset text area.
		 */
		else if (action.equals("Load")) {

			JFileChooser load = new JFileChooser();

			int returnVal = load.showOpenDialog(null);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = load.getSelectedFile();

				try {
					inputManual.setText("");
					BufferedReader readBuffered = new BufferedReader(
							new FileReader(file));

					String inTextField;
					while ((inTextField = readBuffered.readLine()) != null) {
						inputManual.append(inTextField + "\n");

						Start.statusPane.status.setText("Load succesful");
						Start.statusPane.status.setForeground(Color.green);
					}

					readBuffered.close();

				} catch (FileNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
					Start.statusPane.status.setText("Error - File not found");
					Start.statusPane.status.setForeground(Color.red);
				}
			} else {
				System.out.println("Load - command cancelled by user.");
			}

			/**
			 * It save a file. With variable append = true you can append the
			 * new save on the old. You can create a save name with an
			 * InputDialog in String dataName. The data will be saved without an
			 * ending (like *.txt)
			 */

		} else if (action.equals("Save")) {

			String[] outTextField = inputManual.getText().split("\\n");

			JFileChooser save = new JFileChooser();

			int returnVal = save.showSaveDialog(null);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = save.getSelectedFile();

				try {
					boolean append = false;
					PrintWriter out = new PrintWriter(new BufferedWriter(
							new FileWriter(file, append)));

					for (int i = 0; i < outTextField.length; i++) {
						out.println(outTextField[i]);
						Start.statusPane.status.setText("Saved");
						Start.statusPane.status.setForeground(Color.green);
					}
					out.close();

				} catch (IOException e) {
					System.out.println("Didn´t save." + (outTextField.length));
					Start.statusPane.status.setText("IO Error");
					Start.statusPane.status.setForeground(Color.red);
				}
			}

			/**
			 * It only set the turtle line in home position.
			 */
		} else if (action.equals("Reset")) {
			int reset = JOptionPane.showConfirmDialog(null,
					"Reset program? All information will be reset!", "Reset",
					JOptionPane.YES_NO_OPTION);

			if (reset == 0) {
				try{
					runTimer.stop();
				}
				catch(NullPointerException e){
					
				}
				iStep = 0;
				Start.statusPane.counter
						.setText(("Step counter: " + iStep + "  "));
				Start.paintPane.paintLine = true;
				Start.paintPane.startX = Start.paintPane.homeX;
				Start.paintPane.endX = Start.paintPane.homeX;
				Start.paintPane.startY = Start.paintPane.homeY;
				Start.paintPane.endY = Start.paintPane.homeY - 1;
				Start.paintPane.repaint();
				inputManual.setText("");
				Start.statusPane.status.setText("Reset done");
				Start.statusPane.status.setForeground(Color.green);
			} else {
				System.out.println("Reset - command cancelled by user.");
			}

		} else if (action.equals("Help")) {
			JOptionPane.showMessageDialog(null,
					"You can use the following syntax:\n\nthis\nand this",
					"Help", JOptionPane.INFORMATION_MESSAGE);

		}
	}

}
