package com.functionalinterface;


class functionalinterfaceTest{
	public static void main(String []s){
		int area=10;
		Shape side=(int a)->a*a;
		int result=side.calculateArea(area);
		System.out.println(result);
	}
}