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

import logic.Parser;
import logic.Position;
import exceptions.ParserNotFoundException;
import exceptions.SyntaxErrorException;
import exceptions.VariableAlreadyInUseException;
import exceptions.VariableNotFoundException;

public class PanelEast extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	JTextArea inputManual = new JTextArea(28, 0);
	JSlider sliderSpeed = new JSlider();
	//Parser pars = new Parser();
	Parser pars;
	Position[] turtlePosition;
	Position turtleData;
	Position[] pos;
	public PanelEast() {
		// Layout in east
		pars=new Parser();
		
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

		sliderSpeed.setMajorTickSpacing(10);
		sliderSpeed.setMinorTickSpacing(0);
		sliderSpeed.setPaintTicks(true);

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

			Start.statusPane.status.setText("Run");
			Start.statusPane.status.setForeground(Color.green);

			String[] textFieldInput = inputManual.getText().split("\\n"); 
																			
			try {
				pos=pars.parseAll(textFieldInput);
			} catch (ParserNotFoundException e) {

				Start.statusPane.status.setText("Parser not found");
				Start.statusPane.status.setForeground(Color.red);

			} catch (SyntaxErrorException e) {

				Start.statusPane.status.setText("Syntax Error");
				Start.statusPane.status.setForeground(Color.red);
			} catch (VariableAlreadyInUseException e) {

				Start.statusPane.status.setText("Variable alreadi in use");
				Start.statusPane.status.setForeground(Color.red);
			} catch (VariableNotFoundException e) {

				Start.statusPane.status.setText("Variable not found");
				Start.statusPane.status.setForeground(Color.red);
			} catch (Exception e) {
				e.printStackTrace();
			}

			turtlePosition = pars.getTurtlePositions();
			System.out.println(pos.length);

			for (int i = 0; i < turtlePosition.length; i++) {
				try {
					Thread.sleep(sliderSpeed.getValue() * 10);
				} catch (InterruptedException e) {
					Start.statusPane.status.setText("Error - Interrupted");
					Start.statusPane.status.setForeground(Color.red);

				}
				Start.statusPane.counter(turtlePosition.length - 1);
				turtleData=turtlePosition[i];
				Start.paintPane.paintLine = turtleData.getPenState();
				Start.paintPane.endX = Start.paintPane.endX
						+ turtleData.getPositionX();
				Start.paintPane.endY = Start.paintPane.endY
						+ turtleData.getPositionY();

				Start.paintPane.repaint();

				if (Start.paintPane.endX > 410 || Start.paintPane.endX < 0
						|| Start.paintPane.endY > 560
						|| Start.paintPane.endY < 0) {

					Start.statusPane.status.setText("Turtle out of sight");
					Start.statusPane.status.setForeground(Color.orange);

				}

				Start.statusPane.status.setText("Ready");
				Start.statusPane.status.setForeground(Color.green);

			}
		}
		/**
		 * It will paint one step of the turtle line.
		 */

		else if (action.equals("Step")) {
			// String[] textFieldInput = inputManual.getText().split("\\n");

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
