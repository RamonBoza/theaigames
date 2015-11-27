package net.ramonboza.theaigames.strategy;

import java.util.HashMap;
import java.util.Map;

import net.ramonboza.theaigames.bot.BotState;
import net.ramonboza.theaigames.poker.PokerMove;

public class PokerStrategyExecutor  implements PokerStrategy{
	
	Map<Integer,PokerStrategy> strategies = new HashMap<Integer,PokerStrategy>();
	
	public  PokerStrategyExecutor() {
		strategies.put(0, new PreFlopPokerStrategy());
		strategies.put(3, new FlopPokerStrategy());
		strategies.put(4, new TurnPokerStrategy());
		strategies.put(5, new RiverPokerStrategy());
	}

	@Override
	public PokerMove strategy(BotState botState) {
		return strategies.get(botState.getTable().length).strategy(botState);
	}
	
}
