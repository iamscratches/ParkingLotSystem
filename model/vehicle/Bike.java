package model.vehicle;

import model.VehicleType;

public class Bike extends Vehicle{
    public Bike(String licensePlateNo, String ownerName){
        super(licensePlateNo, VehicleType.BIKE, ownerName);
    }
}
