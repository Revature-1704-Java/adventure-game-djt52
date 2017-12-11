package com.revature.CaliforniaTrail;

public  interface ControlEvent {
	
	
	public void initiate(Game game);
	
	public static int getCount() {
		return 0;
	}
	
	public static void incrementCount() {}
}