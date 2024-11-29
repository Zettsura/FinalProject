package search;

import java.util.List;
import vehicle.Vehicle;

public class Search {
    public static List<Vehicle> filterByColor(List<Vehicle> list, String color) {
        return  list.stream().filter(vehicle -> vehicle.getColor().equals(color)).toList();
    }
    public static List<Vehicle> filterByBrand(List<Vehicle> list, String brand) {
        return  list.stream().filter(vehicle -> vehicle.getCarBrand().equals(brand)).toList();
    }
    public static List<Vehicle> filterByModel(List<Vehicle> list, String model) {
        return  list.stream().filter(vehicle -> vehicle.getModelId().equals(model)).toList();
    }
    public static List<Vehicle> filterByTransmission(List<Vehicle> list, String transmission) {
        return  list.stream().filter(vehicle -> vehicle.getTransmissionType().equals(transmission)).toList();
    }
    public static List<Vehicle> filterByPrice(List<Vehicle> list, double price) {
        return  list.stream().filter(vehicle -> vehicle.getBasePrice() < price).toList();
    }
    public static List<Vehicle> filterByFuelType(List<Vehicle> list, String fuel) {
        return  list.stream().filter(vehicle -> vehicle.getFuelType().equals(fuel)).toList();
    }
}
