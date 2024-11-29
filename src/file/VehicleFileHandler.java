package file;

import vehicle.Vehicle;

import java.io.*;
import java.util.ArrayList;

// TODO: add explicit throw if file operation fails
public class VehicleFileHandler extends FileManager {
    private static File vehicleListFile;
    public VehicleFileHandler() {
        super();
        vehicleListFile = new File(getFilePath() + "/vehicle_list.txt");
        try {
            boolean status;
            if (!vehicleListFile.exists()) {
                status = vehicleListFile.createNewFile();
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    // TODO: Properly handle exceptions
    static public void save(ArrayList<Vehicle> vehicleList) {
        for (Vehicle vehicle : vehicleList) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(vehicleListFile, true))) {
                bw.write("vehicleId: "   + vehicle.getVehicleId()   + "\n");
                bw.write("carModel: "    + vehicle.getCarModel()    + "\n");
                bw.write("modelId: "     + vehicle.getModelId()     + "\n");
                bw.write("color: "       + vehicle.getColor()       + "\n");
                bw.write("fuelType: "    + vehicle.getFuelType()    + "\n");
                bw.write("isAutomatic: " + vehicle.getIsAutomatic() + "\n");
                bw.write("passLim: "     + vehicle.getPassLim()     + "\n");
                bw.write("mileageLim: "  + vehicle.getMileageLim()  + "\n");
                bw.write("basePrice: "   + vehicle.getBasePrice()   + "\n");
                bw.write("isRented: "    + vehicle.getIsRented()    + "\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // TODO: Properly handle exceptions
    public ArrayList<Vehicle> load() {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(vehicleListFile))){
            String strLine;
            Vehicle temp = new Vehicle();
            while ((strLine = br.readLine()) != null) {

                if (strLine.isEmpty()) {
                    vehicleList.add(temp);
                    temp = new Vehicle();
                    continue;
                }

                String[] buffer = strLine.split(":");
                String key = buffer[0].trim();
                String value = buffer[1].trim();

                switch (key) {
                    case "vehicleId" -> temp.setVehicleId(Long.parseLong(value));
                    case  "carModel" -> temp.setCarModel(value);
                    case  "modelId" -> temp.setModelId(value);
                    case  "color" -> temp.setColor(value);
                    case  "fuelType" -> temp.setFuelType(value);
                    case  "isAutomatic" -> temp.setIsAutomatic(Boolean.parseBoolean(value));
                    case  "passLim" -> temp.setPassLim(Integer.parseInt(value));
                    case  "mileageLim" -> temp.setMileageLim(Double.parseDouble(value));
                    case  "basePrice" -> temp.setBasePrice(Double.parseDouble(value));
                    case  "isRented" -> temp.setIsRented(Boolean.parseBoolean(value));
                    default -> throw new IllegalStateException("Unexpected value: " + key);
                }
            }

        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return vehicleList;
    }
}
