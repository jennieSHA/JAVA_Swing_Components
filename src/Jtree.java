import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class Jtree {

	private JFrame frame;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jtree window = new Jtree();
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
	public Jtree() {
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
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		lbl = new JLabel("");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 35));
		splitPane.setRightComponent(lbl);
		
		JTree tree = new JTree();
		tree.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				//lbl.setText((String) tree.getLastSelectedPathComponent().toString());
				lbl.setText(tree.getSelectionPath().toString());
			}
		});
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("India") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("Maharashtra");
						node_2 = new DefaultMutableTreeNode("Jalgaon");
							node_2.add(new DefaultMutableTreeNode("pachora"));
							node_2.add(new DefaultMutableTreeNode("Muktainagar"));
							node_2.add(new DefaultMutableTreeNode("Erandol"));
							node_2.add(new DefaultMutableTreeNode("Bhusawal"));
							node_2.add(new DefaultMutableTreeNode("Chalisgaon"));
							node_2.add(new DefaultMutableTreeNode("Jamner"));
						node_1.add(node_2);
						node_1.add(new DefaultMutableTreeNode("Nashik"));
						node_1.add(new DefaultMutableTreeNode("Pune"));
						node_1.add(new DefaultMutableTreeNode("Mumbai"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Madhya Pradesh");
						node_1.add(new DefaultMutableTreeNode("Indore"));
						node_1.add(new DefaultMutableTreeNode("Bhopal"));
						node_1.add(new DefaultMutableTreeNode("Jabalpur"));
						node_1.add(new DefaultMutableTreeNode("Gwalior"));
						node_1.add(new DefaultMutableTreeNode("Ratlam"));
						node_1.add(new DefaultMutableTreeNode("Ujjain"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Punjab");
						node_1.add(new DefaultMutableTreeNode("Amritsar"));
						node_1.add(new DefaultMutableTreeNode("Chandigarh"));
						node_1.add(new DefaultMutableTreeNode("Ludhiana"));
						node_1.add(new DefaultMutableTreeNode("Jalandhar"));
						node_1.add(new DefaultMutableTreeNode("Patiala"));
						node_1.add(new DefaultMutableTreeNode("Patahankot"));
					add(node_1);
				}
			}
		));
		splitPane.setLeftComponent(tree);
	}

}
