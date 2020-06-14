package com.rockpaperscissors.delegate;

import com.rockpaperscissors.domain.Player;
import com.rockpaperscissors.domain.RPSRequest;
import com.rockpaperscissors.domain.RPSResponse;

public interface RockPaperScissorsDelegate {
	String playRockPaperScissors(Player playerOne, Player playerTwo);
	String getWinner(Player playerOne, Player playerTwo, int totalMovements);
	int calculateWinner(int movPO, int movPT, int totalMovements);
	RPSResponse initAndPlay(RPSRequest request);
}
