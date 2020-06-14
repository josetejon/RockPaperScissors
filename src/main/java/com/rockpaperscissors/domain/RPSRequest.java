package com.rockpaperscissors.domain;
/**
 * Request to play. If there is no movements, this will be a random one
 * @author jose
 *
 */
public class RPSRequest {

	private String playerOne;
	private String playerTwo;
	private String movementPO;
	private String movementPT;
	
	public String getPlayerOne() {
		return playerOne;
	}
	public void setPlayerOne(String playerOne) {
		this.playerOne = playerOne;
	}
	public String getPlayerTwo() {
		return playerTwo;
	}
	public void setPlayerTwo(String playerTwo) {
		this.playerTwo = playerTwo;
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
