package com.demo.DemoHib;
//
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Transaction;
//import java.util.List;
//import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//
public class App 
{

    public static void main( String[] args )
    {
    	
    	AlienName an=new AlienName();
    	an.setFname("Manish");
    	an.setMname("babu");
    	an.setLname("Sahay");
    	
        
        Alien telusko=new Alien();
        telusko.setAid(106);
        telusko.setAname(an);
        telusko.setColor("Green");// in transient state 
        
        
        Configuration con= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        
        //ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        
//        session.save(telusko);// in persistent state 
        
//        telusko.setColor("Voilet");  // in persistent state 
        
        
//   For fetching the value      
        telusko=(Alien)session.get(Alien.class, 106);
//        or
//        telusko=(Alien)session.load(Alien.class, 101);  // Gives Proxy Object
        System.out.println( telusko );
        
        
        
//   Using HQL in hibernate     
//        Query q=session.createQuery("from Alien where aid=102");
//        List<Alien> aliens=q.list();
//        for (Alien a: aliens) {
//        	System.out.println( a );
//        }

        
        tx.commit();
//        telusko.setColor("Cyan");// In Detach state so does not got updated

        
//        System.out.println( telusko );
    }
}



