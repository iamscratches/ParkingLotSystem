package model.spot;

import model.VehicleType;
import model.vehicle.Vehicle;

public class MediumSpot extends ParkingSpot{
    public MediumSpot(String spotID){
        super(spotID);
    }
    @Override
    public boolean canFitVehicle(Vehicle vehicle){
        return VehicleType.CAR==vehicle.getVehicleType();
    }
}
