/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClasses;

import java.util.ArrayList;

/**
 *
 * @author Shivers
 */
public class CarPark {

    private static ArrayList<Vehicle> vehicleList = new ArrayList<>();

    private int numberOfSpace = 100;

    CarPark carPark;

    public CarPark getInstance() {
        if (carPark == null) {
            carPark = new CarPark();
        }
        return carPark;
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

}
