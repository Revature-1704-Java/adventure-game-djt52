package com.revature.CaliforniaTrail;

import java.util.Scanner;
public class WagonMarket implements ControlEvent {
	
		
	private static int count;
	public void initiate(Game game) {
		boolean stay = true;
		Scanner sc = new Scanner(System.in);
		String control = "";
		System.out.println("You have reached a gathering of wagons.");
		System.out.println("Here you may trade food for ammo or add members to your party");
		System.out.println("Adding people to your party helps you survive longer but requires more food");
		while(stay) {
			System.out.println("Please select an option: trade, add person, or leave?");
			control = sc.nextLine();
			if(control.equals("q")) {
				System.out.println("Please wait to leave the camp before quiting the game");
			}
			if(control.equals("trade") || control.equals("Trade") || control.equals("t")) {
				System.out.println("Please enter how much ammo you wish to recieve");
				System.out.println("2 pounds of food for each round of ammo");
				String num = sc.nextLine();
				int rounds = Integer.parseInt(num);
				game.setFood(game.getFood() - rounds * 2);
				game.setAmmo(game.getAmmo() + rounds);
			} else if(control.equals("Leave") || control.equals("leave") || control.equals("l")) {
				stay = false;
			} else if(control.equals("Add Person") || control.equals("add person") || control.equals("add")) {
				int ra = (int)(Math.random() * 6);
				String name = "";
				switch(ra) {
					case 1: name = "Randy";
					break;
					case 2: name = "Robert";
					break;
					case 3: name = "Terry";
					break;
					case 4: name = "Becka";
					break;
					case 5: name = "Emily";
					break;
					case 6: name = "Martha";
					break;
					default: name = "Jerry";
					break;
				}
				Member m = new Member(name);
				game.getParty().add(m);
				System.out.println(name + " has joined your party");
			}
		}
			
			
	}
	
	public static int getCount(){
		return 0;
	}
	
	public static void incrementCount() {
		count++;
	}
}