/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.util.Date;
import utilities.IObserver;
import utilities.ISubject;
import utilities.SubjectImpl;

/**
 *
 * @author smhowells
 */
public class Service implements ISubject {

    private ISubject subject = new SubjectImpl();

    private Date serviceStartDate;
    private String serviceStaffID;
    private String staffID;
    private Vehicle vehicle;
    private Boolean vehicleDamaged;
    private Date serviceEndDate;

    public Service(Date serviceStartDate, String serviceStaffID, String staffID,
            Vehicle vehicle, Boolean vehicleDamaged) {
        this.serviceStartDate = serviceStartDate;
        this.serviceStaffID = serviceStaffID;
        this.staffID = staffID;
        this.vehicle = vehicle;
        this.vehicleDamaged = vehicleDamaged;
    }

    public void setServiceEndDate(Date serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
        notifyObservers();
    }

    public Date getServiceStartDate() {
        return serviceStartDate;
    }

    public String getServiceStaffID() {
        return serviceStaffID;
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

    public Date getServiceEndDate() {
        return serviceEndDate;
    }

    @Override
    public Boolean registerObserver(IObserver o) {
        return this.subject.registerObserver(o);
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        return this.subject.removeObserver(o);
    }

    @Override
    public void notifyObservers() {
        this.subject.notifyObservers();
    }

}
