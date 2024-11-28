package vehicle;

public class Vehicle {
    public long vehicleId;      // Id ng shop
    public String carModel;     //brand
    public String modelId;
    public String color;        // Red, White, Blue, Yellow, Black, Pink, Green
    public String fuelType;     // Diesel, Unleaded, High Octane
    public boolean isAutomatic;
    public int passLim;
    public double mileageLim;
    public double basePrice;
    public boolean isRented;
    public boolean canOffRoad;
    public double towingCap;
    public double truckBedCap;
    public int torque;
    public int storageLim;
    public boolean hasExtraSeats;

    public Vehicle(long vehicleId, String carModel, String modelId, String color, String fuelType, boolean isAutomatic, int passLim, double mileageLim, double basePrice, boolean isRented, boolean canOffRoad, double towingCap, double truckBedCap, int torque, int storageLim, boolean hasExtraSeats) {
        this.vehicleId = vehicleId;
        //Add car type
        this.carModel = carModel;
        this.modelId = modelId;
        this.color = color;
        this.fuelType = fuelType;
        this.isAutomatic = isAutomatic;
        this.passLim = passLim;
        this.mileageLim = mileageLim;
        this.basePrice = basePrice;
        this.isRented = isRented;
        this.canOffRoad = canOffRoad; //special
        this.towingCap = towingCap; //special
        this.truckBedCap = truckBedCap; //special
        this.torque = torque;
        this.storageLim = storageLim;
        this.hasExtraSeats = hasExtraSeats;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String isAutomatic() {
        return canOffRoad ? "Automatic" : "Manual";
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public int getPassLim() {
        return passLim;
    }

    public void setPassLim(int passLim) {
        this.passLim = passLim;
    }

    public double getMileageLim() {
        return mileageLim;
    }

    public void setMileageLim(double mileageLim) {
        this.mileageLim = mileageLim;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String isCanOffRoad() {
        return canOffRoad ? "Capable" : "Incapable";
    }

    public void setCanOffRoad(boolean canOffRoad) {
        this.canOffRoad = canOffRoad;
    }

    public String getTowingCap() {
        if (this.towingCap == 0)
            return "-";
        else
            return Double.toString(towingCap);
    }

    public void setTowingCap(double towingCap) {
        this.towingCap = towingCap;
    }

    public String getTruckBedCap() {
        if (this.truckBedCap == 0)
            return "-";
        else
            return Double.toString(truckBedCap);
    }

    public void setTruckBedCap(double truckBedCap) {
        this.truckBedCap = truckBedCap;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getStorageLim() {
        return storageLim;
    }

    public void setStorageLim(int storageLim) {
        this.storageLim = storageLim;
    }

    public String isHasExtraSeats() {
        return hasExtraSeats ? "✅" : "❌";
    }

    public void setHasExtraSeats(boolean hasExtraSeats) {
        this.hasExtraSeats = hasExtraSeats;
    }
}
