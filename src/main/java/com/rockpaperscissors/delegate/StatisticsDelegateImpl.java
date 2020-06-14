package com.rockpaperscissors.delegate;

import org.springframework.stereotype.Service;

import com.rockpaperscissors.domain.FullStatistics;
import com.rockpaperscissors.domain.StatsResponse;

@Service
public class StatisticsDelegateImpl {

	public StatsResponse getStats() throws Exception {
		if(dataIsFine()) {
		return new StatsResponse(FullStatistics.getPlayerOneWon(),
				FullStatistics.getPlayerTwoWon(),
				FullStatistics.getTie(),
				FullStatistics.getTotal());
		}else {
			throw new Exception("Rounds are not consistent");
		}
		
	}
	
	public boolean dataIsFine() {
		return (FullStatistics.getTotal() == (FullStatistics.getPlayerOneWon() +FullStatistics.getPlayerTwoWon() + FullStatistics.getTie()));
	}
}
