package com.rockpaperscissors.controller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

@RunWith(SpringRunner.class)
@WebMvcTest(RockPaperScissorsControllerImp.class)
public class RockPaperScissorsControllerImpTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    /**
     * testing the stats
     * @throws Exception
     */
    @Test
    public void testStats() throws Exception {
    	
    	mockMvc.perform( MockMvcRequestBuilders
    		      .get("/getStats")
    		      .accept(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk());
    }
    
    /**
     * get to a wrong endpoint
     * @throws Exception
     */
    @Test
    public void testStatsWihError() throws Exception {
    	
    	mockMvc.perform( MockMvcRequestBuilders
    		      .get("/getStattis")
    		      .accept(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isNotFound());
    }
    
    /**
     * Will return an exception, doing a post from postman, a 500 error
     * @throws Exception
     */
    @Test
    public void playWithNotValidRequest() throws Exception  {
        expectedException.expectMessage("playerOne and playerTwo are mandatory and different fields");
        
    	String body = "{\"playOne\":\"Player1\",\"plaTwo\":\"Player2\",\"movementPO\":\"\",\"movementPT\":\"\"}";
             mockMvc.perform(post("/play")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body))
            .andExpect(status().is5xxServerError());
 
    }
    
    /**
     * play a round
     * @throws Exception
     */
    @Test
    public void playPaperVsRock() throws Exception  {
        
    	String body = "{\"playerOne\":\"Player1\",\"playerTwo\":\"Player2\",\"movementPO\":\"Paper\",\"movementPT\":\"Rock\"}";
             mockMvc.perform(post("/play")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body))
            .andExpect(status().is2xxSuccessful());
 
    }
    
    /**
     * play a round
     * @throws Exception
     */
    @Test
    public void playPaperVsScissors() throws Exception  {
        
    	String body = "{\"playerOne\":\"Player1\",\"playerTwo\":\"Player2\",\"movementPO\":\"Paper\",\"movementPT\":\"scissors\"}";
             mockMvc.perform(post("/play")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body))
            .andExpect(status().is2xxSuccessful());
 
    }
    
    /**
     * play a round
     * @throws Exception
     */
    @Test
    public void playScissorsVsRock() throws Exception  {
        
    	String body = "{\"playerOne\":\"Player1\",\"playerTwo\":\"Player2\",\"movementPO\":\"scissors\",\"movementPT\":\"Rock\"}";
             mockMvc.perform(post("/play")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body))
            .andExpect(status().is2xxSuccessful());
 
    }
    
    /**
     * play a round
     * @throws Exception
     */
    @Test
    public void playRandoVsRandom() throws Exception  {
        
    	String body = "{\"playerOne\":\"Player1\",\"playerTwo\":\"Player2\",\"movementPO\":\"\",\"movementPT\":\"\"}";
             mockMvc.perform(post("/play")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body))
            .andExpect(status().is2xxSuccessful());
 
    }
    
    /**
     * play a round with same name players
     * @throws Exception
     */
    @Test
    public void playSameNamePlayers() throws Exception  {
        expectedException.expectMessage("playerOne and playerTwo are mandatory and different fields");
    	String body = "{\"playerOne\":\"Player\",\"playerTwo\":\"Player\",\"movementPO\":\"\",\"movementPT\":\"\"}";
             mockMvc.perform(post("/play")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body))
            .andExpect(status().is2xxSuccessful());
 
    }
    
    
}
