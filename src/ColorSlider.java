import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ColorSlider {

	private JFrame frame;
	int r,g,b;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColorSlider window = new ColorSlider();
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
	public ColorSlider() {
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
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblRed = new JLabel("Red");
		lblRed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRed.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRed);
		
		JSlider RedSlider = new JSlider(0,255,0);
		RedSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				r = RedSlider.getValue();
				Color clr = new Color(r,g,b);
				panel_1.setBackground(clr);
				frame.setTitle(r+","+g+","+b);
				
			}
		});
		panel.add(RedSlider);
		
		JLabel lblGreen = new JLabel("Green");
		lblGreen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGreen.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGreen);
		
		JSlider GreenSlider = new JSlider(0,255,0);
		GreenSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				g = GreenSlider.getValue();
				Color clr = new Color(r,g,b);
				panel_1.setBackground(clr);
				frame.setTitle(r+","+g+","+b);
			}
		});
		panel.add(GreenSlider);
		
		JLabel lblBlue = new JLabel("Blue");
		lblBlue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBlue.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblBlue);
		
		JSlider BlueSlider = new JSlider(0,255,0);
		BlueSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				b = BlueSlider.getValue();
				Color clr = new Color(r,g,b);
				panel_1.setBackground(clr);
				frame.setTitle(r+","+g+","+b);
			}
		});
		panel.add(BlueSlider);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
	}

}
