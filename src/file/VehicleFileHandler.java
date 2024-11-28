package file;

import vehicle.Vehicle;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

// TODO: add explicit throw if file operation fails
public class VehicleFileHandler extends FileManager {
    private File vehicleListFile;
    public VehicleFileHandler() {
        super();
        vehicleListFile = new File(getFilePath() + "/user_list.txt");
        try {
            boolean status;
            if (!vehicleListFile.exists()) {
                status = vehicleListFile.createNewFile();
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void save(Vehicle vehicle) {
        String test = "tes\nt";
        try (FileWriter fw = new FileWriter(vehicleListFile, true);){
            fw.write(
                "vehicleId: "       + vehicle.vehicleId     + "\n"
                + "carModel: "      + vehicle.carModel      + "\n"
                + "modelId: "       + vehicle.modelId       + "\n"
                + "color: "         + vehicle.color         + "\n"
                + "fuelType: "      + vehicle.fuelType      + "\n"
                + "isAutomatic: "   + vehicle.isAutomatic   + "\n"
                + "passLim: "       + vehicle.passLim       + "\n"
                + "mileageLim: "    + vehicle.mileageLim    + "\n"
                + "basePrice: "     + vehicle.basePrice     + "\n"
                + "isRented: "      + vehicle.isRented      + "\n"
                + "\n"
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Vehicle> load() {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(vehicleListFile))){
            ArrayList<String> stringList = new ArrayList<>();
            String strLine;
            long vehicleID = 0;
            String carModel = "";     //brand
            String modelId = "";
            String color = "";        // Red, White, Blue, Yellow, Black, Pink, Green
            String fuelType = "";     // Diesel, Unleaded, High Octane
            boolean isAutomatic = false;
            int passLim = 0;
            double mileageLim = 0;
            double basePrice = 0;
            boolean isRented = false;
            while ((strLine = br.readLine()) != null) {

                if (strLine.isEmpty()) {
                    vehicleList.add(new Vehicle(vehicleID, carModel, color, fuelType, isAutomatic, modelId, passLim, mileageLim, basePrice, isRented));
                    continue;
                }

                String[] buffer = strLine.split(":");
                String key = buffer[0].trim();
                String value = buffer[1].trim();

                switch (key) {
                    case "vehicleId" -> vehicleID = Long.parseLong(value);
                    case  "carModel" -> carModel = value;
                    case  "modelId" -> modelId = value;
                    case  "color" -> color = value;
                    case  "fuelType" -> fuelType = value;
                    case  "isAutomatic" -> isAutomatic = Boolean.parseBoolean(value);
                    case  "passLim" -> passLim = Integer.parseInt(value);
                    case  "mileageLim" -> mileageLim = Double.parseDouble(value);
                    case  "basePrice" -> basePrice = Double.parseDouble(value);
                    case  "isRented" -> isRented = Boolean.parseBoolean(value);
                    default -> throw new IllegalStateException("Unexpected value: " + key);
                }

            }

//            for (String string : stringList) {
//                System.out.println(string);
//            }

        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return vehicleList;
    }
}
