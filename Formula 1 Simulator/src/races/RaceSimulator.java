package races;

import java.util.Arrays;

import configutations.Config;
import racers.CreateDrivers;

public class RaceSimulator {
	
	public static double currentRace[] = new double[CreateDrivers.drivers.length]; 
	public static double racedayLuck;

	
	public static void SimulateNextRace() {
		
		System.out.println("\nThe next race is Beginning!!\n");
		
		double raceFinishUnsorted;
		
		for(int i = 0; i < CreateDrivers.drivers.length; i++) {
			racedayLuck = Math.random() * 15 + 1;
			
			
			CreateDrivers.drivers[i].setRacedayLuck(racedayLuck);
			raceFinishUnsorted = racedayLuck + CreateDrivers.drivers[i].getOverall();
			CreateDrivers.drivers[i].setRacedayFinish(raceFinishUnsorted);
			currentRace[i] = raceFinishUnsorted;
		}
		
		Arrays.sort(currentRace);
		reverseArray(currentRace, currentRace.length);
		
		addPoints();
	}
	
	public static int drivers = 0;

	public static void addPoints() {
		for(int i = 0; i < currentRace.length; i++) {
			for(drivers = 0; drivers < CreateDrivers.drivers.length; drivers++) {
				if(CreateDrivers.drivers[drivers].getRacedayFinish() == currentRace[i]) {
					CreateDrivers.drivers[drivers].setTotalPoints(CreateDrivers.drivers[drivers].getTotalPoints() + Integer.parseInt(Config.getConfig(String.valueOf(i+1))));
					if(i == 1) {
						CreateDrivers.drivers[drivers].setWins(CreateDrivers.drivers[drivers].getWins() + 1);
						CreateDrivers.drivers[drivers].setPodiums(CreateDrivers.drivers[drivers].getPodiums() + 1);
						CreateDrivers.drivers[drivers].setPointsFinishes(CreateDrivers.drivers[drivers].getPointsFinishes() + 1);
					} else if (i == 2 || i == 3) {
						CreateDrivers.drivers[drivers].setPodiums(CreateDrivers.drivers[drivers].getPodiums() + 1);
						CreateDrivers.drivers[drivers].setPointsFinishes(CreateDrivers.drivers[drivers].getPointsFinishes() + 1);
					} else if (i <= 10) {
						CreateDrivers.drivers[drivers].setPointsFinishes(CreateDrivers.drivers[drivers].getPointsFinishes() + 1);
					}
					System.out.println("Driver: " + CreateDrivers.drivers[i].getName() + " - " + CreateDrivers.drivers[i].getTotalPoints() + " (" + CreateDrivers.drivers[i].getRacedayFinish() + " - " + CreateDrivers.drivers[i].getRacedayLuck() + ") " + CreateDrivers.drivers[i].getOverall());
				}
			}
		}
	}
	
	public static void TotalWins() {
		System.out.println("\n");
		System.out.println("Driver: " + "	" + "Race Wins:" + " Overall:" + " Podiums:" + " Top 10:");
		for(drivers = 0; drivers < CreateDrivers.drivers.length; drivers++) {
			if(CreateDrivers.drivers[drivers].getName().length() < 16) {
				System.out.println(CreateDrivers.drivers[drivers].getName() + "		" + CreateDrivers.drivers[drivers].getWins() + "	" + CreateDrivers.drivers[drivers].getOverall() + "	" + CreateDrivers.drivers[drivers].getPodiums() + "	" + CreateDrivers.drivers[drivers].getPointsFinishes());

			} else {
				System.out.println(CreateDrivers.drivers[drivers].getName() + "	" + CreateDrivers.drivers[drivers].getWins() + "	" + CreateDrivers.drivers[drivers].getOverall() + "	" + CreateDrivers.drivers[drivers].getPodiums() + "	" + CreateDrivers.drivers[drivers].getPointsFinishes());
			}
		}
	}
	
    static void reverseArray(double doubleArray[], int size) { 
        for (int i = 0; i < size / 2; i++) { 
            double temp = doubleArray[i]; 
            doubleArray[i] = doubleArray[size - i - 1]; 
            doubleArray[size - i - 1] = temp; 
        } 
    } 
	
}
