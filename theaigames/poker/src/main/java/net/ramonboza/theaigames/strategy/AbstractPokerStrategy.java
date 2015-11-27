package net.ramonboza.theaigames.strategy;

import net.ramonboza.theaigames.bot.BotState;
import net.ramonboza.theaigames.com.stevebrecher.HandEval;
import net.ramonboza.theaigames.poker.Card;
import net.ramonboza.theaigames.poker.HandHoldem;
import net.ramonboza.theaigames.poker.PokerMove;

public abstract class AbstractPokerStrategy implements PokerStrategy {

	@Override
	public abstract PokerMove strategy(BotState botState);
	
	/**
	 * Calculates the bot's hand strength, with 0, 3, 4 or 5 cards on the table.
	 * This uses the com.stevebrecher package to get hand strength.
	 * @param hand : cards in hand
	 * @param table : cards on table
	 * @return HandCategory with what the bot has got, given the table and hand
	 */
	protected HandEval.HandCategory getHandCategory(HandHoldem hand, Card[] table) {
		if( table == null || table.length == 0 ) { // there are no cards on the table
			return hand.getCard(0).getHeight() == hand.getCard(1).getHeight() // return a pair if our hand cards are the same
					? HandEval.HandCategory.PAIR
					: HandEval.HandCategory.NO_PAIR;
		}
		long handCode = hand.getCard(0).getNumber() + hand.getCard(1).getNumber();
		
		for( Card card : table ) { handCode += card.getNumber(); }
		
		if( table.length == 3 ) { // three cards on the table
			return rankToCategory(HandEval.hand5Eval(handCode));
		}
		if( table.length == 4 ) { // four cards on the table
			return rankToCategory(HandEval.hand6Eval(handCode));
		}
		return rankToCategory(HandEval.hand7Eval(handCode)); // five cards on the table
	}
	
	/**
	 * small method to convert the int 'rank' to a readable enum called HandCategory
	 */
	protected HandEval.HandCategory rankToCategory(int rank) {
		return HandEval.HandCategory.values()[rank >> HandEval.VALUE_SHIFT];
	}

}
