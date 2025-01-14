package manager;

import java.time.LocalDateTime;
import java.util.*;

import model.ParkingSpot;
import model.Reservation;
import model.vehicle.Vehicle;

public class ReservationManager {
    private Map<String, Reservation> reservations;

    public ReservationManager(){
        reservations = new HashMap<>();
    }

    public Reservation createReservation(Vehicle vehicle, ParkingSpot spot, LocalDateTime starTime, LocalDateTime endTime){
        for(Reservation r: reservations.values()){
            if(r.getParkingSpot().equals(spot) && (r.isActive(starTime) || r.isActive(endTime))){
                throw new IllegalStateException("Spot is not available for reservation");
            }
        }
        if(spot.isAvailable()){
            throw new IllegalStateException("Spot is not available for reservation");
        }
        String reservationID = "RES-"+System.currentTimeMillis();
        Reservation reservation = new Reservation(reservationID, vehicle, spot, starTime, endTime);
        reservations.put(reservationID, reservation);
        return reservation;
    }
    public void cancelReservation(String reservationID){
        Reservation reservation = reservations.get(reservationID);
        if(reservation!=null){
            reservations.remove(reservation.getReservationID());
        }
    }

    @Override
    public String toString() {
        return "ReservationManager [reservations=" + reservations + "]";
    }
    
}
