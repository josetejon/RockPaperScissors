package com.rockpaperscissors.domain;

/**
 * Every Movement will have assigned a number, those numbers will be used on an algorithm to get the winner  
 */
public class Movements {

  Movement rock, paper, scissors;

  public Movements() {
	  rock = new Movement("rock", 0);
	  paper = new Movement("paper", 1);
	  scissors = new Movement("scissors", 2);
  }

  public Movement getRock() {
	return rock;
  }

  public void setRock(Movement rock) {
	this.rock = rock;
  }

  public Movement getPaper() {
	return paper;
  }

  public void setPaper(Movement paper) {
	this.paper = paper;
  }

  public Movement getScissors() {
	return scissors;
  }

  public void setScissors(Movement scissors) {
	this.scissors = scissors;
  }

  
}
