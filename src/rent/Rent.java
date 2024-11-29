package rent;

import java.util.ArrayList;

import vehicle.*;

/**
 * TODO:
 *  - Add map of vehicles
 *  - Add temporary copy of list of vehicles
 *  - Filter rented cars on the temporary copy
 *  - Receives the chosen vehicle from Menu
 *  - Set chosen vehicle as rented
 *  - Set the original object on the vehicle list to the modified vehicle object with the use of map
 *  - Save the original list to file;
 */

public class Rent {
    public ArrayList<Vehicle> vehicleList = new ArrayList<>();
    public java.time.LocalTime dateRented = java.time.LocalTime.now();

    public void mileageLim(float miles){

    }

    public void calcPay(float miles){

    }

    public boolean checkAvailVehicle(Vehicle vehicleList){
        if(!(vehicleList != vehicleList)) {
            return true;
        } else
            return false;
    }

    public double getTotalPay(){
        double pay = 0;

        return pay;
    }
}
