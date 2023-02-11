package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.util.*;

import vo.statevo1;
import vo.countryvo;

public class statedao {
public void insert(statevo1 v){
		
		try
    	{
    		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
    		
    		Session session = sessionfactory.openSession();
    		
    		Transaction transaction = session.beginTransaction();
    		
    		session.save(v);
    		
    		transaction.commit();
    		session.close();
    		
    	}
		catch(Exception e)
		{
			System.out.println(e);
		}
}
public	List search(statevo1 v1)
{
	 List ls= new ArrayList();
	
	 try
		{
		
		
		 SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
 		
 		Session session = sessionfactory.openSession();
 		Query q=session.createQuery("from statevo1 where cid = '"+v1.getCid().getId()+"' ");
 		
		
		
		
			ls=q.list();
		
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	 return ls;
}
}
