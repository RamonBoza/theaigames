package net.ramonboza.theaigames.fourinarow.strategy.model;

public enum MovementScore {
	
	OK(1),
	WORTH_FUTURE(10),
	FOUR_IN_ROW(Integer.MAX_VALUE),
	NOT_POSSIBLE(Integer.MIN_VALUE),
	ENEMY_WILL_FOUR_IN_ROW(Integer.MIN_VALUE);
	
	private int value;

	private MovementScore(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
