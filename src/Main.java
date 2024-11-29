import menu.Menu;
import vehicle.*;
import file.*;
import search.Search;
import auth.*;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        // Actual
        VehicleFileHandler vfh = new VehicleFileHandler();
        Menu menu = new Menu();
        menu.loginMenu();

        // FOR TESTING
        Vehicle sedan1 = new Vehicle(102412412L, "Sedan", "Suzuki", "1.3-CLE-CVT", "Red", "Diesel", "Manual", 5, 523.42, 2000.1, true, false, 200.1, 0.0, 500, 300, false);
        Vehicle sedan2 = new Vehicle(102423415L, "Sedan", "Tonda", "2025-Tivic-Sport-Sedan", "Black", "Unleaded", "Automatic", 5, 643.73, 1234.1, false, true, 0.0, 0.0, 10, 400, false);
        Vehicle sedan3 = new Vehicle(102473345L, "Sedan", "Pooschie", "Panamera", "Blue", "Diesel", "Manual", 5, 895.152, 5000.1, false, true, 0.0, 0.0, 20, 200, true);

        List<Vehicle>  vehicles = new ArrayList<>();
        vehicles.add(sedan1);
        vehicles.add(sedan2);
        vehicles.add(sedan3);

        VehicleFileHandler.save(vehicles);
        List<Vehicle> filtered = Search.filterByColor(vfh.load(), "Red");
        for (Vehicle vehicle : filtered) {
            System.out.println(vehicle.getCarBrand() + " Color: " + vehicle.getColor());
        }

//        User user = new User(12L, "Adrian", "adrian@gmail.com", "1234", 12L);
//        auth.register(user);
//        auth.login("adrian@gmail.com", "1234");
//        System.out.println(Authentication.getAuthenticatedUser().getName());
    }
}