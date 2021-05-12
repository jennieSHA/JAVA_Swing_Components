import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ColorCheckBox {

	private JFrame frame;
    int r,g,b;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColorCheckBox window = new ColorCheckBox();
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
	public ColorCheckBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JCheckBox chckbxNewCheckBox_red = new JCheckBox("RED");
		chckbxNewCheckBox_red.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chckbxNewCheckBox_red.isSelected())
					r = 255;
				else
					r = 0;
				Color clr = new Color(r,g,b);
				panel.setBackground(clr);
			}
		});
		panel.add(chckbxNewCheckBox_red);
		
		JCheckBox chckbxNewCheckBox_green = new JCheckBox("GREEN");
		chckbxNewCheckBox_green.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chckbxNewCheckBox_green.isSelected())
					g = 255;
				else
					g = 0;
				Color clr = new Color(r,g,b);
				panel.setBackground(clr);
			}
		});
		panel.add(chckbxNewCheckBox_green);
		
		JCheckBox chckbxNewCheckBox_blue = new JCheckBox("BLUE");
		chckbxNewCheckBox_blue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chckbxNewCheckBox_blue.isSelected())
					b = 255;
				else
					b = 0;
				Color clr = new Color(r,g,b);
				panel.setBackground(clr);
			}
		});
		panel.add(chckbxNewCheckBox_blue);
	}

}
