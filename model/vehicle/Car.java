package model.vehicle;

import model.VehicleType;

public class Car extends Vehicle{
    public Car(String licensePlateNo, String ownerName){
        super(licensePlateNo, VehicleType.CAR, ownerName);
    }
}
