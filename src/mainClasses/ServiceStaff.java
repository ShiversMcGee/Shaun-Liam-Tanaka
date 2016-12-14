/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import enumerations.StaffType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author smhowells
 */
public class ServiceStaff extends Staff {


    public ServiceStaff(String firstName, String lastName, String staffID,
            String email, String address, String postcode, Boolean canDrive, LocalDate DOB) {
        super(firstName, lastName, staffID, email, address, postcode, canDrive, DOB);
    }

    public ArrayList<Service> getServiceHistory() {
                ArrayList<Service> services = new ArrayList<>();

        for (Service currentService : CarPark.getServiceHistory()) {
            if (currentService.getStaffID() == this.staffID) {
                services.add(currentService);
            }
        }
        return services;

    }
    
    @Override
    public StaffType getStaffType() 
    {
        return StaffType.service;
    }

}
