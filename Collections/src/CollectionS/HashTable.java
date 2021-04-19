package CollectionS;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTable {
	public static void main(String args[])
    {
        // No need to mention the
        // Generic type twice
        Map<Integer, String> hm = new HashMap<>();
  
        // Inserting the Elements
        // using put() method
        hm.put(1, "one");
        hm.put(2, "two");
        hm.put(3, "three");
  
        Hashtable<Integer, String> ht2
            = new Hashtable<Integer, String>(hm);
  
        // Print mappings to the console
  
        System.out.println("Mappings of ht2 : " + ht2);
    }

}
