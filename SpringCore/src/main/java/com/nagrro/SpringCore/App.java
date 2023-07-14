package com.nagrro.SpringCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
//    	System.out.println( "hello" );
    	
//    	ApplicationContext context=new ClassPathXmlApplicationContext("Spring1.xml");
    	
//    	Tyre t=(Tyre) context.getBean("tyre");
//    	t.setBrand("MRF");
    	
//    	Vehicle obj= (Vehicle)context.getBean("car");
        
//        Vehicle obj=new Car();
//        obj.drive();
    	
//    	Tyre t=(Tyre) context.getBean("tyre");
//    	t.setBrand("MRF");
//    	System.out.println( t );
    	
    	
//       Now only annotation based configuration will be used
    	
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
    	Tyre t=(Tyre) context.getBean(Tyre.class);
    	t.setBrand("Ceat");
    	Bike b=context.getBean(Bike.class);
    	b.drive();
    	
    }
}
