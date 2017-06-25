package gra;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;
	private int rozmiarPlanszy = 3;

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
		lblRozmiarPlanszy.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRozmiarPlanszy.setVerticalAlignment(SwingConstants.TOP);
		lblRozmiarPlanszy.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRozmiarPlanszy);
		
		JRadioButton rbtn1 = new JRadioButton("3x3");
		rbtn1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rbtn1);
		btn1Group.add(rbtn1);
		rbtn1.setSelected(true);
		
		JRadioButton rbtn2 = new JRadioButton("4x4");
		rbtn2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rbtn2);
		btn1Group.add(rbtn2);
		
		JRadioButton rbtn3 = new JRadioButton("5x5");
		rbtn3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rbtn3);
		btn1Group.add(rbtn3);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Gra na czas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Ogranicz czas gry");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(chckbxNewCheckBox);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("5sek");
		comboBox.addItem("10sek");
		comboBox.addItem("15sek");
		panel_2.add(comboBox);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				int czas = 10;
				boolean ograniczCzasGry = chckbxNewCheckBox.isSelected();
				
				if (rbtn1.isSelected())
					rozmiarPlanszy = 3;
				else if (rbtn2.isSelected())
					rozmiarPlanszy = 4;
				else if(rbtn3.isSelected())
					rozmiarPlanszy = 5;
				
				if (comboBox.getSelectedItem() == ("5sek"))
					czas = 5;
				else if (comboBox.getSelectedItem() == ("10sek"))
					czas = 10;
				else if(comboBox.getSelectedItem() == ("15sek"))
					czas = 15;
				
				Plansza window = new Plansza(rozmiarPlanszy, czas, ograniczCzasGry);
				window.frame.setVisible(true);
			}
		});
		
		
		panel_2.add(btnNewButton);
	}

}
