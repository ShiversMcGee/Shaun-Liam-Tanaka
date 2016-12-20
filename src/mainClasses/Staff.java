/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import enumerations.StaffType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import utilities.IObserver;
import utilities.ISubject;

/**
 *
 * @author smhowells
 */
public class Staff implements Serializable, ISubject{

    
    protected String firstName;
    protected String lastName;
    protected String staffID;
    protected String email;
    protected String address;
    protected String postcode;
    protected Boolean canDrive;
    protected LocalDate DOB;
    protected ArrayList<IObserver> observers = null;
    protected ArrayList<String> staffNotes;
    

        public Staff(String firstName, String lastName, String staffID,
            String email, String address, String postcode, Boolean canDrive, LocalDate DOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffID = staffID;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.canDrive = canDrive;
        this.DOB = DOB;
        
        TransportSystem.getInstance().addStaffToList(this);
    }
    
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
            notifyObservers();
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

        for (Rental currentRental : TransportSystem.getInstance().getRentalHistory()) {
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
        notifyObservers();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyObservers();
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
        notifyObservers();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyObservers();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyObservers();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
        notifyObservers();
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
        notifyObservers();
    }
    
    public StaffType getStaffType()
    {
        return StaffType.regular;
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
