/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author smhowells
 */
public class ServiceStaff extends Staff {

    private ArrayList<Service> serviceHistory;

    public ServiceStaff(String firstName, String lastName, String staffID,
            String email, String address, String postcode, Boolean canDrive, Date DOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffID = staffID;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.canDrive = canDrive;
        this.DOB = DOB;
    }

    public Boolean addServiceHistory(Service service) {
        Boolean result = false;
        if (result) {
            if (this.serviceHistory == null) {
                serviceHistory = new ArrayList<>();
            }
            this.serviceHistory.add(service);
            result = true;
        }
        return result;
    }

    public ArrayList<Service> getServiceHistory() {
        return serviceHistory;

    }

}
