/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.time.Duration;
import java.util.Date;
import utilities.IObserver;
import utilities.ISubject;
import utilities.SubjectImpl;

/**
 *
 * @author smhowells
 */
public class Rental implements ISubject {

    private ISubject subject = new SubjectImpl();

    private String staffID;
    private String adminID;
    private Date startDate;
    private Duration duration;
    private Vehicle vehicle;
    private Date returnedDate;
    private String rentalDescription;

    public Rental(String adminID, String staffID, Vehicle vehicle, Date startDate, Duration duration) {
        this.adminID = adminID;
        this.staffID = staffID;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.duration = duration;

    }

    public void setReturnedDate(Date returnedDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public String getRentalDescription() {
        return rentalDescription;
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
