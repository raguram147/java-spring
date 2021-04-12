package GUI;

import java.util.ArrayList;
import java.util.Scanner;

public class BTControl {
	static ArrayList<boat> boats = new ArrayList<>();
		public static ArrayList<boat> getBoats() {
			return boats;
		}

		public static void addBoats(boat bt) {
			boats.add(bt);
		}
	


	
	
	public static void preprocess() {
		boats.add(new boat("Titanic", 9999, 50000));
		boats.add(new boat("Evergreen", 7190, 300));
	}
	public static void addToList(Scanner in ) {
		// TODO Auto-generated method stub
		
		 System.out.println("Enter the Boat Name");
		String  name=in.nextLine();
		 System.out.println("Enter the Boat Number ");
		int  Number=in.nextInt();
		 in.nextLine();
        
    	 System.out.println("Enter the Boat Capacity ");
         int capacity = in.nextInt();
         in.nextLine();
         boat bt =  new boat(name, Number , capacity);
         boats.add(bt);
		
	}

	public static void displayAll() {
		// TODO Auto-generated method stub
		ArrayList<boat> b = getBoats();
		
		for(boat Bt: b) {
	
			System.out.println("Boat Name : "+Bt.getBoatName() );
			System.out.println("Boat Number : "+Bt.getBoatNumber() );
			System.out.println("Boat Capacity : "+Bt.getBoatCapacity() );
		
			System.out.println("---------------------------");
		}
		
	}

	public static void showBoat(Scanner in) {
		// TODO Auto-generated method stub
		System.out.println("Enter Boat Number :");
		int num = in.nextInt();
		in.nextLine();
		ArrayList<boat> b = getBoats();
		
		for(boat Bt: b) {
			if(Bt.getBoatNumber()==num) {
				System.out.println("Boat Name : "+Bt.getBoatName() );
				System.out.println("Boat Number : "+Bt.getBoatNumber() );
				System.out.println("Boat Capacity : "+Bt.getBoatCapacity() );
				
				System.out.println("---------------------------");
				System.out.println("Berthing Bill : Y/N ->");
				String ch = in.nextLine();
				
				
				if(ch.charAt(0)=='y' ||ch.charAt(0)=='Y' ) {
					System.out.println("Enter the timing in hours :");
					int time  = in.nextInt();
					in.nextLine();
					billing(Bt, time);
				}
				break;
			}

		}
		
		
	}

	public static void removeBoat(Scanner in) {
		// TODO Auto-generated method stub
		System.out.println("Enter Boat Number :");
		int num = in.nextInt();
		in.nextLine();
		ArrayList<boat> b = getBoats();
		int size = b.size();
		for(int i = 0 ; i <size ;i++) {
			if(b.get(i).getBoatNumber()==num) {
				b.remove(i);
				break;
			}
		}
		if(size-1 == b.size()) {
			System.out.println("Successfully Removed");
		}else {
			System.out.println("Boat Not Found");
		}
	}
	
	public static void billing(boat bt, int time) {
		System.out.println("Amount to be paid : " + bt.getBoatCapacity()*10*time);
		
	}
}
