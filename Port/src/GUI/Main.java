package GUI;

import java.util.InputMismatchException;
import java.util.Scanner;

import GUI.BTControl;

public class Main {
	
	public static void main(String[] args) {
		BTControl.preprocess();
		Scanner in =new Scanner(System.in);

		do {
			try {
				System.out.println("================x HARBOUR SYSTEM x====================");
	            System.out.println("1.New Boat ");
	            System.out.println("2.Display all boat");
	            System.out.println("3.Show specific boat");
	            System.out.println("4.Remove specific boat");
	            System.out.println("5.Exit");
	            System.out.println("================x HARBOUR SYSTEM x====================");
	            int ch = in.nextInt();
	            in.nextLine();
	            if ((ch)==1 ) {
	            	System.out.println("================x HARBOUR SYSTEM ADD BOAT x====================");
	                BTControl.addToList(in);  // need to somehow "start" this class 

	            } else if ((ch)==2 ) {
	            	System.out.println("================x HARBOUR SYSTEM DISPLAY x====================");
	                BTControl.displayAll();
	                System.out.println("================x HARBOUR SYSTEM DISPLAY x====================");

	            } else if ((ch)==3 ){
	            	System.out.println("================x HARBOUR SYSTEM BOAT DETAILS x====================");
	                BTControl.showBoat(in);
	            	System.out.println("================x HARBOUR SYSTEM BOAT DETAILS x====================");


	            } else if ( (ch)==4 ) {
	            	System.out.println("================x HARBOUR SYSTEM REMOVE BOAT x====================");

	            	BTControl.removeBoat(in);
	            	System.out.println("================x HARBOUR SYSTEM REMOVE BOAT x====================");

	            } else if ((ch==5) ) {
	            	System.out.println("================x BYE x====================");
	            	break;
	            }
			}
			catch(InputMismatchException e){
				System.out.println("Enter Valid Option");
			}
			
		}while(true);
		

	}

}
