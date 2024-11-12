package tictactoe;

import javax.swing.*;



/*
  Name:		Andre Siepmann
  Klasse:	TAIF2A
  Gruppe:	B
  Datum:	01.10.2024
*/


public class MyJFrame extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyJFrame(String name)
	{
		super(name);//Fenster Erstellen
		this.addWindowListener(new MyWindowListener());		//Windowlistener Setzen
		this.setLocation(100,100);							//Location Setzen
		this.setSize(500,500);								//Größe sezten
		this.setVisible(true);								//Sichtbar machen
	} 
	
}