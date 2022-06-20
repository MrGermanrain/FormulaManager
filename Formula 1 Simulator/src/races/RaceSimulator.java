package races;

import java.util.Arrays;

import configutations.Config;
import racers.Drivers;

public class RaceSimulator {
	
	public static double currentRace[] = new double[Drivers.driver.length]; 
	public static double racedayLuck;
	public static int racedayCrash;

	
	public static void SimulateNextRace() {
		
		System.out.println("\nThe next race is Beginning!!\n");
		
		double raceFinishUnsorted;
		
		for(int i = 0; i < Drivers.driver.length; i++) {
			racedayLuck = Math.random() * 15 + 1;
			
			//setting up Crashed instances:
			racedayCrash = (int) Math.random() * 15 + 1;
			
			
			Drivers.driver[i].setRacedayLuck(racedayLuck);
			raceFinishUnsorted = racedayLuck + Drivers.driver[i].getOverall();
			Drivers.driver[i].setRacedayFinish(raceFinishUnsorted);
			currentRace[i] = raceFinishUnsorted;
		}
		
		Arrays.sort(currentRace);
		reverseArray(currentRace, currentRace.length);
		
		addPoints();
	}
	
	public static boolean isCrashed() {
		return false;
		
	}
	
	public static int drivers = 0;

	public static void addPoints() {
		for(int i = 0; i < currentRace.length; i++) {
			for(drivers = 0; drivers < Drivers.driver.length; drivers++) {
				if(Drivers.driver[drivers].getRacedayFinish() == currentRace[i]) {
					Drivers.driver[drivers].setTotalPoints(Drivers.driver[drivers].getTotalPoints() + Integer.parseInt(Config.getConfig(String.valueOf(i+1))));
					if(i == 1) {
						Drivers.driver[drivers].setWins(Drivers.driver[drivers].getWins() + 1);
						Drivers.driver[drivers].setPodiums(Drivers.driver[drivers].getPodiums() + 1);
						Drivers.driver[drivers].setPointsFinishes(Drivers.driver[drivers].getPointsFinishes() + 1);
					} else if (i == 2 || i == 3) {
						Drivers.driver[drivers].setPodiums(Drivers.driver[drivers].getPodiums() + 1);
						Drivers.driver[drivers].setPointsFinishes(Drivers.driver[drivers].getPointsFinishes() + 1);
					} else if (i <= 10) {
						Drivers.driver[drivers].setPointsFinishes(Drivers.driver[drivers].getPointsFinishes() + 1);
					}
					System.out.println("Driver: " + Drivers.driver[i].getName() + " - " + Drivers.driver[i].getTotalPoints() + " (" + Drivers.driver[i].getRacedayFinish() + " - " + Drivers.driver[i].getRacedayLuck() + ") " + Drivers.driver[i].getOverall());
				}
			}
		}
	}
	
	public static void totalWins() {
		System.out.println("\n");
		System.out.println("Driver: " + "	" + "Race Wins:" + " Overall:" + " Podiums:" + " Top 10:");
		for(drivers = 0; drivers < Drivers.driver.length; drivers++) {
			if(Drivers.driver[drivers].getName().length() < 16) {
				System.out.println(Drivers.driver[drivers].getName() + "		" + Drivers.driver[drivers].getWins() + "	" + Drivers.driver[drivers].getOverall() + "	" + Drivers.driver[drivers].getPodiums() + "	" + Drivers.driver[drivers].getPointsFinishes());

			} else {
				System.out.println(Drivers.driver[drivers].getName() + "	" + Drivers.driver[drivers].getWins() + "	" + Drivers.driver[drivers].getOverall() + "	" + Drivers.driver[drivers].getPodiums() + "	" + Drivers.driver[drivers].getPointsFinishes());
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
