package net.ramonboza.theaigames.fourinarow.strategy.model;

import java.util.ArrayList;
import java.util.List;

public class PossibleMovement {
	private int column;
	private List<MovementScore> score;
	
	PossibleMovement(int column) {
		this.column = column;
		score = new ArrayList<MovementScore>();
	}
	
	public void setMovementScore(MovementScore movementScore){
		score.add(movementScore);
	}
	
	public int getColumn() {
		return column;
	}
	
	public List<MovementScore> getScore() {
		return score;
	}

}
