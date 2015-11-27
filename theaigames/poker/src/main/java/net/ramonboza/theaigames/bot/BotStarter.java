/**
 * www.TheAIGames.com 
 * Heads Up Omaha pokerbot
 *
 * Last update: May 07, 2014
 *
 * @author Jim van Eeden, Starapple
 * @version 1.0
 * @License MIT License (http://opensource.org/Licenses/MIT)
 */


package net.ramonboza.theaigames.bot;

import net.ramonboza.theaigames.poker.PokerMove;
import net.ramonboza.theaigames.strategy.PokerStrategy;
import net.ramonboza.theaigames.strategy.PokerStrategyExecutor;

/**
 * This class is the brains of your bot. Make your calculations here and return the best move with GetMove
 */
public class BotStarter implements Bot { 

	private PokerStrategy strategy = new PokerStrategyExecutor();
	
	/**
	 * Implement this method to return the best move you can. Currently it will return a raise the ordinal value
	 * of one of our cards is higher than 9, a call when one of the cards has a higher ordinal value than 5 and
	 * a check otherwise.
	 * @param state : The current state of your bot, with all the (parsed) information given by the engine
	 * @param timeOut : The time you have to return a move
	 * @return PokerMove : The move you will be doing
	 */
	@Override
	public PokerMove getMove(BotState state, Long timeOut) {
		return strategy.strategy(state); 
		
	}
	
	

}
