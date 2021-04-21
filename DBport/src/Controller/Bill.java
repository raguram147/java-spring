package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.JdbcInsert;
import DAO.JdbcSelect;
import DAO.JdbcUpdate;
import DAO.ShowBoat;
import Model.Boat;
import Model.bills;

public class Bill {

	static ArrayList<bills> b = new ArrayList<>();
	public static ArrayList<bills> getBill() {
		return b;
	}

	public static void addBill(bills br) {
		b.add(br);
		
	}
	static ArrayList<Boat> boats = new ArrayList<>();
	public static ArrayList<Boat> getBoats() {
		return boats;
	}

	public static void addBoats(Boat bt) {
		boats.add(bt);
		
	}

	public static void Create(Boat bt2, Scanner in) {
		// TODO Auto-generated method stub
		
		int id=bt2.getBoatNumber();
		int cap;
		System.out.println("Do you want to Update the Capacity/timing :Y/N ->");
		String c = in.nextLine();
		if(c.charAt(0)=='y' ||c.charAt(0)=='Y' ) {
			System.out.println("Enter the timing in hours :");
			int time  = in.nextInt();
			in.nextLine();			
			System.out.println("Enter the Capacity to Update :");
			cap  = in.nextInt();
			in.nextLine();
			System.out.println("Enter the Process of the Boat Loading/Unloading:");
			String status  = in.next();
			in.nextLine();
			if(status.equals("Loading")||status.equals("Unloading")) {
				JdbcInsert.billInsert(time,id,status);
				

			}
			JdbcUpdate.updatecap(cap,id);
			JdbcSelect.updatecap(id);
			JdbcSelect.bill(id);
			
			
			
		}
		ArrayList<Boat> b = null;
		b=ShowBoat.find(id);
//		String bname ;
		//int b_id ,b_cap ;
		System.out.println("==============================Bill Reciept===================================");
		String bname = null;
		int b_id = 0,b_cap = 0;
		for(Boat Bt: b) {
			bname=Bt.getBoatName();
			b_id=Bt.getBoatNumber();
			b_cap=Bt.getBoatCapacity();
		}
		ArrayList<bills> bt = null;
		bt=JdbcSelect.bill(id);
		String process = null;
		int bill_id = 0,b_t = 0;
		for(bills Bt: bt) {
			process=Bt.getProcess();
			bill_id=Bt.getbid();
			b_t=Bt.getTime();
		}
		
	Receipt.display(bill_id, b_t, b_id, b_cap, bname, process);
		
			
		
	}
	

}
