package GUI;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import Server.Card;

public class Client implements Serializable{

	
	
	static final long serialVersionUID = -2422350332517575982L;
	public String name;
	public int money;
	ArrayList <Card> cards;
	int bet;
	
	public Client (String Name, int money) {
		
		this.name = Name;
		this.money = money;
		cards = new ArrayList <Card> ();
		
	}
	
	public Client () {
		
	}

	@Override
	public String toString() {
		
		return name + ", " + money;
	}

}



