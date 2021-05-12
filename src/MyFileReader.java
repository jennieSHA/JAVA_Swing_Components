import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MyFileReader {

	private JFrame frame;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFileReader window = new MyFileReader();
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
	public MyFileReader() {
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
		
		JLabel lblNewLabel = new JLabel("File Name:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedReader in = null;
				String fileName = textField.getText();
				textArea.setText("");
				try
				{
				 in = new BufferedReader(new FileReader(fileName));
				// C:\Users\User\Documents\logic.txt
//				 textArea.setText("gsgsgd");
//				 textArea.setText("sdgdg");
				String line;
				while((line=in.readLine()) != null)
				{
					//System.out.println(in.readLine());
					 //textArea.setText(in.readLine());
					 textArea.append(line+"\n");
					 
				}
				in.close();
				
				}
//				catch(EOFException e3)
//				{
//					 try {
//						in.close();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
				catch(FileNotFoundException e2)
				{
					textArea.setText("Sorry,File Not Found:(");
				}
				catch(IOException e1)
				{
					e1.printStackTrace();
				}


			}
		});
		panel.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Courier New", Font.BOLD, 20));
		scrollPane.setViewportView(textArea);
	}

}
