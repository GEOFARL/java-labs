package road;

import java.util.ArrayList;
import java.util.List;

import people.Person;
import vehicle.Vehicle;

public class Road {
  private List<Vehicle<? extends Person>> vehiclesOnRoad = new ArrayList<>();

  public int getCountOfHumans() {
    int totalHumans = 0;
    for (Vehicle<? extends Person> vehicle : vehiclesOnRoad) {
      totalHumans += vehicle.getOccupiedSeats();
    }
    return totalHumans;
  }

  public void addVehicleToRoad(Vehicle<? extends Person> vehicle) {
    vehiclesOnRoad.add(vehicle);
  }
}
