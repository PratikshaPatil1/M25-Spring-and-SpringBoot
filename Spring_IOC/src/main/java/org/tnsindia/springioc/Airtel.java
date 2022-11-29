package org.tnsindia.springioc;

public class Airtel implements Sim{

	public void calling() {
          System.out.println("Calling using Airtel");		
	}

	public void data() {
           System.out.println("Internet using Airtel");		
	}
      
	//constructor
	
	public Airtel() {
		super();
		System.out.println("Airtel class Constructor");
	}
	
	

}
