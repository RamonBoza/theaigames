package net.ramonboza.theaigames.fourinarow.providers;

import net.ramonboza.theaigames.fourinarow.Field;

public class RealGameFieldFactory {
	
	public static Field createOnlineGameBugField() {
		Field field = new Field(7, 6);
		String fieldString =  "0,0,0,0,0,0,0;" 
							+ "1,0,0,0,0,0,0;" 
							+ "1,0,0,0,0,0,0;" 
							+ "1,0,0,0,0,0,0;"
							+ "2,2,0,0,0,0,0;" 
							+ "1,2,0,0,0,0,2;";
		field.parseFromString(fieldString);
		return field;
	}
}