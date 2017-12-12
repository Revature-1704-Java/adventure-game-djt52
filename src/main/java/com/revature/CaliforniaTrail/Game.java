package com.revature.CaliforniaTrail;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Game {
	
	private static Game instance = null;
	public  ArrayList<Member> party;
	private  int weeks,ammo,food,distanceToGo,alv;
	private  boolean alive;
	private Zone z;
	
	public Game() {
	}

	public static void main(String[] args) {
		if(instance == null) {
			Game g = new Game();
			instance = g;
			g.run();
		}
	}
	
	public void run() {
		party = new ArrayList<Member>();
		alive = true;
		z = Zone.MISSOURI_FORESTS;
		weeks = 30;
		ammo = 100;
		food = 1000;
		alv = 4;
		distanceToGo = 2000;
		try (FileReader fr = new FileReader("src/resources/TextArt.txt")) {
			int i;
			while((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
			fr.close();
		} catch(FileNotFoundException ex) {
			System.out.println("Art not found");
		} catch(IOException ex) {
		}
		System.out.println("\n\tWelcome to the California Trail!");
		System.out.println("\t***Not Copyright Infringing***");
		System.out.println("\n\nYou have 30 weeks to go 2000 miles to move to California");
		System.out.println("Each week you can choose to advance, or hunt or gather more food");
		System.out.println("Each party member eats 25 pounds of food per week");
		System.out.println("Reach California before winter comes or you run out of food or people!");
		System.out.println("Controls are Advance: (a) or blank, Hunt (u), Gather (g), Help (h), Quit (q)");
		System.out.println("Please input the names of your four party members:");
		Scanner sc = new Scanner(System.in);
		String name = "";
		for(int i = 0;i < 4;i++) {
			System.out.println("Party Member " + (i + 1) + " :");
			name = sc.nextLine();
			party.add(new Member(name));
		}
		System.out.println("Controls are Advance: (a) or blank, Hunt (u), Gather (g), Help (h), Quit (q)");
		while(alive) {
			System.out.println("Food: " + food + ", Ammo: " + ammo + ", Distance Left: " + distanceToGo + ", Weeks Left: " + weeks);
			String com = sc.nextLine();
			if(com.equals("h") || com.equals("help") || com.equals("Help")) {
				System.out.println("Controls are Advance: (a) or blank, Hunt (u), Gather (g), Help (h), Quit (q)");
			} else if (com.equals("q") || com.equals("quit")) {
				break;
			} else {
				Command c = new Command(this,com);
				c.execute();
			}
			if(food < 125) {
				System.out.println("Low food");
			}
			if(getDistance() <= 0) {
				for(Member live: party) {
					System.out.println(live.getName() + " has survived");
				}
				System.out.println("They have reached the promised land of California!!!");
				win();
				alive = false;
			} else if(getFood() <= 0) {
				if(getAlive() > 1) {
					setFood(getFood() + 100);
					System.out.println("You have no food! Sacrifices need to be made!");
					System.out.println("Food + 100");
					died((Member) party.remove(0));
				}
				else {
					died((Member) party.remove(0));
					alive = false;
					lose();
				}
			}
			if(getWeeks() <= 0) {
				alive = false;
				System.out.println("Your party has frozen in the harsh winter :(");
				lose();
			}
		}				
		
	}
	public void lose() {
		System.out.println("You have lost");
	}
	
	public void win() {
		System.out.println("You win!!!");
	}
	
	public void died(Member m) {
		System.out.println(m.getName() + " has died");
		alv--;
	}
	
	public void died(int d) {
		Member m = party.remove(d);
		System.out.println(m.getName() + " has died");
		alv--;
	}
	
	
	public int getFood() {
		return food;
	}
	
	public void setFood(int food) {
		this.food = food;
	}
	
	public int getDistance() {
		return distanceToGo;
	}
	
	public void setDistance(int distanceToGo) {
		if(this.distanceToGo >= 500 && distanceToGo < 500) {
			z = Zone.ROCKY_MOUNTAINS;
			System.out.println("You have reached the Rocky Mountains!");
		}
		if(this.distanceToGo >= 1500 && distanceToGo < 1500) {
			z = Zone.GREAT_PLAINS;
			System.out.println("You have reached the Great Plains!");
		}
		this.distanceToGo = distanceToGo;
	}
	
	public int getWeeks() {
		return weeks;
	}
	
	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}
	public int getAmmo() {
		return ammo;
	}
	
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	
	public Zone getZone() {
		return z;
	}
	
	public int getAlive() {
		return alv;
	}
	
	public ArrayList<Member> getParty() {
		return party;
	}
}
                                           
                                           