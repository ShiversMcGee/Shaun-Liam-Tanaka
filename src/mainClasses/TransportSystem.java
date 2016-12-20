/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utilities.IObserver;
import utilities.ISubject;

/**
 *
 * @author Shivers
 */
public class TransportSystem implements Serializable, ISubject, IObserver {

    private transient ArrayList<IObserver> observers = null;

    private ArrayList<Vehicle> vehicleList = new ArrayList<>();

    private ArrayList<Staff> staffMembers = new ArrayList<>();

    private ArrayList<Rental> rentalHistory = new ArrayList<>();

    private ArrayList<Service> serviceHistory = new ArrayList<>();

    private AdminStaff currentAdmin;

    private int numberOfSpaces = 100;

    static TransportSystem transportSystem;

    public static TransportSystem getInstance() {
        if (transportSystem == null) {
            transportSystem = new TransportSystem();
        }
        return transportSystem;
    }

    public void setCurrentAdmin(AdminStaff currentAdmin) {
        this.currentAdmin = currentAdmin;
    }

    public AdminStaff getCurrentAdmin() {
        return this.currentAdmin;
    }

    public static void setTransportSystem(TransportSystem newTransportSystem) {
        transportSystem = newTransportSystem;
    }

    public ArrayList<Staff> getStaffList() {
        return staffMembers;
    }

    public void addRentalToList(Rental rental) {
        if (rental != null) {
            rentalHistory.add(rental);
            rental.registerObserver(this);
            this.notifyObservers();
        }
    }

    public void addServiceToList(Service service) {
        if (service != null) {
            serviceHistory.add(service);
            service.registerObserver(this);
            this.notifyObservers();
        }
    }

    public void addStaffToList(Staff staff) {
        if (staff != null) {
            staffMembers.add(staff);
            staff.registerObserver(this);
            this.notifyObservers();
        }
    }

    public void addCarToList(Vehicle vehicle) {
        if (vehicle != null) {
            vehicleList.add(vehicle);
            vehicle.registerObserver(this);
            this.notifyObservers();
        }
    }

    public ArrayList<Vehicle> getVehicleList() {
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

    public ArrayList<Service> getServiceHistory() {
        return serviceHistory;
    }

    public ArrayList<Rental> getRentalHistory() {
        return rentalHistory;
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
            if (currentVehicle.isForSale()) {
                tempArray.add(currentVehicle);
            }
        }
        return tempArray;
    }

    public ArrayList<Vehicle> getDamaged() {
        ArrayList<Vehicle> tempArray = new ArrayList<>();
        for (Vehicle currentVehicle : vehicleList) {
            if (currentVehicle.isDamaged()) {
                tempArray.add(currentVehicle);
            }
        }
        return tempArray;
    }

    public ArrayList<Vehicle> getAvailable() {
        ArrayList<Vehicle> tempArray = new ArrayList<>();
        for (Vehicle currentVehicle : vehicleList) {
            if (currentVehicle.isAvailable()) {
                tempArray.add(currentVehicle);
            }
        }
        return tempArray;
    }

    @Override
    public Boolean registerObserver(IObserver o) {
        Boolean blnAdded = false;
        if (o != null) {
            if (this.observers == null) {
                this.observers = new ArrayList<>();
            }
            if (!this.observers.contains(o)) {
                blnAdded = this.observers.add(o);
            }
            if (blnAdded) {
                for (Vehicle currentVehicle : this.vehicleList) {
                    currentVehicle.registerObserver(this);
                }
                for (Staff currentStaff : this.staffMembers) {
                    currentStaff.registerObserver(this);
                }
                for (Rental currentRental : this.rentalHistory) {
                    currentRental.registerObserver(this);
                }
                for (Service currentService : this.serviceHistory) {
                    currentService.registerObserver(this);
                }
            }
        }
        return blnAdded;
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        Boolean blnRemoved = false;
        //Validate we have something to remove
        if (o != null) {
            if (this.observers != null && this.observers.size() > 0) {
                blnRemoved = this.observers.remove(o);
            }
        }
        return blnRemoved;
    }

    @Override
    public void notifyObservers() {
        //Ensure we have a valid list of observers
        if (this.observers != null && this.observers.size() > 0) {
            //Start foreach loop
            for (IObserver currentObserver : this.observers) {
                //Call update on this observer
                currentObserver.update();
            }
        }
    }

    @Override
    public void update() {
        this.notifyObservers();
    }

}
