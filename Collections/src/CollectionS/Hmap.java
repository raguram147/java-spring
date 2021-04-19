package CollectionS;

import java.util.ArrayList;
import java.util.HashMap;
public class Hmap {
	public static void main(String args[]) {
		ArrayList<Integer>ar=new ArrayList<Integer>();
		ar.add(20000);
		ar.add(50000);
		ar.add(45000);
		for(Integer i:ar) {
			System.out.println("Salary :"+ i);
		}
		HashMap<String, String> hm=new HashMap<String, String>();

		hm.put("Ragu", "TL");
		hm.put("Ram", "ASE");
		hm.put("Sundar", "CEO");
		for(String i:hm.keySet()) {
			System.out.println("Name :"+ i +"\nPosition: "+hm.get(i));
		}
	}

}
