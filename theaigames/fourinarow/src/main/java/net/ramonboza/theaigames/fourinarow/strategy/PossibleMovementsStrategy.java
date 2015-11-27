package net.ramonboza.theaigames.fourinarow.strategy;

import java.util.ArrayList;
import java.util.List;

import net.ramonboza.theaigames.fourinarow.Field;
import net.ramonboza.theaigames.fourinarow.strategy.model.PossibleMovement;
import net.ramonboza.theaigames.fourinarow.strategy.model.PossibleMovementFactory;

public class PossibleMovementsStrategy implements BotStrategy<List<PossibleMovement>> {
	
	
	public List<PossibleMovement> strategy(Field field) {
		return getPossibleMovements(field);
	}
	
	private List<PossibleMovement> getPossibleMovements(final Field field){
		
		List<PossibleMovement> possibleMovements = new ArrayList<PossibleMovement>();
		
		int numOfColumns = field.getNrColumns();
		for( int column = 0; column < numOfColumns; column++){
			PossibleMovement movement = calculateMovementForColumn(field,column);
			if(movement != null){
				possibleMovements.add(movement);
			}
		}
		
		return possibleMovements;
	}

	private PossibleMovement calculateMovementForColumn(Field field, int column) {
		PossibleMovement movement = null;
		
		if(field.isValidMove(column)){
			movement = PossibleMovementFactory.calculateMovement(column, field);
		}
		
		return movement;
	}

}
