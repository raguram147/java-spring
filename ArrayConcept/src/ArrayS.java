import java.util.Arrays;
import java.util.Scanner;

public class ArrayS {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);  
		  
		int[] array = new int[10];  
		System.out.println("Enter the elements of the array: ");  
		for(int i=0; i<5; i++)  
		{  
		  	array[i]=sc.nextInt();  
		} 
		
		System.out.println("Elements of the array: ");  
		for(int i=0; i<5; i++)  
		{  
			System.out.println(array[i]);  

		  
		} 
		int temp;
		   for (int i = 1; i < array.length; i++) {
		    for (int j = i; j > 0; j--) {
		     if (array[j] < array [j - 1]) {
		      temp = array[j];
		      array[j] = array[j - 1];
		      array[j - 1] = temp;
		     }
		    }
		   }
		   System.out.println("Elements After Sorting of the array: ");  
		for(int i=0; i<5; i++)  
		{  
			System.out.println(array[i]);  

		  
		} 
	}
}
