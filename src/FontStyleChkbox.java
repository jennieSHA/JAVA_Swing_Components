import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FontStyleChkbox {

	private JFrame frame;
	int style;
	private JLabel lblNewLabel;
	private JCheckBox chckbxItallic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FontStyleChkbox window = new FontStyleChkbox();
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
	public FontStyleChkbox() {
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
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Info Planet");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JCheckBox chckbxBold = new JCheckBox("Bold");
		chckbxBold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font f = null;
				if(chckbxBold.isSelected())
				{
					style = 1;
				    f = new Font("Tahoma",style,30);
				    lblNewLabel.setFont(f);
				}
				else
				{
					style = 2;
				    f = new Font("Tahoma",style,30);
				    lblNewLabel.setFont(f);
				}
				if(chckbxBold.isSelected() && chckbxItallic.isSelected())
				{
					 style = 2 + 1;
					 f = new Font("Tahoma",style,30);
				     lblNewLabel.setFont(f);
				}
			}
				
		});
		chckbxBold.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(chckbxBold);
		
		chckbxItallic = new JCheckBox("Itallic");
		chckbxItallic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font f = null;
				if(chckbxItallic.isSelected())
				{
					style = 2;
				    f = new Font("Tahoma",style,30);
				    lblNewLabel.setFont(f);
				}
				else
				{
					style = 1;
				    f = new Font("Tahoma",style,30);
				    lblNewLabel.setFont(f);
				}
				if(chckbxBold.isSelected() && chckbxItallic.isSelected())
				{
					 f = new Font("Tahoma",Font.BOLD+Font.ITALIC,30);
				     lblNewLabel.setFont(f);
				}
			}
		});
		chckbxItallic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(chckbxItallic);
	}

}
