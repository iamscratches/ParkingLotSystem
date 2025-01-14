package model.vehicle;

import model.VehicleType;

public class Truck extends Vehicle{
    public Truck(String licensePlateNo, String ownerName){
        super(licensePlateNo, VehicleType.TRUCK, ownerName);
    }
}
