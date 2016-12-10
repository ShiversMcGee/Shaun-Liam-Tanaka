/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author smhowells
 */
public abstract class Staff {

    String firstName;
    String lastName;
    String staffID;
    String email;
    String address;
    String postcode;
    Boolean canDrive;
    Date DOB;
    private ArrayList<Rental> rentalHistory;
    private ArrayList<String> staffNotes;

    public ArrayList<String> getStaffNotes() {
        return staffNotes;
    }

    public Boolean addStaffNotes(String note) {
        boolean result = false;
        if (note != null) {
            if (this.staffNotes == null) {
                this.staffNotes = new ArrayList<>();
            }
            this.staffNotes.add(note);
            result = true;
        }
        return result;
    }

    public Boolean deleteStaffNote(String note) {
        Boolean result = false;
        if (note != null) {
            if (staffNotes != null) {
                if (staffNotes.contains(note)) {
                    staffNotes.remove(note);
                    result = true;
                }
            }
        }
        return result;
    }

    public Boolean giveRental(AdminStaff admin, Vehicle vehicle, Date startDate, Duration duration) {
        Boolean result = false;
        if (admin != null && vehicle != null && startDate != null && duration != null) {
            if (!admin.getStaffID().equals(this.staffID)) {
                Rental rental = new Rental(admin.getStaffID(), this.staffID, vehicle, startDate, duration);
                if (this.rentalHistory == null) {
                    this.rentalHistory = new ArrayList<>();
                }
                rentalHistory.add(rental);
                admin.addRentedOutHistory(rental);
                result = true;
            }
        }
        return result;
    }

    public Boolean returnRental(Rental rental, Date returnDate) {
        Boolean result = false;
        if (rental != null && returnDate != null) {
            if (rentalHistory != null) {
                if (rentalHistory.contains(rental)) {
                    int index = rentalHistory.indexOf(rental);
                    rentalHistory.get(index).setReturnedDate(returnDate);
                    result = true;
                }
            }

        }
        return result;
    }

    public ArrayList<Rental> getRentalHistory() {
        return this.rentalHistory;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Boolean getCanDrive() {
        return canDrive;
    }

    public void setCanDrive(Boolean canDrive) {
        this.canDrive = canDrive;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
}
