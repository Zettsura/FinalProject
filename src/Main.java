import vehicle.*;
import file.*;
import search.Search;
import auth.*;
import menu.Menu;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Authentication auth = new Authentication();
        VehicleFileHandler vfh = new VehicleFileHandler();

        List<Vehicle> vehicleList = vfh.load();

        Menu menu = new Menu(vehicleList, auth);
        menu.loginMenu();
        menu.menuOptions();
    }
}