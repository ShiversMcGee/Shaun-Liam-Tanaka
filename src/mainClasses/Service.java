/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import utilities.IObserver;
import utilities.ISubject;

/**
 *
 * @author smhowells
 */
public class Service implements ISubject, Serializable {

    private ArrayList<IObserver> observers = null;
    private LocalDate serviceStartDate;
    private String staffID;
    private Vehicle vehicle;
    private Boolean vehicleDamaged;
    private LocalDate serviceEndDate;

    public Service(LocalDate serviceStartDate, ServiceStaff serviceStaff,
            Vehicle vehicle, Boolean vehicleDamaged) {
        this.serviceStartDate = serviceStartDate;
        this.staffID = serviceStaff.getStaffID();
        this.vehicle = vehicle;
        this.vehicleDamaged = vehicleDamaged;

        TransportSystem.getInstance().addServiceToList(this);
    }


    public void setServiceEndDate(LocalDate serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
        notifyObservers();
    }

    public LocalDate getServiceStartDate() {
        return serviceStartDate;
    }

    public String getStaffID() {
        return staffID;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public Boolean getVehicleDamaged() {
        return vehicleDamaged;
    }

    public LocalDate getServiceEndDate() {
        return serviceEndDate;
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
