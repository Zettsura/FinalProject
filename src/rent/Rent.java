package rent;

import java.util.ArrayList;

import vehicle.*;

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
