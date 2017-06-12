package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;
import java.util.TreeMap;

import cardPools.CardPool;
import cardPools.StandardCardPool;
import cards.Card;

/**
 * Class to represent the core game
 * @author Dom Parfitt
 *
 */
public class Game extends Observable {

	private CardPool cardPool;
	private ArrayList<Player> players;
//	private ArrayList<CardRequester> threads;
	private TreeMap<Player, Card> played;
	private Deck deck;
	private Deck discard;
	private int handSize;
	private int rounds;
	private int maxPlayers;

	/**
	 * Default constructor for the game
	 */
	public Game(int maxPlayers) {
		this.cardPool = new StandardCardPool();
		this.deck = new Deck(cardPool);
		this.deck.shuffle();
		this.discard = new Deck();
		this.players = new ArrayList<Player>();
//		this.threads = new ArrayList<>();
		this.played = new TreeMap<>();
		this.handSize = 9;
		this.rounds = 3;
		this.maxPlayers = maxPlayers;
	}
	

	/**
	 * Adds a player to the game
	 * 
	 * @param player
	 *            the player to add
	 */
	public synchronized void addPlayer(Player player) {
		if (players.size() < maxPlayers) {
			this.players.add(player);
//			this.threads.add(new CardRequester(this, player));
			notifyAll();
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Adds a card to the played cards pool
	 * @param player the player who has played the card
	 * @param card the card played
	 */
	public synchronized void addPlayedCard(Player player, Card card) {
		played.put(player, card);
		notifyAll();
	}
	
	@Deprecated
	public synchronized Map<Player, Card> getPlayedCards() {
		while (played.size() < maxPlayers) {
			try {
				System.out.println("[Game] # of played cards: " + played.size());
				System.out.println("[Game] Waiting until there are enough cards");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("[Game] There are enough played cards now");
//		Map<Player, Card> output = played;
//		played.clear();
		return played;
	}
	
	/**
	 * Method for the game to request each player play a card and then wait
	 * until they have all done so
	 */
	public synchronized void requestCards() {
		//For some reason it doesn't like this
//		for(CardRequester requester : threads) {
//			requester.start();
//		}
		for (Player player : players) {
			CardRequester requester = new CardRequester(this, player);
			requester.start();
		}

		while (played.size() < maxPlayers) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Gets a list of the current players in the game
	 * @return
	 */
	public List<Player> getPlayers() {
		return this.players;
	}
	
	/**
	 * Gets a particular player
	 * @param player the player object to retrieve
	 * @return the player object
	 */
	public Player getPlayer(Player player) {
		int index = players.indexOf(player);
		return players.get(index);
	}
	
	/**
	 * Gets the hand of a particular player
	 * @param player the player to get the hand of
	 * @return an ArrayList of Cards representing the player's hand
	 */
	public ArrayList<Card> getHand(Player player) {
		int index = players.indexOf(player);
		if(index >= 0) {
			return players.get(index).getHand();
		} else {
			return new ArrayList<Card>();
		}
	}
	
	/**
	 * Gets the played cards of a particular player
	 * @param player the player to get the played cards of
	 * @return an ArrayList of Cards representing the player's played cards
	 */
	public ArrayList<Card> getPlayedCards(Player player) {
		int index = players.indexOf(player);
		if(index >= 0) {
			return players.get(index).getPlayedCards();
		} else {
			return new ArrayList<Card>();
		}
	}
	
	/**
	 * Get the maximum number of players for the game
	 * @return the max players
	 */
	public int getMaxPlayers() {
		return this.maxPlayers;
	}
	
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	
	public int getHandSize() {
		return this.handSize;
	}
	
	public void setHandSize(int handSize) {
		this.handSize = handSize;
	}
	
	public int getNumberOfRounds() {
		return this.rounds;
	}
	
	public void setNumberOfRounds(int rounds) {
		this.rounds = rounds;
	}

	/**
	 * Deals the top card from the deck. If the deck is empty then it switches
	 * in the discard pile (shuffled) to allow the game to continue
	 * 
	 * @return a Card object, the top card on the deck
	 */
	private Card dealCard() {
		// If the deck is empty switch with the discard pile and clear it
		if (this.deck.getDeckSize() <= 0) {
			this.deck = this.discard;
			this.discard.getCards().clear();
		}

		return this.deck.deal();
	}

	/**
	 * Deal out a hand to each player
	 */
	public void deal() {
		for (int i = 0; i < this.handSize; i++) {
			for (Player player : this.players) {
				player.receiveCard(dealCard());
			}
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * Rotates each player's hand around
	 */
	private void switchHands() {
		ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>();
		for (Player player : this.players) {
			hands.add(player.getHand());
		}

		for (int j = 0; j < hands.size(); j++) {
			this.players.get((j + 1) % this.players.size()).receiveHand(hands.get(j));
		}
		setChanged();
		notifyObservers();
		
	}

	/**
	 * Adds a list of cards to the discard pile in a random order
	 * 
	 * @param cards
	 *            the list of cards to discard
	 */
	private void addToDiscardPile(List<Card> cards) {
		for (Card card : cards) {
			this.discard.insert(card);
		}
	}

	/**
	 * Adds all the played cards of the Players provided to the
	 * discard pile
	 * @param players a list of players
	 */
	private void discardPlayedCards(List<Player> players) {
		for (Player player : players) {
			addToDiscardPile(player.getPlayedCards());
			player.clearPlayedCards();
		}
	}

	/**
	 * Play the game
	 * 
	 * Pre-requisites: 
	 * 1) At least 2 players 
	 * 2) Enough cards (Deck size >= num Players * hand size)
	 * 
	 * Order of play: 
	 * 1) Deal each player a hand 
	 * 2) Each player plays a card(series/parallel depending on implementation) 
	 * 3) Players pass hands 
	 * 4) Continue until no cards left 
	 * 5) Calculate basic score for each player 
	 * 6) Assign Maki bonuses 
	 * 7) Add played hands to discard pile 
	 * (Opt) Show running scores 
	 * 8) Repeat 1-7 as many times as there are rounds 
	 * 9) Assign pudding bonus/forfeit 
	 * 10) Show final scores, declare winner
	 */
	public void play() {

		//Scanner to get user input
		Scanner in = new Scanner(System.in);
		
		for (int round = 0; round < this.rounds; round++) {
			
			System.out.println("////////////////////////////");
			System.out.println("//        ROUND " + (round + 1) + "         //");
			System.out.println("////////////////////////////");
			
			// 1) Deal each player a hand
			deal();

			// 2) Each player plays a card
			
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

				// 3) Players switch hands
				switchHands();

			} // 4) Continue until no cards left

			// 5) Calculate basic score for each player
			// 6) Assign Maki bonuses
			Score.getRoundScore(players);

			// (Opt) Show scores
			Score.showScores(players);

			// 7) Add played hands to discard pile
			discardPlayedCards(players);
			
		} // 8) Repeat 1-7 for each round

		// 9) Assign pudding bonus/forfeit
		Score.addPuddings(players);

		// 10) Show final scores
		Score.showScores(players);

		//Close scanner
		in.close();
	}
	
	/**
	 * Public method to start the game. Creates a new thread
	 * which handles the actual starting and running of the game
	 */
	public synchronized void start() {
		GameThread thread = new GameThread(this);
		thread.start();
	}
	
	public synchronized void startGame() {
		System.out.println("Game will start when enough players join");
		while(players.size() != maxPlayers) {
			try {
				System.out.println(players.size() + " players have joined, waiting for " + (maxPlayers - players.size() + " more"));
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Starting game");
		
		for(int round = 0; round < rounds; round++) {
			deal();
			
			for(int i = 0; i < handSize; i++) {
				requestCards(); //Blocks until all cards are in
				
				//Update each player with their played card
				for(Player player : played.keySet()) {
//					System.out.println(player + " plays " + played.get(player));
					player.playCard(played.get(player));
//					System.out.println("Played cards are: ");
//					player.showPlayed();
				}
				
				//All cards are played so reset the Map
				played.clear();
				
				switchHands();
			}
			
			Score.getRoundScore(players);

			Score.showScores(players);
			
			discardPlayedCards(players);
		}
		
		Score.addPuddings(players);

		Score.showScores(players);

		
	}
	
	public void playSingle() {
		deal();
		for (Player player : players) {
			player.getPlayedCards();
		}
//		for (Player player : players){
//			actions.add(executor.submit(player.getPlayerThread()));
//		}
//		
//		for(Future<PlayerAction> action : actions) {
//			try {
//				PlayerAction playerAction = action.get();
//				Player player = playerAction.getPlayer();
//				Card card = playerAction.getCard();
//				getPlayer(player).playCard(card);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		switchHands();
	}
	

}
