package menu;
import file.VehicleFileHandler;
import vehicle.*;
import rent.Rent;
import java.util.List;
import auth.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public Scanner inp = new Scanner(System.in);
    private Authentication auth;
    public Rent rentVehicles;

    public Menu(List<Vehicle> vehicles, Authentication auth){
        this.rentVehicles = new Rent(vehicles);
        this.auth = auth;
    }

    private String vehicleId = "Vehicle Id", carModel = "Model", color = "Color", fuelType = "Fuel Type", isAutomatic = "Transmission Type", modelId = "Model Id", passLim = "Passenger Limit", mileageLim = "Mileage Limit", canOffRoad = "Off Road Capability";
    protected Vehicle sedan1 = new Vehicle(695783304L , "Sedan", "Suzuki", "1.3-CLE-CVT", "Red", "Diesel", "Manual", 5, 50.0, 1500.1, false, false, 200, 0, 500, 300, false);
    protected Vehicle sedan2 = new Vehicle(102423415L, "Sedan", "Tonda", "2025-Tivic-Sport-Sedan", "Black", "Unleaded", "Automatic", 5, 50.0, 2400.1, false, true, 700, 0, 750, 200, false);
    protected Vehicle sedan3 = new Vehicle(528692830L, "Sedan", "Pooschie", "Panamera", "Blue", "Diesel", "Manual", 5, 50.0, 2000.1, false, false, 500, 0, 450, 150, false);
    protected Vehicle van1 = new Vehicle(229680265L, "Van", "Tonda", "2024-Tonda-ODYSSEY", "Pink", "Unleaded", "Manual", 8, 50.0, 6500.69, false, true, 3700, 0, 1700, 350, true);
    protected Vehicle van2 = new Vehicle(232352365L, "Van", "Kyundai", "US4", "Green", "Diesel", "Manual", 8, 50.0, 4500.69, false, false, 3200, 0, 1500, 400, true);
    protected Vehicle van3 = new Vehicle(433252976L, "Van", "Yoyota", "B721", "White", "Premium", "Automatic", 8, 50.0, 5000.69, false, false, 3500, 0, 1450, 400, true);
    protected Vehicle pickUp1 = new Vehicle(242097450L, "Pick-Up", "Tord", "F150", "Gray", "Unleaded", "Manual", 2, 50.0, 10000.69, false, true, 7000, 100, 2300, 600, false);
    protected Vehicle pickUp2 = new Vehicle(128952996L, "Pick-Up", "Kia", "F160", "Black", "Unleaded", "Manual", 2, 50.0, 11000.69, false, true, 6800, 300, 2400, 800, false);
    protected Vehicle pickUp3 = new Vehicle(684529782L, "Pick-Up", "Toyota", "G987", "White", "Premium", "Manual", 2, 50.0, 12500.69, false, true, 7500, 500, 2500, 1000, false);

    public void initializeVehicles(List<Vehicle> vehicles){
        if (vehicles.isEmpty()){
            vehicles.add(sedan1);
            vehicles.add(sedan2);
            vehicles.add(sedan3);
            vehicles.add(van1);
            vehicles.add(van2);
            vehicles.add(van3);
            vehicles.add(pickUp1);
            vehicles.add(pickUp2);
            vehicles.add(pickUp3);

            VehicleFileHandler.save(vehicles);
        }
    }

    public void loginMenu(){
        while(true) {
            System.out.println(" CAR RENTAL Log-In");
            System.out.println("+-----------------+");
            System.out.println("| [1] Sign-In     |");
            System.out.println("| [2] Register    |");
            System.out.println("| [3] Exit        |");
            System.out.println("+-----------------+");
            System.out.print("ENTER: ");
                try {
                    int opt = inp.nextInt();
                    switch (opt) {
                        case 1 -> auth.loginPrompt(inp);
                        case 2 -> auth.registerPrompt(inp);
                        case 3 -> System.exit(0);
                        default -> throw new RuntimeException("Invalid");
                    }
                } catch (AuthenticationException ex) {
                    System.out.println("ERROR: " + ex.getMessage());
                    continue;
                } catch (InputMismatchException ex){
                    inp.nextLine();
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
        System.out.println("++====================================================++");
        System.out.println("++====================================================++");
        System.out.println("||   __                                               ||");
        System.out.println("|| __  ---________CCCCCC      AAA      RRRRRRR        ||");
        System.out.println("||   --_________CCC         AA AA     RR    RR        ||");
        System.out.println("||   _________CCC         AA   AA    RR    RR         ||");
        System.out.println("|| __________CCC        AAAAAAAAA   RRRRRRR           ||");
        System.out.println("||___________CCC      AA       AA  RR    RR           ||");
        System.out.println("|| __________CCCCCC AA         AA RR     RR           ||");
        System.out.println("|| _                                                  ||");
        System.out.println("||  --____RRRRRRR   EEEEEEE  NNN    NN TTTTTTTTTT     ||");
        System.out.println("||--_____RR    RR  EE       NNNN   NN    TTTT         ||");
        System.out.println("|| _____RR    RR  EEEEEEE  NN NN  NN    TTTT          ||");
        System.out.println("||  ___RRRRRRR   EE       NN  NN NN    TTTT           ||");
        System.out.println("||  __RR    RR  EE       NN   NNNN    TTTT            ||");
        System.out.println("||  _RR     RR EEEEEEE  NN    NNN    TTTT             ||");
        System.out.println("||                                                    ||");
        System.out.println("++====================================================++");
        System.out.println("++====================================================++");
        while(true) {
        System.out.println();
        System.out.println("       ++===================================++");
        System.out.println("       || [A]  Display Available Vehicles   ||");
        System.out.println("       || [B]  Search                       ||");
        System.out.println("       || [C]  Rent Car                     ||");
        System.out.println("       || [D]  Log Out                      ||");
        System.out.println("       || [E]  Delete Account               ||");
        System.out.println("       ++===================================++");
        System.out.print("               ENTER: ");
            try{
            String opt = inp.next();
            switch (opt) {
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
                    System.out.print("Are you sure? [Y/N]: ");
                    opt = inp.next();
                    if(Objects.equals(opt, "Y") || Objects.equals(opt, "y"))
                        loginMenu();
                    else if(Objects.equals(opt, "N") || Objects.equals(opt, "n"))
                        continue;
                case "E": case "e":
                    System.out.print("Are you sure!? [Y/N]: ");
                    opt = inp.next();
                    if(Objects.equals(opt, "Y") || Objects.equals(opt, "y")) {
                        auth.delete(Authentication.getAuthenticatedUser());
                        loginMenu();
                    }else if(Objects.equals(opt, "N") || Objects.equals(opt, "n"))
                        continue;
                    break;
                default:
                    throw new RuntimeException("Invalid");
                }
            }catch(InputMismatchException ex){
                System.out.println("ERROR: " + ex.getMessage());
            }catch (RuntimeException ex){
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
    }

    public void displayCars(){
        int i = 1;
        System.out.println("=======================================");
        System.out.println("       Available Cars for Rent ");
        System.out.println("=======================================");
        List<Vehicle> availableVehicles = rentVehicles.getRentedVehicleList();

        if (availableVehicles.isEmpty()) {
            System.out.println("There are no available cars to rent at the moment.");
            return;
        }
        printColumn();
        for (Vehicle v : availableVehicles){
            System.out.format("%-5s%-10s%-15s%-15s%-25s%-10s%-15s%-15s%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-10s%n",i ,
                    v.getCarType(),
                    v.getVehicleId(),
                    v.getCarBrand(),
                    v.getModelId(),
                    v.getColor(),
                    v.getFuelType(),
                    v.getTransmissionType(),
                    v.getPassLim(),
                    v.getMileageLim() + " mi",
                    v.isCanOffRoad() ? "Capable" : "Incapable",
                    v.getTowingCap() + " kg",
                    v.getTruckBedCap() + " kg",
                    v.getTorque() + " Nm",
                    v.getStorageLim() + " kg",
                    v.isHasExtraSeats() ? "Yes" : "No");
            i++;
        }
    }

    public void rentACar(){
        Scanner input = new Scanner(System.in);
        List<Vehicle> availableVehicles = rentVehicles.getRentedVehicleList();

        if (availableVehicles.isEmpty()) {
            System.out.println("===================================================");
            System.out.println(" There are no available cars to rent at the moment.");
            System.out.println("====================================================");
            return;
        }

        displayCars();
        try {
            System.out.println("==============================================================\n");
            System.out.printf(" Enter the number of the vehicle that you would like to rent: ");
            int choice = input.nextInt();

            if ((choice - 1) >= 0 && choice < availableVehicles.size()) {
                Vehicle vehicleChoice = availableVehicles.get(choice - 1);
                long vehicleId = vehicleChoice.getVehicleId();

                rentVehicles.rentCar(vehicleId);

                rentVehicles.updateRentedVehicleList();

                VehicleFileHandler.save(rentVehicles.getRentedVehicleList());System.out.println("\nThe vehicle that you rented is");
                System.out.format("%-5s%-10s%-20s%-15s%-25s%-15s%-15s%-15s%-10s%-15s%-15s%-10s%-10s%-10s%-10s%n",
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
            }else {throw new RuntimeException("Invalid");}
        }catch (InputMismatchException ex){
            System.out.println("ERROR: " + ex.getMessage());
        } catch (RuntimeException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void printType(String type){
        List<Vehicle> availableVehicles = rentVehicles.getRentedVehicleList();
        printColumn();
        for (Vehicle v : availableVehicles) {
            if (Objects.equals(v.getCarType(), type)) {
                System.out.format("%-10s%-15s%-15s%-25s%-10s%-15s%-15s%-10s%-15s%-15s%-15s%-5s%-5s%-5s%n",
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
            }
        }
    }
    
    public void filterCars(){
        List<Vehicle> availableVehicles = rentVehicles.getRentedVehicleList();
            System.out.println("========================================");
            System.out.println("Which type of car would you like to see:\n\t[1] Sedan\n\t[2] Van\n\t[3] Pick-up Truck");
            System.out.println("========================================");
            System.out.print("Enter: ");
            Scanner input = new Scanner(System.in);
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        printType("Sedan");
                        System.out.println();
                        break;
                    case 2:
                        printType("Van");
                        System.out.println();
                        break;
                    case 3:
                        printType("Pick-Up");
                        System.out.println();
                        break;
                    default:
                        throw new RuntimeException("Invalid");
                }
            } catch (InputMismatchException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            } catch (RuntimeException ex){
                System.out.println("ERROR: " + ex.getMessage());
            }
    }

    public void printColumn(){
        String i = "#",
                l= "",
                CarType = "Car Type",
                VehicleId = "Vehicle ID",
                CarBrand = "Car Brand",
                ModelId = "Model ID",
                Color = "Color",
                FuelType = "Fuel",
                TransmissionType2 = "Transmission",
                TransmissionType = "Type",
                PassLim2 = "Passenger",
                PassLim = "Limit",
                MileageLim2 = "Mileage",
                MileageLim = "Limit",
                CanOffRoad2 = "Off Road",
                CanOffRoad = "Capability",
                TowingCap2 = "Towing",
                TowingCap = "Capacity",
                TruckBedCap2 = "Truck Bed",
                TruckBedCap = "Capacity",
                Torque = "Torque",
                StorageLim2 = "Storage ",
                StorageLim = "Limit",
                HasExtraSeats2 = "Extra ",
                HasExtraSeats = "Seats";
        System.out.print("========================================================================");
        System.out.print("========================================================================");
        System.out.println("========================================================================");
        System.out.format("%-95s%-15s%-10s%-15s%-15s%-15s%-30s%-15s%s%n",
                l,
                TransmissionType2,
                PassLim2,
                MileageLim2,
                CanOffRoad2,
                TowingCap2,
                TruckBedCap2,
                StorageLim2,
                HasExtraSeats2);
        System.out.format("%-5s%-10s%-15s%-15s%-25s%-10s%-15s%-15s%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-10s%n",i ,
                CarType,
                VehicleId,
                CarBrand,
                ModelId,
                Color,
                FuelType,
                TransmissionType,
                PassLim,
                MileageLim,
                CanOffRoad,
                TowingCap,
                TruckBedCap,
                Torque,
                StorageLim,
                HasExtraSeats);
        System.out.print("========================================================================");
        System.out.print("========================================================================");
        System.out.println("========================================================================");
    }
}


