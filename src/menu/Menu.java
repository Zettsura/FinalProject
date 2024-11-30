package menu;
import vehicle.*;
import rent.Rent;
import java.util.List;
import auth.*;

import java.util.Objects;
import java.util.Scanner;

/**
 * TODO
 *  - Only display non-rented cars
 *
 * NOTES:
 *  - Show different menu for authenticated user is currently renting a car
 *    (maybe option to return the vehicle?? )
 *  - Create temporary list of vehicles and filter rented cars
 *  - The menu will receive the temporary copy list of vehicles with filter for rented cars
 *  - Displays the temporary copy list
 *  - Sends the chosen vehicle to rent
 *  - Modify the object on the original
 */

public class Menu {
    public Scanner inp = new Scanner(System.in);
    private Authentication auth;
    private Rent rentVehicles;

    public Menu(List<Vehicle> vehicles, Authentication auth){
        this.rentVehicles = new Rent(vehicles);
        this.auth = auth;
    }

    private String vehicleId = "Vehicle Id", carModel = "Model", color = "Color", fuelType = "Fuel Type", isAutomatic = "Transmission Type", modelId = "Model Id", passLim = "Passenger Limit", mileageLim = "Mileage Limit", canOffRoad = "Off Road Capability";
    protected Vehicle sedan1 = new Vehicle(695783304L , "Sedan", "Suzuki", "1.3-CLE-CVT", "Red", "Diesel", "Manual", 5, 523.42, 2000.1, true, false, 200.1, 0, 500, 300, false);
    protected Vehicle sedan2 = new Vehicle(102423415L, "Sedan", "Tonda", "2025-Tivic-Sport-Sedan", "Black", "Unleaded", "Automatic", 5, 643.73, 1234.1, false, true, 0, 0, 10, 400, false);
    protected Vehicle sedan3 = new Vehicle(528692830L, "Sedan", "Pooschie", "Panamera", "Blue", "Diesel", "Manual", 5, 895.152, 5000.1, false, true, 0, 0, 20, 200, true);
    protected Vehicle van1 = new Vehicle(229680265L, "Van", "Tonda", "2024-Tonda-ODYSSEY", "Pink", "Unleaded", "Manual", 8, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);
    protected Vehicle van2 = new Vehicle(232352365L, "Van", "Kyundai", "US4", "Green", "Diesel", "Manual", 8, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);
    protected Vehicle van3 = new Vehicle(433252976L, "Van", "Yoyota", "B721", "White", "Premium", "Automatic", 8, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);
    protected Vehicle pickUp1 = new Vehicle(242097450L, "Pick-Up Truck", "Tord", "F150", "Gray", "Unleaded", "Manual", 2, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);
    protected Vehicle pickUp2 = new Vehicle(128952996L, "Pick-Up Truck", "Tord", "F160", "Gray", "Unleaded", "Manual", 2, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);
    protected Vehicle pickUp3 = new Vehicle(684529782L, "Pick-Up Truck", "Tord", "G987", "Gray", "Unleaded", "Manual", 2, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);

    public void loginMenu(){
        while(true) {
            System.out.println(" CAR RENTAL Log-In");
            System.out.println("+-----------------+");
            System.out.println("| [1] Sign-In     |");
            System.out.println("| [2] Register    |");
            System.out.println("| [3] Exit        |");
            System.out.println("+-----------------+");
            System.out.print("ENTER:");
            int opt = inp.nextInt();
                try {
                    switch (opt) {
                        case 1 -> auth.loginPrompt(inp);
                        case 2 -> auth.registerPrompt(inp);
                        case 3 -> System.exit(0);
                        default -> throw new RuntimeException("Invalid");
                    }
                } catch (AuthenticationException ex) {
                    System.out.println("ERROR: " + ex.getMessage());
                    continue;
                } catch (RuntimeException ex) {
                    System.out.println("ERROR: " + ex.getMessage());
                    continue;
                }
                break;
            }
        }

