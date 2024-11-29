package file;

import vehicle.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    static public void save(List<Vehicle> vehicleList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(vehicleListFile))) {
            for (Vehicle vehicle : vehicleList) {
                bw.write("vehicleId: "        + vehicle.getVehicleId()        + "\n");
                bw.write("carType: "          + vehicle.getCarType()          + "\n");
                bw.write("carBrand: "         + vehicle.getCarBrand()         + "\n");
                bw.write("modelId: "          + vehicle.getModelId()          + "\n");
                bw.write("color: "            + vehicle.getColor()            + "\n");
                bw.write("fuelType: "         + vehicle.getFuelType()         + "\n");
                bw.write("transmissionType: " + vehicle.getTransmissionType() + "\n");
                bw.write("passLim: "          + vehicle.getPassLim()          + "\n");
                bw.write("mileageLim: "       + vehicle.getMileageLim()       + "\n");
                bw.write("basePrice: "        + vehicle.getBasePrice()        + "\n");
                bw.write("isRented: "         + vehicle.getIsRented()         + "\n");
                bw.write("canOffRoad: "       + vehicle.getCanOffRoad()       + "\n");
                bw.write("towingCap: "        + vehicle.getTowingCap()        + "\n");
                bw.write("truckBedCap: "      + vehicle.getTruckBedCap()      + "\n");
                bw.write("torque: "           + vehicle.getTorque()           + "\n");
                bw.write("storageLim: "       + vehicle.getStorageLim()       + "\n");
                bw.write("hasExtraSeats: "    + vehicle.getHasExtraSeats()    + "\n");
                bw.write("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: Properly handle exceptions
    public List<Vehicle> load() {
        List<Vehicle> vehicleList = new ArrayList<>();

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
                    case "carType" -> temp.setCarType(value);
                    case "carBrand" -> temp.setCarBrand(value);
                    case "modelId" -> temp.setModelId(value);
                    case "color" -> temp.setColor(value);
                    case "fuelType" -> temp.setFuelType(value);
                    case "transmissionType" -> temp.setTransmissionType(value);
                    case "passLim" -> temp.setPassLim(Integer.parseInt(value));
                    case "mileageLim" -> temp.setMileageLim(Double.parseDouble(value));
                    case "basePrice" -> temp.setBasePrice(Double.parseDouble(value));
                    case "isRented" -> temp.setIsRented(Boolean.parseBoolean(value));
                    case "canOffRoad" -> temp.setCanOffRoad(Boolean.parseBoolean(value));
                    case "towingCap" -> temp.setTowingCap(Double.parseDouble(value));
                    case "truckBedCap" -> temp.setTruckBedCap(Double.parseDouble(value));
                    case "torque" -> temp.setTorque(Integer.parseInt(value));
                    case "storageLim" -> temp.setStorageLim(Integer.parseInt(value));
                    case "hasExtraSeats" -> temp.setHasExtraSeats(Boolean.parseBoolean(value));

                    default -> throw new IllegalStateException("Unexpected value: " + key);
                }
            }

        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return vehicleList;
    }
}
