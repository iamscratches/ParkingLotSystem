package manager;

import java.util.*;

import model.ParkingLevel;
import model.spot.ParkingSpot;
import model.vehicle.Vehicle;
import util.ParkingFeeCalculator;

public class ParkingLotManager {
    private List<ParkingLevel> levels;
    private ParkingFeeCalculator parkingFeeCalculator;
    public ParkingLotManager(List<ParkingLevel> parkingLevels, ParkingFeeCalculator parkingFeeCalculator) {
        this.levels = parkingLevels;
        this.parkingFeeCalculator = parkingFeeCalculator;
    }

    public List<ParkingLevel> getLevels() {
        return levels;
    }



    public void setLevels(List<ParkingLevel> levels) {
        this.levels = levels;
    }



    public ParkingFeeCalculator getParkingFeeCalculator() {
        return parkingFeeCalculator;
    }



    public void setParkingFeeCalculator(ParkingFeeCalculator parkingFeeCalculator) {
        this.parkingFeeCalculator = parkingFeeCalculator;
    }



    public ParkingSpot allocateSpot(Vehicle vehicle){
        ParkingSpot spot;
        for(ParkingLevel parkingLevel: levels){
            spot = parkingLevel.findAvailableSpot(vehicle);
            if(spot!=null){
                spot.parkVehicle();
                return spot;
            }
        }
        throw new IllegalStateException("No available spot for the vehicle");
    }

    public double releaseSpot(ParkingSpot spot, Vehicle vehicle, long duration){
        spot.freeSpot();
        return parkingFeeCalculator.calculateFee(vehicle, duration);
    }

    @Override
    public String toString() {
        return "ParkingLotManager [levels=" + levels + "]";
    }
}
