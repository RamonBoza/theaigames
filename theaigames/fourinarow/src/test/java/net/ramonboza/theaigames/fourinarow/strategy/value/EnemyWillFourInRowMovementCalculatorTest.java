package net.ramonboza.theaigames.fourinarow.strategy.value;


import org.junit.Assert;
import org.junit.Test;

import net.ramonboza.theaigames.fourinarow.Field;
import net.ramonboza.theaigames.fourinarow.providers.TestFieldFactory;

public class EnemyWillFourInRowMovementCalculatorTest {

	@Test
	public void enemyCannotFourInRowWithSimpleField() throws Exception {
		Field field = TestFieldFactory.createSimpleField();

		EnemyWillFourInRowMovementCalculator movementCalculator = new EnemyWillFourInRowMovementCalculator();
		Assert.assertFalse(movementCalculator.visits(0, field));
	}

	@Test
	public void enemyCanFourInARowWithSimpleField() throws Exception {
		Field field = TestFieldFactory.createEnemyInTheMiddleField();

		EnemyWillFourInRowMovementCalculator movementCalculator = new EnemyWillFourInRowMovementCalculator();
		Assert.assertTrue(movementCalculator.visits(0, field));
	}
	
	@Test
	public void enemyCannotFourInARowIfIFillTheGap() throws Exception {
		Field field = TestFieldFactory.createEnemyInTheMiddleField();

		EnemyWillFourInRowMovementCalculator movementCalculator = new EnemyWillFourInRowMovementCalculator();
		Assert.assertFalse(movementCalculator.visits(3, field));
	}
	
	@Test
	public void enemyWillFourIfIAddAtThree() throws Exception {
		Field field = TestFieldFactory.createEnemyWillFourIfIAddAtThree();
		EnemyWillFourInRowMovementCalculator movementCalculator = new EnemyWillFourInRowMovementCalculator();
		Assert.assertFalse(movementCalculator.visits(2, field));
		Assert.assertTrue(movementCalculator.visits(3, field));
	}
}