    public void menuOptions(){
        System.out.println("++=================================================================================++");
        System.out.println("++=================================================================================++");
        System.out.println("||   //                                                                            ||");
        System.out.println("||  //                 CCCCCCCCC          AA          RRRRRRRRRR                   ||");
        System.out.println("|| //                 CCCCCCCCCC         AAAA         RRRRRRRRRRR                  ||");
        System.out.println("||//                 CCCC               AA  AA        RRR       RR                 ||");
        System.out.println("||/                  CCC               AA    AA       RRR       RR                 ||");
        System.out.println("||                   CCC              AAAAAAAAAA      RRRRRRRRRRR                  ||");
        System.out.println("||                   CCC             AAAAAAAAAAAA     RRRRRRRRRR                   ||");
        System.out.println("||                   CCCC           AAAA      AAAA    RRR    RRRR                  ||");
        System.out.println("||                    CCCCCCCCCC   AAAA        AAAA   RRR      RRRR                ||");
        System.out.println("||                      CCCCCCCC  AAAA          AAAA  RRR      RRRR                ||");
        System.out.println("||                                                                                 ||");
        System.out.println("||            RRRRRRRRRR     EEEEEEEEEE  NNNNN       NNN  TTTTTTTTTTTTTT           ||");
        System.out.println("||            RRRRRRRRRRR    EEEEEEEEEE  NNNNNN      NNN  TTTTTTTTTTTTTT           ||");
        System.out.println("||            RRR       RR   EEE         NNNNNNN     NNN       TTTT                ||");
        System.out.println("||            RRR       RR   EEE         NNN  NNN    NNN       TTTT                ||");
        System.out.println("||            RRRRRRRRRRR    EEEEEEEE    NNN   NNN   NNN       TTTT                ||");
        System.out.println("||            RRRRRRRRRR     EEEEEEEE    NNN    NNNN NNN       TTTT                ||");
        System.out.println("||            RRR    RRRR    EEE         NNN     NNNNNNN       TTTT                ||");
        System.out.println("||            RRR      RRRR  EEEEEEEEEE  NNN       NNNNN       TTTT                ||");
        System.out.println("||            RRR      RRRR  EEEEEEEEEE  NNN        NNNN       TTTT                ||");
        System.out.println("||                                                                                 ||");
        System.out.println("++=================================================================================++");
        System.out.println("++=================================================================================++");
        while(true) {
            System.out.println("++===================================++");
            System.out.println("++===================================++");
            System.out.println("|| [A]  Display Available Vehicles   ||");
            System.out.println("|| [B]  Search                       ||");
            System.out.println("|| [C]  Rent Car                     ||");
            System.out.println("|| [D]  Log Out                      ||");
            System.out.println("++===================================++");
            System.out.println("++===================================++");
            System.out.println("ENTER: ");
            String opt = inp.next();

            switch (opt){
                case "A": case "a":
                    displayCars();
                    break;
                case "B": case "b":
                    filterCars();
                    break;
                case "C": case "c":
                    rentACar();
                    break;
                case "D": case "d":
                    System.out.println("Are you sure? [Y/N]: ");
                    opt = inp.next();
                    if(Objects.equals(opt, "Y") || Objects.equals(opt, "y"))
                        System.exit(0);
                    else if(opt == "N" || opt == "n")
                        continue;
                case "E": case "e":
                    auth.delete(Authentication.getAuthenticatedUser());
                    break;
                default:
                    System.out.println("ERROR: Invalid Option");
            }
            break;
        }
    }

    public void displayCars(){
        int i = 1;
        System.out.println("Available Cars for Rent: ");
        List<Vehicle> availableVehicles = rentVehicles.getRentedVehicleList();

        if (availableVehicles.isEmpty()) {
            System.out.println("There are no available cars to rent at the moment.");
            return;
        }

        for (Vehicle v : availableVehicles){
            System.out.format("%-15s%-10s%-10s%-15s%-25s%-25s%-20s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n",i ,
                    v.getCarType(),
                    v.getVehicleId(),
                    v.getCarBrand(),
                    v.getModelId(),
                    v.getColor(),
                    v.getFuelType(),
                    v.getTransmissionType(),
                    v.getPassLim(),
                    v.getMileageLim(),
                    v.isCanOffRoad(),
                    v.getTowingCap(),
                    v.getTruckBedCap(),
                    v.getTorque(),
                    v.getStorageLim(),
                    v.isHasExtraSeats());
            i++;
        }
    }

    public void rentACar(){
        Scanner input = new Scanner(System.in);
        List<Vehicle> availableVehicles = rentVehicles.getRentedVehicleList();

        if (availableVehicles.isEmpty()) {
            System.out.println("There are no available cars to rent at the moment.");
            return;
        }

        displayCars();

        System.out.printf("%nEnter the number of the vehicle that you would like to rent: ");
        int choice = input.nextInt();

        if((choice-1) >= 0 && choice < availableVehicles.size()){
            Vehicle vehicleChoice = availableVehicles.get(choice-1);
            long vehicleId = vehicleChoice.getVehicleId();

            rentVehicles.rentCar(vehicleId);

            rentVehicles.updateRentedVehicleList();

            System.out.println("\nThe vehicle that you rented is");
            System.out.format("%-15s%-10s%-10s%-15s%-25s%-25s%-20s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n",
                    vehicleChoice.getCarType(),
                    vehicleChoice.getVehicleId(),
                    vehicleChoice.getCarBrand(),
                    vehicleChoice.getModelId(),
                    vehicleChoice.getColor(),
                    vehicleChoice.getFuelType(),
                    vehicleChoice.getTransmissionType(),
                    vehicleChoice.getPassLim(),
                    vehicleChoice.getMileageLim(),
                    vehicleChoice.isCanOffRoad(),
                    vehicleChoice.getTowingCap(),
                    vehicleChoice.getTruckBedCap(),
                    vehicleChoice.getTorque(),
                    vehicleChoice.getStorageLim(),
                    vehicleChoice.isHasExtraSeats());
        }
    }

    public void filterCars(){


    }
}


//System.out.format("%-15s%-10s%-10s%-15s%-25s%-25s%-20s%-15s%-15s%n", sedan1.getVehicleId(), sedan1.getCarBrand(), sedan1.getColor(), sedan1.getFuelType(), sedan1.isAutomatic(), sedan1.getModelId(), sedan1.getPassLim(), sedan1.getMileageLim(), sedan1.isCanOffRoad());