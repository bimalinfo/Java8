package com.java8practice.collection;


public class MyDataImpl implements MyData {

	
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	
	@Override
	public void print(String str){
		System.out.println("print in overriden method");
	}
	public static void main(String args[]){
		MyDataImpl obj = new MyDataImpl();
		obj.print("");
		obj.isNull("abc");
		obj.display("Display of MydataImpl");
	}

	@Override
	public void display(String str) {
		System.out.println("Display in overriden method");
		
	}
}

