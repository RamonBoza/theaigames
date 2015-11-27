package net.ramonboza.theaigames.strategy;

import net.ramonboza.theaigames.bot.BotState;
import net.ramonboza.theaigames.poker.PokerMove;

public interface PokerStrategy {

	PokerMove strategy(BotState botState);
}
