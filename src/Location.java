import java.util.Random;

public class Location {
	String locationName;
	String aStreet;
	int aLocation;
	String bStreet;
	int bLocation; 

	public Location(String a, String b, int c, String d, int e){
		locationName= a;
		aStreet= b;
		aLocation = c;
		bStreet = d;
		bLocation = e;
	}
	public String getLocationName(){
		return locationName;
		
	}
	public Location goToNextLocation(Car c, Random rand) {
		Location[] locs =  new Location[5];
		locs[0] = new Location("Outside City", "Fourth Ave", 1, "Fifth Ave", 4);
		locs[1] = new Location("Mall", "Fourth Ave", 2, "Meow St", 3);
		locs[2] = new Location("Bookstore", "Fouth Ave", 0, "Chirp St", 4);
		locs[3] = new Location("Coffee", "Fifth Ave", 0, "Meow St", 1);
		locs[4] = new Location("University", "Fifth Ave", 3, "Chirp St",2);
		Location nextLocation; 
		int nextLocationNumber;
		Street nextStreet;


		String viaStreet;
		if (rand.nextInt() % 2 == 0) {
			nextLocationNumber = aLocation;
			viaStreet = aStreet;
		} else {
			nextLocationNumber = bLocation;
			viaStreet = bStreet;
		}
		nextLocation = locs[nextLocationNumber];
		System.out.println(c.getName() + " heading from " +c.getLocation().getLocationName()+ " to " + nextLocation.getLocationName() + " via " +viaStreet + ".");
				return nextLocation;

	}
}