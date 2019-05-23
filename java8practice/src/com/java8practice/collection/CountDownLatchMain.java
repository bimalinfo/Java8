package com.java8practice.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchMain {

	public static void main(String[] args) {
		//ApplicationUtil applicationUtil=new ApplicationUtil();
		boolean result=false;
		try{
			result=ApplicationUtil.getInstance().checkExternalServices();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Result"+result);
	}

}

abstract class baseservice implements Runnable {
	private CountDownLatch cdl;
	private boolean serviceUp;
	private String serviceName;

	public baseservice(){
		
	}
	public baseservice(String seriveName,CountDownLatch cdl){
		super();
		this.serviceName=serviceName;
		this.cdl=cdl;
	}
	public CountDownLatch getCdl() {
		return cdl;
	}

	public void setCdl(CountDownLatch cdl) {
		this.cdl = cdl;
	}

	public boolean isServiceUp() {
		return serviceUp;
	}

	public void setServiceUp(boolean serviceUp) {
		this.serviceUp = serviceUp;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public  abstract void verifyService();

	@Override
	public void run() {
		try {
			System.out.println("Service call Run method");
			verifyService();
			serviceUp = true;
		} catch (Exception e) {
			e.printStackTrace();
			serviceUp = false;
		} finally {
			cdl.countDown();
			System.out.println("...................count------------------------"+cdl.getCount());
		}
	}

}

class networkservice extends baseservice {

	public networkservice(CountDownLatch latch){
		super("Network Service",latch);
	}
	@Override
	public void verifyService() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Network service is up");
	}
}

class databaseservice extends baseservice {
	
	public databaseservice(CountDownLatch latch){
		super("Database Service",latch);
	}
	
	@Override
	public void verifyService() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Database service is up");
	}
}

class ApplicationUtil {
	// List of service checkers
	private static List<baseservice> _services;

	// This latch will be used to wait on
	private static CountDownLatch _latch;

	private ApplicationUtil() {
	}

	private final static ApplicationUtil INSTANCE = new ApplicationUtil();

	public static ApplicationUtil getInstance() {
		return INSTANCE;
	}

	public static boolean checkExternalServices() throws Exception
	{
	//Initialize the latch with number of service checkers
		_latch = new CountDownLatch(2);
	
	//All add checker in lists
		_services = new ArrayList<baseservice>();
		_services.add(new networkservice(_latch));
		_services.add(new databaseservice(_latch));
	
		//Start service checkers using executor framework
		Executor executor = Executors.newFixedThreadPool(_services.size());

		for (final baseservice v : _services) {
			executor.execute(v);
		}
	
		//Now wait till all services are checked
		_latch.await();

	//Services are file and now proceed startup
	for(final baseservice v : _services) 
	{
		if( ! v.isServiceUp())
		{
			return false;
		}
	}
	return true;
	}
}
