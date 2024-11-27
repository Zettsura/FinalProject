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
                "vehicleId: "       + vehicle.vehicleId     + ",\n"
                + "carModel: "      + vehicle.carModel      + ",\n"
                + "modelId: "       + vehicle.modelId       + ",\n"
                + "color: "         + vehicle.color         + ",\n"
                + "fuelType: "      + vehicle.fuelType      + ",\n"
                + "isAutomatic: "   + vehicle.isAutomatic   + ",\n"
                + "passLim: "       + vehicle.passLim       + ",\n"
                + "mileageLim: "    + vehicle.mileageLim    + ",\n"
                + "basePrice: "     + vehicle.basePrice     + ",\n"
                + "isRented: "      + vehicle.isRented      + ",\n"
                + "\n"
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Vehicle> load() {
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
        try (BufferedReader br = new BufferedReader(new FileReader(vehicleListFile))){
            ArrayList<String> stringList = new ArrayList<String>();
            String strLine;
            while ((strLine = br.readLine()) != null) {
                int start = strLine.lastIndexOf(" ");
                int end = strLine.indexOf(",");

                if (start != -1 && end != -1) {
                    String property = strLine.substring(start+1, end);
                    stringList.add(property);
                }
            }

            for (String string : stringList) {
                System.out.println(string);
            }


        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return vehicleList;
    }
}
