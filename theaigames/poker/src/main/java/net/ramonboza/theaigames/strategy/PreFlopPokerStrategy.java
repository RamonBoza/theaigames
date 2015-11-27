package net.ramonboza.theaigames.strategy;

import net.ramonboza.theaigames.bot.BotState;
import net.ramonboza.theaigames.constants.GameConstants;
import net.ramonboza.theaigames.poker.HandHoldem;
import net.ramonboza.theaigames.poker.PokerMove;

public class PreFlopPokerStrategy extends AbstractPokerStrategy {

	@Override
	public PokerMove strategy(BotState state) {
		HandHoldem hand = state.getHand();
		String handCategory = getHandCategory(hand, state.getTable()).toString();
		System.err.printf("my hand is %s, opponent action is %s, pot: %d\n", handCategory, state.getOpponentAction(), state.getPot());
		
		// Get the ordinal values of the cards in your hand
		int height1 = hand.getCard(0).getHeight().ordinal();
		int height2 = hand.getCard(1).getHeight().ordinal();
		
		// Return the appropriate move according to our amazing strategy
		if( height1 >= 12 && height2 != 12) {
			return new PokerMove(state.getMyName(), GameConstants.RAISE, 3 * state.getBigBlind());
		}
		else if( height1 > 10 && height2 > 10 ) {
			return new PokerMove(state.getMyName(), GameConstants.RAISE, state.getBigBlind());
		} else if( Math.abs(height1 - height2) == 1 ) {
			return new PokerMove(state.getMyName(), GameConstants.CALL, state.getAmountToCall());
		} else {
			return new PokerMove(state.getMyName(), GameConstants.CHECK, 0);
		}
	}

}
