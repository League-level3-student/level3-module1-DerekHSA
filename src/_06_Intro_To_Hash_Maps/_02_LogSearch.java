package _06_Intro_To_Hash_Maps;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements MouseListener {
	JFrame frame;
	JPanel panel;
	JButton b1;
	JButton b2;
	JButton b3;
	HashMap<Integer ,String> lol;
	public static void main(String[] args) {
		new _02_LogSearch();
	}
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	public _02_LogSearch() {
		frame = new JFrame();
		panel = new JPanel();
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		lol = new HashMap<Integer, String>();
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.setText("Add Entry");
		panel.add(b1);
		b2.setText("Search by ID");
		panel.add(b2);
		b3.setText("View List");
		panel.add(b3);
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		b3.addMouseListener(this);
		frame.pack();
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource()==b1) {
			String ts;
			String ti;
			int ti2;
			ti=JOptionPane.showInputDialog("Please enter an ID number");
			ts=JOptionPane.showInputDialog("Please enter a name");
			ti2=Integer.parseInt(ti);
			lol.put(ti2, ts);
		}else if(arg0.getSource()==b2) {
			String ts;
			ts=JOptionPane.showInputDialog("Please enter the ID number you would like to search for");
			int ti=Integer.parseInt(ts);
			for (Integer I : lol.keySet()) {
				if(I==ti) {
					JOptionPane.showMessageDialog(null, lol.get(I));
				}
			}
		}else if(arg0.getSource()==b3) {
			String ts = "";
			for (Integer i : lol.keySet()) {
				ts+=("ID: "+i+"  Name: "+lol.get(i)+"   ");
				
			}
			JOptionPane.showMessageDialog(null, ts);
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
