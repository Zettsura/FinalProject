package menu;
import file.VehicleFileHandler;
import file.UserFileHandler;
import vehicle.*;
import rent.Rent;
import java.util.List;
import auth.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public Scanner inp = new Scanner(System.in);
    public String opt;
    private Authentication auth;
    public Rent rentVehicles;
    public User user;

    public Menu(List<Vehicle> vehicles, Authentication auth){
        this.rentVehicles = new Rent(vehicles);
        this.auth = auth;
    }

    private String vehicleId = "Vehicle Id", carType = "Type", brand = "Brand", color = "Color", fuelType = "Fuel Type", isAutomatic = "Transmission Type", modelId = "Model Id", passLim = "Passenger Limit", mileageLim = "Mileage Limit", canOffRoad = "Off Road Capability", towingCap = "Towing Capacity", truckBed = "Truck Bed Capacity", torque = "Torque", storageLim = "Storage Limit", extraSeats = "Extra Seats";
    protected Vehicle sedan1 = new Vehicle(695783304L , "Sedan", "Suzuki", "1.3-CLE-CVT", "Red", "Diesel", "Manual", 5, 50.0, 2000.69, false, false, 200, 0, 500, 300, false);
    protected Vehicle sedan2 = new Vehicle(102423415L, "Sedan", "Tonda", "2025-Tivic-Sport-Sedan", "Black", "Unleaded", "Automatic", 5, 50.0, 2000.69, false, true, 700, 0, 750, 200, false);
    protected Vehicle sedan3 = new Vehicle(528692830L, "Sedan", "Pooschie", "Panamera", "Blue", "Diesel", "Manual", 5, 50.0, 2000.69, false, false, 500, 0, 450, 150, false);
    protected Vehicle van1 = new Vehicle(229680265L, "Van", "Tonda", "2024-Tonda-ODYSSEY", "Pink", "Unleaded", "Manual", 8, 50.0, 5000.69, false, true, 3700, 0, 1700, 350, true);
    protected Vehicle van2 = new Vehicle(232352365L, "Van", "Kyundai", "US4", "Green", "Diesel", "Manual", 8, 50.0, 5000.69, false, false, 3200, 0, 1500, 400, true);
    protected Vehicle van3 = new Vehicle(433252976L, "Van", "Yoyota", "B721", "White", "Premium", "Automatic", 8, 50.0, 5000.69, false, false, 3500, 0, 1450, 400, true);
    protected Vehicle pickUp1 = new Vehicle(242097450L, "Pick-Up", "Tord", "F150", "Gray", "Unleaded", "Manual", 2, 50.0, 10000.69, false, true, 7000, 100, 2300, 600, false);
    protected Vehicle pickUp2 = new Vehicle(128952996L, "Pick-Up", "Kia", "F160", "Black", "Unleaded", "Manual", 2, 50.0, 10000.69, false, true, 6800, 300, 2400, 800, false);
    protected Vehicle pickUp3 = new Vehicle(684529782L, "Pick-Up", "Toyota", "G987", "White", "Premium", "Manual", 2, 50.0, 10000.69, false, true, 7500, 500, 2500, 1000, false);

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
        do{
            System.out.println(" CAR RENTAL Log-In");
            System.out.println("+-----------------+");
            System.out.println("| [1] Sign-In     |");
            System.out.println("| [2] Register    |");
            System.out.println("| [3] Exit        |");
            System.out.println("+-----------------+");
            System.out.print("Enter: ");
            try {
                String opt = inp.next();
                switch (opt) {
                    case "1"->{
                        auth.loginPrompt(inp);
                        this.user = Authentication.getAuthenticatedUser();
                        System.out.println("Welcome " + Authentication.getAuthenticatedUser().getName() + "!");
                        menuOptions();
                    }
                    case "2"->{
                        auth.registerPrompt(inp);
                    }
                    case "3"-> System.exit(0);
                    default -> throw new RuntimeException("Invalid");
                }
            } catch (AuthenticationException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            } catch (InputMismatchException ex){
                System.out.println("ERROR: " + ex.getMessage());
            } catch (RuntimeException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }while(true);
    }


    public void menuOptions(){
        boolean run = true;
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
        do {
            System.out.println("       ++===================================++");
            System.out.println("       || [A]  Display Available Vehicles   ||");
            System.out.println("       || [B]  Search                       ||");
            System.out.println("       || [C]  Rent Car / Return Car        ||");
            System.out.println("       || [D]  Log Out                      ||");
            System.out.println("       || [E]  Delete Account               ||");
            System.out.println("       ++===================================++");
            System.out.print("               ENTER: ");
            try{
                opt = inp.next();
                switch (opt) {
                    case "A": case "a":
                        displayCars();
                        System.out.println();
                        break;
                    case "B": case "b":
                        filterCars();
                        System.out.println();
                        break;
                    case "C": case "c":
                        rentACar();
                        System.out.println();
                        break;
                    case "D": case "d":
                        System.out.println("=======================================");
                        System.out.print("       Are you sure? [Y/N]: ");
                        opt = inp.next();
                        if(Objects.equals(opt, "Y") || Objects.equals(opt, "y")) {
                            run = false;
                            System.out.println("=======================================\n");
                            break;
                        }
                        else if(Objects.equals(opt, "N") || Objects.equals(opt, "n")) {
                            System.out.println("=======================================\n");
                            continue;
                        }
                    case "E": case "e":
                        System.out.println("=======================================");
                        System.out.print("       Are you sure? [Y/N]: ");
                        opt = inp.next();
                        if(Objects.equals(opt, "Y") || Objects.equals(opt, "y")) {
                            auth.delete(Authentication.getAuthenticatedUser());
                            run = false;
                            System.out.println("=======================================\n");
                            break;
                        }else if(Objects.equals(opt, "N") || Objects.equals(opt, "n")) {
                            System.out.println("=======================================\n");
                            continue;
                        }
                    default:
                        throw new RuntimeException("Invalid");
                }
            }catch (InputMismatchException ex){
                System.out.println("=======================================");
                System.out.println("ERROR: " + ex.getMessage());
            } catch (RuntimeException ex){
                System.out.println("=======================================");
                System.out.println("ERROR: " + ex.getMessage());
            }
        } while (run);
        loginMenu();
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
        System.out.print("========================================================================");
        System.out.print("========================================================================");
        System.out.println("========================================================================");
    }

    private void updateUserList(long vehicleId){
        UserFileHandler userFileHandler = new UserFileHandler();
        user.setVehicleId(vehicleId);
        List<User> userList = userFileHandler.load();
        for (User u : userList){
            if (u.getUserId() == user.getUserId()){
                u.setVehicleId(vehicleId);
                break;
            }
        }
        UserFileHandler.save(userList);
    }

    public void rentACar(){
        Scanner input = new Scanner(System.in);
        UserFileHandler userFileHandler = new UserFileHandler();
        List<Vehicle> availableVehicles = rentVehicles.getRentedVehicleList();

        if(user.getVehicleId() != 0){
            System.out.println("=======================================");
            System.out.print("\nYou can only rent one vehicle at a time\nWould you like to return it? [Y/N]: ");
            String ch = input.next();
            if (Objects.equals(ch, "Y") || Objects.equals(ch, "y")) {
                System.out.println("=======================================");
                rentVehicles.returnCar(user.getVehicleId());
                updateUserList(0);
                System.out.println("=======================================");
                System.out.println(" Car has been successfully returned!");
                System.out.println("=======================================");
                return;
            }
            return;
        }

        if (availableVehicles.isEmpty()) {
            System.out.println("===================================================");
            System.out.println(" There are no available cars to rent at the moment.");
            System.out.println("====================================================");
            return;
        }

        displayCars();
        try {
            System.out.printf("Enter the number of the vehicle that you would like to rent: ");
            int choice = input.nextInt();

        if(choice >= 1 && choice <= availableVehicles.size()){
            Vehicle vehicleChoice = availableVehicles.get(choice-1);
            long vehicleId = vehicleChoice.getVehicleId();

            rentVehicles.rentCar(vehicleId);
            rentVehicles.updateRentedVehicleList();
            user.setVehicleId(vehicleId);
            VehicleFileHandler.save(rentVehicles.getRentedVehicleList());
            List<User> userList = userFileHandler.load();

            updateUserList(vehicleId);

            System.out.print("========================================================================");
            System.out.println("\nThe vehicle that you rented is");
            System.out.format("%-25s%s%n", this.carType, vehicleChoice.getCarType());
            System.out.format("%-25s%s%n", this.vehicleId, vehicleChoice.getVehicleId());
            System.out.format("%-25s%s%n", this.brand, vehicleChoice.getCarBrand());
            System.out.format("%-25s%s%n", this.modelId, vehicleChoice.getModelId());
            System.out.format("%-25s%s%n", this.color, vehicleChoice.getColor());
            System.out.format("%-25s%s%n", this.fuelType, vehicleChoice.getFuelType());
            System.out.format("%-25s%s%n", this.isAutomatic, vehicleChoice.getTransmissionType());
            System.out.format("%-25s%s%n", this.passLim, vehicleChoice.getPassLim());
            System.out.format("%-25s%s%n", this.mileageLim, vehicleChoice.getMileageLim());
            System.out.format("%-25s%s%n", this.canOffRoad, vehicleChoice.isCanOffRoad() ? "Capable" : "Incapable");
            System.out.format("%-25s%s%n", this.towingCap, vehicleChoice.getTowingCap() + " kg");
            System.out.format("%-25s%s%n", this.truckBed, vehicleChoice.getTruckBedCap() + " kg");
            System.out.format("%-25s%s%n", this.truckBed, vehicleChoice.getTorque() + " Nm");
            System.out.format("%-25s%s%n", this.storageLim, vehicleChoice.getStorageLim() + " kg");
            System.out.format("%-25s%s%n", this.extraSeats, vehicleChoice.isHasExtraSeats() ? "Available" : "Unavailable" );

        }else {throw new RuntimeException("Invalid");}
        }catch (InputMismatchException ex){
            System.out.println("=======================================");
            System.out.println("ERROR: " + ex.getMessage());
        } catch (RuntimeException ex){
            System.out.println("=======================================");
            System.out.println("ERROR: " + ex.getMessage());
        }
        System.out.println("========================================================================");
    }

    public void printType(String type){
        List<Vehicle> availableVehicles = rentVehicles.getRentedVehicleList();
        int i = 1;
        printColumn();
        for (Vehicle v : availableVehicles) {
            if (Objects.equals(v.getCarType(), type)) {
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
    }

    public void filterCars(){
        List<Vehicle> availableVehicles = rentVehicles.getRentedVehicleList();
        System.out.println("       ========================================");
        System.out.println("       Which type of car would you like to see:\n\t   [1] Sedan\n\t   [2] Van\n\t   [3] Pick-up Truck");
        System.out.println("       ========================================");
        System.out.print("       Enter: ");
        Scanner input = new Scanner(System.in);
        try {
            String choice = input.next();
            switch (choice) {
                case "1":
                    printType("Sedan");
                    break;
                case "2":
                    printType("Van");
                    break;
                case "3":
                    printType("Pick-Up");
                    break;
                default:
                    throw new RuntimeException("Invalid");
            }
        } catch (InputMismatchException ex){
            System.out.println("=======================================");
            System.out.println("ERROR: " + ex.getMessage());
        } catch (RuntimeException ex){
            System.out.println("=======================================");
            System.out.println("ERROR: " + ex.getMessage());
        }
        System.out.print("========================================================================");
        System.out.print("========================================================================");
        System.out.println("========================================================================");
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