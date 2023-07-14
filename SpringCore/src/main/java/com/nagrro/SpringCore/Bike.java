package com.nagrro.SpringCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {
	
	@Autowired
	Tyre t;
	
	
	public Tyre getT() {
		return t;
	}


	public void setT(Tyre t) {
		this.t = t;
	}


	public void drive() {
		System.out.println("Bhaag rhi h ");		
		System.out.println(t);
		
	}

}
