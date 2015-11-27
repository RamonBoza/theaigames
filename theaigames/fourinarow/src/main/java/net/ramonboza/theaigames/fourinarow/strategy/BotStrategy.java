package net.ramonboza.theaigames.fourinarow.strategy;

import net.ramonboza.theaigames.fourinarow.Field;

public interface BotStrategy<T> {
	
	T strategy(final Field field);

}
