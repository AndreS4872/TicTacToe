package tictactoe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class Spiel implements ActionListener	
{
	protected JButton a1,a2,a3,b1,b2,b3,c1,c2,c3;			//Deklaration der Buttons, die das Spielfeld darstellen. Diese werden Später im 3x3 Muster angeordnet
	protected String who;									//Der String who speichert wer gerade dran ist
	//protected JLabel whois;
	protected JLabel zuegeausgabe, infotexte;		//Das Label whois gibt aus wer am Zug ist, das label zuegeausgabe gibt die bisherige gesamtanzahl
															//der züge aus.
	//protected JDialog dStart;
	protected int zuege;									//der Integer zuege speichert die aktuelle gesammtanzahl der Züge
	protected boolean ende = false;
	Spiel(JFrame frame, String wer)
	{
		//Erstellt das Spiel
			frame.setBackground(Color.WHITE);
			ende = false;
			a1 = new JButton();
			a1.addActionListener(this);
			a2 = new JButton();
			a2.addActionListener(this);
			a3 = new JButton();
			a3.addActionListener(this);
			b1 = new JButton();
			b1.addActionListener(this);
			b2 = new JButton();
			b2.addActionListener(this);
			b3 = new JButton();
			b3.addActionListener(this);
			c1 = new JButton();
			c1.addActionListener(this);
			c2 = new JButton();
			c2.addActionListener(this);
			c3 = new JButton();
			c3.addActionListener(this);
			JButton restartButton = new JButton("Restart");
		    restartButton.addActionListener(e -> resetGame(wer));
			
			//whois = new JLabel("Wer ist dran? Player");
			//whois.setBackground(Color.WHITE);
			zuegeausgabe = new JLabel("Züge: 0");
			zuegeausgabe.setBackground(Color.WHITE);
			
			for (JButton button : new JButton[]{a1, a2, a3, b1, b2, b3, c1, c2, c3}) {
				//Farben setzen
				button.setBackground(Color.WHITE);
				button.setFont(new Font("ARIAL", Font.BOLD, 60));
			}
			//Ausgangsstellung
			
			zuege = 0;
			
			
			who = wer;
			/*
			a1.setText("a1");
			a2.setText("a2");
			a3.setText("a3");
			b1.setText("b1");
			b2.setText("b2");
			b3.setText("b3");
			c1.setText("c1");
			c2.setText("c2");
			c3.setText("c3");
			*/
			Container cp = frame.getContentPane();
			Panel pLabels = new Panel();
			pLabels.setLayout(new GridLayout(2, 1));
			cp.setBackground(Color.WHITE);
			Panel p1 = new Panel();
			p1.setLayout(new GridLayout(1,2));
			//p1.add(whois);
			p1.add(zuegeausgabe);
			Panel p2 = new Panel();
			p2.setLayout(new GridLayout(3,3));
			p2.add(a1);
			p2.add(a2);
			p2.add(a3);
			p2.add(b1);
			p2.add(b2);
			p2.add(b3);
			p2.add(c1);
			p2.add(c2);
			p2.add(c3);
			cp.setLayout(new BorderLayout());
			cp.add("North", p1);
			cp.add("Center", p2);
			infotexte = new JLabel(" ");
			pLabels.add(restartButton);
			pLabels.add(infotexte);
			cp.add("South", pLabels);
			frame.setVisible(true);
			if(who == "PC")
			{
				pcStart();
			}
	}
	public void ausgabe()
	{
		//whois.setText("Wer ist dran? " + who);
		zuegeausgabe.setText("Züge: " + zuege);
	}
	public void pruefe(String ausgangsfeld, String who)
	//Überprüft ob eine Gewinnbedingung erfüllt ist
	{
		if(ausgangsfeld == "a1")
		{
			if(who=="Player")
			{
				zuege++;
				if(b1.getText()=="X"&&c1.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(b2.getText()=="X"&&c3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(a2.getText()=="X"&&a3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
			}
			else
			{
				if(b1.getText()=="O"&&c1.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(b2.getText()=="O"&&c3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(a2.getText()=="O"&&a3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
			}
		}
		if(ausgangsfeld == "a2")
		{
			if(who=="Player")
			{
				zuege++;
				if(a1.getText()=="X"&&a3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(b2.getText()=="X"&&c2.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
			}
			else
			{
				if(a1.getText()=="O"&&a3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(b2.getText()=="O"&&c2.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
			}
		}
		if(ausgangsfeld == "a3")
		{
			if(who=="Player")
			{
				zuege++;
				if(a1.getText()=="X"&&a2.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(b3.getText()=="X"&&c3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(b2.getText()=="X"&&c1.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
			}
			else
			{
				if(a1.getText()=="O"&&a2.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(b3.getText()=="O"&&c3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(b2.getText()=="O"&&c1.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
			}
		}
		if(ausgangsfeld == "b1")
		{
			if(who=="Player")
			{
				zuege++;
				if(a1.getText()=="X"&&c1.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(b2.getText()=="X"&&b3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
			}
			else {
				if(a1.getText()=="O"&&c1.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(b2.getText()=="O"&&b3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
			}
		}
		if(ausgangsfeld == "b2")
		{
			if(who=="Player")
			{
				zuege++;
				if(a2.getText()=="X"&&c2.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(b1.getText()=="X"&&b3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(a1.getText()=="X"&&c3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(c1.getText()=="X"&&a3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
			}
			else
			{
				if(a2.getText()=="O"&&c2.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(b1.getText()=="O"&&b3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(a1.getText()=="O"&&c3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(c1.getText()=="O"&&a3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
			}
		}
		if(ausgangsfeld == "b3")
		{
			zuege++;
			if(who=="Player")
			{
				if(a3.getText()=="X"&&c3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(b2.getText()=="X"&&b1.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
			}
			if(who=="PC")
			{
				if(a3.getText()=="O"&&c3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(b2.getText()=="O"&&b1.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
			}
		}
		if(ausgangsfeld == "c1")
		{
			if(who=="Player")
			{
				zuege++;
				if(b1.getText()=="X"&&a1.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(c2.getText()=="X"&&c3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(b2.getText()=="X"&&a3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
			}
			else
			{
				if(b1.getText()=="O"&&a1.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(c2.getText()=="O"&&c3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(b2.getText()=="O"&&a3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
			}
			}
		}
		if(ausgangsfeld == "c2")
		{
			if(who=="Player")
			{
				zuege++;
				if(c1.getText()=="X"&&c3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(a2.getText()=="X"&&b2.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				
			}
			else
			{
				if(c1.getText()=="O"&&c3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(a2.getText()=="O"&&b2.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
			}
		}
		if(ausgangsfeld == "c3")
		{
			if(who=="Player")
			{
				zuege++;
				if(c1.getText()=="X"&&c2.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(b2.getText()=="X"&&a1.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
				if(b3.getText()=="X"&&a3.getText()=="X")
				{
					infotexte.setText("Player Wins!");
					ende = true;
				}
			}
			else
			{
				if(c1.getText()=="O"&&c2.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(b2.getText()=="O"&&a1.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
				if(b3.getText()=="O"&&a3.getText()=="O")
				{
					infotexte.setText("PC Wins!");
					ende = true;
				}
			}
		}
		if(zuege>=9&& ende == false)
		{
			ende = true;
			infotexte.setText("Unentschieden!");
		}
		
	}
	public void actionPerformed (ActionEvent e)	{
		//Arbeitet die Tastendrücke ab
		if(!ende)
		{
		if(e.getSource()==a1 && a1.getText()=="")
		{
			if (who == "Player")
			{
				a1.setText("X");
				a1.setForeground(Color.RED);
				who = "PC";
				ausgabe();
				pruefe("a1", "Player");
				pc_logic((JButton)e.getSource());
			}
			else
			{
				a1.setText("O");
				a1.setForeground(Color.BLUE);
				who = "Player";
				ausgabe();
				pruefe("a1", "PC");
			}
		}
		
		else if(e.getSource()==a2 && a2.getText()=="")
		{
			if (who == "Player")
			{
				a2.setText("X");
				a2.setForeground(Color.RED);
				who = "PC";
				ausgabe();
				pruefe("a2", "Player");
				pc_logic((JButton)e.getSource());
			}
			else
			{
				a2.setText("O");
				a2.setForeground(Color.BLUE);
				who = "Player";
				ausgabe();
				pruefe("a2", "PC");
			}
		}
		
		if(e.getSource()==a3 && a3.getText()=="")
		{
			if (who == "Player")
			{
				a3.setText("X");
				a3.setForeground(Color.RED);
				who = "PC";
				ausgabe();
				pruefe("a3", "Player");
				pc_logic((JButton)e.getSource());
			}
			else
			{
				a3.setText("O");
				a3.setForeground(Color.BLUE);
				who = "Player";
				ausgabe();
				pruefe("a3", "PC");
			}
		}
		
		if(e.getSource()==b1 && b1.getText()=="")
		{
			if (who == "Player")
			{
				b1.setText("X");
				b1.setForeground(Color.RED);
				who = "PC";
				ausgabe();
				pruefe("b1", "Player");
				pc_logic((JButton)e.getSource());
				
			}
			else
			{
				b1.setText("O");
				b1.setForeground(Color.BLUE);
				who = "Player";
				ausgabe();
				pruefe("b1", "PC");
			}
		}
		
		if(e.getSource()==b2 && b2.getText()=="")
		{
			if (who == "Player")
			{
				
				b2.setText("X");
				b2.setForeground(Color.RED);
				who = "PC";
				ausgabe();
				pruefe("b2", "Player");
				pc_logic((JButton)e.getSource());
			}
			else
			{
				b2.setText("O");
				b2.setForeground(Color.BLUE);
				who = "Player";
				ausgabe();
				pruefe("b2", "PC");
			}
		}
		if(e.getSource()==b3 && b3.getText()=="")
		{
			if (who == "Player")
			{
				
				b3.setText("X");
				b3.setForeground(Color.RED);
				who = "PC";
				ausgabe();
				pruefe("b3", "Player");
				pc_logic((JButton)e.getSource());
				
			}
			else
			{
				b3.setText("O");
				b3.setForeground(Color.BLUE);
				who = "Player";
				ausgabe();
				pruefe("b3", "PC");
				
			}
		}
		if(e.getSource()==c1 && c1.getText()=="")
		{
			if (who == "Player")
			{
				c1.setText("X");
				c1.setForeground(Color.RED);
				who = "PC";
				ausgabe();
				pruefe("c1","Player");
				pc_logic((JButton)e.getSource());
			}
			else
			{
				c1.setText("O");
				who = "Player";
				ausgabe();
				pruefe("c1", "PC");
			}
		}
		if(e.getSource()==c2 && c2.getText()=="")
		{
			if (who == "Player")
			{
				
				c2.setText("X");
				c2.setForeground(Color.RED);
				who = "PC";
				ausgabe();
				pruefe("c2", "Player");
				pc_logic((JButton)e.getSource());
				
			}
			else
			{
				c2.setText("O");
				who = "Player";
				ausgabe();
				pruefe("c2", "PC");
			}
		}
		
		if(e.getSource()==c3 && c3.getText()=="")
		{
			if (who == "Player")
			{
				
				c3.setText("X");
				c3.setForeground(Color.RED);
				who = "PC";
				ausgabe();
				pruefe("c3", "Player");
				pc_logic((JButton)e.getSource());
			}
			else
			{
				c3.setText("O");
				who = "Player";
				ausgabe();
				pruefe("c3", "PC");
			}
		}
		pruefeUnentschieden(infotexte);
		ausgabe();
	}
	}
	public void pc_logic(JButton letztes_Feld) {
		//Bestimmt wie der PC Handelt
	    if (!ende) {
	        // 1. Gewinnmöglichkeiten für den PC prüfen
	        for (JButton button : new JButton[]{a1, a2, a3, b1, b2, b3, c1, c2, c3}) {
	            if (button.getText().isEmpty()) {
	                button.setText("O"); // Setze PC-Zug
	                button.setForeground(Color.BLUE);
	                if (pruefeGewinn("PC")) { // Überprüfe, ob PC gewonnen hat
	                	infotexte.setText("PC Wins!");
	        			ende = true;
	        			who="Player";
	        			zuege++;
	                    return; // Zug gemacht, Spiel gewonnen
	                }
	                button.setText(""); // Rückgängig machen
	                button.setForeground(Color.BLACK);
	            }
	        }

	        // 2. Gewinnmöglichkeiten des Spielers überprüfen
	        for (JButton button : new JButton[]{a1, a2, a3, b1, b2, b3, c1, c2, c3}) {
	            if (button.getText().isEmpty()) {
	                button.setText("X"); // Setze Spieler-Zug
	                if (pruefeGewinn("Player")) { // Überprüfe, ob Spieler gewonnen hat
	                    button.setText("O"); // Zug machen, um den Sieg des Spielers zu verhindern
	                    button.setForeground(Color.BLUE);
	                    who = "Player";
	                    zuege++;
	                    return; // Zug gemacht
	                }
	                button.setText(""); // Rückgängig machen
	            }
	        }

	        // 3. Zufälligen Zug machen, wenn keine Gewinnmöglichkeiten vorhanden sind
	        List<JButton> freieFelder = new ArrayList<>();
	        for (JButton button : new JButton[]{a1, a2, a3, b1, b2, b3, c1, c2, c3}) {
	            if (button.getText().isEmpty()) {
	                freieFelder.add(button);
	            }
	        }

	        // Wähle zufällig ein Feld, wenn freie Felder vorhanden sind
	        if (!freieFelder.isEmpty()) {
	            Random random = new Random();
	            JButton zufaelligesFeld = freieFelder.get(random.nextInt(freieFelder.size()));
	            zufaelligesFeld.setText("O"); // Setze PC-Zug
	            zufaelligesFeld.setForeground(Color.BLUE);
	            who = "Player";
	            zuege++;
	        }
	        //whois.setText("Wer ist dran? " + who);
	    }
	}
	
	private void pruefeUnentschieden(JLabel infotext)
	{
		List<JButton> freieFelder = new ArrayList<>();
        for (JButton button : new JButton[]{a1, a2, a3, b1, b2, b3, c1, c2, c3}) {
            if (button.getText().isEmpty()) {
                freieFelder.add(button);
            }
        }
        if(freieFelder.size()==0&&ende==false)
        {
        	infotext.setText("Unentschieden");
        }
	}
	private void pcStart() {
		//Lässt den PC Starten
		List<JButton> freieFelder = new ArrayList<>();
        for (JButton button : new JButton[]{a1, a2, a3, b1, b2, b3, c1, c2, c3}) {
            if (button.getText().isEmpty()) {
                freieFelder.add(button);
            }
        }

        // Wähle zufällig ein Feld, wenn freie Felder vorhanden sind
        if (!freieFelder.isEmpty()) {
            Random random = new Random();
            JButton zufaelligesFeld = freieFelder.get(random.nextInt(freieFelder.size()));
            zufaelligesFeld.setText("O"); // Setze PC-Zug
            zufaelligesFeld.setForeground(Color.BLUE);
            who = "Player";
            zuege++;
            ausgabe();
        }
        
	}
	private void resetGame(String wer) {
		//Startet das Spiel neu 
	    zuege = 0;
	    ende = false;
	    who = wer;
	    //whois.setText("Wer ist dran? Player");
	    zuegeausgabe.setText("Züge: 0");
	    infotexte.setText(" ");
	    
	    // Alle Buttons zurücksetzen
	    for (JButton button : new JButton[]{a1, a2, a3, b1, b2, b3, c1, c2, c3}) {
	        button.setText("");
	        button.setForeground(Color.BLACK);
	    }
	    if(wer=="PC")
	    {
	    	pcStart();
	    }
	}
	private boolean pruefeGewinn(String who) {
		//Überprüft die Gewinnmöglichkeiten, Wird von der PC Logik aufgerufen
	    String symbol = who.equals("PC") ? "O" : "X";

	    // Gewinnbedingungen (Reihen, Spalten, Diagonalen)
	    if (
	        (a1.getText().equals(symbol) && a2.getText().equals(symbol) && a3.getText().equals(symbol)) || // Erste Reihe
	        (b1.getText().equals(symbol) && b2.getText().equals(symbol) && b3.getText().equals(symbol)) || // Zweite Reihe
	        (c1.getText().equals(symbol) && c2.getText().equals(symbol) && c3.getText().equals(symbol)) || // Dritte Reihe
	        (a1.getText().equals(symbol) && b1.getText().equals(symbol) && c1.getText().equals(symbol)) || // Erste Spalte
	        (a2.getText().equals(symbol) && b2.getText().equals(symbol) && c2.getText().equals(symbol)) || // Zweite Spalte
	        (a3.getText().equals(symbol) && b3.getText().equals(symbol) && c3.getText().equals(symbol)) || // Dritte Spalte
	        (a1.getText().equals(symbol) && b2.getText().equals(symbol) && c3.getText().equals(symbol)) || // Diagonale von oben links nach unten rechts
	        (a3.getText().equals(symbol) && b2.getText().equals(symbol) && c1.getText().equals(symbol))    // Diagonale von oben rechts nach unten links
	    ) {
	        return true; // Gewinn erkannt
	    }

	    return false; // Kein Gewinn
	}

}


/*
  Name:		Andre Siepmann
  Klasse:	TAIF2A
  Gruppe:	B
  Datum:	01.10.2024
*/