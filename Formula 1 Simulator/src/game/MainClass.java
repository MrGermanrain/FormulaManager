package game;

import cars.CreateCars;
import racers.Drivers;
import races.RaceSimulator;

public class MainClass {
	
	/*
	public static void main(String[] args) {
		CreateCars.createCars();
		Drivers.createDrivers();
		
		for(int i = 0; i < Drivers.driver.length; i++) {
			System.out.println("Racer Name: " + Drivers.driver[i].getName());
			System.out.println("Racer Rating: " +  Drivers.driver[i].getRating());
			System.out.println("Car: " + Drivers.driver[i].getCar().getName());
			System.out.println("Car Rating: " + Drivers.driver[i].getCar().getRating());
			System.out.println("Overall: " + Drivers.driver[i].getOverall());
			System.out.println("---------------");
		} 
		
		System.out.println("\n"
				+  "Game Setup Complete...");
		
		for(int i = 0; i < 23; i++) {
			System.out.println("\nRace: " + i+1);
			RaceSimulator.SimulateNextRace();
		}
		
		RaceSimulator.totalStats();
	}
	*/
	
	public static void gameSetup() {
		CreateCars.createCars();
		Drivers.createDrivers();
	}

	public static void nextRace() {
		RaceSimulator.SimulateNextRace();
		RaceSimulator.totalStats();
	}
}
