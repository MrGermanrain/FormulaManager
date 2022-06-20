package game;

import cars.CreateCars;
import racers.CreateDrivers;
import races.RaceSimulator;

public class MainClass {
	public static void main(String[] args) {
		CreateCars.createCars();
		CreateDrivers.createDrivers();
		
		for(int i = 0; i < CreateDrivers.drivers.length; i++) {
			System.out.println("Racer Name: " + CreateDrivers.drivers[i].getName());
			System.out.println("Racer Rating: " +  CreateDrivers.drivers[i].getRating());
			System.out.println("Car: " + CreateDrivers.drivers[i].getCar().getName());
			System.out.println("Car Rating: " + CreateDrivers.drivers[i].getCar().getRating());
			System.out.println("Overall: " + CreateDrivers.drivers[i].getOverall());
			System.out.println("---------------");
		} 
		
		System.out.println("\n"
				+  "Game Setup Complete...");
		
		for(int i = 0; i < 23; i++) {
			RaceSimulator.SimulateNextRace();			
		}
		RaceSimulator.TotalWins();
	}
}
