
public class Car {

	
	private String name;
	private Location location;
	
	public Car(String a, Location b){
		name = a;
		location = b;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
