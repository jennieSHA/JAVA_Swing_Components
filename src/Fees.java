import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Fees {

	private JFrame frame;
	int fees;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textArea;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fees window = new Fees();
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
	public Fees() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 531, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(86, 10, 65, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				switch(index)
				{
					case 0: fees = 2500;
					break;
					case 1: fees = 2500;
					break;
					case 2: fees = 4500;
					break;
					case 3: fees = 4500;
					break;
					case 4: fees = 3500;
					break;
					case 5: fees = 6000;
					break;
					case 6: fees = 6000;
					break;
				}
				textArea.setText(Integer.toString(fees));
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"C", "C++", "Core Java", "Advanced Java", "Python", "Android", "Data Structure",}));
		comboBox.setBounds(201, 10, 130, 32);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Fees");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(86, 70, 45, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.BOLD, 17));
		textArea.setBounds(201, 70, 127, 24);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Mode");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(86, 115, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JRadioButton rdbtnRegular = new JRadioButton("Regular");
		buttonGroup.add(rdbtnRegular);
		rdbtnRegular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnRegular.setBounds(201, 111, 118, 21);
		frame.getContentPane().add(rdbtnRegular);
		
		JRadioButton rdbtnFastTrack = new JRadioButton("Fast Track");
		rdbtnFastTrack.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnFastTrack.isSelected())
				fees = fees + 1000;
			}
		});
		buttonGroup.add(rdbtnFastTrack);
		rdbtnFastTrack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFastTrack.setBounds(325, 111, 128, 21);
		frame.getContentPane().add(rdbtnFastTrack);
		
		JLabel lblNewLabel_3 = new JLabel("Others");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(86, 176, 63, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		JCheckBox chckbxNotes = new JCheckBox("Notes");
		chckbxNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNotes.isSelected())
				    fees = fees + 500;
				else
					fees = fees - 500;
			}
		});
		chckbxNotes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxNotes.setBounds(201, 172, 106, 21);
		frame.getContentPane().add(chckbxNotes);
		
		JCheckBox chckbxApp = new JCheckBox("App");
		chckbxApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxApp.isSelected())
				    fees = fees + 500;
				else
					fees = fees - 500;
			}
		});
		chckbxApp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxApp.setBounds(315, 172, 114, 21);
		frame.getContentPane().add(chckbxApp);
		
		JCheckBox chckbxNewExam = new JCheckBox("Exam");
		chckbxNewExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewExam.isSelected())
				    fees = fees + 500;
				else
					fees = fees - 500;
			}
		});
		chckbxNewExam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxNewExam.setBounds(201, 199, 109, 21);
		frame.getContentPane().add(chckbxNewExam);
		
		JCheckBox chckbxLabA = new JCheckBox("Lab Assistant");
		chckbxLabA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxLabA.isSelected())
				    fees = fees + 500;
				else
					fees = fees - 500;
			}
		});
		chckbxLabA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxLabA.setBounds(315, 199, 140, 21);
		frame.getContentPane().add(chckbxLabA);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText(Integer.toString(fees));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(201, 248, 116, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Total Fees");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(86, 307, 102, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Courier New", Font.BOLD, 18));
		textArea_1.setBounds(226, 308, 147, 29);
		frame.getContentPane().add(textArea_1);
	}
}
