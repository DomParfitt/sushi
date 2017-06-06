package core;

import java.util.ArrayList;
import java.util.Scanner;

import cardPools.CardPool;
import cardPools.StandardCardPool;
import cards.Card;

public class Game {

	private CardPool cardPool;
	private ArrayList<Player> players;
	private Deck deck;
	private int handSize;
	private int rounds;

	public Game() {
		this.cardPool = new StandardCardPool();
		this.deck = new Deck(cardPool);
		this.deck.shuffle();
		this.players = new ArrayList<Player>();
		this.handSize = 3;
	}

	public void addPlayer(Player player) {
		// TODO: Add player limit and check
		this.players.add(player);
	}

	private void deal() {
		for (int i = 0; i < this.handSize; i++) {
			for (Player player : this.players) {
				player.receiveCard(this.deck.deal());
			}
		}
	}
	
	private void switchHands() {
		ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>();
		for (Player player : this.players) {
			hands.add(player.getHand());
		}
		
		for(int j = 0; j < hands.size(); j++) {
			this.players.get((j+1) % this.players.size()).receiveHand(hands.get(j));
		}
		
	}

	public void play() {
		deal();
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < this.handSize; i++) {
			for (Player player : this.players) {
				System.out.println(player);
				System.out.println("Hand: ");
				player.showHand();
				System.out.println("Played: ");
				player.showPlayed();
				System.out.println("Enter the index of the card you wish to play. ");
				int index = in.nextInt();
				player.playCard(index);
			}
			
			switchHands();
			
		}
		in.close();
		
		Score[] scores = new Score[this.players.size()];
		int count = 0;
		for (Player player : this.players) {
			ArrayList<Card> playedCards = player.getPlayedCards();
			Card[] playedArr = new Card[playedCards.size()];
			playedArr = player.getPlayedCards().toArray(playedArr);
			scores[count] = Score.getScore(playedArr);
			count++;
		}
		
		Score.addMakis(scores);
		Score.addPuddings(scores);
		
		for(int i = 0; i < this.players.size(); i++) {
			System.out.println(players.get(i));
			players.get(i).showPlayed();
			System.out.println(scores[i].getNumScore());
			
		}
	}

}
