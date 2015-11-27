package net.ramonboza.theaigames.fourinarow.strategy.value;



import org.junit.Assert;
import org.junit.Test;

import net.ramonboza.theaigames.fourinarow.Field;
import net.ramonboza.theaigames.fourinarow.constants.FieldValues;
import net.ramonboza.theaigames.fourinarow.providers.TestFieldFactory;

public class FourInARowMovementCalculatorTest {

	@Test
	public void thereIsNoFourInARowInASimpleMap() throws Exception {
		Field field = TestFieldFactory.createSimpleField();

		FourInARowMovementCalculator movementCalculator = new FourInARowMovementCalculator(FieldValues.PLAYER_VALUE);
		Assert.assertFalse("There is no four in a row for player", movementCalculator.visits(0, field));
	}

	@Test
	public void thereIsNoFourInARowInAnEnemyFourInARowMap() throws Exception {
		Field field = TestFieldFactory.createSimpleEnemyField();

		FourInARowMovementCalculator movementCalculator = new FourInARowMovementCalculator(FieldValues.PLAYER_VALUE);
		Assert.assertFalse("There is no four in a row for player", movementCalculator.visits(3, field));
	}
	
	@Test
	public void thereIsFourInARowAsAnEnemy() throws Exception {
		Field field = TestFieldFactory.createSimpleEnemyField();

		FourInARowMovementCalculator movementCalculator = new FourInARowMovementCalculator(FieldValues.ENEMY_VALUE);
		Assert.assertTrue("There is no four in a row for player", movementCalculator.visits(3, field));
	}
	
	@Test
	public void thereIsFourInARowInTheMiddle() throws Exception {
		Field field = TestFieldFactory.createInTheMiddleField();

		FourInARowMovementCalculator movementCalculator = new FourInARowMovementCalculator(FieldValues.PLAYER_VALUE);
		Assert.assertTrue("There is no four in a row for player", movementCalculator.visits(3, field));
	}
	
	@Test
	public void thereIsFourInARowInUpAngle() throws Exception {
		Field field = TestFieldFactory.createInTheMiddleUpAngleField();

		FourInARowMovementCalculator movementCalculator = new FourInARowMovementCalculator(FieldValues.ENEMY_VALUE);
		Assert.assertTrue("There is no four in a row for player", movementCalculator.visits(2, field));
	}
}
