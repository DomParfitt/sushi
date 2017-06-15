package core;

import java.util.ArrayList;

import cards.Card;

//TODO: Change ArrayList instances in method heads to generic List

/**
 * Class for holding various elements which contribute to a player's final score
 * 
 * @author Dom Parfitt
 *
 */
public class Score {

	private int score;
	private int puddingCount;
	private int makiScore;

	/**
	 * Public constructor for intialising starting score
	 */
	public Score() {
		this.score = 0;
		this.puddingCount = 0;
		this.makiScore = 0;
	}

	/**
	 * Private constructor for returning new score
	 * 
	 * @param score
	 *            numerical score
	 * @param puddingCount
	 *            count of puddings
	 */
	public Score(int score, int puddingCount, int makiScore) {
		this.score = score;
		this.puddingCount = puddingCount;
		this.makiScore = makiScore;
	}

	/**
	 * Get the numerical score
	 * 
	 * @return the numerical score
	 */
	public int getNumScore() {
		return this.score;
	}

	/**
	 * Get the count of puddings
	 * 
	 * @return the number of puddings
	 */
	public int getPuddingCount() {
		return this.puddingCount;
	}

	public int getMakiScore() {
		return this.makiScore;
	}

	/**
	 * Adds two scores together. Used to update scores between rounds
	 * 
	 * @param other
	 * @return
	 */
	public Score addScore(Score other) {
		int newScore = this.getNumScore() + other.getNumScore();
		int newPuddingCount = this.getPuddingCount() + other.getPuddingCount();
		return new Score(newScore, newPuddingCount, other.getMakiScore());
	}

	/**
	 * Calculates the individual components of a Score object from a list of
	 * cards
	 * 
	 * @param cards
	 *            the list of cards
	 * @return a Score object
	 */
	public static Score getScore(ArrayList<Card> cards) {
		int score = 0;
		int makiScore = 0;
		int tempuraCount = 0;
		int sashimiCount = 0;
		int puddingCount = 0;
		int dumplingCount = 0;
		boolean wasabiFlag = false;

		// Handle each individual card
		for (Card card : cards) {
			switch (card.getType()) {
			case CHOPSTICKS:
				break;
			case MAKI:
				makiScore += card.getValue();
				break;
			case NIGIRI:
				if (wasabiFlag) {
					score += (card.getValue() * 3);
					wasabiFlag = false;
				} else {
					score += card.getValue();
				}
				break;
			case PUDDING:
				puddingCount++;
				break;
			case SASHIMI:
				sashimiCount++;
				break;
			case TEMPURA:
				tempuraCount++;
				break;
			case WASABI:
				wasabiFlag = true;
				break;
			case DUMPLING:
				dumplingCount++;
				break;
			default:
				break;
			}

		}

		// Check for tempura pairs
		score += ((tempuraCount / 2) * 5);

		// Check for sashimi triples
		score += ((sashimiCount / 3) * 10);
		
		//Add dumplings
		for(int i = 1; i <= dumplingCount; i++) {
			score += i;
		}

		return new Score(score, puddingCount, makiScore);
	}

	/**
	 * Assigns the bonuses to the players with the most and second most maki
	 * rolls
	 * 
	 * @param players
	 *            a list of players
	 * @return the same list of players with each player's score updated to
	 *         reflect the assigned bonuses
	 */
	public static ArrayList<Player> addMakis(ArrayList<Player> players) {
		// TODO: Allow handling of ties
		int highIndex = 0;
		ArrayList<Integer> highIndices = new ArrayList<Integer>();
		int highScore = 0;
		int secondIndex = 0;
		ArrayList<Integer> secondIndices = new ArrayList<Integer>();
		int secondScore = 0;

		for (int i = 0; i < players.size(); i++) {
			int score = players.get(i).getScore().getMakiScore();
			if (score > highScore) {
				// Set the second highest to the current max
				secondIndices = highIndices;
				secondIndex = highIndex;
				secondScore = highScore;

				// Set the highest to the new one
				highIndices = new ArrayList<Integer>();
				highIndices.add(i);
				highIndex = i;
				highScore = score;
			} else if (score == highScore) {
				highIndices.add(i);
			} else if (score > secondScore) {
				// Set the second highest to the new one
				secondIndices = new ArrayList<Integer>();
				secondIndices.add(i);
				secondIndex = i;
				secondScore = score;
			} else if (score == secondScore) {
				secondIndices.add(i);
			}
		}

		// Only give bonuses if counts are greater than 0
		if (highScore > 0) {
			int highCount = highIndices.size();
			int highPoints = 6 / highCount;
			for (Integer index : highIndices) {
				// players.get(highIndex).updateScore(new Score(6, 0, 0));
				players.get(index).updateScore(new Score(highPoints, 0, 0));
				System.out.println(players.get(index) + " scored +" + highPoints + " for most Makis with " + highScore);

			}

			if (secondScore > 0) {
				int secoundCount = secondIndices.size();
				int secondPoints = 3 / secoundCount;
				for (Integer index : secondIndices) {
//					players.get(secondIndex).updateScore(new Score(3, 0, 0));
					players.get(index).updateScore(new Score(secondPoints, 0, 0));
					System.out.println(players.get(index) + " scored +" + secondPoints + " for second most Makis with " + secondScore);
				}
			}
		}

		return players;

	}

