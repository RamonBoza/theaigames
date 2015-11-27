package net.ramonboza.theaigames.strategy;

import net.ramonboza.theaigames.bot.BotState;
import net.ramonboza.theaigames.com.stevebrecher.HandEval.HandCategory;
import net.ramonboza.theaigames.constants.GameConstants;
import net.ramonboza.theaigames.poker.PokerMove;

public class TurnPokerStrategy extends AbstractPokerStrategy {

	@Override
	public PokerMove strategy(BotState state) {
		
		HandCategory handCategory = getHandCategory(state.getHand(), state.getTable());
		
		if(handCategory.ordinal() > HandCategory.THREE_OF_A_KIND.ordinal()){
			return new PokerMove(state.getMyName(), GameConstants.RAISE, 3 * state.getBigBlind());
		}
		
		if(handCategory.equals(HandCategory.NO_PAIR)){
			return new PokerMove(state.getMyName(), GameConstants.CHECK, 0);
		}
		
		return new PokerMove(state.getMyName(), GameConstants.CALL, state.getAmountToCall());
	}

}
