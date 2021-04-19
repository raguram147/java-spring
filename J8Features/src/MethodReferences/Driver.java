package MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//method reference indicated using symbol ::
public class Driver {

	public static void main(String[] args) {
		// foreach method
		List<String> names=new ArrayList<String>();
		names.add("Ragu");
		names.add("Mano");
		names.add("John");
		names.forEach(System.out::println);
		//Optional and Stream Class
		List<Integer> number=Arrays.asList(1,12,15,7,36);
		Optional<Integer>mx=number.stream().reduce(Math::max);
		mx.ifPresent(value-> System.out.println(value));
		Optional<Integer>mn=number.stream().reduce(Math::min);
		mn.ifPresent(value-> System.out.println(value));
		
		//Method reference to instance method
		
		List<String> str=Arrays.asList("hi","bye","Hello","Hiao");
		//Lambda Expression
		List<String> Sorted=str.stream().sorted((s1,s2)->s1.compareTo(s2)).collect(Collectors.toList());
		System.out.println(Sorted);

		//new instance of arraylist use of ArrayList::new 
		
	}

}
