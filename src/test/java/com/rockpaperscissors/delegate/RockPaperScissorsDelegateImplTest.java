package com.rockpaperscissors.delegate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import org.mockito.MockitoAnnotations;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.rockpaperscissors.domain.Movement;
import com.rockpaperscissors.domain.Movements;
import com.rockpaperscissors.domain.Player;
import com.rockpaperscissors.domain.RPSRequest;
import com.rockpaperscissors.domain.RPSResponse;

@RunWith(SpringRunner.class)
@WebMvcTest(RockPaperScissorsDelegateImplTest.class)
public class RockPaperScissorsDelegateImplTest {
	
	String tie;
	Player playerOne;
	Player playerTwo;
	String winner;
	int a,b,c;
	int zero, one, two, three;
	double half;
	String rock, paper, scissors;
	Movement moveRock, movePaper;
	String empty;

	RockPaperScissorsDelegateImpl delegate;
	
	Movements movements;
	
	RPSResponse response;
	RPSRequest request;
	
	@Rule
    public ExpectedException expectedException = ExpectedException.none();
	
	@Before
	public void setUp(){
		
		MockitoAnnotations.initMocks(this);
	    delegate = new RockPaperScissorsDelegateImpl();
		playerOne = new Player("player1");
		playerTwo = new Player("player2");
		movements = new Movements();
		tie = new String("TIE");
		a = 5;
		b = 2;
		c = 8;
		zero = 0;
		one = 1;
		two = 2;
		three = 3;
		half = 0.5;
		rock = new String("rock");
		paper = new String("paper");
		scissors = new String("scissors");
		moveRock = movements.getRock();
		movePaper = movements.getPaper();
		empty = new String("");
		response = new RPSResponse(empty, empty, empty);
		request = new RPSRequest();
		request.setPlayerOne(playerOne.getName());
		request.setPlayerTwo(playerTwo.getName());
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomGivesZero() {
		Assert.assertEquals(zero, delegate.getRandomNumberBetweenZeroAndMax(three, zero));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomWithZeroDotOne() {
		Assert.assertEquals(zero, delegate.getRandomNumberBetweenZeroAndMax(three, 0.1));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomWithZeroDotTwo() {
		Assert.assertEquals(zero, delegate.getRandomNumberBetweenZeroAndMax(three, 0.2));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomWithZeroDotThree() {
		Assert.assertEquals(zero, delegate.getRandomNumberBetweenZeroAndMax(three, 0.3));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomWithZeroDotThirtyone() {
		Assert.assertEquals(zero, delegate.getRandomNumberBetweenZeroAndMax(three, 0.31));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomWithZeroDotFour() {
		Assert.assertEquals(one, delegate.getRandomNumberBetweenZeroAndMax(three, 0.4));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomGivesOne() {
		Assert.assertEquals(one, delegate.getRandomNumberBetweenZeroAndMax(three, half));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomWithZeroDotSix() {
		Assert.assertEquals(one, delegate.getRandomNumberBetweenZeroAndMax(three, 0.6));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomWithZeroDotSixtynine() {
		Assert.assertEquals(two, delegate.getRandomNumberBetweenZeroAndMax(three, 0.69));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomWithZeroDotSeven() {
		Assert.assertEquals(two, delegate.getRandomNumberBetweenZeroAndMax(three, 0.7));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomWithZeroDotEigth() {
		Assert.assertEquals(two, delegate.getRandomNumberBetweenZeroAndMax(three, 0.8));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomWithZeroDotNine() {
		Assert.assertEquals(two, delegate.getRandomNumberBetweenZeroAndMax(three, 0.9));
	}
	
	/**
	 * get random number with known the seed
	 */
	@Test
	public void randomGivesTwo() {
		Assert.assertEquals(two, delegate.getRandomNumberBetweenZeroAndMax(three, one));
	}

	/**
	 * calculate winner algorithm
	 */
	@Test
	public void isCorrectReturnsFalse() {
		Assert.assertFalse(delegate.isCorrect(c, a));
	}
	
	/**
	 * calculate winner algorithm
	 */
	@Test
	public void isCorrectReturnsTrue() {
		Assert.assertTrue(delegate.isCorrect(b, a));
	}
	
	/**
	 * calculate winner algorithm
	 */
	@Test
	public void calculateWinnerAlgorithmRockVsScissors() {
		Assert.assertEquals(one, delegate.calculateWinner(movements.getRock().getValue(), movements.getScissors().getValue(), three));
	}
	
	/**
	 * calculate winner algorithm
	 */
	@Test
	public void calculateWinnerAlgorithmScissorsVsRock() {
		Assert.assertEquals(zero, delegate.calculateWinner(movements.getScissors().getValue(), movements.getRock().getValue(),three));
	}
	
	/**
	 * calculate winner algorithm
	 */
	@Test
	public void calculateWinnerAlgorithmRockVsPaper() {
		Assert.assertEquals(zero, delegate.calculateWinner(movements.getRock().getValue(), movements.getPaper().getValue(), three));
	}
	
	/**
	 * calculate winner algorithm
	 */
	@Test
	public void calculateWinnerAlgorithmPaperVsRock() {
		Assert.assertEquals(one, delegate.calculateWinner(movements.getPaper().getValue(), movements.getRock().getValue(),three));
	}
	
	/**
	 * calculate winner algorithm
	 */
	@Test
	public void calculateWinnerAlgorithmScissorsVsPaper() {
		Assert.assertEquals(one, delegate.calculateWinner(movements.getScissors().getValue(), movements.getPaper().getValue(), three));
	}
	
	/**
	 * calculate winner algorithm
	 */
	@Test
	public void calculateWinnerAlgorithmPaperVsScissors() {
		Assert.assertEquals(zero, delegate.calculateWinner(movements.getPaper().getValue(), movements.getScissors().getValue(),three));
	}
	
	/**
	 * round from created players
	 */
	@Test
	public void playGameRockVsPaper() {
		playerOne.setMovement(movements.getRock());
		playerTwo.setMovement(movements.getPaper());
		
		winner = delegate.playRockPaperScissors(playerOne, playerTwo);
		Assert.assertTrue(winner.equals(playerTwo.getName()));
	} 
	
	/**
	 * round from created players
	 */
	@Test
	public void playGamePaperVsRock() {
		playerOne.setMovement(movements.getPaper());
		playerTwo.setMovement(movements.getRock());
		
		winner = delegate.playRockPaperScissors(playerOne, playerTwo);
		Assert.assertTrue(winner.equals(playerOne.getName()));
	} 
	
	/**
	 * round from created players
	 */
	@Test
	public void playGameRockVsScissors() {
		playerOne.setMovement(movements.getRock());
		playerTwo.setMovement(movements.getScissors());
		
		winner = delegate.playRockPaperScissors(playerOne, playerTwo);
		Assert.assertTrue(winner.equals(playerOne.getName()));
	}
	
	/**
	 * round from created players
	 */
	@Test
	public void playGameScissorsVsRock() {
		playerOne.setMovement(movements.getScissors());
		playerTwo.setMovement(movements.getRock());
		
		winner = delegate.playRockPaperScissors(playerOne, playerTwo);
		Assert.assertTrue(winner.equals(playerTwo.getName()));
	}
	
	/**
	 * round from created players
	 */
	@Test
	public void playGamePaperVsScissors() {
		playerOne.setMovement(movements.getPaper());
		playerTwo.setMovement(movements.getScissors());
		
		winner = delegate.playRockPaperScissors(playerOne, playerTwo);
		Assert.assertTrue(winner.equals(playerTwo.getName()));
	}
	
	/**
	 * round from created players
	 */
	@Test
	public void playGameScissorsVsPaper() {
		playerOne.setMovement(movements.getScissors());
		playerTwo.setMovement(movements.getPaper());
		
		winner = delegate.playRockPaperScissors(playerOne, playerTwo);
		Assert.assertTrue(winner.equals(playerOne.getName()));
	}
	
	/**
	 * round from created players
	 */
	@Test
	public void playGamePaperVsPaper() {
		playerOne.setMovement(movements.getPaper());
		playerTwo.setMovement(movements.getPaper());
		
		winner = delegate.playRockPaperScissors(playerOne, playerTwo);
		Assert.assertTrue(winner.equals(tie));
	}
	
	/**
	 * round from created players
	 */
	@Test
	public void playGameScissorsVsScissors() {
		playerOne.setMovement(movements.getScissors());
		playerTwo.setMovement(movements.getScissors());
		
		winner = delegate.playRockPaperScissors(playerOne, playerTwo);
		Assert.assertTrue(winner.equals(tie));
	}
	
	/**
	 * round from created players
	 */
	@Test
	public void playGameRockVsRock() {
		playerOne.setMovement(movements.getRock());
		playerTwo.setMovement(movements.getRock());
		
		winner = delegate.playRockPaperScissors(playerOne, playerTwo);
		Assert.assertTrue(winner.equals(tie));
	}
	
	/**
	 * create paper movement
	 */
	@Test
	public void getMovementFromStringPaper() {
		Movement m;
		m = delegate.getMovementFromString(paper);
		Assert.assertEquals(movements.getPaper().getName(), m.getName());
		Assert.assertEquals(movements.getPaper().getValue(), m.getValue());
	}
	
	/**
	 * create rock movement
	 */
	@Test
	public void getMovementFromStringRock() {
		Movement m;
		m = delegate.getMovementFromString(rock);
		Assert.assertEquals(movements.getRock().getName(), m.getName());
		Assert.assertEquals(movements.getRock().getValue(), m.getValue());
	}
	
	/**
	 * create scissors movement
	 */
	@Test
	public void getMovementFromStringScissors() {
		Movement m;
		m = delegate.getMovementFromString(scissors);
		Assert.assertEquals(movements.getScissors().getName(), m.getName());
		Assert.assertEquals(movements.getScissors().getValue(), m.getValue());
	}
	
	/**
	 * get movement error as the received does not exists
	 */
	@Test
	public void getMovementFromStringError() throws Exception {
		
		expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Movement name is not correct");
		
	    delegate.getMovementFromString("");

	}
	
	/**
	 * create player with random who will use rock
	 */
	@Test
	public void createPlayerWithRock(){
		Player p = delegate.createPlayerFromRequest(playerOne.getName(),rock);
		Assert.assertTrue(p.getMovement().getName().equals(rock));
		Assert.assertEquals(p.getMovement().getValue(),zero);
		Assert.assertEquals(p.getName(),playerOne.getName());
	}
	
	/**
	 * create player with random who will use Paper
	 */
	@Test
	public void createPlayerWithPaper(){
		Player p = delegate.createPlayerFromRequest(playerOne.getName(),paper);
		Assert.assertTrue(p.getMovement().getName().equals(paper));
		Assert.assertEquals(p.getMovement().getValue(),one);
		Assert.assertEquals(p.getName(),playerOne.getName());
	}
	
	/**
	 * create player with random who will use scissors
	 */
	@Test
	public void createPlayerWithScissors(){
		Player p = delegate.createPlayerFromRequest(playerOne.getName(),scissors);
		Assert.assertTrue(p.getMovement().getName().equals(scissors));
		Assert.assertEquals(p.getMovement().getValue(),two);
		Assert.assertEquals(p.getName(),playerOne.getName());
	}
	
	/**
	 * create player with random movement using emptty
	 */
	@Test
	public void createPlayerWithRandom(){
		Player p = delegate.createPlayerFromRequest(playerOne.getName(),empty);
		Assert.assertNotNull(p.getMovement().getName());
		Assert.assertNotNull(p.getMovement().getValue());
		Assert.assertNotNull(p.getName());
	}
	
	/**
	 * create player with random movement using null
	 */
	@Test
	public void createPlayerWithNull(){
		Player p = delegate.createPlayerFromRequest(playerOne.getName(),null);
		Assert.assertNotNull(p.getMovement().getName());
		Assert.assertNotNull(p.getMovement().getValue());
		Assert.assertNotNull(p.getName());
	}
	
	/**
	 * check if string is a movement
	 */
	@Test
	public void rockIsMovement(){
		Assert.assertTrue(delegate.isMovementFromString(rock));
	}
	
	/**
	 * check if string is a movement
	 */
	@Test
	public void paperIsMovement(){
		Assert.assertTrue(delegate.isMovementFromString(paper));
	}
	
	/**
	 * check if string is a movement
	 */
	@Test
	public void scissorsIsMovement(){
		Assert.assertTrue(delegate.isMovementFromString(scissors));
	}
	
	/**
	 * check if string is a movement
	 */
	@Test
	public void nullIsNotMovement(){
		Assert.assertFalse(delegate.isMovementFromString(null));
	}
	
	/**
	 * get movement from valid value
	 */
	@Test
	public void getMovementFromZero(){
		Movement m = delegate.getMovementFromNumber(zero);
		Assert.assertTrue(m.getName().equals(rock));
		Assert.assertEquals(m.getValue(),zero);
	}
	
	/**
	 * get movement from valid value
	 */
	@Test
	public void getMovementFromOne(){
		Movement m = delegate.getMovementFromNumber(one);
		Assert.assertTrue(m.getName().equals(paper));
		Assert.assertEquals(m.getValue(),one);
	}
	
	/**
	 * get movement from valid value
	 */
	@Test
	public void getMovementFromTwo(){
		Movement m = delegate.getMovementFromNumber(two);
		Assert.assertTrue(m.getName().equals(scissors));
		Assert.assertEquals(m.getValue(),two);
	}
	
	/**
	 * get movement error
	 */
	@Test
	public void getMovementFromMoreThanTwo(){
		expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Movement value is not correct");
		
		delegate.getMovementFromNumber(5);
	}

	
	/**
	 * Test covering all the posibles values for a full play
	 */
	@Test
	public void fullRoundRockVsPaper() {
		request.setMovementPO(rock);
		request.setMovementPT(paper);
		response = delegate.initAndPlay(request);
		Assert.assertEquals(response.getWinner(),request.getPlayerTwo());
	}
	
	/**
	 * round case
	 */
	@Test
	public void fullRoundRockVsScissors() {
		request.setMovementPO(rock);
		request.setMovementPT(scissors);
		response = delegate.initAndPlay(request);
		Assert.assertEquals(response.getWinner(),request.getPlayerOne());
	}
	
	/**
	 * round case
	 */
	@Test
	public void fullRoundRockVsRock() {
		request.setMovementPO(rock);
		request.setMovementPT(rock);
		response = delegate.initAndPlay(request);
		Assert.assertEquals(response.getWinner(),tie);
	}
	
	/**
	 * round case
	 */
	@Test
	public void fullRoundPaperVsRock() {
		request.setMovementPO(paper);
		request.setMovementPT(rock);
		response = delegate.initAndPlay(request);
		Assert.assertEquals(response.getWinner(),request.getPlayerOne());
	}
	
	/**
	 * round case
	 */
	@Test
	public void fullRoundPaperVsScissors() {
		request.setMovementPO(paper);
		request.setMovementPT(scissors);
		response = delegate.initAndPlay(request);
		Assert.assertEquals(response.getWinner(),request.getPlayerTwo());
	}
	
	/**
	 * round case
	 */
	@Test
	public void fullRoundPaperVsPaper() {
		request.setMovementPO(paper);
		request.setMovementPT(paper);
		response = delegate.initAndPlay(request);
		Assert.assertEquals(response.getWinner(),tie);
	}
	
	/**
	 * round case
	 */
	@Test
	public void fullRoundScissorsVsRock() {
		request.setMovementPO(scissors);
		request.setMovementPT(rock);
		response = delegate.initAndPlay(request);
		Assert.assertEquals(response.getWinner(),request.getPlayerTwo());
	}
	
	/**
	 * round case
	 */
	@Test
	public void fullRoundScissorsVsPaper() {
		request.setMovementPO(scissors);
		request.setMovementPT(paper);
		response = delegate.initAndPlay(request);
		Assert.assertEquals(response.getWinner(),request.getPlayerOne());
	}
	
	/**
	 * Full round with all the random movements
	 */
	@Test
	public void fullRoundScissorsVsScissors() {
		request.setMovementPO(scissors);
		request.setMovementPT(scissors);
		response = delegate.initAndPlay(request);
		Assert.assertEquals(response.getWinner(),tie);
	}
	
	/**
	 * Full round with all the random movements with null values
	 */
	@Test
	public void fullRoundNullVsNull() {
		request.setMovementPO(null);
		request.setMovementPT(null);
		response = delegate.initAndPlay(request);
		Assert.assertNotNull(response.getWinner());
	}
	
	/**
	 * Full round with all the random movements with empty
	 */
	@Test
	public void fullRoundEmptyVsEmpty() {
		request.setMovementPO(empty);
		request.setMovementPT(empty);
		response = delegate.initAndPlay(request);
		Assert.assertNotNull(response.getWinner());
	}
	
	/**
	 * Testing with a movement name not valid
	 */
	@Test
	public void fullRoundWithNotValidValue() {
		expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Movement name is not correct");
		
		request.setMovementPO("aaa");
		request.setMovementPT(empty);
		response = delegate.initAndPlay(request);
		Assert.assertNotNull(response.getWinner());
	}
	
	/**
	 * Testing with a movement name not valid
	 */
	@Test
	public void fullRoundWithNotValidValueAgain() {
		expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Movement name is not correct");
		
		request.setMovementPO(empty);
		request.setMovementPT("aaa");
		response = delegate.initAndPlay(request);
		Assert.assertNotNull(response.getWinner());
	}
	
	/**
	 * Testing with not valid request
	 */
	@Test
	public void testNotValidRequest() {
		expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("playerOne and playerTwo are mandatory and different fields");
		
        request.setPlayerOne(null);
		request.setMovementPO("aaa");
		request.setMovementPT(empty);
		response = delegate.initAndPlay(request);
	}
	
	/**
	 * Testing with not valid request
	 */
	@Test
	public void testNotValidRequestSecond() {
		expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("playerOne and playerTwo are mandatory and different fields");
		
        request.setPlayerTwo(null);
		request.setMovementPO("aaa");
		request.setMovementPT(empty);
		response = delegate.initAndPlay(request);
	}
	
	/**
	 * Testing with not valid request
	 */
	@Test
	public void testNotValidRequestThird() {
		expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("playerOne and playerTwo are mandatory and different fields");
		
        request.setPlayerTwo(empty);
		request.setMovementPO("aaa");
		request.setMovementPT(empty);
		response = delegate.initAndPlay(request);
	}
	
	/**
	 * Testing with not valid request
	 */
	@Test
	public void testNotValidRequestFourth() {
		expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("playerOne and playerTwo are mandatory and different fields");
		
        request.setPlayerOne("Player");
        request.setPlayerTwo("Player");
		request.setMovementPO("aaa");
		request.setMovementPT(empty);
		response = delegate.initAndPlay(request);
	}
	
}
