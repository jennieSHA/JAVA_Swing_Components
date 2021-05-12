import java.awt.EventQueue;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class formatedTxtField {

	private JFrame frame;
	private JLabel lbl;
	private JLabel lblLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formatedTxtField window = new formatedTxtField();
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
	public formatedTxtField() {
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
		
		NumberFormat nf = NumberFormat.getIntegerInstance();
		nf.setMinimumIntegerDigits(10);
		JFormattedTextField frmtdtxtfld = new JFormattedTextField(nf);
		frmtdtxtfld.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmtdtxtfld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no =frmtdtxtfld.getText();
				if(no.length() == 10)
				{
					if(no.charAt(0) == '6' || no.charAt(0) == '7' || no.charAt(0) == '8' || no.charAt(0) == '9')
					{
					    lbl.setText(no+" is valid");
					}
				}
				else
					lbl.setText(no+" is not valid");
			}
		});
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(frmtdtxtfld);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 0, 0, 0));
		
		lbl = new JLabel("");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(lbl);
		
		
		String regex = "^(.+)@(.+).com$";
		Pattern pattern = Pattern.compile(regex);
		JFormattedTextField ftf = new JFormattedTextField();
		ftf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ftf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = ftf.getText();
				Matcher matcher = pattern.matcher(email);
				if(matcher.matches())
				    lblLabel.setText(email+" is valid");
				else
					lblLabel.setText(email+" is not valid");
			}
		});
		panel_1.add(ftf);
		
		lblLabel = new JLabel("");
		lblLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(lblLabel);
	}

}
