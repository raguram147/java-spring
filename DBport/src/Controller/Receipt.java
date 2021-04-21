package Controller;

public class Receipt {

	public static int bill(int t, int ca) {
		// TODO Auto-generated method stub
		return (t*ca);
		
	}

	public static void display(int b, int t, int bid, int ca, String name, String st) {
		// TODO Auto-generated method stub
		
		
		System.out.println("==============================Bill Reciept===================================");
		System.out.println("RECIEPT NO: "+b);
		System.out.println("");

		System.out.println("BOAT NAME    :"+name+"\t\t\t\tBOAT ID :"+bid);
		System.out.println("");
		System.out.println("BOAT CAPACITY:"+ca+"\t\t\t\tTIME   :"+t+"hrs  PROCESS :"+st);
		System.out.println("");
		//System.out.println("AMOUNT TO BE PAID :"+amt);


		System.out.println("===================Please Collect The Correct Amount==========================");
		
	}

}
