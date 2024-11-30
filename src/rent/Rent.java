package rent;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import auth.Authentication;
import vehicle.*;

public class Rent {
    private List<Vehicle> vehicleList;
    private List<Vehicle> availableVehicleList;
    private HashMap<Long, Vehicle> vehicleHashMap;
    private java.time.LocalTime dateRented = java.time.LocalTime.now();

    public Rent() {}
    public Rent(List<Vehicle> vehicles) {
        vehicleList = vehicles;
        availableVehicleList = vehicles.stream().filter(vehicle -> !vehicle.getIsRented()).toList();
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
            updateRentedVehicleList();
        }
    }

    public void updateRentedVehicleList() {
        availableVehicleList = vehicleList.stream().filter(vehicle -> !vehicle.getIsRented()).toList();
    }

    public List<Vehicle> getRentedVehicleList(){
        return availableVehicleList;
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
