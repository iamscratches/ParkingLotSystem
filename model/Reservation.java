package model;

import java.time.LocalDateTime;

import model.vehicle.Vehicle;

public class Reservation {
    private String reservationID;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    public Reservation(String reservationID, Vehicle vehicle, ParkingSpot parkingSpot, LocalDateTime startTime,
            LocalDateTime endTime) {
        this.reservationID = reservationID;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isActive(LocalDateTime currentTime){
        return currentTime.isAfter(startTime) && currentTime.isBefore(endTime);
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Reservation [reservationID=" + reservationID + ", vehicle=" + vehicle + ", parkingSpot=" + parkingSpot
                + ", startTime=" + startTime + ", endTime=" + endTime + "]";
    }
    
}
