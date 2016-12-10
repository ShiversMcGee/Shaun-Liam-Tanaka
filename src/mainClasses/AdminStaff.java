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
public class AdminStaff extends Staff {

    public AdminStaff(String firstName, String lastName, String staffID,
            String email, String address, String postcode, Boolean canDrive, LocalDate DOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffID = staffID;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.canDrive = canDrive;
        this.DOB = DOB;
    }

    public ArrayList<Rental> getRentedOutHistory() {
        ArrayList<Rental> rentals = new ArrayList<>();

        for (Rental currentRental : Rental.getRentalHistory()) {
            if (currentRental.getAdminID() == this.staffID) {
                rentals.add(currentRental);
            }
        }
        return rentals;

    }

}
