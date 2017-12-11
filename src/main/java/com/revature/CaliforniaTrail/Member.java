package com.revature.CaliforniaTrail;

public class Member {
	private int health;
	private String name;
	
	public  Member() {
	}
	
	public Member(String name) {
		this.name = name;
		health = 100;
	}
	
	public void healthChange(int adjust) {
		health+=adjust;
	}
	public String getName() {
		return this.name;
	}
	
	public int getHealth() {
		return health;
	}
}