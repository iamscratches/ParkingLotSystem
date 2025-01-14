package util;
import model.vehicle.Vehicle;

public class DefaultFeeCalculator implements ParkingFeeCalculator{
    @Override
    public double calculateFee(Vehicle vehicle, long duration){
        switch (vehicle.getVehicleType()) {
            case BIKE:
                return duration*1.0;
            case CAR:
                return duration*2.0;
            case TRUCK:
                return duration*3.0;
            default:
                return 0.0;
        }
    }
}
