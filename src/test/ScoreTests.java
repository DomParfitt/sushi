package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

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

	@Before
	public void setUp() throws Exception {
		players = new ArrayList<>();
		for (int i = 1; i <= 4; i++) {
			players.add(new Player("p" + i));
		}
	}

	/*
	 * Testing various maki combinations
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
	 * Testing various pudding combinations 
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
