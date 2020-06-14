package com.rockpaperscissors.domain;

/**
 * Define one movement, with its name and its value, the value will be used in an algorithm to get the winner
 * @author jose
 *
 */
public class Movement {
	
	private String name;
	private int value;
	
	public Movement(String name, int value){
		this.setName(name);
		this.setValue(value);
	}
	
	public Movement(Movement movement){
		this.name = movement.getName();
		this.value = movement.getValue();
	}
	
	public Movement() {
		super();
	}

	public int getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
