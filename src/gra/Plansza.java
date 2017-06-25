package gra;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Plansza {

	public JFrame frame;
	private String startGame = "X";
	private int xCount = 0;
	private int oCount = 0;
	private JTextField txtCountX;
	private JTextField txtCountO;
	private List<JButton> listaPrzyciskow;
	private List<JPanel> listaPol;
	private int rozmiarPlanszy;
	private int iloscWypelnionychPol;
	private int xTimeLimit;
	private int oTimeLimit;
	private int timeLimit;
	private boolean xPlayerTurn = false;
	private boolean oPlayerTurn = false;
	boolean ograniczCzasGry;

	/**
	 * Create the application.
	 */
	public Plansza(int rozmiar, int timeLimit, boolean ograniczCzasGry) {
		xTimeLimit = timeLimit;
		oTimeLimit = timeLimit;
		this.timeLimit = timeLimit;
		rozmiarPlanszy = rozmiar;
		iloscWypelnionychPol = 0;
		this.ograniczCzasGry = ograniczCzasGry;
		initialize(rozmiar);
	}
	
	private void gameScore(){
		txtCountX.setText(String.valueOf(xCount));
		txtCountO.setText(String.valueOf(oCount));
	}
	
	private void choosePlayer(){
		if(startGame.equalsIgnoreCase("X"))
		{
			startGame = "O";
			xPlayerTurn = true;
			oPlayerTurn = false;
		}
		else
		{
			startGame = "X";
			xPlayerTurn = false;
			oPlayerTurn = true;
		}
	}
	
	private void winningGame(){
		List<String> wyniki = new ArrayList<String>();
		
		for(JButton x : listaPrzyciskow)
			wyniki.add(x.getText());
		 
		//sprawdzamy wiersze
		for(int i = 0; i < rozmiarPlanszy; i++)
		{
			if(wyniki.get(rozmiarPlanszy*i) == (""))
				continue;
			
			for(int j = 0; j < rozmiarPlanszy - 1; j++)
			{
				if(wyniki.get(rozmiarPlanszy*i + j) != wyniki.get(rozmiarPlanszy*i + j + 1))
					break;
				//wszystkie s¹ równe
				if(j == rozmiarPlanszy - 2)
				{
					checkWhoWon(wyniki.get(rozmiarPlanszy*i));
					return;
				}
			}	
		}
		
		//sprawdzamy kolumny
		for(int i = 0; i < rozmiarPlanszy; i++)
		{
			if(wyniki.get(i) == (""))
				continue;
			
			for(int j = 0; j < rozmiarPlanszy - 1; j++)
			{
				if(wyniki.get(i + rozmiarPlanszy*j) != wyniki.get(i + rozmiarPlanszy*(j + 1)))
					break;
				//wszystkie s¹ równe
				if(j == rozmiarPlanszy - 2)
				{
					checkWhoWon(wyniki.get(i));
					return;
				}
			}
			
		}
		
		//sprawdzamy pierwsza przekatna
		if(wyniki.get(0) != (""))
		{
			for(int i = 0; i < rozmiarPlanszy - 1; i++)
			{
				if(wyniki.get(i*(rozmiarPlanszy + 1)) != wyniki.get((i + 1)*(rozmiarPlanszy + 1)))
					break;
				
				if(i == rozmiarPlanszy - 2)
				{
					checkWhoWon(wyniki.get(0));
					return;
				}
			}
		}
		
		//sprawdzamy druga przekatna
		if(wyniki.get(rozmiarPlanszy - 1) != (""))
		{
			for(int i = 0; i < rozmiarPlanszy - 1; i++)
			{
				if(wyniki.get((rozmiarPlanszy - 1) * (i + 1)) != wyniki.get((rozmiarPlanszy - 1) * (i + 2)))
					break;
				
				if(i == rozmiarPlanszy - 2)
				{
					checkWhoWon(wyniki.get(rozmiarPlanszy - 1));
					return;
				}
			}
		}
		
		if(iloscWypelnionychPol == rozmiarPlanszy*rozmiarPlanszy)
		{
			xPlayerTurn = false;
			oPlayerTurn = false;
			JOptionPane.showMessageDialog(frame, "Remis",
					"Kolko i krzyzyk", JOptionPane.INFORMATION_MESSAGE );
			gameScore();
			nowaRunda();
		}
		
	}

	private void checkWhoWon(String Gracz) {
		xPlayerTurn = false;
		oPlayerTurn = false;
		JOptionPane.showMessageDialog(frame, "Gracz " + Gracz + " zwyciezyl",
				"Kolko i krzyzyk", JOptionPane.INFORMATION_MESSAGE );
		if (Gracz == ("X")) xCount++;
		else oCount++;
		gameScore();
		nowaRunda();
	}
	
	private void fillBox(JButton btn) {
		if (btn.getText() == (""))
		{
			btn.setText(startGame);
			if(startGame.equalsIgnoreCase("X"))
			{
				btn.setForeground(Color.BLUE);
			}
			else
			{
				btn.setForeground(Color.LIGHT_GRAY);
			}
			choosePlayer();
			winningGame();
			iloscWypelnionychPol++;
		}
	}
	
	private void nowaRunda() {
		for(JButton x : listaPrzyciskow)
		{
			x.setText("");
		}
		
		iloscWypelnionychPol = 0;
		xPlayerTurn = false;
		oPlayerTurn = false;
		xTimeLimit = timeLimit;
		oTimeLimit = timeLimit;
	}
	
	private void nowaGra(){
		nowaRunda();
		xCount = 0;
		oCount = 0;
		gameScore();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int rozmiar) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 2, 2, 2));
		
		//plansza
		JPanel plansza = new JPanel();
		plansza.setBorder(new LineBorder(new Color(0,0,0)));
		plansza.setLayout(new GridLayout(rozmiar, rozmiar));
		panel.add(plansza);
		
		listaPol = new ArrayList<JPanel>();
		listaPrzyciskow = new ArrayList<JButton>();
		
		//tworzymy liste paneli 
		for (int i = 0; i < rozmiar * rozmiar; i++)
		{
			listaPol.add(new JPanel());
		}
		
		//tworzymy przyciski, dodajemy panele do planszy
		for(JPanel x : listaPol)
		{
			x.setBorder(new LineBorder(new Color(0, 0, 0)));
			plansza.add(x);
			x.setLayout(new BorderLayout(0, 0));
			listaPrzyciskow.add(new JButton(""));
		}
		
		//dodajemy przyciski do paneli
		for(JButton x : listaPrzyciskow)
		{
			x.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillBox(x);}
				});
			
			x.setFont(new Font("Tahoma", Font.BOLD, 96));
			listaPol.get(listaPrzyciskow.indexOf(x)).add(x, BorderLayout.CENTER);
		}
		
		//menu
		JPanel menu = new JPanel();
		menu.setBorder(new LineBorder(new Color(0,0,0)));
		menu.setLayout(new GridLayout(3, 2));
		panel.add(menu);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		menu.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGraczX = new JLabel("Gracz X:");
		lblGraczX.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraczX.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_10.add(lblGraczX, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		menu.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		txtCountX = new JTextField();
		txtCountX.setHorizontalAlignment(SwingConstants.CENTER);
		txtCountX.setFont(new Font("Tahoma", Font.BOLD, 48));
		txtCountX.setText("0");
		panel_11.add(txtCountX, BorderLayout.CENTER);
		txtCountX.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		menu.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGraczO = new JLabel("Gracz O:");
		lblGraczO.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraczO.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_12.add(lblGraczO, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		menu.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		txtCountO = new JTextField();
		txtCountO.setText("0");
		txtCountO.setFont(new Font("Tahoma", Font.BOLD, 48));
		txtCountO.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(txtCountO, BorderLayout.CENTER);
		txtCountO.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		menu.add(panel_14);
		panel_14.setLayout(new GridLayout(3, 0, 0, 2));
		
		JButton btnRestart = new JButton("Nowa gra");
		panel_14.add(btnRestart);
		btnRestart.setFont(new Font("Tahoma", Font.BOLD, 32));
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nowaGra();
			}
		});
		
		JButton btnReset = new JButton("Nowa runda");
		panel_14.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xPlayerTurn = false;
				oPlayerTurn = false;
				nowaRunda();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JButton btnExit = new JButton("Wyjscie");
		panel_14.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame();
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
		menu.add(panel_15);
		panel_15.setLayout(new GridLayout(3, 0));
		
		JLabel timeCountlbl = new JLabel();
		timeCountlbl.setFont(new Font("Tahoma", Font.BOLD, 32));
		timeCountlbl.setHorizontalAlignment(SwingConstants.CENTER);
		if (ograniczCzasGry)
			timeCountlbl.setText("Pozosta³y czas");
		else 
			timeCountlbl.setText("Bez ograniczen");
		
		panel_15.add(timeCountlbl);
		
		JLabel xTimeCount = new JLabel();
		xTimeCount.setFont(new Font("Tahoma", Font.BOLD, 32));
		xTimeCount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_15.add(xTimeCount);
		
		JLabel oTimeCount = new JLabel();
		oTimeCount.setFont(new Font("Tahoma", Font.BOLD, 32));
		oTimeCount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_15.add(oTimeCount);
		
		if (ograniczCzasGry)
		{
			new Thread() {
		        public void run() {
		            while(true) {
		            	xTimeCount.setText("Gracz X: " + (xTimeLimit) + "sek");
		            	if (xPlayerTurn)
		            	{
		            		oTimeCount.setText("Gracz O: " + (oTimeLimit--) + "sek");
		            	}
		                try{
		                    Thread.sleep(1000);
		                } catch(Exception e) {}
		                if (xTimeLimit == -1)
		    	            checkWhoWon("O");
		            }
		        }
		    }.start();
		    
		    new Thread() {
		        public void run() {
		            while(true) {
		            	oTimeCount.setText("Gracz O: " + (oTimeLimit) + "sek");
		            	if (oPlayerTurn)
		            	{
		            		xTimeCount.setText("Gracz X: " + (xTimeLimit--) + "sek");
		            	}
		                try{
		                    Thread.sleep(1000);
		                } catch(Exception e) {}
		                if (oTimeLimit == -1)
		    	            checkWhoWon("X");
		            }
		        }
		    }.start();
		}
	}

}
