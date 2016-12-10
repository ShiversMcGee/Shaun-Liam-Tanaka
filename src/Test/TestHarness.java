/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import mainClasses.AdminStaff;
import mainClasses.RegularStaff;
import mainClasses.Rental;
import mainClasses.ServiceStaff;
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
        LocalDate DOB = LocalDate.now();
        AdminStaff staff1 = new AdminStaff("Shaun", "Howells", "1122",
                "shaun.howells@students.plymouth.ac.uk", "Some place", "PL1 1QQ",
                true, DOB);
        System.out.println(staff1.getFirstName() + staff1.getLastName()
                + staff1.getStaffID() + staff1.getEmail() + staff1.getAddress()
                + staff1.getPostcode() + staff1.getCanDrive() + staff1.getDOB());
        ServiceStaff staff2 = new ServiceStaff("Liam", "Chilcott", "3344",
                "liam.chilcott@students.plymouth.ac.uk", "Another place", "PL2 2WW",
                true, DOB);
        System.out.println(staff2.getFirstName() + staff2.getLastName()
                + staff2.getStaffID() + staff2.getEmail() + staff2.getAddress()
                + staff2.getPostcode() + staff2.getCanDrive() + staff2.getDOB());
        RegularStaff staff3 = new RegularStaff("Tanaka", "Mudimu", "5566",
                "tanaka.mudimu@students.plymouth.ac.uk", "Not here", "PL3 3EE",
                true, DOB);
        System.out.println(staff3.getFirstName() + staff3.getLastName()
                + staff3.getStaffID() + staff3.getEmail() + staff3.getAddress()
                + staff3.getPostcode() + staff3.getCanDrive() + staff3.getDOB());

        Vehicle vehicle = new Vehicle();
        Duration duration = Duration.ofDays(1);

        System.out.println("Creating rental!");
        Rental rental1 = new Rental(staff1, staff3, vehicle, DOB, duration);

        IObserver observer = new AnObserver();

        rental1.registerObserver(observer);

        System.out.println(rental1.getStaffID() + rental1.getAdminID() + rental1.getStartDate() + rental1.getDuration());

        ArrayList<Rental> rentList = staff3.getRentalHistory();

        LocalDate newDate = LocalDate.of(2000, Month.MARCH, 2);

        rentList.get(0).setReturnedDate(newDate);

        System.out.println(rentList.get(0).getReturnedDate());
        System.out.println(Rental.getRentalHistory().get(0).getReturnedDate());

        rentList.get(0).setRentalDescription("EYYYY KAPPA POGCHAMP");

        System.out.println(rentList.get(0).getRentalDescription());
        System.out.println(Rental.getRentalHistory().get(0).getRentalDescription());

        ArrayList<Rental> rentedList = staff1.getRentedOutHistory();

        rentedList.get(0).setRentalDescription("O SHIT ITS NYANBOI");

        System.out.println(rentedList.get(0).getRentalDescription());
        System.out.println(Rental.getRentalHistory().get(0).getRentalDescription());

    }

    @Override
    public void update() {
        System.out.println("State Change was detected!");
    }

}
