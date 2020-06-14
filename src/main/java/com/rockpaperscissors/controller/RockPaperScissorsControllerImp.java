package com.rockpaperscissors.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rockpaperscissors.delegate.RockPaperScissorsDelegateImpl;
import com.rockpaperscissors.delegate.StatisticsDelegateImpl;
import com.rockpaperscissors.domain.RPSRequest;
import com.rockpaperscissors.domain.RPSResponse;
import com.rockpaperscissors.domain.StatsResponse;

@RestController
public class RockPaperScissorsControllerImp implements RockPaperScissorsController {
	
	@Autowired
	RockPaperScissorsDelegateImpl rockPaperScissorsDelegateImpl;
	
	@Autowired
	StatisticsDelegateImpl statisticsDelegate;

	@RequestMapping(value = "/play", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON })
    public RPSResponse playRPS(@RequestBody RPSRequest request) {

		return rockPaperScissorsDelegateImpl.initAndPlay(request);
		
    }

	@RequestMapping(value = "/getStats", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public StatsResponse getStats() throws Exception {
		
		return statisticsDelegate.getStats();
	}
	
}
