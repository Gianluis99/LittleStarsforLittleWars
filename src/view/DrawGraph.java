package view;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;
import Model.Game;


public class DrawGraph {
	//essendo che avremo piu thread che lavoreranno in parallelo allora ci serve un unica instanza che disegna il grafo
	
	
	//riceve un livello e lo disegna
	private JFrame f ;
	private MainPanel j;
	private JPanel home,buttonPanel;
	private static DrawGraph instance;
	private Container container;
	private JButton button;
	private Controller controller=new Controller();
	private JLabel label;
	private boolean finito=false;
	
	private DrawGraph() {
		f= new JFrame();
		j = new MainPanel();
		setFrame();
	}
	
	public static DrawGraph getInstance() {
		if(instance==null) {
			instance=new DrawGraph();
		}
		return instance;
	}

	public void run() {

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//setta la home con il pulsante play
	private void setFrame() {
		f.setSize(1300, 750);
		f.setResizable(false);
		f.getContentPane().setBackground(new Color(114, 220, 241));
		f.setLayout(null);
		container=f.getContentPane();
		
		home=new JPanel();
		home.setBounds(50,100,1200,150);
		home.setBackground(new Color(114, 220, 241));
		
		
		Font font=new Font("Times New Roman",Font.BOLD,70);
		label=new JLabel("Little Stars For Little Wars");
		label.setForeground(Color.white);
		label.setFont(font);
		
		buttonPanel=new JPanel();
		buttonPanel.setBounds(525,400,200,100);
		buttonPanel.setBackground(new Color(114, 220, 241));
		button=new JButton("PLAY");
		button.setBackground(new Color(114, 220, 241));
		button.setForeground(Color.white);
		
		font=new Font("Times New Roman",Font.BOLD,30);
		button.setFont(font);
		button.addActionListener(controller);
		
		home.add(label);	
		buttonPanel.add(button);
		container.add(home);
		container.add(buttonPanel); 
	}
	
	
	//una volta che si preme play si setta il mainPanel
	public void setGameFrame() {
		//rendiamo invisibile la home 
		home.setVisible(false);
		buttonPanel.setVisible(false);
		
		//aggingiamo il mainPanel al frame
		j.setBounds(f.getBounds());
		container.add(j);
		
		//si disegna il livello
		j.update(Game.getGame().getLivello());

		
	}
	
	public void playGame() {
		setGameFrame();
	}
	
	
	
	//aggiorna il livello(grafica)
	public void update( ) {
		j.update(Game.getGame().getLivello());
	}
	
	public void endGame() {
		
		if(!finito) {
			
			int squadra=Game.getGame().getLivello().getPossesso(0).getSquadra();	
			if(squadra==1) {
				label.setForeground(Color.blue);
				label.setText("Blue won!");
			}
			else if(squadra==2) {
				label.setForeground(Color.yellow);
				label.setText("Yellow won!");
			}

			home.setVisible(true);
			j.setVisible(false);
			finito=true;
		}
	}



	
}
