package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cards.Card;
import cards.Dumpling;
import cards.Nigiri;
import cards.Sashimi;
import cards.Tempura;
import cards.Wasabi;
import core.Player;
import core.Score;

/**
 * Unit tests for Score
 * 
 * @author Dom Parfitt
 *
 */
public class ScoreTests {

	private ArrayList<Player> players;
	private ArrayList<Card> hand;

	@Before
	public void setUp() throws Exception {
		hand = new ArrayList<>();
		players = new ArrayList<>();
		for (int i = 1; i <= 4; i++) {
			players.add(new Player("p" + i));
		}
	}
	
	/*
	 * NIGIRI
	 */
	@Test
	public void nigiri() {
		for(int i = 1; i <= 3; i++) {
			hand.add(new Nigiri(i));
			assertEquals(i, Score.getScore(hand).getNumScore());
			hand.clear();
		}
	}
	
	/*
	 * DUMPLINGS
	 */
	@Test
	public void dumpling() {
		for (int i = 1; i <= 5; i++) {
			int score = 0;
			for(int j = 1; j <= i; j++) {
				score += j;
				hand.add(new Dumpling());
			}
			assertEquals(score, Score.getScore(hand).getNumScore());
			hand.clear();
		}
	}
	
	/*
	 * TEMPURA
	 */
	@Test
	public void tempuraOne() {
		hand.add(new Tempura());
		assertEquals(0, Score.getScore(hand).getNumScore());
	}

	@Test
	public void tempuraTwo() {
		hand.add(new Tempura());
		hand.add(new Tempura());
		assertEquals(5, Score.getScore(hand).getNumScore());
	}
	
	@Test
	public void tempuraThree() {
		hand.add(new Tempura());
		hand.add(new Tempura());
		hand.add(new Tempura());
		assertEquals(5, Score.getScore(hand).getNumScore());
	}
	
	@Test
	public void tempuraFour() {
		hand.add(new Tempura());
		hand.add(new Tempura());
		hand.add(new Tempura());
		hand.add(new Tempura());
		assertEquals(5*2, Score.getScore(hand).getNumScore());
	}
	
	/*
	 * SASHIMI
	 */
	@Test
	public void sashimiTwo() {
		hand.add(new Sashimi());
		hand.add(new Sashimi());
		assertEquals(0, Score.getScore(hand).getNumScore());
	}
	
	@Test
	public void sashimiThree() {
		hand.add(new Sashimi());
		hand.add(new Sashimi());
		hand.add(new Sashimi());
		assertEquals(10, Score.getScore(hand).getNumScore());
	}
	
	@Test
	public void sashimiFour() {
		hand.add(new Sashimi());
		hand.add(new Sashimi());
		hand.add(new Sashimi());
		hand.add(new Sashimi());
		assertEquals(10, Score.getScore(hand).getNumScore());
	}
	
	@Test
	public void sashimiSix() {
		hand.add(new Sashimi());
		hand.add(new Sashimi());
		hand.add(new Sashimi());
		hand.add(new Sashimi());
		hand.add(new Sashimi());
		hand.add(new Sashimi());
		assertEquals(10 * 2, Score.getScore(hand).getNumScore());
	}
	
	/*
	 * WASABI
	 */
	@Test
	public void wasabiNoNigiri() {
		hand.add(new Wasabi());
		assertEquals(0, Score.getScore(hand).getNumScore());
	}

	@Test
	public void wasabiBeforeNigiri() {
		for (int i = 1; i <= 3; i++) {
			hand.add(new Wasabi());
			hand.add(new Nigiri(i));
			assertEquals(i * 3, Score.getScore(hand).getNumScore());
			hand.clear();
		}
	}

	@Test
	public void wasabiAfterNigiri() {
		for (int i = 1; i <= 3; i++) {
			hand.add(new Nigiri(i));
			hand.add(new Wasabi());
			assertEquals(i, Score.getScore(hand).getNumScore());
			hand.clear();
		}
	}

	@Test
	public void wasabiTwoNigiri() {
		for (int i = 1; i <= 3; i++) {
			hand.add(new Wasabi());
			hand.add(new Nigiri(i));
			hand.add(new Nigiri(i));
			assertEquals((i * 3) + i, Score.getScore(hand).getNumScore());
			hand.clear();
		}
	}

	@Test
	public void wasabiNigiriTwice() {
		for (int i = 1; i <= 3; i++) {
			hand.add(new Wasabi());
			hand.add(new Nigiri(i));
			hand.add(new Wasabi());
			hand.add(new Nigiri(i));
			assertEquals((i * 3) * 2, Score.getScore(hand).getNumScore());
			hand.clear();
		}
	}

	/*
	 * MAKIS
	 */
	@Test
	public void makiNone() {
		for (Player player : players) {
			player.updateScore(new Score(0, 0, 0));
		}
		players = Score.addMakis(players);
		for (Player player : players) {
			assertEquals(0, player.getScore().getNumScore());
		}
	}

