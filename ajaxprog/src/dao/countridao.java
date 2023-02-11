package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.countryvo;

public class countridao {
	public void insert(countryvo v){
		
		try
    	{
    		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
    		
    		Session session = sessionfactory.openSession();
    		
    		Transaction transaction = session.beginTransaction();
    		
    		session.save(v);
    		
    		transaction.commit();
    		session.close();
    		
    	}
    	catch (Exception e) {
		
    		e.printStackTrace();
		}
	}
	public List search(countryvo v1)
	{
		 List ls= new ArrayList();
 		
		 try
			{
			
			
			 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	    		
	    		Session session = sessionfactory.openSession();
	    		Query q=session.createQuery("from countryvo");
			
				ls=q.list();
			session.close();
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		 return ls;
		
	}

	}
