package net.ramonboza.theaigames.fourinarow.decision;

import java.util.ArrayList;
import java.util.List;

import net.ramonboza.theaigames.fourinarow.strategy.model.MovementScore;
import net.ramonboza.theaigames.fourinarow.strategy.model.PossibleMovement;

public class BasicMovementDecisioner implements MovementDecisioner{

	public int decideMovement(List<PossibleMovement> possibleMovements){
		
		List<PossibleMovement> movements = new ArrayList<PossibleMovement>(possibleMovements);
		
		PossibleMovement fourInRowMovement = getFourInRowMovement(movements);
		if(fourInRowMovement != null)
			return fourInRowMovement.getColumn();

		removeEnemyWillFourInARow(movements);
		
		
		PossibleMovement anyMovement = getAnyMovement(movements);
		return anyMovement.getColumn();
	}

	private PossibleMovement getAnyMovement(List<PossibleMovement> movements) {
		return movements.get(0);
	}

	private PossibleMovement getFourInRowMovement(List<PossibleMovement> movements) {
		for(PossibleMovement movement : movements){
			if(movement.getScore().contains(MovementScore.FOUR_IN_ROW)){
				return movement;
			}
		}
		return null;
				
	}

	private void removeEnemyWillFourInARow(List<PossibleMovement> movements) {
		for(PossibleMovement movement : movements){
			if(movement.getScore().contains(MovementScore.ENEMY_WILL_FOUR_IN_ROW)){
				movements.remove(movement);
			}
		}
	}
}
