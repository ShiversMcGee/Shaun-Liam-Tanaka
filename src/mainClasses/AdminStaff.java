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
import java.util.Date;

/**
 *
 * @author smhowells
 */
public class AdminStaff extends Staff implements Serializable {

    public AdminStaff(String firstName, String lastName, String staffID,
            String email, String address, String postcode, Boolean canDrive, LocalDate DOB) {
        super(firstName, lastName, staffID, email, address, postcode, canDrive, DOB);
    }

    public ArrayList<Rental> getRentedOutHistory() {
        ArrayList<Rental> rentals = new ArrayList<>();

        for (Rental currentRental : TransportSystem.getInstance().getRentalHistory()) {
            if (currentRental.getAdminID() == this.staffID) {
                rentals.add(currentRental);
            }
        }
        return rentals;

    }
    
    @Override
    public StaffType getStaffType() 
    {
        return StaffType.admin;
    }

}
