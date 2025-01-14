package model.vehicle;

import model.VehicleType;

public abstract class Vehicle {
    private String licensePlateNo;
    private VehicleType vehicleType;
    private String ownerName;
    
    public Vehicle(String licensePlateNo, VehicleType vehicleType, String ownerName) {
        this.licensePlateNo = licensePlateNo;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
    }
    public String getLicensePlateNo() {
        return licensePlateNo;
    }
    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    @Override
    public String toString() {
        return "Vehicle [licensePlateNo=" + licensePlateNo + ", vehicleType=" + vehicleType + "]";
    }
    
}
