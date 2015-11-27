package net.ramonboza.theaigames.fourinarow.strategy.value;

import net.ramonboza.theaigames.fourinarow.Field;

public interface MovementValueCalculator {
	
	boolean visits(int column,Field field);

}
