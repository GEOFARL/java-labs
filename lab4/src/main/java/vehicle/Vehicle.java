package vehicle;

import java.util.ArrayList;
import java.util.List;

import people.Person;

public class Vehicle<T extends Person> {
  private int capacity;
  private List<T> passengers;

  public Vehicle(int capacity) {
    this.capacity = capacity;
    this.passengers = new ArrayList<>();
  }

  public int getMaxCapacity() {
    return capacity;
  }

  public int getOccupiedSeats() {
    return passengers.size();
  }

  public void boardPassenger(T passenger) throws Exception {
    if (passengers.size() >= capacity) {
      throw new Exception("All seats are occupied");
    }
    passengers.add(passenger);
  }

  public void disembarkPassenger(T passenger) throws Exception {
    if (!passengers.contains(passenger)) {
      throw new Exception("Passenger is not in the vehicle");
    }
    passengers.remove(passenger);
  }

  public List<T> getPassengers() {
    return passengers;
  }
}
