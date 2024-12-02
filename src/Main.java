import vehicle.*;
import file.*;
import auth.*;
import menu.Menu;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        Authentication auth = new Authentication();
        VehicleFileHandler vfh = new VehicleFileHandler();
        List<Vehicle> vehicleList = vfh.load();
        Menu menu = new Menu(vehicleList, auth);

        if (vehicleList.isEmpty()) {
            menu.initializeVehicles(vehicleList);
            VehicleFileHandler.save(vehicleList);
        }

        VehicleFileHandler.save(vehicleList);

        menu.loginMenu();
    }
}

