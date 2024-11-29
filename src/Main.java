import vehicle.*;

public class Main {
    public static void main (String[] args) {
        Vehicle sedan1 = new Vehicle(102412412L, "Sedan", "Suzuki", "1.3-CLE-CVT", "Red", "Diesel", "Manual", 5, 523.42, 2000.1, true, false, 200.1, 0, 500, 300, false);
        Vehicle sedan2 = new Vehicle(102423415L, "Sedan", "Tonda", "2025-Tivic-Sport-Sedan", "Black", "Unleaded", "Automatic", 5, 643.73, 1234.1, false, true, 0, 0, 10, 400, false);
        Vehicle sedan3 = new Vehicle(102473345L, "Sedan", "Pooschie", "Panamera", "Blue", "Diesel", "Manual", 5, 895.152, 5000.1, false, true, 0, 0, 20, 200, true);
        String vehicleId = "Vehicle Id", carModel = "Model", color = "Color", fuelType = "Fuel Type", isAutomatic = "Transmission Type", modelId = "Model Id", passLim = "Passenger Limit", mileageLim = "Mileage Limit", canOffRoad = "Off Road Capability";
        System.out.println("Sedan");
        System.out.format("%-15s%-10s%-10s%-15s%-25s%-25s%-20s%-15s%-15s%n", vehicleId, carModel, color, fuelType, isAutomatic, modelId, passLim, mileageLim, canOffRoad);
        System.out.format("%-15s%-10s%-10s%-15s%-25s%-25s%-20s%-15s%-15s%n", sedan1.getVehicleId(), sedan1.getCarModel(), sedan1.getColor(), sedan1.getFuelType(), sedan1.isAutomatic(), sedan1.getModelId(), sedan1.getPassLim(), sedan1.getMileageLim(), sedan1.isCanOffRoad());
        System.out.format("%-15s%-10s%-10s%-15s%-25s%-25s%-20s%-15s%-15s%n", sedan2.getVehicleId(), sedan2.getCarModel(), sedan2.getColor(), sedan2.getFuelType(), sedan2.isAutomatic(), sedan2.getModelId(), sedan2.getPassLim(), sedan2.getMileageLim(), sedan2.isCanOffRoad());
        System.out.format("%-15s%-10s%-10s%-15s%-25s%-25s%-20s%-15s%-15s%n", sedan3.getVehicleId(), sedan3.getCarModel(), sedan3.getColor(), sedan3.getFuelType(), sedan3.isAutomatic(), sedan3.getModelId(), sedan3.getPassLim(), sedan3.getMileageLim(), sedan3.isCanOffRoad());

        System.out.println();
        System.out.println("Van");
        System.out.format("%-15s%-10s%-10s%-15s%-25s%-25s%-20s%-15s%-15s%n", vehicleId, carModel, color, fuelType, isAutomatic, modelId, passLim, mileageLim, canOffRoad);
        System.out.format("%-15s%-10s%-10s%-15s%-25s%-25s%-20s%-15s%-15s%n", sedan1.getVehicleId(), sedan1.getCarModel(), sedan1.getColor(), sedan1.getFuelType(), sedan1.isAutomatic(), sedan1.getModelId(), sedan1.getPassLim(), sedan1.getMileageLim(), sedan1.isCanOffRoad());
        System.out.format("%-15s%-10s%-10s%-15s%-25s%-25s%-20s%-15s%-15s%n", sedan2.getVehicleId(), sedan2.getCarModel(), sedan2.getColor(), sedan2.getFuelType(), sedan2.isAutomatic(), sedan2.getModelId(), sedan2.getPassLim(), sedan2.getMileageLim(), sedan2.isCanOffRoad());

    }
}