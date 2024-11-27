package vehicle;

import java.util.Objects;

public class Sedan extends Vehicle implements rent, payment{
    public boolean canOffRoad;

    public Sedan(long vehicleId, String carModel, String color, String fuelType, boolean isAutomatic, String modelId, int passLim, float mileageLim, boolean canOffRoad) {
        super(vehicleId, carModel, color, fuelType, isAutomatic, modelId, passLim, mileageLim);
        this.canOffRoad = canOffRoad;
    }

    public Sedan(){
        super();
    }

    public boolean isCanOffRoad() {
        return canOffRoad;
    }

    @Override
    public void calcRent(Vehicle car) {
        basePrice = 5000.1;

        if (!Objects.equals(car.getColor(), "Black") || !Objects.equals(car.getColor(), "Blue"))
            basePrice *= 1.03;
        if (canOffRoad)
            basePrice *= 1.06;
        if (isAutomatic)
            basePrice *= 1.02;
        if (Objects.equals(fuelType, "High Octane"))
            basePrice *= 1.02;
        else
            basePrice *= 1.01;

    }
}
