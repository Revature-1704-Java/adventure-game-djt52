package com.revature.CaliforniaTrail;

import java.util.Scanner;
public class RiverCrossing implements ControlEvent {
	
	private static int count;
	
	public void initiate(Game game) {
		boolean stay = true;
		Scanner sc = new Scanner(System.in);
		String control = "";
		System.out.println("You have reached a wide deep river.");
		System.out.println("You may choose to either ford the river or attempt to float your wagon across");
		while(stay) {
			System.out.println("Please select your option: ford or float?");
			control = sc.nextLine();
			if(control.equals("q")) {
				System.out.println("Please wait to cross the river before quiting the game");
			}
			if(control.equals("ford") || control.equals("Ford")) {
				int ra = (int)(Math.random() * 2 + 1);
				stay = false;
				if(ra == 1) {
					System.out.println("Oh no, 200 pounds of food was soaked and has been ruined");
					game.setFood(game.getFood() - 200);
				} else {
					System.out.println("You have successfully forded the river!");
				}
			} else if(control.equals("float") || control.equals("Float")) {
				int ra = (int)(Math.random() * 2 + 1);
				stay = false;
				if(ra == 1) {
					System.out.println("Oh no, your wagon floated too far down the river, you have lost a week and 100 miles");
					game.setWeeks(game.getWeeks() - 1);
					game.setDistance(game.getDistance() + 100);
				} else {
					System.out.println("You have successfully floated across the river!");
				}
			}
		}
			
			
	}
	
	public static int getCount(){
		return count;
	}
	
	public static void incrementCount() {
		count++;
	}
}