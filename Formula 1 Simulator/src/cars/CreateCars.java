package cars;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import racers.CreateDrivers;


public class CreateCars extends Car {
	
	public static Car cars[] = new Car[CreateDrivers.drivers.length / 2];
	
	public static void main(String[] args) {
		createCars();
	}

	public static void createCars() {
		
		for(int i = 0; i < cars.length; i++) {
			cars[i] = new Car();
			
			cars[i].setName(setCarNames(i));
			
			cars[i].setAcceloration((int) (Math.random() * 50 + 50));
			cars[i].setBrakes((int) (Math.random() * 50 + 50));
			cars[i].setHandling((int) (Math.random() * 50 + 50));
			cars[i].setReliability((int) (Math.random() * 50 + 50));
			cars[i].setSpeed((int) (Math.random() * 50 + 50));
			
			cars[i].setRating(
					(int) Math.round(
					(cars[i].getAcceloration() * .2 +
					cars[i].getBrakes() * .2 +
					cars[i].getHandling() * .2 +
					cars[i].getReliability() * .2 +
					cars[i].getSpeed() * .2)
					));
			}
	}
	
	private static String setCarNames(int i) {
		String name = null;

		File file = new File("TeamNames");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			
			for(int x = 0; x <= i; x++) {
				name = scanner.nextLine();
			}
	
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return name;
	}

	
}
