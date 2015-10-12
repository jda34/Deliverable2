import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;




public class CitySim9000Test {






	//This tests that the pickRandomLocation will only return a number between 0 and 4.
	@Test
	public void testPickRandomLocation() {

		CitySim9000 main = new CitySim9000();
		Random rand = new Random();
		int num = main.pickRandomLocation(rand);
		assertTrue(num<5 && num>-1);
	}

	//This tests that car.getName() works properly.
	@Test
	public void testNames(){
		Location loc = new Location("Mall", "Fourth Ave", 2, "Meow St", 3);
		Car c = new Car("Driver 1", loc);
		assertEquals("Driver 1",c.getName());
	}

	//This tests that getLocationName() works properly.
	@Test
	public void testLocationName(){
		Location loc = new Location("Mall", "Fourth Ave", 2, "Meow St", 3);
		assertEquals("Mall",loc.getLocationName());
	}

	//This tests goToNextLocation.
	//Based on input, the next location must be either the bookstore or coffee.
	@Test
	public void testNextLocation(){

		Random rand = new Random();
		Location loc = new Location("Mall", "Fourth Ave", 2, "Meow St", 3);
		Car c = new Car("Driver 1", loc);
		Location newLoc = loc.goToNextLocation(c, rand);
		assertTrue(newLoc.getLocationName().equals("Bookstore") || newLoc.getLocationName().equals("Coffee"));
	}


	//This tests Car.getName by using a Location object double.
	//This test can be run without having the Location object set up yet.
	@Test
	public void mockLocationCheckCarName(){
		Location mockLoc = Mockito.mock(Location.class);
		Car c = new Car("Ralph", mockLoc);
		assertEquals("Ralph",c.getName());

	}

	//This tests that Car.setName() works after initializing a car.
	//This test can be run without having the Location object set up yet.
	@Test
	public void mockLocationCheckCarSetName(){
		Location mockLoc = Mockito.mock(Location.class);
		Car c = new Car ("Ralph", mockLoc);
		c.setName("Bill");
		assertTrue(!c.getName().equals("Ralph"));
	}

	//This tests that Car.getLocation() works after initializing a car.
	//This test can be run without having the Location object set up yet.
	@Test
	public void mockLocationCheckLocation(){
		Location mockLoc = Mockito.mock(Location.class);
		Car c = new Car ("Ralph", mockLoc);
		c.setName("Bill");
		c.setLocation(null);
		assertNull(c.getLocation());
	}

	//This test uses a stubbing of a method to set c's new location.
	@Test
	public void carNewLocationFromMockLocation(){
		Location mockLoc = Mockito.mock(Location.class);
		Car c = new Car("Ralph", mockLoc);
		Random rand = new Random();
		Mockito.when(mockLoc.goToNextLocation(c, rand)).thenReturn(new Location("Mall", "Fourth Ave", 2, "Meow St", 3));
		Location loc = mockLoc.goToNextLocation(c, rand);
		c.setLocation(loc);
		assertEquals("Mall",c.getLocation().getLocationName());
	}

	//This test mocks the random number generator to return 1 every time.
	//This lets us go to the next location in a repeatable way.
	@Test
	public void mockRandCaseOne(){

		Location loc = new Location("Mall", "Fourth Ave", 2, "Meow St", 3);
		Random rand = Mockito.mock(Random.class);

		Mockito.when(rand.nextInt()).thenReturn(1);
		Car c = new Car("Steve", loc);
		loc = loc.goToNextLocation(c, rand);
		assertEquals("Coffee", loc.getLocationName());
	}

	//This test mocks the random number generator to return 0 every time.
	//This lets us go to the next location in a repeatable way.
	@Test
	public void mockRandCaseTwo(){

		Location loc = new Location("Mall", "Fourth Ave", 2, "Meow St", 3);
		Random rand = Mockito.mock(Random.class);

		Mockito.when(rand.nextInt()).thenReturn(0);
		Car c = new Car("Jerry", loc);
		loc = loc.goToNextLocation(c, rand);
		assertEquals("Bookstore", loc.getLocationName());
	}







}
