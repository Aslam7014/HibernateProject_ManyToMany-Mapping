package com.jsp.HibernateProject_ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	
    	
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerName("Xaruk");
        
        Customer customer1 = new Customer();
        customer1.setCustomerId(2);
        customer1.setCustomerName("Aslam");
        
        
        
        Products product = new Products();
        product.setProductId(101);
        product.setProductName("Parle-G");
        
        Products product1 = new Products();
        product1.setProductId(102);
        product1.setProductName("Lays");
        
        Products product2 = new Products();
        product2.setProductId(103);
        product2.setProductName("Nicotex");
   
        
         product.getCustomer().add(customer);
         product.getCustomer().add(customer1);
        
         product1.getCustomer().add(customer);
         product1.getCustomer().add(customer1);
        
        customer.getProduct().add(product);
        customer.getProduct().add(product1);
        customer.getProduct().add(product2);
        
        customer1.getProduct().add(product);
        customer1.getProduct().add(product1);
        customer1.getProduct().add(product2);
    	
       
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Products.class).addAnnotatedClass(Customer.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session see = sf.openSession();
        Transaction tr = see.beginTransaction();
    
                
        see.save(customer);
        see.save(customer1);
        
        see.save(product);
        see.save(product1);
        see.save(product2);
        
        tr.commit();
        see.close();
	
    }
}
