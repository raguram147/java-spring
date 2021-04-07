package GUI;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;





public class BTControl {
	static ArrayList<boat> boats = new ArrayList<>();
	
	public static ArrayList<boat> getBoats() {
			return boats;
		}

		public static void addBoats(boat bt) {
			boats.add(bt);
		}
	
	static String [] BoatList = {"Oil Tanker = w", "Gas Container = r", "Cargo = p", 
    "Unknown = u"};

	static Scanner in =new Scanner(System.in);
	

	public static void addToList() {
		// TODO Auto-generated method stub
		
		 System.out.println("Enter the Boat Name");
		String  name=in.nextLine();
		 System.out.println("Enter the Boat Number ");
		int  Number=in.nextInt();
		 in.nextLine();
         System.out.println("Type");
         System.out.println("Enter type of boat, "+ "," + "Choose from: " );
         for(String str : BoatList) {
             System.out.print(str + " ");
         }
         String type = in.nextLine();
         try {
         if (type == "w") {
              System.out.println("Oil Tanker");
         }else if (type == "r") {
                  System.out.println("Gas Container");
         }else if (type == "p") {
              System.out.println("Cargo");
         }else if (type == "u") {
              System.out.println("Unknown");
         } else type = null;
             }
         catch (InputMismatchException i) {
             System.out.println("You must enter valid command: " + BoatList);
         }
    	 System.out.println("Enter the Boat Capacity ");
         int capacity = in.nextInt();
         
         boat bt =  new boat(name , type, Number , capacity);
		
	}

	public static void displayAll() {
		// TODO Auto-generated method stub
		
	}

	public static void showBoat() {
		// TODO Auto-generated method stub
		
	}

	public static void removeBoat() {
		// TODO Auto-generated method stub
		
	}

}
