/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.time.LocalDate;
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
    LocalDate DOB;
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

    public ArrayList<Rental> getRentalHistory() {
        ArrayList<Rental> rentals = new ArrayList<>();

        for (Rental currentRental : Rental.getRentalHistory()) {
            if (currentRental.getStaffID() == this.staffID) {
                rentals.add(currentRental);
            }
        }
        return rentals;
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

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
}
