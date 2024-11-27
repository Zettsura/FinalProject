import vehicle.*;

public class Main {
    public static void main (String[] args) {
        Sedan sedan1 = new Sedan(102412412L, "Suzuki", "Red", "Gasoline", false, "1.3-CLE-CVT", 5, 523.42, true);
        Sedan sedan2 = new Sedan(102423415L, "Tonda", "Black", "Gasoline", true, "2025-Tivic-Sport-Sedan", 5, 643.73, true);
        Sedan sedan3 = new Sedan(102473345L, "Pooschie", "Blue", "Gasoline", true, "Panamera", 5, 895.152, false);
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