package Part3;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        Suit suit;

        while(!(choice == 1 || choice == 2 || choice == 3)){
            System.out.println("Please enter the number of suit type you want.");
            System.out.println("1) Dec (500k TL, 25kg)");
            System.out.println("2) Ora (1500k TL, 30kg)");
            System.out.println("3) Tor (5000k TL, 50kg)");
            choice=scan.nextInt();
        }

        if(choice == 1)
            suit = new Dec();
        else if(choice == 2)
            suit = new Ora();
        else
            suit = new Tor();

        choice = -1;

         while(!(choice == 1 || choice == 2)){
            System.out.println("Do you want any accessory?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            choice=scan.nextInt();
         }

         if(choice == 1){
             choice = -1;

             while(choice != 0){
                 System.out.println("Please enter the number of accessory you want.");
                 System.out.println("0) Exit");
                 System.out.println("1) Flamethrower (50k TL per item, 2k)");
                 System.out.println("2) AutoRifle (30k TL per item, 1.5kg)");
                 System.out.println("3) RocketLauncher (150k TL per item, 7.5kg)");
                 System.out.println("4) Laser (200k TL per item, 5.5kg)");

                 choice=scan.nextInt();

                 if(choice == 1)
                     suit = new Flamethrower(suit);
                 else if(choice == 2)
                     suit = new AutoRifle(suit);
                 else if(choice == 3)
                     suit = new RocketLauncher(suit);
                 else if(choice == 4)
                     suit = new Laser(suit);
             }
         }

         System.out.println("Your suit:      " + suit.getDescription());
         System.out.println("Total cost:     " + suit.cost());
         System.out.println("Total weight:   " + suit.weight());
    }
}

