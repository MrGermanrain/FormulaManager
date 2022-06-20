package cars;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import racers.Drivers;


public class CreateCars extends Car {
	
	public static Car car[] = new Car[Drivers.driver.length / 2];

	public static void createCars() {
		
		for(int i = 0; i < car.length; i++) {
			car[i] = new Car();
			
			car[i].setName(setCarNames(i));
			
			car[i].setAcceloration((int) (Math.random() * 50 + 50));
			car[i].setBrakes((int) (Math.random() * 50 + 50));
			car[i].setHandling((int) (Math.random() * 50 + 50));
			car[i].setReliability((int) (Math.random() * 50 + 50));
			car[i].setSpeed((int) (Math.random() * 50 + 50));
			
			car[i].setRating(
					(int) Math.round(
					(car[i].getAcceloration() * .2 +
					car[i].getBrakes() * .2 +
					car[i].getHandling() * .2 +
					car[i].getReliability() * .2 +
					car[i].getSpeed() * .2)
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
