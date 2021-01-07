package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	int lives;
	JFrame frame;
	JPanel panel;
	JLabel label;
	JLabel life;
	Stack<String> stack;
	String input;
	String gate;
	String tempString;
	String u;
	int output;

	public static void main(String[] args) {
		new HangMan();

	}

	public HangMan() {
		start();
		runGame();
	}

	public void start() {
		lives = 10;
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		panel = new JPanel();
		label = new JLabel();
		life = new JLabel();
		life.setText("Lives: "+lives);
		stack = new Stack<String>();
		frame.add(panel);
		panel.add(label);
		panel.add(life);
		input = JOptionPane.showInputDialog("Enter a number (1-266)");
		output = Integer.parseInt(input);
		for (int i = 0; i < output; i++) {
			gate = Utilities.readRandomLineFromFile("dictionary.txt");
			if (stack.contains(gate)) {
				i--;
			} else {
				stack.push(gate);
			}

		}
	}

	public void runGame() {
			if (lives > 0) {
				if (!stack.isEmpty()) {
					tempString = stack.pop();
					u = "";
					for (int j = 0; j < tempString.length(); j++) {
						u += "_ ";
					}
					label.setText(u);
				} else {
					end();
				}
				frame.pack();
			} else {
				end();
			}
		}
	public void end() {
		int leave = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "HangMan", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (leave == JOptionPane.YES_OPTION) {
			System.exit(0);
		} else {
			frame.setVisible(false);
			start();
			runGame();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		String tempU = "";
		if (tempString.contains(String.valueOf(arg0.getKeyChar()))) {
			for (int i = 0; i < tempString.length(); i++) {
				if (arg0.getKeyChar() == tempString.charAt(i)) {
					tempU += (arg0.getKeyChar() + " ");
				}else {
					tempU+=(u.charAt(i*2)+" ");
				}
			}
			u=tempU;
			label.setText(u);
			if(!u.contains(String.valueOf("_"))) {
				runGame();
			}
		} else {
			lives--;
			life.setText("Lives: "+lives);
			if(lives<1) {
				end();
			}
		}
	}

}
