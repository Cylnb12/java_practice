package annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

public static void main(String[] args) {
		
	
	
		Doctor01 dr1 =new Doctor01(1001,"adam fawer", 11,"adam@email.com","kbb");
		Doctor01 dr2 =new Doctor01(1002,"gel git", 12,"er@email.com","goz");
		Doctor01 dr3 =new Doctor01(1003,"dr strange", 13,"s@email.com","kalp");
		
		Doctor01 dr4 =new Doctor01();
		dr4.setId(1004);
		dr4.setName("John Coffee");
		dr4.setGrade(10);
		dr4.setBranch("kbb");
		
		
		Configuration con = new     
                  Configuration().configure("hibernate.cfg.xml").
                  addAnnotatedClass(Doctor01.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
			
		session.save(dr1);
		session.save(dr2);
		session.save(dr3);
		session.save(dr4);
		
		
		
		
		tx.commit();

		session.close();

		sf.close();
	}
}
