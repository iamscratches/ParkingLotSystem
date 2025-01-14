# Parking Lot Management System

## Overview
This project implements a **Parking Lot Management System** using the principles of **SOLID design**. The system supports:

1. Management of multiple parking levels.
2. Handling of reservations for parking spots.
3. Allocation and release of parking spots based on vehicle types and availability.
4. Calculation of parking fees based on duration and vehicle type.

The design ensures scalability, maintainability, and extensibility by adhering to **Object-Oriented Design (OOD)** principles.

---

## Features

### Core Features
1. **Multiple Levels**: 
   - Supports parking lots with multiple levels, each containing various parking spots.
2. **Vehicle Types**:
   - Manages parking for different types of vehicles such as bikes, cars, and trucks.
3. **Dynamic Spot Allocation**:
   - Allocates parking spots based on availability and vehicle type.
4. **Fee Calculation**:
   - Calculates parking fees dynamically based on parking duration and vehicle type.

### Additional Features
1. **Reservations**:
   - Allows users to reserve parking spots in advance.
   - Prevents reserved spots from being allocated to others.
2. **Conflict Management**:
   - Ensures no overlaps between reservations and dynamic allocations.

---

## Design Principles
This project follows the **SOLID principles** to ensure clean architecture:

1. **Single Responsibility Principle (SRP)**:
   - Each class has a single, well-defined responsibility (e.g., `Vehicle`, `ParkingSpot`, `ParkingFeeCalculator`).

2. **Open-Closed Principle (OCP)**:
   - The system is open for extension but closed for modification. New vehicle or spot types can be added without altering existing code.

3. **Liskov Substitution Principle (LSP)**:
   - Subclasses (`SmallSpot`, `LargeSpot`) can replace their base class (`ParkingSpot`) without breaking functionality.

4. **Interface Segregation Principle (ISP)**:
   - Interfaces are kept small and specific, avoiding unnecessary implementations (e.g., `Parkable`, `Billable`).

5. **Dependency Inversion Principle (DIP)**:
   - High-level modules depend on abstractions, not concrete implementations (e.g., `ParkingFeeCalculator` is an interface).

---

## Class Structure

### Core Classes
1. **Vehicle**:
   - Represents vehicles with attributes like license plate and type.
   - Subclasses: `Bike`, `Car`, `Truck`.

2. **ParkingSpot**:
   - Represents a parking spot with attributes like spot ID, availability, and type.
   - Subclasses: `SmallSpot`, `MediumSpot`, `LargeSpot`.

3. **ParkingLevel**:
   - Manages a collection of parking spots within a single level.

4. **ParkingLotManager**:
   - Orchestrates parking operations across multiple levels.

5. **ParkingFeeCalculator**:
   - Interface for calculating fees. Concrete implementation: `DefaultFeeCalculator`.

### Additional Classes
1. **Reservation**:
   - Represents a reservation for a specific parking spot and time range.

2. **ReservationManager**:
   - Handles reservation creation, cancellation, and conflict checks.

---

## Workflow

### 1. Spot Allocation
- The `ParkingLotManager` iterates through levels to find the first available spot matching the vehicle type.

### 2. Reservations
- The `ReservationManager` reserves a spot for a specified time range, marking it unavailable for others during that time.

### 3. Fee Calculation
- Fees are calculated dynamically using the `ParkingFeeCalculator` interface, factoring in the duration and vehicle type.

---

## Code Example

### Vehicle Class
```java
public abstract class Vehicle {
    private String licensePlate;
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}
```

### ParkingSpot Class
```java
public abstract class ParkingSpot {
    private String spotId;
    private boolean reserved;
    private boolean available;

    public boolean isAvailable() {
        return available && !reserved;
    }

    public void parkVehicle() {
        this.available = false;
    }

    public void freeSpot() {
        this.available = true;
        this.reserved = false;
    }

    public void reserve() {
        this.reserved = true;
    }
}
```

### ReservationManager
```java
public class ReservationManager {
    private Map<String, Reservation> reservations = new HashMap<>();

    public Reservation createReservation(Vehicle vehicle, ParkingSpot spot, LocalDateTime startTime, LocalDateTime endTime) {
        if (spot.isReserved() || !spot.isAvailable()) {
            throw new IllegalStateException("Spot is not available for reservation");
        }
        String reservationId = UUID.randomUUID().toString();
        Reservation reservation = new Reservation(reservationId, vehicle, spot, startTime, endTime);
        reservations.put(reservationId, reservation);
        spot.reserve();
        return reservation;
    }
}
```

---

## Future Enhancements
1. **Dynamic Pricing**:
   - Adjust parking fees based on demand and time of day.
2. **Electric Vehicle (EV) Charging Spots**:
   - Add support for charging spots with tracking of charging time.
3. **Mobile App Integration**:
   - Provide a user-friendly app for reservations and real-time updates.

---

## How to Run
1. Clone the repository.
2. Set up the project in your IDE (e.g., IntelliJ, Eclipse).
3. Run the main class to start the application.
4. Test various scenarios such as spot allocation, reservations, and fee calculations.

---

## Conclusion
This Parking Lot Management System is designed with scalability and extensibility in mind, leveraging SOLID principles to deliver a robust solution. With support for multiple levels and reservations, it meets the requirements of modern parking systems.
