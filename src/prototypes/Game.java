package prototypes;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Game {

//	private ArrayList<Player> players;
	private TreeMap<Player, ArrayList<Card>> players;
	private Deck deck;
	private int handSize = 10;
	
	public Game() {
//		this.players = new ArrayList<Player>();
		this.players = new TreeMap<Player, ArrayList<Card>>();
		this.deck = new Deck(100);
		this.deck.shuffle();
	}
	
	public List<Player> getPlayers() {
		Set<Player> playerSet = this.players.keySet();
		ArrayList<Player> players = new ArrayList<Player>();
		for (Player player : playerSet) {
			players.add(player);
		}
		return players;
		
	}
	
	public String showPlayers() {
		String output = "";
		for (Player player : getPlayers()) {
			output += player + "\n";
		}
		
		return output;
	}
	
	public void addPlayer(Player player) {
//		getPlayers().add(player);
		this.players.put(player, new ArrayList<Card>());
	}
	
	public int getNumberOfPlayers() {
		return getPlayers().size();
	}
	
	public void deal() {
		for (int i = 0; i < handSize; i++) {
			for (Player player : getPlayers()) {
				player.giveCard(this.deck.deal());
			}
		}
	}
	
	public void play() {
		for (Player player : getPlayers()) {
			Card card = player.playCard(0);
			ArrayList<Card> cards = this.players.get(player);
			cards.add(card);
			this.players.put(player, cards);
		}
	}
	
	public String showScores() {
		String output = "";
		for (Player player : getPlayers()) {
			int score = 0;
			
			for (Card card : this.players.get(player)) {
				score += Integer.parseInt(card.getName());
			}
			
			output += player + ": " + score + "\n";
			
		}
		
		return output;
	}
	
	public void playFull() {
		
	}
	
}
