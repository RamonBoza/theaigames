package net.ramonboza.theaigames.fourinarow.strategy.model;

import net.ramonboza.theaigames.fourinarow.Field;
import net.ramonboza.theaigames.fourinarow.constants.FieldValues;
import net.ramonboza.theaigames.fourinarow.strategy.value.EnemyWillFourInRowMovementCalculator;
import net.ramonboza.theaigames.fourinarow.strategy.value.FourInARowMovementCalculator;
import net.ramonboza.theaigames.fourinarow.strategy.value.MovementValueCalculator;

public class PossibleMovementFactory {
	
	private static MovementValueCalculator fourInARowMovementCalculator = new FourInARowMovementCalculator(FieldValues.PLAYER_VALUE);
	
	private static MovementValueCalculator enemyWillFourInRowMovementCalculator = new EnemyWillFourInRowMovementCalculator();
	
	public static PossibleMovement calculateMovement(int column, Field field){
		PossibleMovement possibleMovement = new PossibleMovement(column);
		
		if(fourInARowMovementCalculator.visits(column, field))
			possibleMovement.setMovementScore(MovementScore.FOUR_IN_ROW);
		
		if(enemyWillFourInRowMovementCalculator.visits(column, field))
			possibleMovement.setMovementScore(MovementScore.ENEMY_WILL_FOUR_IN_ROW);
		
		
		if(possibleMovement.getScore().isEmpty()){
			possibleMovement.setMovementScore(MovementScore.OK);
		}
		
		return possibleMovement;
	}
}
