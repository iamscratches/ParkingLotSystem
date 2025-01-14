package model.spot;

import model.VehicleType;
import model.vehicle.Vehicle;

public class LargeSpot extends ParkingSpot{
    public LargeSpot(String spotID){
        super(spotID);
    }
    @Override
    public boolean canFitVehicle(Vehicle vehicle){
        return VehicleType.TRUCK==vehicle.getVehicleType();
    }
}
