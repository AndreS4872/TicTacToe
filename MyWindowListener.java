package tictactoe;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowListener extends WindowAdapter
{
	private boolean ende;
	
	//Konstruktoren
	public MyWindowListener (boolean ende)
	{
		this.ende = ende;
	}
	
	public MyWindowListener ()
	{
		this.ende = false;
	}
	
	public void windowClosing (WindowEvent event)
	{
		event.getWindow().setVisible(false);		//Fenster unsichtbar
		event.getWindow().dispose();				//Fenster entsorgen
		if (ende)
		{
			System.exit(0);
		}
	}

}

/*
  Name:		Andre Siepmann
  Klasse:	TAIF2A
  Gruppe:	B
  Datum:	01.10.2024
*/