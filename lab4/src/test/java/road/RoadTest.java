package road;

import org.junit.Before;
import org.junit.Test;
import people.FireFighter;
import people.Person;
import people.PoliceOfficer;
import vehicle.Bus;
import vehicle.FireTruck;
import vehicle.PoliceCar;
import vehicle.Taxi;

import static org.junit.Assert.*;

public class RoadTest {
  private Road road;

  @Before
  public void setUp() {
    road = new Road();
  }

  @Test
  public void testAddVehicleToRoad() throws Exception {
    Bus bus = new Bus(3);
    bus.boardPassenger(new Person("John"));
    bus.boardPassenger(new FireFighter("Alice"));
    bus.boardPassenger(new PoliceOfficer("Bob"));

    road.addVehicleToRoad(bus);
    assertEquals(3, road.getCountOfHumans());
  }

  @Test
  public void testAddMultipleVehicles() throws Exception {
    Bus bus = new Bus(2);
    bus.boardPassenger(new Person("John"));
    bus.boardPassenger(new FireFighter("Alice"));

    Taxi taxi = new Taxi(2);
    taxi.boardPassenger(new Person("Eve"));

    road.addVehicleToRoad(bus);
    road.addVehicleToRoad(taxi);

    assertEquals(3, road.getCountOfHumans());
  }

  @Test
  public void testAddFireTruckWithFirefighters() throws Exception {
    FireTruck fireTruck = new FireTruck(2);
    fireTruck.boardPassenger(new FireFighter("Sam"));
    fireTruck.boardPassenger(new FireFighter("George"));

    road.addVehicleToRoad(fireTruck);

    assertEquals(2, road.getCountOfHumans());
  }

  @Test
  public void testAddPoliceCarWithPoliceOfficers() throws Exception {
    PoliceCar policeCar = new PoliceCar(2);
    policeCar.boardPassenger(new PoliceOfficer("Officer Mike"));

    road.addVehicleToRoad(policeCar);

    assertEquals(1, road.getCountOfHumans());
  }

  @Test
  public void testBoardPassengerThrowsExceptionWhenFull() {
    Bus bus = new Bus(1);
    try {
      bus.boardPassenger(new Person("John"));
    } catch (Exception e) {
      fail("Should not have thrown an exception");
    }

    try {
      bus.boardPassenger(new FireFighter("Alice"));
      fail("Expected an exception for full bus");
    } catch (Exception e) {
      assertEquals("All seats are occupied", e.getMessage());
    }
  }

  @Test
  public void testDisembarkPassengerThrowsExceptionIfNotOnBoard() {
    Bus bus = new Bus(2);
    Person person1 = new Person("John");
    Person person2 = new FireFighter("Alice");

    try {
      bus.boardPassenger(person1);
    } catch (Exception e) {
      fail("Should not have thrown an exception");
    }

    try {
      bus.disembarkPassenger(person2);
      fail("Expected an exception for non-existent passenger");
    } catch (Exception e) {
      assertEquals("Passenger is not in the vehicle", e.getMessage());
    }
  }

  @Test
  public void testDisembarkPassengerSuccess() throws Exception {
    Bus bus = new Bus(2);
    Person person1 = new Person("John");

    bus.boardPassenger(person1);
    bus.disembarkPassenger(person1);

    assertEquals(0, bus.getOccupiedSeats());
  }
}
