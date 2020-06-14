package com.rockpaperscissors.delegate;

import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;

import com.rockpaperscissors.domain.FullStatistics;
import com.rockpaperscissors.domain.Movement;
import com.rockpaperscissors.domain.Movements;
import com.rockpaperscissors.domain.Player;
import com.rockpaperscissors.domain.RPSRequest;
import com.rockpaperscissors.domain.RPSResponse;

@Service
public class RockPaperScissorsDelegateImpl implements RockPaperScissorsDelegate{
	
	private static final int THREE = 3;
	private static final int ZERO = 0;
	private static final int TWO = 2;
	private static final int ONE = 1;
	private static final String TIE = "TIE";
	
	Movements movements = new Movements();
	
	/**
	 * This method will return the name of the winner, or empty name if there is not a winner
	 */
	public String playRockPaperScissors(Player playerOne, Player playerTwo) {
		String winner = new String("");
		if(isCorrect(playerOne.getMovement().getValue(), THREE) &&  isCorrect(playerTwo.getMovement().getValue(), THREE) ) {
			
		  FullStatistics.setTotal(FullStatistics.getTotal() + 1);
		  if (playerOne.getMovement().getValue() != playerTwo.getMovement().getValue() ) {
			  winner = getWinner(playerOne, playerTwo, THREE);
		  }else {
			  winner=TIE;
			  FullStatistics.setTie(FullStatistics.getTie() + 1);
		  }
		}else {
			throw new IllegalArgumentException("Values are not correct");
		}
		return winner;
	}

	
	/**
	 * This method returns the name of the winner
	 */
	public String getWinner(Player playerOne, Player playerTwo, int totalMovements) {
		String winner;
		int auxWinner = calculateWinner(playerOne.getMovement().getValue(), playerTwo.getMovement().getValue(), totalMovements);
		
		if(auxWinner == ONE) {
			winner=playerOne.getName();
			FullStatistics.setPlayerOneWon(FullStatistics.getPlayerOneWon() + 1);
		}else {
			winner=playerTwo.getName();
			FullStatistics.setPlayerTwoWon(FullStatistics.getPlayerTwoWon() + 1);
		}
		return winner;
	}

	/**
	 * 	This return a number which represent the user, One if is the first argument, or 0 if the winner is in the second argument
	 */
	public int calculateWinner(int movPO, int movPT, int totalMovements) {

		int auxWinner;
		
		auxWinner = ((totalMovements + movPO - movPT)%totalMovements)%TWO;
				
		return auxWinner;
	}
	
	/**
	 * This method will return
	 * @param movement
	 * @param totalMovements
	 * @return
	 */
	public boolean isCorrect(int movement, int totalMovements) {
		
		return (movement < totalMovements && movement >= ZERO);
	}


	/**
	 * Receive the request and generate a response after play a game
	 */
	public RPSResponse initAndPlay(RPSRequest request) {
		
		Player playerOne;
		Player playerTwo;
		String winner;
		if (isValidRequest(request)) {
			playerOne = createPlayerFromRequest(request.getPlayerOne(), request.getMovementPO());
			playerTwo = createPlayerFromRequest(request.getPlayerTwo(), request.getMovementPT());
			winner = playRockPaperScissors(playerOne, playerTwo);
		
			RPSResponse response = new RPSResponse(winner, playerOne.getMovement().getName(), playerTwo.getMovement().getName());
			return response;
		}else {
			throw new IllegalArgumentException("playerOne and playerTwo are mandatory and different fields");
		}
	}


	/**
	 * Return a movement having its value
	 * @param movementValue
	 * @return
	 */
	public Movement getMovementFromNumber(int movementValue) {

		Movement outputMovement = new Movement();
		
		if(isCorrect(movementValue, THREE)) {
			if(movementValue == movements.getRock().getValue()){
				outputMovement = new Movement(movements.getRock());
			}else if(movementValue == movements.getPaper().getValue()){
				outputMovement = new Movement(movements.getPaper());
			}else if(movementValue == movements.getScissors().getValue()){
				outputMovement = new Movement(movements.getScissors());
			}
		}else {
			throw new IllegalArgumentException("Movement value is not correct");
		}
		
		return outputMovement;
	}
	
	/**
	 * Advice if the movement received as string is valid
	 * @param movementName
	 * @return
	 */
	public boolean isMovementFromString(String movementName) {

		if (movementName != null) {
		  return (movementName.equalsIgnoreCase(movements.getRock().getName()) ||
				  movementName.equalsIgnoreCase(movements.getPaper().getName()) ||
				  movementName.equalsIgnoreCase(movements.getScissors().getName()));
		}else {
				return false;
		}

	}
	
	/**
	 * Return a movement having its name
	 * @param movementName
	 * @return
	 */
	public Movement getMovementFromString(String movementName) {
		
		Movement movement = new Movement();
		if(isMovementFromString(movementName)) {
			if(movementName.equalsIgnoreCase(movements.getRock().getName())) {
				movement = new Movement(movements.getRock());
			}else if(movementName.equalsIgnoreCase(movements.getPaper().getName())) {
				movement = new Movement(movements.getPaper());
			}else if(movementName.equalsIgnoreCase(movements.getScissors().getName())) {
				movement = new Movement(movements.getScissors());
			}
		}else {
			throw new IllegalArgumentException("Movement name is not correct");
		}
		
		return movement;
	}
	
	
	/**
	 * Obtain a random number between 0 and a max
	 * @param maxNumber
	 * @return
	 */
	public int getRandomNumberBetweenZeroAndMax(int maxNumber, double inputRandom) {
	
        int result = (int)Math.floor(inputRandom*(maxNumber-0.1));

		return result;
	}
	
	/**
	 * Create a player from the details in the request
	 * @param playerName
	 * @param movementName
	 * @return
	 */
	public Player createPlayerFromRequest(String playerName, String movementName) {
		
		double inputRandom= Math.random();
		Player player = new Player();
		Movement movement = new Movement();
		
		if(StringUtils.isBlank(movementName) ){
			movement = getMovementFromNumber(getRandomNumberBetweenZeroAndMax(THREE, inputRandom));
			player.setMovement(movement);
			player.setName(playerName);
		}else {
			movement = getMovementFromString(movementName);
			player.setMovement(movement);
			player.setName(playerName);
		}
		
		return player;
		
	}
	
	/**
	 * Validate Request, players name are mandatory and different
	 */
	public boolean isValidRequest(RPSRequest request) {
		
		return (StringUtils.isNotBlank(request.getPlayerOne()) && StringUtils.isNotBlank(request.getPlayerTwo()) && 
				!StringUtils.equalsIgnoreCase(request.getPlayerOne(), request.getPlayerTwo()));
		
	}

}


