/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import enumerations.Manufacturer;
import enumerations.TransmissionType;
import enumerations.VehicleType;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author smhowells
 */
public class Vehicle {

    private int seats;
    private int doors;
    private Manufacturer manufacturer;
    private String licensePlate;
    private Date lastServiceDate;
    private Date nextServiceDate;
    private TransmissionType transmission;
    private String physicalState;
    private Boolean available;
    private VehicleType vehicleType;
    private Boolean rentalState;
    private Boolean forSale;
    private Boolean damaged;
    private int parkingSpot;
    private ArrayList<Service> serviceHistory;

    public ArrayList<Service> getServiceHistory() {
        return serviceHistory;
    }

    public Boolean addServiceHistory(Service service) {
        Boolean result = false;
        if (service != null) {
            if (this.serviceHistory == null) {
                serviceHistory = new ArrayList<>();
            }
            this.serviceHistory.add(service);
            result = true;
        }
        return result;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public Date getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(Date nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public String getPhysicalState() {
        return physicalState;
    }

    public void setPhysicalState(String physicalState) {
        this.physicalState = physicalState;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Boolean getRentalState() {
        return rentalState;
    }

    public void setRentalState(Boolean rentalState) {
        this.rentalState = rentalState;
    }

    public Boolean getForSale() {
        return forSale;
    }

    public void setForSale(Boolean forSale) {
        this.forSale = forSale;
    }

    public Boolean getDamaged() {
        return damaged;
    }

    public void setDamaged(Boolean damaged) {
        this.damaged = damaged;
    }

    public int getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(int parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
