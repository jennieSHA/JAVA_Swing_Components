import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class StudentFormDisplay {

	private JFrame frame;
	Connection con;
	Statement st = null;
	ResultSet rs;
	String name,addrs,roll,clg,gender;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
	private JTextArea textArea_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFormDisplay window = new StudentFormDisplay(null,null,null,null,null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public StudentFormDisplay(String name,String roll,String addrs,String gender,String clg) {
	    this.name = name;
	    this.roll = roll;
	    this.addrs = addrs;
	    this.gender = gender;
	    this.clg = clg;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Driver is Registered");
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","Jinisha","jini");
			System.out.println("Connected to db!");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			st = con.createStatement();
		    rs = st.executeQuery("Select * from student_info");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(62, 10, 59, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile No:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(62, 71, 92, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(62, 128, 70, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(62, 184, 70, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("College:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(62, 238, 70, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.BOLD, 18));
		textArea.setEditable(false);
		textArea.setBounds(202, 10, 152, 27);
		frame.getContentPane().add(textArea);
		textArea.setText(name);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Courier New", Font.BOLD, 18));
		textArea_1.setEditable(false);
		textArea_1.setBounds(202, 72, 152, 27);
		frame.getContentPane().add(textArea_1);
		textArea_1.setText(roll);
		
		textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Courier New", Font.BOLD, 18));
		textArea_3.setEditable(false);
		textArea_3.setBounds(202, 194, 152, 26);
		frame.getContentPane().add(textArea_3);
		textArea_3.setText(gender);
		
		textArea_4 = new JTextArea();
		textArea_4.setFont(new Font("Courier New", Font.BOLD, 18));
		textArea_4.setEditable(false);
		textArea_4.setBounds(202, 248, 152, 27);
		frame.getContentPane().add(textArea_4);
		textArea_4.setText(clg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(202, 114, 201, 62);
		frame.getContentPane().add(scrollPane);
		
		textArea_2 = new JTextArea();
		scrollPane.setViewportView(textArea_2);
		textArea_2.setFont(new Font("Courier New", Font.BOLD, 18));
		textArea_2.setEditable(false);
		textArea_2.setText(addrs);
		
		JButton PrevBtn = new JButton("Previous");
		PrevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rs.previous())
					{
						textArea.setText(rs.getString(1));
						textArea_1.setText(String.valueOf(rs.getInt(2)));
						textArea_2.setText(rs.getString(3));
						textArea_3.setText(rs.getString(4));
						textArea_4.setText(rs.getString(5));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		PrevBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PrevBtn.setBounds(69, 325, 109, 38);
		frame.getContentPane().add(PrevBtn);
		
		JButton nextBtn = new JButton("Next");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rs.next())
					{
						textArea.setText(rs.getString(1));
						textArea_1.setText(String.valueOf(rs.getInt(2)));
						textArea_2.setText(rs.getString(3));
						textArea_3.setText(rs.getString(4));
						textArea_4.setText(rs.getString(5));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		nextBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nextBtn.setBounds(245, 325, 109, 38);
		frame.getContentPane().add(nextBtn);
		
	}
}
