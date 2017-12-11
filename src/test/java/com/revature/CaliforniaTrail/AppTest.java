package com.revature.CaliforniaTrail;

import static org.junit.Assert.*;
import org.junit.Test;


public class AppTest {
	
	@Test
	public final void GetterSetterTests() {
		Game g = new Game();
		g.setAmmo(20);
		g.setFood(30);
		g.setDistance(40);
		g.setWeeks(50);
		assertEquals(20,g.getAmmo());
		assertEquals(30,g.getFood());
		assertEquals(40,g.getDistance());
		assertEquals(50,g.getWeeks());
	}
	
	@Test
	public final void MemberTest() {
		Member m = new Member("Bob");
		assertEquals(100,m.getHealth());
		assertTrue("Bob".equals(m.getName()));
		m.healthChange(-50);
		assertEquals(50,m.getHealth());
	}
}
		


	
