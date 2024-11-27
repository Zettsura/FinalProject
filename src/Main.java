import vehicle.*;
import file.VehicleFileHandler;

public class Main {
    public static void main (String[] args) {
        System.out.println("Hello");
        Vehicle vehicle = new Vehicle(102412412L, "Yotta", "Black", "Gasoline", false, "1.3-CLE-CVT", 5, 523.42f);

        VehicleFileHandler vfh = new VehicleFileHandler();
        vfh.save(vehicle);
        vfh.load();

    }
}
