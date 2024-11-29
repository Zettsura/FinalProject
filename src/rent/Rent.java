package rent;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import auth.Authentication;
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
    private List<Vehicle> vehicleList;
    private List<Vehicle> rentedVehicleList;
    private HashMap<Long, Vehicle> vehicleHashMap;
    private java.time.LocalTime dateRented = java.time.LocalTime.now();

    public Rent() {}
    public Rent(List<Vehicle> vehicles) {
        vehicleList = vehicles;
        rentedVehicleList = vehicles.stream().filter(vehicle -> !vehicle.getIsRented()).toList();
        vehicleHashMap = new HashMap<>(vehicles.stream().collect(Collectors.toMap(Vehicle::getVehicleId, vehicle -> vehicle)));
    }

    public void mileageLim(float miles){

    }

    public void calcPay(float miles){

    }

    public void rentCar(long vehicleId) {
        Vehicle vehicle = vehicleHashMap.get(vehicleId);
        if (vehicle != null) {
            vehicle.setIsRented(true);
            Authentication.getAuthenticatedUser().setVehicleId(vehicleId);
        }
    }

    public void updateRentedVehicleList() {
        rentedVehicleList = vehicleList.stream().filter(vehicle -> !vehicle.getIsRented()).toList();
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
