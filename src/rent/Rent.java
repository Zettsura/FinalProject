package rent;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import auth.Authentication;
import file.VehicleFileHandler;
import vehicle.*;

public class Rent {
    private List<Vehicle> vehicleList;
    private List<Vehicle> availableVehicleList;
    private HashMap<Long, Vehicle> vehicleHashMap;
    protected java.time.LocalTime dateRented = java.time.LocalTime.now();

    public Rent() {}
    public Rent(List<Vehicle> vehicles) {
        this.vehicleList = vehicles;
        availableVehicleList = vehicles.stream().filter(vehicle -> !vehicle.getIsRented()).toList();
        vehicleHashMap = new HashMap<>(vehicles.stream().collect(Collectors.toMap(Vehicle::getVehicleId, vehicle -> vehicle)));
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

    public List<Vehicle> getAllVehicles() {
        return vehicleList;
    }

    public void returnCar(long vehicleId){
        for (Vehicle v : getAllVehicles()){
            if(v.getVehicleId() == vehicleId){
                v.setIsRented(false);
                updateRentedVehicleList();
                VehicleFileHandler.save(getRentedVehicleList());
                break;
            }
        }
    }
}
