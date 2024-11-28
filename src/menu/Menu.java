package menu;
import vehicle.*;
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
public class Menu extends Vehicle {
    public Scanner inp = new Scanner(System.in);
    public void loginMenu(){
        while(true) {
            System.out.println("    CAR RENTAL  ");
            System.out.println("+---------------+");
            System.out.println("| [A] Sign-In   |");
            System.out.println("| [B] Sign-Up   |");
            System.out.println("| [X]  Exit     |");
            System.out.println("+---------------+");
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
            System.out.println("++==============================================++");
            System.out.println("++==============================================++");
            System.out.println("|| [A]         Display All Vehicles             ||");
            System.out.println("|| [B]               Search                     ||");
            System.out.println("|| [C]                                          ||");
            System.out.println("|| [D]              Log Out                     ||");
            System.out.println("++==============================================++");
            System.out.println("++==============================================++");
        }
    }

    public void displayAll(){

    }

    public void searchType(){


    }
}
