/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;;
import utilities.IObserver;
import utilities.ISubject;

/**
 *
 * @author smhowells
 */
public class Rental implements ISubject, Serializable {

    private ArrayList<IObserver> observers = null;
    private String staffID;
    private String adminID;
    private LocalDate startDate;
    private Duration duration;
    private Vehicle vehicle;
    private LocalDate returnedDate;
    private String rentalDescription;

    public Rental(AdminStaff admin, Staff staff, Vehicle vehicle, LocalDate startDate, Duration duration) {
        this.adminID = admin.getStaffID();
        this.staffID = staff.getStaffID();
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.duration = duration;
        
        
        TransportSystem.getInstance().addRentalToList(this);    
    }


    
    public void setReturnedDate(LocalDate returnedDate) {
        //int index = this.rentalHistory.indexOf(this);
        //this.rentalHistory.get(index).returnedDate = returnedDate;
        this.returnedDate = returnedDate;
        notifyObservers();
    }

    public void setRentalDescription(String rentalDescription) {
        this.rentalDescription = rentalDescription;
        notifyObservers();
    }

    public String getStaffID() {
        return staffID;
    }

    public String getAdminID() {
        return adminID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public String getRentalDescription() {
        return rentalDescription;
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
            /*if (blnAdded)
            {
                for (StockItem currItem : this.arlStockItems)
                {
                    currItem.registerObserver(this);
                }
            }*/
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