	@Test
	public void makiSingleHighNoSecond() {
		players.get(0).updateScore(new Score(0, 0, 3));
		players = Score.addMakis(players);
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (i == 0) {
				assertEquals(6, player.getScore().getNumScore());
			} else {
				assertEquals(0, player.getScore().getNumScore());
			}
		}
	}

	@Test
	public void makiSingleHighSingleSecond() {
		players.get(0).updateScore(new Score(0, 0, 3));
		players.get(1).updateScore(new Score(0, 0, 1));
		players = Score.addMakis(players);
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (i == 0) {
				assertEquals(6, player.getScore().getNumScore());
			} else if (i == 1) {
				assertEquals(3, player.getScore().getNumScore());
			} else {
				assertEquals(0, player.getScore().getNumScore());
			}
		}
	}

	@Test
	public void makiSingleHighMultiSecond() {
		players.get(0).updateScore(new Score(0, 0, 3));
		players.get(1).updateScore(new Score(0, 0, 1));
		players.get(2).updateScore(new Score(0, 0, 1));
		players = Score.addMakis(players);
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (i == 0) {
				assertEquals(6, player.getScore().getNumScore());
			} else if (i == 1 || i == 2) {
				assertEquals(1, player.getScore().getNumScore());
			} else {
				assertEquals(0, player.getScore().getNumScore());
			}
		}
	}

	@Test
	public void makiMultiHighNoSecond() {
		players.get(0).updateScore(new Score(0, 0, 3));
		players.get(1).updateScore(new Score(0, 0, 3));
		players = Score.addMakis(players);
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (i == 0 || i == 1) {
				assertEquals(3, player.getScore().getNumScore());
			} else {
				assertEquals(0, player.getScore().getNumScore());
			}
		}
	}

	@Test
	public void makiMultiHighSingleSecond() {
		players.get(0).updateScore(new Score(0, 0, 3));
		players.get(1).updateScore(new Score(0, 0, 3));
		players.get(2).updateScore(new Score(0, 0, 1));
		players = Score.addMakis(players);
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (i == 0 || i == 1 || i == 2) {
				assertEquals(3, player.getScore().getNumScore());
			} else {
				assertEquals(0, player.getScore().getNumScore());
			}
		}
	}

	@Test
	public void makiMultiHighMultiecond() {
		players.get(0).updateScore(new Score(0, 0, 3));
		players.get(1).updateScore(new Score(0, 0, 3));
		players.get(2).updateScore(new Score(0, 0, 1));
		players.get(3).updateScore(new Score(0, 0, 1));
		players = Score.addMakis(players);
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (i == 0 || i == 1) {
				assertEquals(3, player.getScore().getNumScore());
			} else {
				assertEquals(1, player.getScore().getNumScore());
			}
		}
	}

	/*
	 * PUDDINGS
	 */
	@Test
	public void puddingNone() {
		for (Player player : players) {
			player.updateScore(new Score(0, 0, 0));
		}
		players = Score.addPuddings(players);
		for (Player player : players) {
			assertEquals(0, player.getScore().getNumScore());
		}
	}

	@Test
	public void puddingSingleHighMultiLow() {
		players.get(0).updateScore(new Score(0, 3, 0));
		players = Score.addPuddings(players);
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (i == 0) {
				assertEquals(6, player.getScore().getNumScore());
			} else {
				assertEquals(-2, player.getScore().getNumScore());
			}
		}
	}

	@Test
	public void puddingSingleHighSingleLow() {
		players.get(0).updateScore(new Score(0, 3, 0));
		players.get(1).updateScore(new Score(0, 1, 0));
		players.get(2).updateScore(new Score(0, 1, 0));
		players.get(3).updateScore(new Score(0, 0, 0));
		players = Score.addPuddings(players);
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (i == 0) {
				assertEquals(6, player.getScore().getNumScore());
			} else if (i == 1 || i == 2) {
				assertEquals(0, player.getScore().getNumScore());
			} else {
				assertEquals(-6, player.getScore().getNumScore());
			}
		}
	}

	@Test
	public void puddingMultiHighMultiLow() {
		players.get(0).updateScore(new Score(0, 3, 0));
		players.get(1).updateScore(new Score(0, 3, 0));
		players = Score.addPuddings(players);
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (i == 0 || i == 1) {
				assertEquals(3, player.getScore().getNumScore());
			} else {
				assertEquals(-3, player.getScore().getNumScore());
			}
		}
	}

	@Test
	public void puddingMultiHighSingleLow() {
		players.get(0).updateScore(new Score(0, 3, 0));
		players.get(1).updateScore(new Score(0, 3, 0));
		players.get(2).updateScore(new Score(0, 3, 0));
		players = Score.addPuddings(players);
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			if (i == 0 || i == 1 || i == 2) {
				assertEquals(2, player.getScore().getNumScore());
			} else {
				assertEquals(-6, player.getScore().getNumScore());
			}
		}
	}

}
