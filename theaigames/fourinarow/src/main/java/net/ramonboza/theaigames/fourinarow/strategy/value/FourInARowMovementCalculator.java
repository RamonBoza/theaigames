package net.ramonboza.theaigames.fourinarow.strategy.value;

import net.ramonboza.theaigames.fourinarow.Field;
import net.ramonboza.theaigames.fourinarow.constants.FieldValues;

public class FourInARowMovementCalculator implements MovementValueCalculator {
	
	private int fieldValue;

	public FourInARowMovementCalculator(FieldValues fieldValue){
		this.fieldValue = fieldValue.getValue();
	}

	public boolean visits(int column, Field field) {

		
		if(checkHorizontal(column,field))
			return true;
		
		if(checkVertical(column,field))
			return true;
		
		if(checkUpAngle(column,field))
			return true;
		
		if(checkDownAngle(column, field))
			return true;
		
		
		return false;
	}

	

	private boolean checkHorizontal(int column, Field field) {
		int row = field.getRowForColumn(column);
		
		int count = 1;
		
		//check left
		int intColumn = column - 1;
		while(intColumn >= 0 && intColumn >= column -3 && field.getDisc(intColumn, row) == fieldValue){
			count++;
			intColumn--;
		}
		
		//check right
		intColumn = column + 1;
		while(intColumn < field.getNrColumns() && intColumn <= column + 3 && field.getDisc(intColumn, row) == fieldValue){
			count++;
			intColumn++;
		}
		
		return count >= 4;
	}
	
	private boolean checkVertical(int column, Field field){
		int row = field.getRowForColumn(column);
		
		int count = 1;
		
		int intRow = row-1; 
		while(intRow >= 0 && intRow >= row - 3 && field.getDisc(column, intRow) == fieldValue){
			count++;
			intRow--;
		}
		
		intRow = row+1; 
		while(intRow < field.getNrRows() && intRow <= row + 3 && field.getDisc(column, intRow) == fieldValue){
			count++;
			intRow++;
		}
		
		return count >= 4;
		
	}
	
	private boolean checkUpAngle(int column, Field field) {
		int row = field.getRowForColumn(column);
		
		int count = 1;
		
		int intRow = row-1; 
		int intColumn = column+1;
		while(intRow >= 0 && intRow >= row - 3 && intColumn < field.getNrColumns() && intColumn <= column + 3 && field.getDisc(intColumn, intRow) == fieldValue){
			count++;
			intRow--;
			intColumn++;
		}
		
		intRow = row+1; 
		intColumn = column - 1;
		while(intRow < field.getNrRows() && intRow <= row + 3 && intColumn >= 0 && intColumn >= column - 3 && field.getDisc(intColumn, intRow) == fieldValue){
			count++;
			intRow++;
			intColumn--;
		}
		
		return count >= 4;
	}
	
	private boolean checkDownAngle(int column, Field field) {
		int row = field.getRowForColumn(column);
		
		int count = 1;
		
		int intRow = row+1; 
		int intColumn = column+1;
		while(intRow < field.getNrRows() && intRow <= row + 3 && intColumn < field.getNrColumns() && intColumn <= column + 3 && field.getDisc(intColumn, intRow) == fieldValue){
			count++;
			intRow++;
			intColumn++;
		}
		
		intRow = row-1; 
		intColumn = column - 1;
		while(intRow >= 0 && intRow >= row - 3 && intColumn >= 0 && intColumn >= column - 3 && field.getDisc(intColumn, intRow) == fieldValue){
			count++;
			intRow--;
			intColumn--;
		}
		
		return count >= 4;
	}

}
