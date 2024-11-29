package vehicle;

public class Vehicle {
    private long vehicleId;      // Id ng shop
    private String carType;
    private String carBrand;     //brand
    private String modelId;
    private String color;        // Red, White, Blue, Yellow, Black, Pink, Green
    private String fuelType;     // Diesel, Unleaded, High Octane
    private String transmissionType;
    private int passLim;
    private double mileageLim;
    private double basePrice;
    private boolean isRented;
    private boolean canOffRoad;
    private double towingCap; //truck
    private double truckBedCap; //truck
    private int torque;
    private int storageLim;
    private boolean hasExtraSeats; //van

    public Vehicle(){}

    public Vehicle(long vehicleId, String carType, String carBrand, String modelId, String color, String fuelType, String transmissionType, int passLim, double mileageLim, double basePrice, boolean isRented, boolean canOffRoad, double towingCap, double truckBedCap, int torque, int storageLim, boolean hasExtraSeats) {
        this.vehicleId = vehicleId;
        this.carType = carType;
        this.carBrand = carBrand;
        this.modelId = modelId;
        this.color = color;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.passLim = passLim;
        this.mileageLim = mileageLim;
        this.basePrice = basePrice;
        this.isRented = isRented;
        this.canOffRoad = canOffRoad;
        this.towingCap = towingCap;
        this.truckBedCap = truckBedCap;
        this.torque = torque;
        this.storageLim = storageLim;
        this.hasExtraSeats = hasExtraSeats;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public String getCarType() {return carType;}

    public void setCarType(String carType) {this.carType = carType;}

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
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

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
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

    public boolean getIsRented() {
        return isRented;
    }

    public void setIsRented(boolean rented) {
        isRented = rented;
    }

    public String isCanOffRoad() {
        return canOffRoad ? "Capable" : "Incapable";
    }

    public void setCanOffRoad(boolean canOffRoad) {
        this.canOffRoad = canOffRoad;
    }
    public boolean getCanOffRoad() {
        return this.canOffRoad;
    }

    public double getTowingCap() {
        return this.towingCap;
    }

    public void setTowingCap(double towingCap) {
        this.towingCap = towingCap;
    }

    public double getTruckBedCap() {
        return this.truckBedCap;
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
    public boolean getHasExtraSeats() {
        return this.hasExtraSeats;
    }

    public void setHasExtraSeats(boolean hasExtraSeats) {
        this.hasExtraSeats = hasExtraSeats;
    }

    public double rent(double mileageLim){//sedan
        if (mileageLim < 0)
            throw new IllegalArgumentException("Mileage limit is 0, that is wrong");
        if (mileageLim > 50)
            basePrice+=((mileageLim-50)*0.02);

        return basePrice;
    }
    public double rent(double mileageLim, boolean hasExtraSeats){ //van
        if (mileageLim < 0)
            throw new IllegalArgumentException("Mileage limit is 0, that is wrong");
        if (mileageLim > 50)
            basePrice+=((mileageLim-50)*0.02);
        if (hasExtraSeats)
            basePrice *= 1.4;

        return  basePrice;
    }
    public double rent(double mileageLim, double towingCap, double bedCap){ //truck
        if (mileageLim < 0)
            throw new IllegalArgumentException("Mileage limit is 0, that is wrong");
        if (mileageLim > 50)
            basePrice+=((mileageLim-50)*0.02);
        if (towingCap > 500)
            basePrice+=((towingCap-500)*0.05);
        if (bedCap > 1.33)
            basePrice+=((bedCap - 1.33)*0.05);

        return  basePrice;
    }
}
