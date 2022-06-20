package racers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import cars.CreateCars;
import game.FileManager;


public class Drivers extends Driver {
	
	public static Driver driver[] = new Driver[18];

	
	public static void main(String[] args) {		
		CreateCars.createCars();
		createDrivers();
		
		for(int i = 0; i < driver.length; i++) {
			System.out.println(driver[i].getName());
			System.out.println(driver[i].getRating());
		}
	}
	
	public static void createDrivers() {		
		
		for(int i = 0; i < driver.length; i++) {
			driver[i] = new Driver();

			driver[i].setFirstName(createFirstName());
			driver[i].setLastName(createLastName());
			driver[i].setName(driver[i].getFirstName() + " " + driver[i].getLastName());
			driver[i].setAge((int) (Math.random() * 20 + 16));
			driver[i].setLikability((int) (Math.random() * 100));

			
			driver[i].setAggression((int) (Math.random() * 50 + 50));
			driver[i].setAwareness((int) (Math.random() * 50 + 50));
			driver[i].setCorners((int) (Math.random() * 50 + 50));
			driver[i].setExperience((int) (Math.random() * 50 + 50));
			driver[i].setPace((int) (Math.random() * 50 + 50));
			driver[i].setRain((int) (Math.random() * 50 + 50));
			driver[i].setSkill((int) (Math.random() * 50 + 50));
			driver[i].setStraightaways((int) (Math.random() * 50 + 50));			
			driver[i].setRating(
					(int) Math.round(
					driver[i].getAggression() * .05 +
					driver[i].getAwareness() * .1 +
					driver[i].getCorners() * .1 +
					driver[i].getExperience() * .175 +
					driver[i].getLikability() * .025 +
					driver[i].getPace() * .2 +
					driver[i].getRain() * .05 +
					driver[i].getSkill() * .2 +
					driver[i].getStraightaways() * .1
					));
			
			driver[i].setCar(CreateCars.car[(int) Math.round(i * .5 - .5)]);
			driver[i].setOverall((int) (driver[i].getCar().getRating() * .6 + driver[i].getRating() * .4));
			
			driver[i].getCar();

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
