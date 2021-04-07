package GUI;

import java.util.InputMismatchException;
import java.util.Scanner;

import GUI.BTControl;

public class Main {
	static Scanner in =new Scanner(System.in);

	public static void main(String[] args) {
		do {
			try {
				System.out.println("================x HARBOUR SYSTEM x====================");
	            System.out.println("1.New Boat ");
	            System.out.println("2.Display all boat");
	            System.out.println("3.Brething");
	            System.out.println("5.Show specific boat");
	            System.out.println("6.Remove specific boat");
	            System.out.println("7.Exit");
	            System.out.println("================x HARBOUR SYSTEM x====================");
	            int ch = in.nextInt();
	            if ((ch)==1 ) {
	                BTControl.addToList();  // need to somehow "start" this class 

	            } else if ((ch)==2 ) {
	                BTControl.displayAll();

	            } else if ((ch)==3 ){
	                BTControl.showBoat();

	            } else if ( (ch)==4 ) {
	                BTControl.removeBoat();

	            } else if ( (in.nextInt(ch)==5) ) {
	            	System.out.println("================x BYE x====================");
	            }
			}
			catch(InputMismatchException e){
				
			}
			
		}while(true);
		

	}

}
