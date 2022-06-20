package cars;

public class Car {
	
	//Car Traits
	String name;
	
	//Car Stats
	int reliability;
	int speed;
	int acceloration;
	int brakes;
	int handling;
	int rating;
	
	//TODO Percent of Chance car will retire
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReliability() {
		return reliability;
	}
	public void setReliability(int reliability) {
		this.reliability = reliability;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAcceloration() {
		return acceloration;
	}
	public void setAcceloration(int acceloration) {
		this.acceloration = acceloration;
	}
	public int getBrakes() {
		return brakes;
	}
	public void setBrakes(int brakes) {
		this.brakes = brakes;
	}
	public int getHandling() {
		return handling;
	}
	public void setHandling(int handling) {
		this.handling = handling;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
