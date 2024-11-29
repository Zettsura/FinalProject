package menu;
import vehicle.*;
import auth.*;
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
    private String vehicleId = "Vehicle Id", carModel = "Model", color = "Color", fuelType = "Fuel Type", isAutomatic = "Transmission Type", modelId = "Model Id", passLim = "Passenger Limit", mileageLim = "Mileage Limit", canOffRoad = "Off Road Capability";

    protected Vehicle sedan1 = new Vehicle(695783304L , "Sedan", "Suzuki", "1.3-CLE-CVT", "Red", "Diesel", "Manual", 5, 523.42, 2000.1, true, false, 200.1, 0, 500, 300, false);
    Vehicle sedan2 = new Vehicle(102423415L, "Sedan", "Tonda", "2025-Tivic-Sport-Sedan", "Black", "Unleaded", "Automatic", 5, 643.73, 1234.1, false, true, 0, 0, 10, 400, false);
    Vehicle sedan3 = new Vehicle(528692830L, "Sedan", "Pooschie", "Panamera", "Blue", "Diesel", "Manual", 5, 895.152, 5000.1, false, true, 0, 0, 20, 200, true);
    Vehicle van1 = new Vehicle(229680265L, "Van", "Tonda", "2024-Tonda-ODYSSEY", "Pink", "Unleaded", "Manual", 8, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);
    Vehicle van2 = new Vehicle(232352365L, "Van", "Kyundai", "US4", "Green", "Diesel", "Manual", 8, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);
    Vehicle van3 = new Vehicle(433252976L, "Van", "Yoyota", "B721", "White", "Premium", "Automatic", 8, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);
    Vehicle pickUp1 = new Vehicle(242097450L, "Pick-Up Truck", "Tord", "F150", "Gray", "Unleaded", "Manual", 2, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);
    Vehicle pickUp2 = new Vehicle(128952996L, "Pick-Up Truck", "Tord", "F160", "Gray", "Unleaded", "Manual", 2, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);
    Vehicle pickUp3 = new Vehicle(684529782L, "Pick-Up Truck", "Tord", "G987", "Gray", "Unleaded", "Manual", 2, 1237.23, 2500.69, false, true, 0, 0, 20, 200, true);

    public void loginMenu(){
        while(true) {
            System.out.println(" CAR RENTAL Log-In");
            System.out.println("+-----------------+");
            System.out.println("| [A] Sign-In     |");
            System.out.println("| [B] Sign-Up     |");
            System.out.println("| [X]  Exit       |");
            System.out.println("+-----------------+");
            System.out.print("ENTER:");
            String opt = inp.nextLine();
            switch(opt) {
                case "A": case "a":

                    break;
                case "B": case "b":
                    break;
                case "X": case "x":
                    System.exit(0);
                default:
                    System.out.println("Invalid Input");
            }
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
            System.out.println("++=================================++");
            System.out.println("++=================================++");
            System.out.println("|| [A]  Display All Vehicles       ||");
            System.out.println("|| [B]  Search                     ||");
            System.out.println("|| [C]  Rent Car                   ||");
            System.out.println("|| [D]  Log Out                    ||");
            System.out.println("++=================================++");
            System.out.println("++=================================++");
            System.out.println("ENTER: ");
            String opt = inp.next();

            switch (opt){
                case "A": case "a":
                    displayRentedCars();
                    break;
                case "B": case "b":
                    break;
                case "C": case "c":
                    break;
                case "D": case "d":
                    System.out.println("Are you sure? [Y/N]: ");
                    opt = inp.next();
                    if(opt == "Y" || opt == "y")
                        loginMenu();
                    else if(opt == "N" || opt == "n")
                        continue;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    public void displayRentedCars(){
        System.out.format("%-15s%-10s%-10s%-15s%-25s%-25s%-20s%-15s%-15s%n", vehicleId, carModel, color, fuelType, isAutomatic, modelId, passLim, mileageLim, canOffRoad);


    }

    public void rentACar(){


    }

    public void filterCars(){


    }
}
