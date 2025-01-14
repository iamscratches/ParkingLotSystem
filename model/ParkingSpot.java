package model;

import java.time.LocalDateTime;
import java.util.*;

import model.vehicle.Vehicle;

public abstract class ParkingSpot {
    private String spotID;
    private boolean available;
    public ParkingSpot(String spotID){
        this.spotID = spotID;
        this.available = true;
    }
    public String getSpotID() {
        return spotID;
    }
    public void setSpotID(String spotID) {
        this.spotID = spotID;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public void parkVehicle(){
        this.available=false;
    }
    public void freeSpot(){
        this.available=true;
    }
    public abstract boolean canFitVehicle(Vehicle vehicle);
    @Override
    public String toString() {
        return "ParkingSpot [spotID=" + spotID + ", available=" + available + "]";
    }
   
    
    
}
