package model;

import java.util.*;

import model.spot.ParkingSpot;
import model.vehicle.Vehicle;
public class ParkingLevel {
    private int levelID;
    private List<ParkingSpot> spots;
    public ParkingLevel(int levelID, List<ParkingSpot> spots) {
        this.levelID = levelID;
        this.spots = spots;
    }
    
    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle){
        for(ParkingSpot spot: spots){
            if(spot.isAvailable() && spot.canFitVehicle(vehicle)){
                return spot;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "ParkingLevel [levelID=" + levelID + ", spots=" + spots + "]";
    }

}
