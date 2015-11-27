package net.ramonboza.theaigames.fourinarow.strategy.value;

import net.ramonboza.theaigames.fourinarow.Field;
import net.ramonboza.theaigames.fourinarow.constants.FieldValues;

public class EnemyWillFourInRowMovementCalculator implements MovementValueCalculator {

	MovementValueCalculator enemyFourInRowMovementCalculator = new FourInARowMovementCalculator(
			FieldValues.ENEMY_VALUE);

	public boolean visits(int column, Field field) {
		return isEnemyFourInRowAfterThis(column, field);
	}

	private boolean isEnemyFourInRowAfterThis(int column, Field field) {

		Field auxiliarField = new Field(field.getNrColumns(), field.getNrRows());
		auxiliarField.parseFromString(field.toString());
		auxiliarField.addDisc(column, FieldValues.PLAYER_VALUE.getValue());

		int[] enemyPossibleMovements = new int[field.getNrColumns()];

		for (int nColumn = 0; nColumn < enemyPossibleMovements.length; nColumn++) {
			if (!auxiliarField.isColumnFull(nColumn)) {
				if (enemyFourInRowMovementCalculator.visits(nColumn, auxiliarField)) {
					return true;
				}
			}
		}

		return false;

	}

}
