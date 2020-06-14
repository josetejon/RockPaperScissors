package com.rockpaperscissors.domain;

/**
 * Response to play
 * @author jose
 *
 */
public class RPSResponse {
	
	private String winnerName;
	private String movementPO;
	private String movementPT;
	
	public RPSResponse(String winnerName, String movementPO, String movementPT) {
		super();
		this.winnerName = winnerName;
		this.movementPO = movementPO;
		this.movementPT = movementPT;
	}
	
	public RPSResponse() {
		super();
	}

	public String getWinner() {
		return winnerName;
	}
	public void setWinner(String winnerName) {
		this.winnerName = winnerName;
	}
	public String getMovementPO() {
		return movementPO;
	}
	public void setMovementPO(String movementPO) {
		this.movementPO = movementPO;
	}
	public String getMovementPT() {
		return movementPT;
	}
	public void setMovementPT(String movementPT) {
		this.movementPT = movementPT;
	}
	
}
