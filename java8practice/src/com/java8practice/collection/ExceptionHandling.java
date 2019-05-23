package com.java8practice.collection;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testExceptions();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException ioex){
			ioex.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		

	}
	
	public static void testExceptions() throws IOException, FileNotFoundException{
		
	}


}
