package racers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import cars.CreateCars;
import game.FileManager;


public class CreateDrivers extends Driver {
	
	public static Driver drivers[] = new Driver[18];

	
	public static void main(String[] args) {		
		CreateCars.createCars();
		createDrivers();
		
		for(int i = 0; i < drivers.length; i++) {
			System.out.println(drivers[i].getName());
			System.out.println(drivers[i].getRating());
		}
	}
	
	public static void createDrivers() {		
		
		for(int i = 0; i < drivers.length; i++) {
			drivers[i] = new Driver();

			drivers[i].setFirstName(createFirstName());
			drivers[i].setLastName(createLastName());
			drivers[i].setName(drivers[i].getFirstName() + " " + drivers[i].getLastName());
			drivers[i].setAge((int) (Math.random() * 20 + 16));
			drivers[i].setLikability((int) (Math.random() * 100));

			
			drivers[i].setAggression((int) (Math.random() * 50 + 50));
			drivers[i].setAwareness((int) (Math.random() * 50 + 50));
			drivers[i].setCorners((int) (Math.random() * 50 + 50));
			drivers[i].setExperience((int) (Math.random() * 50 + 50));
			drivers[i].setPace((int) (Math.random() * 50 + 50));
			drivers[i].setRain((int) (Math.random() * 50 + 50));
			drivers[i].setSkill((int) (Math.random() * 50 + 50));
			drivers[i].setStraightaways((int) (Math.random() * 50 + 50));			
			drivers[i].setRating(
					(int) Math.round(
					drivers[i].getAggression() * .05 +
					drivers[i].getAwareness() * .1 +
					drivers[i].getCorners() * .1 +
					drivers[i].getExperience() * .175 +
					drivers[i].getLikability() * .025 +
					drivers[i].getPace() * .2 +
					drivers[i].getRain() * .05 +
					drivers[i].getSkill() * .2 +
					drivers[i].getStraightaways() * .1
					));
			
			drivers[i].setCar(CreateCars.cars[(int) Math.round(i * .5 - .5)]);
			drivers[i].setOverall((int) (drivers[i].getCar().getRating() * .6 + drivers[i].getRating() * .4));
			
			drivers[i].getCar();

		}
	}

	
	private static String createFirstName() {
		String name = null;

		File file = new File("FirstNames");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			
			int count = FileManager.countFileLines(file);
			int random = (int) (Math.random() * count + 1);
			
			for(int x = 0; x < random; x++) {
				name = scanner.nextLine();
			}		
			scanner.close();
			return name;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return name;
	}

	
	private static String createLastName() {
		String name = null;

		File file = new File("LastNames");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			
			int count = FileManager.countFileLines(file);
			int random = (int) (Math.random() * count + 1);
			
			for(int x = 0; x < random; x++) {
				name = scanner.nextLine();
			}		
			scanner.close();
			return name;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return name;
	}
}
