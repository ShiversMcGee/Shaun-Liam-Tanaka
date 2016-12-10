/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.util.ArrayList;
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

    private static ArrayList<Service> serviceHistory = new ArrayList<>();

    private Date serviceStartDate;
    private String staffID;
    private Vehicle vehicle;
    private Boolean vehicleDamaged;
    private Date serviceEndDate;

    public Service(Date serviceStartDate, ServiceStaff serviceStaff,
            Vehicle vehicle, Boolean vehicleDamaged) {
        this.serviceStartDate = serviceStartDate;
        this.staffID = serviceStaff.getStaffID();
        this.vehicle = vehicle;
        this.vehicleDamaged = vehicleDamaged;

        Service.serviceHistory.add(this);
    }

    public static ArrayList<Service> getServiceHistory() {
        return Service.serviceHistory;
    }

    public void setServiceEndDate(Date serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
        notifyObservers();
    }

    public Date getServiceStartDate() {
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
