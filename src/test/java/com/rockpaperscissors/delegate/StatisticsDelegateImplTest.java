package com.rockpaperscissors.delegate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.rockpaperscissors.domain.FullStatistics;
import com.rockpaperscissors.domain.StatsResponse;


@RunWith(SpringRunner.class)
@WebMvcTest(StatisticsDelegateImpl.class)
public class StatisticsDelegateImplTest {
	
	@Rule
    public ExpectedException expectedException = ExpectedException.none();
	StatisticsDelegateImpl stats;
	int zero = 0;
	int one = 1;
	int two = 2;
	int three = 3;
	StatsResponse response;
	@Before
	public void setUp() {
		stats = new StatisticsDelegateImpl();
		FullStatistics.setPlayerOneWon(one);
		FullStatistics.setPlayerTwoWon(two);
		FullStatistics.setTotal(three);
		FullStatistics.setTie(zero);
	}
	
	@Test
	public void checkCorrectStats() throws Exception {
		
		response = stats.getStats();
		
		Assert.assertEquals(FullStatistics.getPlayerOneWon(), response.getPlayerOneWon());
		Assert.assertEquals(FullStatistics.getPlayerTwoWon(), response.getPlayerTwoWon());
		Assert.assertEquals(FullStatistics.getTotal(), response.getTotal());
		Assert.assertEquals(FullStatistics.getTie(), response.getDraws());
	}
	
	@Test
	public void checkCorrectStatsWithVadStoredDetails() throws Exception {
		FullStatistics.setPlayerOneWon(one);
		FullStatistics.setPlayerTwoWon(two);
		FullStatistics.setTotal(three);
		FullStatistics.setTie(one);
		
		expectedException.expect(Exception.class);
        expectedException.expectMessage("Rounds are not consistent");
		response = stats.getStats();
		

	}
}
