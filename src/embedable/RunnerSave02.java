package embedable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

public static void main(String[] args) {
		
	
		Doctor02 dr1 =new Doctor02(1001,"adam fawer", 11,"adam@email.com","kbb");
		Doctor02 dr2 =new Doctor02(1002,"gel git", 12,"er@email.com","goz");
		Doctor02 dr3 =new Doctor02(1003,"dr strange", 13,"s@email.com","kalp");
		
		Education edu1=new Education();
		edu1.setUniversity("itu");
		edu1.setCity("istabnuk");
		edu1.setCountry("tr");
		edu1.setDegree(99);
		
		dr1.setEducation(edu1);
		
		Configuration con = new     
                  Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Doctor02.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
			
		session.save(dr1);
		/*
		 * session.save(dr2); session.save(dr3);
		 */
		
		
		
		
		
		tx.commit();

		session.close();

		sf.close();
	}
}
