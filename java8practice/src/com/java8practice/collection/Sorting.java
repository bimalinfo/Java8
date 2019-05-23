package com.java8practice.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

	public static void main(String[] args) {
		Employee e1=new Employee(11,"Bimal",1000);
		Employee e2=new Employee(1,"Nirimal",500);
		Employee e3=new Employee(21,"Samal",7000);
		Employee e4=new Employee(3,"Jhon",4000);
		List<Employee> listemp=new ArrayList<Employee>();
		listemp.add(e1);
		listemp.add(e2);
		listemp.add(e3);
		listemp.add(e4);
		
		List<Employee> l=listemp.stream().sorted((e5,e6)->((Integer)e5.getSalary()).compareTo(e6.getSalary())).collect(Collectors.toList());
		
		l.stream().forEach(s->{
			System.out.println(s.getName()+", "+s.getSalary());
		});
		
		System.out.println("----------------------------------------------------------------------------------");
		
		//There are various ways to sort
		//List<Employee> l1=listemp.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getId)).collect(Collectors.toList());
		//List<Employee> l1=listemp.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		List<Employee> l1=listemp.stream().sorted(Comparator.comparing(e->e.getName())).collect(Collectors.toList());
		l1.stream().forEach(s->{
			System.out.println(s.getName()+", "+s.getSalary());
		});
		

	}

}
