/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import enumerations.Manufacturer;
import enumerations.TransmissionType;
import enumerations.VehicleType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import utilities.IObserver;
import utilities.ISubject;
import utilities.SubjectImpl;

/**
 *
 * @author smhowells
 */
public class Vehicle implements ISubject, Serializable{

    private int seats;
    private int doors;
    private Manufacturer manufacturer;
    private String licensePlate;
    private Date lastServiceDate;
    private Date nextServiceDate;
    private TransmissionType transmission;
    private String physicalState;
    private Boolean available = true;
    private VehicleType vehicleType;
    private Boolean rentalState = false;
    private Boolean forSale = false;
    private Boolean damaged = false;
    private int parkingSpot;
    private Boolean toBeServiced;
    private ArrayList<IObserver> observers = null;

    
    public Vehicle(VehicleType vehicleType, Manufacturer manufacturer, TransmissionType transmission,
    int seats, int doors, String licensePlate)
    {
        this.vehicleType = vehicleType;
        this.manufacturer = manufacturer;
        this.transmission = transmission;
        this.seats = seats;
        this.doors = doors;
        this.licensePlate = licensePlate;
        
        TransportSystem.getInstance().addCarToList(this);
    }
    
    public Boolean getToBeServiced() {
        return toBeServiced;
    }

    public void setToBeServiced(Boolean toBeServiced) {
        this.toBeServiced = toBeServiced;
        notifyObservers();
    }

    public ArrayList<Service> getServiceHistory() {
                ArrayList<Service> services = new ArrayList<>();

        for (Service currentService : TransportSystem.getInstance().getServiceHistory()) {
            if (currentService.getVehicle() == this) {
                services.add(currentService);
            }
        }
        return services;

    }
    
    
    public int getSeats() {
        return seats;
    }


    public int getDoors() {
        return doors;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }


    public String getLicensePlate() {
        return licensePlate;
    }


    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
        notifyObservers();
    }

    public Date getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(Date nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
        notifyObservers();
    }

    public TransmissionType getTransmission() {
        return transmission;
    }


    public String getPhysicalState() {
        return physicalState;
    }

    public void setPhysicalState(String physicalState) {
        this.physicalState = physicalState;
        notifyObservers();
    }

    public void setAllStates(Boolean available, Boolean forSale, Boolean damaged)
    {
        this.available = available;
        this.forSale = forSale;
        this.damaged = damaged;
        notifyObservers();
    }
    
    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
        notifyObservers();
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Boolean getRentalState() {
        return rentalState;
    }

    public void setRentalState(Boolean rentalState) {
        this.rentalState = rentalState;
        notifyObservers();
    }

    public Boolean isForSale() {
        return forSale;
    }

    public void setForSale(Boolean forSale) {
        this.forSale = forSale;
        notifyObservers();
    }

    public Boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(Boolean damaged) {
        this.damaged = damaged;
        notifyObservers();
    }

    public int getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(int parkingSpot) {
        this.parkingSpot = parkingSpot;
        notifyObservers();
    }

    @Override
    public Boolean registerObserver(IObserver o)
    {
        Boolean blnAdded = false;                
        if (o != null)
        {
            if (this.observers == null)
            {
                this.observers = new ArrayList<>();
            }
            if (!this.observers.contains(o))
            {
                blnAdded = this.observers.add(o);
            }
        }
        return blnAdded;
    }

    @Override
    public Boolean removeObserver(IObserver o)
    {
        Boolean blnRemoved = false;
        if (o != null)
        {
            if (this.observers != null && this.observers.size() > 0)
            {
                blnRemoved = this.observers.remove(o);
            }
        }
        return blnRemoved;
    }

    @Override
    public void notifyObservers()
    {
        if (this.observers != null && this.observers.size() > 0)
        {
            for (IObserver currentObserver : this.observers)
            {
                currentObserver.update();
            }
        }
    }
}
