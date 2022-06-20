package racers;

import cars.Car;

public class Driver {
	// Personal Attributes
	String name;
	String firstName;
	String lastName;
	int age;

	Car car;

	int overall;
	int rating;
	// Racing Stats
	int corners;
	int straightaways;
	int rain;
	int skill;
	int experience;
	int pace;
	int awareness;

	// Personality Traits
	int aggression;

	int likability;

	// RaceDay Stuff
	double racedayFinish;
	double racedayLuck;

	// Driver Game State
	int totalPoints;
	int wins;
	int podiums;
	int pointsFinishes;
	int totalCrashes;

	public int getPointsFinishes() {
		return pointsFinishes;
	}

	public void setPointsFinishes(int pointsFinishes) {
		this.pointsFinishes = pointsFinishes;
	}

	public int getPodiums() {
		return podiums;
	}

	public void setPodiums(int podiums) {
		this.podiums = podiums;
	}

	public double getRacedayLuck() {
		return racedayLuck;
	}

	public void setRacedayLuck(double racedayLuck) {
		this.racedayLuck = racedayLuck;
	}
	
	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public double getRacedayFinish() {
		return racedayFinish;
	}

	public void setRacedayFinish(double raceFinishUnsorted) {
		this.racedayFinish = raceFinishUnsorted;
	}

	public int getOverall() {
		return overall;
	}

	public void setOverall(int overal) {
		this.overall = overal;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getCorners() {
		return corners;
	}

	public void setCorners(int corners) {
		this.corners = corners;
	}

	public int getStraightaways() {
		return straightaways;
	}

	public void setStraightaways(int straightaways) {
		this.straightaways = straightaways;
	}

	public int getRain() {
		return rain;
	}

	public void setRain(int rain) {
		this.rain = rain;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getPace() {
		return pace;
	}

	public void setPace(int pace) {
		this.pace = pace;
	}

	public int getAwareness() {
		return awareness;
	}

	public void setAwareness(int awareness) {
		this.awareness = awareness;
	}

	public int getAggression() {
		return aggression;
	}

	public void setAggression(int aggression) {
		this.aggression = aggression;
	}

	public int getLikability() {
		return likability;
	}

	public void setLikability(int likability) {
		this.likability = likability;
	}
}
