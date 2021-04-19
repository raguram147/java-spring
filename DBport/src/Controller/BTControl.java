package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.JdbcDelete;
import DAO.JdbcInsert;
import DAO.JdbcSelect;
import DAO.ShowBoat;
import Model.Boat;

public class BTControl {
	static ArrayList<Boat> boats = new ArrayList<>();
		public static ArrayList<Boat> getBoats() {
			return boats;
		}

		public static void addBoats(Boat bt) {
			boats.add(bt);
			
		}
	


	
	
//	public static void preprocess() {
//		boats.add(new Boat(9999, "Titanic", 50000));
//		boats.add(new Boat(7190, "Evergreen", 300));
//	}
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
         Boat bt =  new Boat(Number, name , capacity);
         boats.add(bt);
         JdbcInsert.insert(name,Number,capacity);
		
	}

	public static void displayAll() {
		// TODO Auto-generated method stub
//		ArrayList<Boat> b = getBoats();
//		
//		for(Boat Bt: b) {
//	
//			System.out.println("Boat Name : "+Bt.getBoatName() );
//			System.out.println("Boat Number : "+Bt.getBoatNumber() );
//			System.out.println("Boat Capacity : "+Bt.getBoatCapacity() );
//		
//			System.out.println("---------------------------");
//		}
		JdbcSelect.selectAll();
		
	}

	public static void showBoat(Scanner in) {
		// TODO Auto-generated method stub
		System.out.println("Enter Boat Number :");
		int num = in.nextInt();
		in.nextLine();
		ArrayList<Boat> boats = null;
		boats=ShowBoat.find(num);
		
		
		for(Boat Bt: boats) {
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
			else {
				System.out.println("==========x Boat NOT FOUND::INVALID NUMBER x===============");
			}

		}
		
		
	}

	public static void removeBoat(Scanner in) {
		// TODO Auto-generated method stub
		System.out.println("Enter Boat Number :");
		int num = in.nextInt();
		in.nextLine();
		JdbcDelete.DeleteDBOfBoat(num);
//		ArrayList<Boat> b = getBoats();
//		int size = b.size();
//		for(int i = 0 ; i <size ;i++) {
//			if(b.get(i).getBoatNumber()==num) {
//				b.remove(i);
//				break;
//			}
//		}
//		if(size-1 == b.size()) {
//			System.out.println("Successfully Removed");
//		}else {
//			System.out.println("Boat Not Found");
//		}
	}
	
	public static void billing(Boat bt, int time) {
		System.out.println("Amount to be paid : " + bt.getBoatCapacity()*10*time);
		
	}
}
