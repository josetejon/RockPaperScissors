package com.rockpaperscissors.controller;

import com.rockpaperscissors.domain.RPSRequest;
import com.rockpaperscissors.domain.RPSResponse;
import com.rockpaperscissors.domain.StatsResponse;

public interface RockPaperScissorsController {
	
	public RPSResponse playRPS(RPSRequest request);
	public StatsResponse getStats() throws Exception;
	
}
