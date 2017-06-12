package gra;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		
		ButtonGroup btn1Group = new ButtonGroup();
		panel.setLayout(new GridLayout(4, 0, 1, 0));
		
		JLabel lblRozmiarPlanszy = new JLabel("Rozmiar planszy");
		lblRozmiarPlanszy.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRozmiarPlanszy);
		
		JRadioButton rbtn2 = new JRadioButton("4x4");
		rbtn2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rbtn2);
		btn1Group.add(rbtn2);
		
		JRadioButton rbtn3 = new JRadioButton("5x5");
		rbtn3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rbtn3);
		btn1Group.add(rbtn3);
		
		JRadioButton rbtn1 = new JRadioButton("3x3");
		rbtn1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rbtn1);
		
		btn1Group.add(rbtn1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		
		ButtonGroup btn2Group = new ButtonGroup();
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Tryb gry");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		JRadioButton rbtn4 = new JRadioButton("1 vs. 1");
		rbtn4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(rbtn4);
		btn2Group.add(rbtn4);
		
		JRadioButton rbtn5 = new JRadioButton("komputer");
		rbtn5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(rbtn5);
		btn2Group.add(rbtn5);
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Gra na czas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Ogranicz czas gry");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(chckbxNewCheckBox);
		
		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);
	}

}
