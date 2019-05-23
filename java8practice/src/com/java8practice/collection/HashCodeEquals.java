package com.java8practice.collection;

import java.util.HashMap;
import java.util.Map;

public class HashCodeEquals {

	public static void main(String[] args) {
		Employee emp1=new Employee(1);
		Employee emp2=new Employee(1);
		
		Map<Employee,String> map1=new HashMap<Employee,String>();
		map1.put(emp1, "one");
		map1.put(emp2, "one");
		
		//Output 2 as //hashCode and equals method is not overriden in employee class which checks equals method of Object class where references are are checked which is 2
		//If we override hashCode and equals method of employee class then output becomes 1 as both the objects hasve same value "one".
		System.out.println(map1.size()); 
		
		Integer i1=new Integer(1); //Output 1 as hashCode and equals method is overriden in wrapper classes which checks value
		Integer i2=new Integer(1);
		
		Map<Integer,String> map2=new HashMap<Integer,String>();
		map2.put(i1, "one");
		map2.put(i2, "one");
		
		System.out.println(map2.size());
	}

}
