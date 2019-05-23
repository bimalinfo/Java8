package com.java8practice.collection;

public class GenericClass<U,V> {
	
	private U p1;
	private V p2;
	
	public GenericClass(U p1, V p2){
		this.p1=p1;
		this.p2=p2;
	}
	
	public void printData(){
		System.out.println("P1= "+p1.getClass().getName()+":"+p1.toString());
		System.out.println("P2= "+p2.getClass().getName()+":"+p2.toString());
	}

}
