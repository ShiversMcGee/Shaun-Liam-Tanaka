/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
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

    private static ArrayList<Rental> rentalHistory = new ArrayList<>();
    
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
        
        Rental.rentalHistory.add(this);
        
    }

    public static ArrayList<Rental> getRentalHistory() {
        return Rental.rentalHistory;
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
