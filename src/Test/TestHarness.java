/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.time.Duration;
import java.util.Date;
import mainClasses.AdminStaff;
import mainClasses.RegularStaff;
import mainClasses.Rental;
import mainClasses.Staff;
import mainClasses.Vehicle;
import utilities.AnObserver;
import utilities.IObserver;

/**
 *
 * @author smhowells
 */
public class TestHarness implements IObserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Starting test");
        Date DOB = new Date();
        Staff staff1 = new AdminStaff("Shaun", "Howells", "1122",
                "shaun.howells@students.plymouth.ac.uk", "Some place", "PL1 1QQ",
                true, DOB);
        System.out.println(staff1.getFirstName() + staff1.getLastName()
                + staff1.getStaffID() + staff1.getEmail() + staff1.getAddress()
                + staff1.getPostcode() + staff1.getCanDrive() + staff1.getDOB());
        Staff staff2 = new AdminStaff("Liam", "Chilcott", "3344",
                "liam.chilcott@students.plymouth.ac.uk", "Another place", "PL2 2WW",
                true, DOB);
        System.out.println(staff2.getFirstName() + staff2.getLastName()
                + staff2.getStaffID() + staff2.getEmail() + staff2.getAddress()
                + staff2.getPostcode() + staff2.getCanDrive() + staff2.getDOB());
        Staff staff3 = new RegularStaff("Tanaka", "Mudimu", "5566",
                "tanaka.mudimu@students.plymouth.ac.uk", "Not here", "PL3 3EE",
                true, DOB);
        System.out.println(staff3.getFirstName() + staff3.getLastName()
                + staff3.getStaffID() + staff3.getEmail() + staff3.getAddress()
                + staff3.getPostcode() + staff3.getCanDrive() + staff3.getDOB());

        Vehicle vehicle = new Vehicle();
        Duration duration = Duration.ofDays(1);
        
        System.out.println("Creating rental!");
        Rental rental1 = new Rental(staff1.getStaffID(), staff3.getStaffID(), vehicle, DOB, duration);
        
        IObserver observer = new AnObserver();
        
        rental1.registerObserver(observer);
        
        System.out.println(rental1.getStaffID() + rental1.getAdminID() + rental1.getStartDate() + rental1.getDuration());
        System.out.println("Changing Returned Date!");
        rental1.setReturnedDate(DOB);
        
        
        
    }

    @Override
    public void update() {
        System.out.println("State Change was detected!");
    }

}
