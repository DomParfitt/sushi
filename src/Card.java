
public class Card {
	
	private String name;
	private String text;
	
	public Card(String name, String text) {
		this.name = name;
		this.text = text;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getText() {
		return this.text;
	}
	
	@Override
	public String toString() {
		return getName() + " - " + getText();
	}
}
