package vehicle;

interface payment{

}
interface rent{
    public void calcRent(Vehicle car);
}


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

    public Vehicle() {
    }

    public Vehicle(long vehicleId, String carModel, String color, String fuelType, boolean isAutomatic, String modelId, int passLim, float mileageLim) {
        this.vehicleId = vehicleId;
        this.carModel = carModel;
        this.color = color;
        this.fuelType = fuelType;
        this.isAutomatic = isAutomatic;
        this.modelId = modelId;
        this.passLim = passLim;
        this.mileageLim = mileageLim;
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

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setTransType(boolean transType) {
        this.isAutomatic = transType;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
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

    public boolean isIsRented() {
        return isRented;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }
}

