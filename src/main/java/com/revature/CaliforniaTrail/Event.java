package com.revature.CaliforniaTrail;

import java.util.Random;
public class Event {
	Game game;
	
	public Event(Game game) {
		this.game = game;
		Random random = new Random();
		int ran = random.nextInt(100);
		if(ran < 25) {
			trigger(5);
		}
	}
	
	public Event(Game game, int quality) {
		this.game = game;
		Random random = new Random();
		int ran = random.nextInt(100);
		if(ran < 50) {
			trigger(quality);
		}
	}
	
	public void trigger(int r) {
		Random random = new Random();
		int ran = random.nextInt(11);
		int cas = ran + r;
		Member m;
		switch(cas) {
			case 1: m = game.getParty().get(random.nextInt(game.getAlive()));
				System.out.println("A vulture flies away with your youngest");
				game.getParty().remove(m);
				game.died(m);
				
			break;
			case 2: m = game.getParty().get(random.nextInt(game.getAlive()));
				System.out.println(m.getName() + " had a particularly bad encounter with bear cubs");
				m.healthChange(-75);
				System.out.println(m.getName() + " health: " + m.getHealth());
				if(m.getHealth() <= 0) {
					game.getParty().remove(m);
					game.died(m);
				}
			break;
			case 3:  m = game.getParty().get(random.nextInt(game.getAlive()));
				System.out.println(m.getName() + " was bitten by a very large mosquito");
				m.healthChange(-50);
				System.out.println(m.getName() + " health: " + m.getHealth());
				if(m.getHealth() <= 0) {
					game.getParty().remove(m);
					game.died(m);
				}
			break;
			case 4: System.out.println("Your wagon was stampeded by bison, Lose 2 weeks in repairs");
				game.setWeeks(game.getWeeks() - 2);
			break;
			case 5: System.out.println("A angry beaver steals 100 pounds of food");
				game.setFood(game.getFood() - 100);
			break;
			case 6: System.out.println("You are lost for a week");
				game.setWeeks(game.getWeeks() - 1);
			break;
			case 7: System.out.println("You are hit by a tornado, miraculously no one is hurt but you are set back 200 miles");
				game.setDistance(game.getDistance() + 200);
			break;
			case 8: System.out.println("A bear ran out of the woods scaring the horses who sprinted 100 miles but dropped 100 pounds of food");
				game.setFood(game.getFood() - 100);
				game.setDistance(game.getDistance() - 100);
			break;
			case 9 : m = game.getParty().get(random.nextInt(game.getAlive()));
				System.out.println(m.getName() + " fell into a river");
				m.healthChange(-50);
				System.out.println(m.getName() + " health: " + m.getHealth());
				if(m.getHealth() <= 0) {
					game.getParty().remove(m);
					game.died(m);
				}
			break;
			case 10: System.out.println("A deer fell onto your campfire, leaving it perfectly barbequed; + 100 pounds of food");
				game.setFood(game.getFood() + 100);
			break;
			case 11: if(game.getAmmo() > 0) {
					System.out.println("Bandits steal all of your ammo in the night!");
					game.setAmmo(0);
					}
			break;
			case 12:
			case 13: ControlEvent event = null;
					int ra = (int)(Math.random() * 2 + 1);
					if(ra == 1 && RiverCrossing.getCount() < 2) {
						event = new RiverCrossing();
						RiverCrossing.incrementCount();
					} else if(ra == 2 && WagonMarket.getCount() < 2) {
						event = new WagonMarket();
						WagonMarket.incrementCount();
					}
					if(event != null) {
						event.initiate(game);
					}
					break;
			case 14: m = game.getParty().get(random.nextInt(game.getAlive()));
				System.out.println(m.getName() + " found some really nutritious berries, + 100 pounds of food");
				game.setFood(game.getFood() + 100);
			break;
			case 15:  m = game.getParty().get(random.nextInt(game.getAlive()));
				System.out.println(m.getName() + " becomes vegan, throwing away 100 pounds of meat");
				game.setFood(game.getFood() - 100);
			break;
			case 16: m = game.getParty().get(random.nextInt(game.getAlive()));
				System.out.println(m.getName() + " died of dysentery");
				game.getParty().remove(m);
				game.died(m);
			break;
			case 17: m = game.getParty().get(random.nextInt(game.getAlive()));
				System.out.println(m.getName() + " got a bad papercut");
				m.healthChange(-25);
				System.out.println(m.getName() + " health: " + m.getHealth());
				if(m.getHealth() <= 0) {
					game.getParty().remove(m);
					game.died(m);
				}
			break;
			case 18: System.out.println("Almanacs predicts a warm winter! Gain a week!");
				game.setWeeks(game.getWeeks() + 1);
			break;
			default :
			break;
		}
	}
			
}