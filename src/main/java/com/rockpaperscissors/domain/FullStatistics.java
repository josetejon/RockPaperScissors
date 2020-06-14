package com.rockpaperscissors.domain;

import org.springframework.stereotype.Component;

/**
 * Class with statics attributes to store the information
 * @author jose
 *
 */
@Component
public class FullStatistics {
	private static int playerOneWon;
	private static int playerTwoWon;
	private static int tie;
	private static int total;
	
	public static int getTie() {
		return tie;
	}

	public static void setTie(int tie) {
		FullStatistics.tie = tie;
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		FullStatistics.total = total;
	}

	public static int getPlayerOneWon() {
		return playerOneWon;
	}

	public static void setPlayerOneWon(int playerOneWon) {
		FullStatistics.playerOneWon = playerOneWon;
	}

	public static int getPlayerTwoWon() {
		return playerTwoWon;
	}

	public static void setPlayerTwoWon(int playerTwoWon) {
		FullStatistics.playerTwoWon = playerTwoWon;
	}
}
