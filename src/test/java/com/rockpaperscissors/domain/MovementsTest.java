package com.rockpaperscissors.domain;

import org.junit.Assert;
import org.junit.Test;

import com.rockpaperscissors.domain.Movements;

public class MovementsTest {
  
	@Test
	public void createMovements() {
		Movements m = new Movements();
		
        Assert.assertEquals("rock", m.getRock().getName());
        Assert.assertEquals("paper", m.getPaper().getName());
        Assert.assertEquals("scissors", m.getScissors().getName());
        
        Assert.assertEquals(0, m.getRock().getValue());
        Assert.assertEquals(1, m.getPaper().getValue());
        Assert.assertEquals(2, m.getScissors().getValue());
		
	} 
}