	/**
	 * Static method to calculate the bonus and reduction for the most and least
	 * puddings
	 * 
	 * @param players
	 *            the list of players to calculate the bonus and forfeit for
	 * @return the same list of players with the scores updated to reflect the
	 *         assigned bonus/forfeit
	 */
	public static ArrayList<Player> addPuddings(ArrayList<Player> players) {
		int highIndex = 0;
		ArrayList<Integer> highIndices = new ArrayList<>();
		int highCount = 0;
		int lowIndex = 0;
		ArrayList<Integer> lowIndices = new ArrayList<>();
		int lowCount = Integer.MAX_VALUE;

		for (int i = 0; i < players.size(); i++) {
			int puddingCount = players.get(i).getScore().getPuddingCount();
			if (puddingCount > highCount) {
				highCount = puddingCount;
				highIndices = new ArrayList<>();
				highIndices.add(i);
				highIndex = i;
			} else if(puddingCount == highCount) {
				highIndices.add(i);
			} else if (puddingCount < lowCount) {
				lowCount = puddingCount;
				lowIndices = new ArrayList<>();
				lowIndices.add(i);
				lowIndex = i;
			} else if (puddingCount == lowCount) {
				lowIndices.add(i);
			}
		}

		// Only give a bonus/forfeit if someone has puddings
		if (highCount > 0) {
			int highPoints = 6 / highIndices.size();
			for(Integer index : highIndices) {
				players.get(index).updateScore(new Score(highPoints, 0, 0));
				System.out.println(players.get(index) + " scored +" + highPoints + " for most Puddings with " + highCount);
				
			}
			
			int lowPoints = -1 * (6 / lowIndices.size());
			for(Integer index : lowIndices) {
				
				players.get(index).updateScore(new Score(lowPoints, 0, 0));
				System.out.println(players.get(index) + " scored -" + lowPoints + " for least Puddings with " + lowCount);
			}

		}
		return players;

	}

	/**
	 * Updates the scores for a list of players
	 * 
	 * @param players
	 *            the list of players
	 * @return the same list of players with their scores updated
	 */
	public static ArrayList<Player> getScores(ArrayList<Player> players) {
		for (Player player : players) {
			ArrayList<Card> playedCards = player.getPlayedCards();
			Score newScore = Score.getScore(playedCards);
			player.updateScore(newScore);
			System.out.println(player + " scored " + newScore.getNumScore() + " from Nigiris, Tempuras and Sashimis");
		}

		return players;
	}

	/**
	 * Gets the score at the end of the round, i.e. the numerical score with the
	 * maki bonus assigned
	 * 
	 * @param players
	 *            the list of players
	 * @return the same list of players with their scores updated
	 */
	public static ArrayList<Player> getRoundScore(ArrayList<Player> players) {
		players = getScores(players);
		return addMakis(players);

	}

	/**
	 * Prints the scores to the console
	 * 
	 * @param players
	 *            the list of players
	 */
	public static void showScores(ArrayList<Player> players) {
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i));
			players.get(i).showPlayed();
			System.out.println(players.get(i).getScore().getNumScore());

		}
	}

}
