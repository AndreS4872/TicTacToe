package tictactoe;

import javax.swing.JDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Start 
{
	public static void main(String[] args)
	{
		start();		
	}
	public static void start()
	{
		JDialog Start = new JDialog();
		JButton PC = new JButton("PC");
		PC.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MyJFrame spiel = new MyJFrame("TicTacToe");
				new Spiel(spiel, "PC");
				Start.setVisible(false);
				Start.dispose();
			}
		});
		JButton Player = new JButton("Player");
		Player.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MyJFrame spiel = new MyJFrame("TicTacToe");
				new Spiel(spiel, "Player");
				Start.setVisible(false);
				Start.dispose();
			}
		});
		Start.setSize(400,100);
		Start.setLayout(new GridLayout(1,2));
		Start.add(PC);
		Start.add(Player);
		Start.setVisible(true);
	}
	
}