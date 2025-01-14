package model.spot;

import model.ParkingSpot;
import model.VehicleType;
import model.vehicle.Vehicle;

public class SmallSpot extends ParkingSpot{
    public SmallSpot(String spotID){
        super(spotID);
    }
    @Override
    public boolean canFitVehicle(Vehicle vehicle){
        return VehicleType.BIKE==vehicle.getVehicleType();
    }
}
