package net.ramonboza.theaigames.fourinarow.providers;

import net.ramonboza.theaigames.fourinarow.Field;

public class TestFieldFactory {
	
	 public static Field createSimpleField(){
		Field field = new Field(7, 6);
		String fieldString =  "0,0,0,0,0,0,0;" 
							+ "0,0,0,0,0,0,0;"
							+ "0,0,0,0,0,0,0;" 
							+ "0,0,0,0,0,0,0;"
							+ "0,0,0,0,0,0,0;" 
							+ "0,0,0,0,0,0,0;";
		field.parseFromString(fieldString);
		return field;
	 }
	 
	 public static Field createInTheMiddleField() {
			Field field = new Field(7, 6);
			String fieldString =  "0,0,0,0,0,0,0;" 
								+ "0,0,0,0,0,0,0;" 
								+ "0,0,0,0,0,0,0;" 
								+ "0,0,0,0,0,0,0;"
								+ "0,0,0,0,0,0,0;" 
								+ "0,0,1,0,1,1,2;";
			field.parseFromString(fieldString);
			return field;
	 }
	
	 public static Field createEnemyInTheMiddleField() {
		Field field = new Field(7, 6);
		String fieldString =  "0,0,0,0,0,0,0;" 
							+ "0,0,0,0,0,0,0;" 
							+ "0,0,0,0,0,0,0;" 
							+ "0,0,0,0,0,0,0;"
							+ "0,0,0,0,0,0,0;" 
							+ "0,0,2,0,2,2,1;";
		field.parseFromString(fieldString);
		return field;
	}
	
	 public static Field createEnemyWillFourIfIAddAtThree() {
		Field field = new Field(7, 6);
		String fieldString =  "0,0,0,0,0,0,0;" 
							+ "0,0,0,0,0,0,0;" 
							+ "0,0,2,0,0,0,0;" 
							+ "0,0,1,0,0,0,0;"
							+ "0,0,1,0,2,0,0;" 
							+ "0,0,2,1,2,2,1;";
		field.parseFromString(fieldString);
		return field;
	}
	 
	 

	 public static Field createSimpleEnemyField() {
			Field field = new Field(7, 6);
			String fieldString =  "0,0,0,0,0,0,0;" 
								+ "0,0,0,0,0,0,0;" 
								+ "0,0,0,0,0,0,0;" 
								+ "0,0,0,0,0,0,0;"
								+ "0,0,0,0,0,0,0;" 
								+ "2,2,2,0,2,2,2;";
			field.parseFromString(fieldString);
			return field;
	 }
	 
	 public static Field createInTheMiddleUpAngleField() {
		 	Field field = new Field(7, 6);
			String fieldString =  "0,0,0,0,0,0,0;" 
								+ "0,0,0,0,0,0,0;" 
								+ "0,0,0,2,0,0,0;" 
								+ "0,0,0,1,0,0,0;"
								+ "0,2,1,1,0,0,0;" 
								+ "2,2,2,1,2,2,2;";
			field.parseFromString(fieldString);
			return field;
	 }

	
}