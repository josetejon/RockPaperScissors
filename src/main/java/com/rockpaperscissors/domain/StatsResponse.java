package com.rockpaperscissors.domain;
/**
 * Response what will be give the full statistics
 * @author jose
 *
 */
public class StatsResponse {
	private int playerOneWon;
	private int playerTwoWon;
	private int draws;
	private int total;
	
	public StatsResponse(int playerOneWon, int playerTwoWon, int drwan, int total) {
		super();
		this.playerOneWon = playerOneWon;
		this.playerTwoWon = playerTwoWon;
		this.draws = drwan;
		this.total = total;
	}
	public int getPlayerOneWon() {
		return playerOneWon;
	}
	public void setPlayerOneWon(int playerOneWon) {
		this.playerOneWon = playerOneWon;
	}
	public int getPlayerTwoWon() {
		return playerTwoWon;
	}
	public void setPlayerTwoWon(int playerTwoWon) {
		this.playerTwoWon = playerTwoWon;
	}
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
