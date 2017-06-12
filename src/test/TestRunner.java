package test;

import java.util.ArrayList;

import ai.MakiAI;
import cards.Card;
import cards.MakiRoll;
import core.Player;

public class TestRunner {

	public static void main(String[] args) {
		Player ai = new MakiAI("CPU");
		ArrayList<Card> cards = new ArrayList<>();
		cards.add(new MakiRoll(1));
		cards.add(new MakiRoll(3));
		cards.add(new MakiRoll(2));
		ai.receiveHand(cards);
		Card card = ai.requestCard();
		System.out.println(card);
	}
	
}
