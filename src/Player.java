
public class Player implements Comparable {

	private static int NUMBEROFPLAYERS = 1;
	
	private int number;
	private String name;
	private int score;
	private Hand hand;
	
	public Player(String name) {
		this.number = Player.NUMBEROFPLAYERS;
		Player.NUMBEROFPLAYERS++;
		this.name = name;
		this.score = 0;
		this.hand = new Hand();
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public Hand getHand() {
		return this.hand;
	}
	
	public String viewHand() {
		return getHand().toString();
	}
	
	public void giveCard(Card card) {
		getHand().addCard(card);
	}
	
	public Card playCard(Card card) {
		return getHand().playCard(card);
	}
	
	public Card playCard(int index) {
		return getHand().playCard(index);
	}
	
	@Override
	public String toString() {
		return "Player " + getNumber() + " - " + getName();
	}

	@Override
	public int compareTo(Object otherPlayer) {
		return ((Integer) this.getNumber()).compareTo(((Player)otherPlayer).getNumber());
	}
}
