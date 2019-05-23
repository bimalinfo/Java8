package collections.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.java8practice.collection.Employee;

public class ArrayListRemoveDuplicates {
	
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list){
		Set<T> set=new HashSet<T>();
		set.addAll(list);
		list.clear();
		list.addAll(set);
		return list;
	}
	
	public static void main(String[] arg){
		ArrayList <Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(3);
		
		
		list.stream().distinct().forEach(i->{
			if(i!=1){
				System.out.println(i);
			}
		});
		//ArrayList<Integer> listi=removeDuplicates(list);
		//listi.stream().forEach(i->System.out.println(i));
		//System.out.println("listi"+listi);
		
		Employee e=new Employee(1);
		ArrayList <Employee> liste=new ArrayList<Employee>();
		liste.add(e);
		
		e=new Employee(2);
		liste.add(e);
		
		liste.stream().forEach(e1->{
			/*Employee e2=(Employee)e1;
			System.out.println(e2.getId());*/ //Not need to cast
			System.out.println(e1.getId());
		});
			
		
		
			
		
	}

}
