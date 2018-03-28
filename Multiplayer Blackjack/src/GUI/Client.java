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
	ArrayList <Card> splitCards;
	int bet;
	boolean playing;
	boolean bePatientflag;
	Dealer dealer;
	ArrayList <Client> players;
	int points;
	boolean haveToWait;
	public boolean notAccepted;
	public boolean playingSplitCards;
	
	public Client (String Name, int money) {
		
		this.name = Name;
		this.money = money;
		cards = new ArrayList <Card> ();
		splitCards = new ArrayList <Card> ();
		this.playing = true;
		dealer = new Dealer();
		players = new ArrayList <Client> ();
		
	}
	
public Client (String Name, int money, int bet) {
		
		this.name = Name;
		this.money = money;
		this.bet = bet;
		cards = new ArrayList <Card> ();
		splitCards = new ArrayList <Card> ();
		this.playing = true;
		dealer = new Dealer();
		players = new ArrayList <Client> ();
		
	}
	
	public Client () {
		cards = new ArrayList <Card> ();
		splitCards = new ArrayList <Card> ();
		dealer = new Dealer();
		players = new ArrayList <Client> ();
	}

	@Override
	public String toString() {
		
		return name + ", " + money;
	}

}



