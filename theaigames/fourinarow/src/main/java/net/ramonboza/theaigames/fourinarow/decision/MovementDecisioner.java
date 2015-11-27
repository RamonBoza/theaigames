package net.ramonboza.theaigames.fourinarow.decision;

import java.util.List;

import net.ramonboza.theaigames.fourinarow.strategy.model.PossibleMovement;

public interface MovementDecisioner {
	int decideMovement(List<PossibleMovement> possibleMovements);
}
