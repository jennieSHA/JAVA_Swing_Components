import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FontRadioButton {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
    int fsize = 10;
    String fname = "Tahoma";
    private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FontRadioButton window = new FontRadioButton();
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
	public FontRadioButton() {
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
		
		JRadioButton rdbtn12 = new JRadioButton("12");
		rdbtn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fsize = 12;
				Font f = new Font(fname,Font.PLAIN,fsize);
				lblNewLabel.setFont(f); 
			}
		});
		buttonGroup.add(rdbtn12);
		panel.add(rdbtn12);
		
		JRadioButton rdbtn20 = new JRadioButton("20");
		rdbtn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fsize = 20;
				Font f = new Font(fname,Font.PLAIN,fsize);
				lblNewLabel.setFont(f); 
			}
		});
		buttonGroup.add(rdbtn20);
		panel.add(rdbtn20);
		
		JRadioButton rdbtn40 = new JRadioButton("40");
		rdbtn40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fsize = 40;
				Font f = new Font(fname,Font.PLAIN,fsize);
				lblNewLabel.setFont(f); 
			}
		});
		buttonGroup.add(rdbtn40);
		panel.add(rdbtn40);
		
		JRadioButton rdbtn60 = new JRadioButton("60");
		rdbtn60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fsize = 60;
				Font f = new Font(fname,Font.PLAIN,fsize);
				lblNewLabel.setFont(f); 
			}
		});
		buttonGroup.add(rdbtn60);
		panel.add(rdbtn60);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JRadioButton rdbtnAriel = new JRadioButton("Arial");
		rdbtnAriel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fname = "Arial";
				Font f = new Font(fname,Font.PLAIN,fsize);
				lblNewLabel.setFont(f); 
			}
		});
		buttonGroup_1.add(rdbtnAriel);
		panel_1.add(rdbtnAriel);
		
		JRadioButton rdbtnHelvetica = new JRadioButton("Cooper black");
		rdbtnHelvetica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fname = "Cooper black";
				Font f = new Font(fname,Font.PLAIN,fsize);
				lblNewLabel.setFont(f); 
			}
		});
		buttonGroup_1.add(rdbtnHelvetica);
		panel_1.add(rdbtnHelvetica);
		
		lblNewLabel = new JLabel("Info Planet");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}
