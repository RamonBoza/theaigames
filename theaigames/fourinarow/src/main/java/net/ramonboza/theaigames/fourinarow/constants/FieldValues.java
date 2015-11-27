package net.ramonboza.theaigames.fourinarow.constants;

public enum FieldValues {
	
	EMPTY_VALUE(0),
	PLAYER_VALUE(1),
	ENEMY_VALUE(2);
	
	private int value;

	private FieldValues(int value){
		this.value= value;
	}
	
	public int getValue() {
		return value;
	}

}
