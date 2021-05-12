import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OptionPane {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionPane window = new OptionPane();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OptionPane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Message");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "This is message","My Msg Dialog",JOptionPane.WARNING_MESSAGE);
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = JOptionPane.showConfirmDialog(frame, "Are u sure?","My Confirm Dialog",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(x == JOptionPane.YES_OPTION)
					frame.setTitle("Yes Option SELECTED");
				else if(x == JOptionPane.NO_OPTION)
					frame.setTitle("NO Option SELECTED");
				else if(x == JOptionPane.CANCEL_OPTION)
					frame.setTitle("Cancel Option SELECTED");
				else if(x == JOptionPane.CLOSED_OPTION)
					frame.setTitle("Closed Option SELECTED");
				else
					frame.setTitle("My Frame");
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Input");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = JOptionPane.showInputDialog(frame, "Enter Title For Frame","My Input Dialog",JOptionPane.QUESTION_MESSAGE);
				if(str == null)
					frame.setTitle(null);
				else
					frame.setTitle(str);
			}
		});
		frame.getContentPane().add(btnNewButton_2);
	}

}
