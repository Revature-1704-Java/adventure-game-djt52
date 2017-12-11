package com.revature.CaliforniaTrail;

import java.util.Random;
public class Command {
	public String com;
	private Game game;
	
	public Command(Game g,String com) {
		game = g;
		this.com = com;
	}
	
	public void execute() {
		if(com.equals("") || com.equals("a") || com.equals("Advance") || com.equals("advance")) {
			game.setWeeks(game.getWeeks() - 1);
			game.setFood(game.getFood() - (game.getAlive() * 25));
			Event e;
			switch(game.getZone()) {
				case MISSOURI_FORESTS: game.setDistance(game.getDistance() - 150);
					e = new Event(game,7);
					break;
				case GREAT_PLAINS: game.setDistance(game.getDistance() - 100);
					e = new Event(game,5);
					break;
				case ROCKY_MOUNTAINS: game.setDistance(game.getDistance() - 75);
					e = new Event(game,0);
					break;
				default : System.out.println("Yay, you broke it");
			}
		} else if(com.equals("u") || com.equals("Hunt") || com.equals("hunt")) {
			game.setWeeks(game.getWeeks() - 1);
			game.setFood(game.getFood() - (game.getAlive() * 25));
			if(game.getAmmo() == 0) {
				System.out.println("You stumble around the woods without ammo or food");
			}
			else {
				Random random = new Random();
				int ran = random.nextInt(25) + 10;
				game.setAmmo(game.getAmmo() - ran);
				if(game.getAmmo() < 0) {
					game.setAmmo(0);
					System.out.println("You are out of ammo");
				}
				game.setFood(game.getFood() + ran * 12);
			}
			Event e = new Event(game);
		} else if(com.equals("g") || com.equals("Gather") || com.equals("gather")) {
			game.setWeeks(game.getWeeks() - 1);
			game.setFood(game.getFood() - (game.getAlive() * 25));
			Random random = new Random();
			int ran = random.nextInt(150) + 100;
			game.setFood(game.getFood() + ran);
			Event e = new Event(game);
		}
	}
}