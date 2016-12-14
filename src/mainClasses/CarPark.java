/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Shivers
 */
public class CarPark implements Serializable {

    private static ArrayList<Vehicle> vehicleList = new ArrayList<>();

    private static ArrayList<Staff> staffMembers = new ArrayList<>();

    private static ArrayList<Rental> rentalHistory = new ArrayList<>();

    private static ArrayList<Service> serviceHistory = new ArrayList<>();

    private int numberOfSpaces = 100;

    static CarPark carPark;

    public static CarPark getInstance() {
        if (carPark == null) {
            carPark = new CarPark();
        }
        return carPark;
    }

    public ArrayList<Staff> getStaffList() {
        return staffMembers;
    }

    public static void addRentalToList(Rental rental) {
        if (rental != null) {
            CarPark.rentalHistory.add(rental);
        }
    }

    public static void addServiceToList(Service service) {
        if (service != null) {
            CarPark.serviceHistory.add(service);
        }
    }

    public static void addStaffToList(Staff staff) {
        if (staff != null) {
            CarPark.staffMembers.add(staff);
        }
    }

    public static void addCarToList(Vehicle vehicle) {
        if (vehicle != null) {
            CarPark.vehicleList.add(vehicle);
        }
    }

    public static ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public int getNumberOfSpaces() {
        return numberOfSpaces;
    }

    public Boolean checkSpace(int space) {
        Boolean result = true;

        for (Vehicle currentVehicle : vehicleList) {
            if (currentVehicle.getParkingSpot() == space) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static ArrayList<Service> getServiceHistory() {
        return CarPark.serviceHistory;
    }

    public static ArrayList<Rental> getRentalHistory() {
        return CarPark.rentalHistory;
    }

    public ArrayList<Vehicle> getToBeServiced() {
        ArrayList<Vehicle> tempArray = new ArrayList<>();
        for (Vehicle currentVehicle : vehicleList) {
            if (currentVehicle.getToBeServiced()) {
                tempArray.add(currentVehicle);
            }
        }
        return tempArray;
    }

    public ArrayList<Vehicle> getToBeSold() {
        ArrayList<Vehicle> tempArray = new ArrayList<>();
        for (Vehicle currentVehicle : vehicleList) {
            if (currentVehicle.getForSale()) {
                tempArray.add(currentVehicle);
            }
        }
        return tempArray;
    }

    public ArrayList<Vehicle> getDamaged() {
        ArrayList<Vehicle> tempArray = new ArrayList<>();
        for (Vehicle currentVehicle : vehicleList) {
            if (currentVehicle.getDamaged()) {
                tempArray.add(currentVehicle);
            }
        }
        return tempArray;
    }

    public ArrayList<Vehicle> getAvailable() {
        ArrayList<Vehicle> tempArray = new ArrayList<>();
        for (Vehicle currentVehicle : vehicleList) {
            if (currentVehicle.getAvailable()) {
                tempArray.add(currentVehicle);
            }
        }
        return tempArray;
    }

}
