package com.java8practice.collection;

public class StringConcepts {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = new String("abc");
		s2=s2.intern();
		System.out.println(s1 ==s2);//true
		
		
		StringBuffer s3 = new StringBuffer(s1);
		System.out.println(s2.equals(s3));//false



	}

}
