import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class MenuBar {

	private JFrame frame;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private boolean isFrmNew = true;
	private boolean isTyped = false;
	String state = "";
	String filename;
	String copiedText = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBar window = new MenuBar();
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
	public MenuBar() {
		initialize();
	}
	private void saveMethod()
	{
		FileDialog dlg = new FileDialog(frame, "Save as", FileDialog.SAVE); 
		dlg.setVisible(true);
		String filename = dlg.getDirectory()+dlg.getFile();
		frame.setTitle("MyNotepad - "+filename);
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(filename +".txt")); 
			pw.print(textArea.getText());
			pw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 442);
		frame.setTitle("MyNotepad - "+"Untitled");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New",'n');
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("MyNotepad - "+"Untitled");
				textArea.setText(null);
				isFrmNew = true;
				//state = "Untyped";
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open",'o');
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               
				//state = "Typed"; 
				FileDialog dlg = new FileDialog(frame);
                dlg.setVisible(true);
				BufferedReader bf = null;
				filename = dlg.getDirectory()+dlg.getFile();
				frame.setTitle("MyNotepad - "+filename);
				isFrmNew = false;
				textArea.setText("");
				try {
					bf = new BufferedReader(new FileReader(filename));
					String line = bf.readLine();
					while(line != null)
					{
						textArea.append(line+"\n");
						line = bf.readLine();
					}
					bf.close();
				}catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					textArea.setText("Sorry,File Not Found:(");
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				finally {
//				 isTyped = false;
//				}

			}
			
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save as",'s');
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveMethod();
			}
		});
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Save");
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isFrmNew == true)
				{
					saveMethod();
				}
				else
				{
					try {
						PrintWriter pw = new PrintWriter(new FileWriter(filename +".txt")); 
						pw.print(textArea.getText());
						pw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Exit");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Copy");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 copiedText = textArea.getSelectedText();
				
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Cut");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copiedText = textArea.getSelectedText();
				textArea.replaceSelection(null);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Paste");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (copiedText != null) {
					textArea.insert(copiedText, textArea.getCaretPosition());
				}
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Select All");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.select(0, textArea.getText().length());
			}
		});
		mntmNewMenuItem_8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmNewMenuItem_8.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_2 = new JMenu("Font");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Bold");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textArea.getSelectedText() == null)
				{
					textArea.setFont(new Font("Courier New", Font.BOLD, 20));
				}
				else
				{
					
				}
			}
		});
		mntmNewMenuItem_9.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Plain");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Italic");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenuItem_11.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		mnNewMenu_2.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Bold Italic");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenuItem_12.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		mnNewMenu_2.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_3 = new JMenu("Size");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu_2.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("9");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenuItem_13.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		mnNewMenu_3.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("12");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenuItem_14.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu_3.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("16");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenuItem_15.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("20");
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenuItem_16.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnNewMenu_3.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("25");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenuItem_17.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		mnNewMenu_3.add(mntmNewMenuItem_17);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("30");
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenuItem_18.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		mnNewMenu_3.add(mntmNewMenuItem_18);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		
		textArea.setFont(new Font("Courier New", Font.BOLD, 20));
		scrollPane.setViewportView(textArea);
//		textArea.getDocument().addDocumentListener(new DocumentListener() {
//			public void insertUpdate(DocumentEvent e) {
//				
//				if (isFrmNew == true) {
//					frame.setTitle("MyNotepad - " + "*" + "Untitled");
//					//isFrmNew = true;
//				}
//				else if(isTyped == true){
//					frame.setTitle("MyNotepad - " + "*" + filename);
//				}
//				isTyped = true;
//			}
//			public void removeUpdate(DocumentEvent e) {
//				
//				if (isFrmNew == true) {
//					frame.setTitle("MyNotepad - " + "*" + "Untitled");
//					//isFrmNew = true;
//				}
//				else if(isTyped == true)
//				{
//					frame.setTitle("MyNotepad - " + "*" + filename);
//				}
//				isTyped = true;
//			}
//			public void changedUpdate(DocumentEvent e) {
//				System.out.println("c");
//			}
//		});
		
	}

}
