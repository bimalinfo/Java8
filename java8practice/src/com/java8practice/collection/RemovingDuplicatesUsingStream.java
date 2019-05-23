package com.java8practice.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemovingDuplicatesUsingStream {

	public static void main(String[] args) {
		/*List<Integer> list = new ArrayList<>( Arrays.asList(1, 10, 1, 2, 2, 3, 10, 3, 3, 4, 5, 5)); 

		System.out.println("ArrayList with duplicates: "+ list); 
		List<Integer> newList = list.stream().distinct().collect(Collectors.toList()); 
		System.out.println("ArrayList with duplicates removed: "+ newList);*/ 
		List<String> list = new ArrayList<>( Arrays.asList("s1", "s2","s1"));
		List<String> newList = list.stream().distinct().collect(Collectors.toList()); 
		System.out.println("ArrayList of Strings with duplicates removed: "+ newList);
		//int s=newList.stream().filter(i->i<=10).mapToInt(i->i).sum();
		
		long  c=newList.stream().filter(s->s.startsWith("s")).count();
		boolean b=newList.stream().anyMatch(s->s.endsWith("1"));
		System.out.println("b-->"+b);
		
		//List
		Stream<String> str=newList.stream();
			str.forEach(action->{
				if(action.equals("s2")){
					System.out.println("action:"+action);
				}
			});
		
			newList.forEach(action->{
				if(action.equals("s2")){
					System.out.println("action:"+action);
				}
			});

		//Map
		Map<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(1, "Monkey");
		hmap.put(2, "Dog"); 
		hmap.put(3, "Cat");
		hmap.put(4, "Lion"); 
		hmap.put(5, "Tiger"); 
		hmap.put(6, "Bear");
		
		hmap.forEach((key,val)->{
			System.out.println("key: "+key+" Value: "+val);
		});
		
	}

}
