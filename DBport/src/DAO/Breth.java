package DAO;

import Model.Boat;

public class Breth {
	
 public static void bill(Boat bt, int time) {
	 System.out.println("Amount to be paid : " + bt.getBoatCapacity()*10*time);
	 
 }
}
