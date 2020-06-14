package com.rockpaperscissors.domain;

/**
 * Class to have a player, with the name and the movement
 * @author jose
 *
 */
public class Player {
	private String name;
	private Movement movement;

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player(String name) {
		super();
		this.name = name;
	}
	
	public Player() {
		super();
	}

	public boolean equals(Player player) {
	
		if(!player.equals(null)) {
			return player.getName().equalsIgnoreCase(this.getName());
		}
		return false;
	}
	
}