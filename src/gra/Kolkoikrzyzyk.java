package gra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Kolkoikrzyzyk {

	private JFrame frame;
	private String startGame = "X";
	private int xCount = 0;
	private int oCount = 0;
	private JTextField txtCountX;
	private JTextField txtCountO;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kolkoikrzyzyk window = new Kolkoikrzyzyk();
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
	public Kolkoikrzyzyk() {
		initialize();
	}
	
	private void gameScore(){
		txtCountX.setText(String.valueOf(xCount));
		txtCountO.setText(String.valueOf(oCount));
	}
	
	private void choosePlayer(){
		if(startGame.equalsIgnoreCase("X"))
		{
			startGame = "O";
		}
		else
		{
			startGame = "X";
		}
	}
	
	private void winningGame(){
		String b1 = btn1.getText();
		String b2 = btn2.getText();
		String b3 = btn3.getText();
		String b4 = btn4.getText();
		String b5 = btn5.getText();
		String b6 = btn6.getText();
		String b7 = btn7.getText();
		String b8 = btn8.getText();
		String b9 = btn9.getText();
		
		if(b1 != ("") && b1 == b2 &&  b2 == b3 )	
			checkWhoWon(b1); //pierwszy wiersz
		else if(b4 != ("") && b4 == b5 &&  b5 == b6 )	
			checkWhoWon(b4); //drugi wiersz		
		else if(b7 != ("") && b7 == b8 &&  b8 == b9 )	
			checkWhoWon(b7); //trzeci wiersz
		else if(b1 != ("") && b1 == b4 &&  b4 == b7 )	
			checkWhoWon(b1); //pierwsza kolumna
		else if(b2 != ("") && b2 == b5 &&  b5 == b8 )	
			checkWhoWon(b2); //druga kolumna
		else if(b3 != ("") && b3 == b6 &&  b6 == b9 )	
			checkWhoWon(b3); //trzecia kolumna
		else if(b1 != ("") && b1 == b5 &&  b5 == b9 )	
			checkWhoWon(b1); //pierwsza przekatna
		else if(b3 != ("") && b3 == b5 &&  b5 == b7 )	
			checkWhoWon(b3); //druga przekatna
		else {
			JOptionPane.showMessageDialog(frame, "Remis",
				"Kolko i krzyzyk", JOptionPane.INFORMATION_MESSAGE );
			}
	}

	private void checkWhoWon(String Gracz) {
		JOptionPane.showMessageDialog(frame, "Gracz " + Gracz + " zwyciezyl",
				"Kolko i krzyzyk", JOptionPane.INFORMATION_MESSAGE );
		if (Gracz == ("X")) xCount++;
		else oCount++;
		gameScore();
		reset();
	}
	
	private void fillBox(JButton btn) {
		if (btn.getText() == (""))
		{
			btn.setText(startGame);
			if(startGame.equalsIgnoreCase("X"))
			{
				btn.setForeground(Color.ORANGE);
			}
			else
			{
				btn.setForeground(Color.GREEN);
			}
			choosePlayer();
			winningGame();
		}
	}
	
	private void reset() {
		btn1.setText("");
		btn2.setText("");
		btn3.setText("");
		btn4.setText("");
		btn5.setText("");
		btn6.setText("");
		btn7.setText("");
		btn8.setText("");
		btn9.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 5, 2, 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			fillBox(btn1);}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 96));
		panel_1.add(btn1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillBox(btn2);}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 96));
		panel_2.add(btn2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillBox(btn3);}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 96));
		panel_3.add(btn3, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGraczX = new JLabel("Gracz X:");
		lblGraczX.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraczX.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_10.add(lblGraczX, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		txtCountX = new JTextField();
		txtCountX.setHorizontalAlignment(SwingConstants.CENTER);
		txtCountX.setFont(new Font("Tahoma", Font.BOLD, 48));
		txtCountX.setText("0");
		panel_11.add(txtCountX, BorderLayout.CENTER);
		txtCountX.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillBox(btn4);}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 96));
		panel_4.add(btn4, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillBox(btn5);}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 96));
		panel_5.add(btn5, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillBox(btn6);}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 96));
		panel_6.add(btn6, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGraczO = new JLabel("Gracz O:");
		lblGraczO.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraczO.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_12.add(lblGraczO, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		txtCountO = new JTextField();
		txtCountO.setText("0");
		txtCountO.setFont(new Font("Tahoma", Font.BOLD, 48));
		txtCountO.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(txtCountO, BorderLayout.CENTER);
		txtCountO.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillBox(btn7);}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 96));
		panel_7.add(btn7, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillBox(btn8);}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 96));
		panel_8.add(btn8, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillBox(btn9);}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 96));
		panel_9.add(btn9, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_14);
		panel_14.setLayout(new GridLayout(3, 0, 0, 2));
		
		JButton btnRestart = new JButton("Nowa gra");
		panel_14.add(btnRestart);
		btnRestart.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JButton btnReset = new JButton("Nowa runda");
		panel_14.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JButton btnExit = new JButton("Wyj\u015Bcie");
		panel_14.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Czy chcesz opuscic gre?", "Kolko i krzyzyk",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
				System.exit(0);
				}
			}
		});
		
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 32));
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
	}

}
