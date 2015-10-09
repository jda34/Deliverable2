import java.util.Random;

/*outside city=0   0to1Fourth or 0to4Fifth
 * mall=1          1to2Fourth  or 1to3Meow
 * bookstore=2     2to0Fouuth or  2to4Chirp
 * coffee=3        3to0Fifth  or 3to1Meow
 * university=4    4to3Fifth or 4to2Chirp
 * 
 *  City Map

       ---> [Mall] ----> [Bookstore] ----> Fourth Ave.
             A  |         A   |
     Meow St.|  |         |   | Chirp St.
             |  V         |   V
       <--- [Coffee] <-- [University] <--- Fifth Ave.
 * 
 */

public class Deliverable2 {
	public static void main(String args[]){
		if (args.length!= 1){
			System.out.println("Must only have one argument");
			System.exit(1);
		}
		integer(args[0]); //exits if not integer
		
		Random rand = new Random(Integer.parseInt(args[0]));

		Location[] locs =  new Location[5];
		locs[0] = new Location("Outside City", "Fourth Ave", 1, "Fifth Ave", 4);
		locs[1] = new Location("Mall", "Fourth Ave", 2, "Meow St", 3);
		locs[2] = new Location("Bookstore", "Fouth Ave", 0, "Chirp St", 4);
		locs[3] = new Location("Coofee", "Fifth Ave", 0, "Meow St", 1);
		locs[4] = new Location("University", "Fifth Ave", 3, "Chirp St",2);


		Location currentLocation;
		for (int j = 0; j < 5; j++) {
			Car c = new Car();
			c.setName("Driver "+j);
			int firstLocation = pickRandomLocation(rand);
			currentLocation = locs[firstLocation];
			c.setLocation(currentLocation);
			do {
				currentLocation = currentLocation.goToNextLocation(c, rand);
				c.setLocation(currentLocation);
			} while (!currentLocation.getLocationName().equals("Outside City")); // 0 = outside city
			System.out.println(c.getName() + " has left the city!");
		}



	}

	public static int pickRandomLocation(Random rand) {
		return rand.nextInt(5);
	}

	//checks to see if input is integer or not
	public static void integer(String string){
		try{
			int number=Integer.parseInt(string);
		} catch (NumberFormatException e){
			System.out.println("Argument must be an integer");
			System.exit(1);
		}

	}


}

