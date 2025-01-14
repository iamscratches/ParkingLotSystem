package util;
import model.vehicle.Vehicle;
public interface ParkingFeeCalculator {
    double calculateFee(Vehicle vehicle, long duration);
}
