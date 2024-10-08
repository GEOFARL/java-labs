package geofarl;

import people.FireFighter;
import people.Person;
import people.PoliceOfficer;
import road.Road;
import vehicle.Bus;
import vehicle.FireTruck;

public class App {
    public static void main(String[] args) {
        Road road = new Road();
        Bus bus = new Bus(3);
        FireTruck fireTruck = new FireTruck(2);

        try {
            bus.boardPassenger(new Person("John"));
            bus.boardPassenger(new PoliceOfficer("Officer Bob"));
            bus.boardPassenger(new FireFighter("Fireman Frank"));

            fireTruck.boardPassenger(new FireFighter("Fireman Joe"));
        } catch (Exception e) {
            System.out.println(e);
        }

        road.addVehicleToRoad(bus);
        road.addVehicleToRoad(fireTruck);

        System.out.println("Total passengers on road: " + road.getCountOfHumans());
    }
}
