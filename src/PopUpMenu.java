import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopUpMenu {

	private JFrame frame;
	private JPanel panel;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpMenu window = new PopUpMenu();
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
	public PopUpMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.1);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"file1", "file2", "file3", "file4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		splitPane.setLeftComponent(list);
		
		JPopupMenu popupMenu1 = new JPopupMenu();
		addPopup(list, popupMenu1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("copy");
		popupMenu1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("paste");
		popupMenu1.add(mntmNewMenuItem_1);
		
		
		
		panel = new JPanel();
		splitPane.setRightComponent(panel);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(panel, popupMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Rect");
		popupMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Line");
		popupMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Circle");
		popupMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu = new JMenu("Color");
		popupMenu.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Red");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.RED);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
