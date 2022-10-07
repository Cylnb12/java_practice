package embedable;

import java.util.Arrays;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RunnerFetch02 {

	public static void main(String[] args) {

		
		  Doctor02 dr1 = new Doctor02();
		  Doctor02 dr2 = new Doctor02(); 
		  Doctor02 dr3 =new Doctor02();
		 

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Doctor02.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s1 = sf.openSession();

		Transaction tx = s1.beginTransaction();
		//onemli olan iliskiler cok onemli
		//

		//1001 id li  dr nin edu bilgilerini cekin 
		//Doctor02 dr1 = s1.get(Doctor02.class, 1001);
		
		System.out.println(dr1);
		
		tx.commit();
		s1.close();
		sf.close();

	}

}
