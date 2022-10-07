package manytomany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch05 {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Doctor05.class)
				.addAnnotatedClass(Patient.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		// 1- 1001 id li doktorun i get methodu kullanarak
		// patientlerini yazdirin

		Doctor05 dr1 = session.get(Doctor05.class, 1001);
		// dr1.getPatientList().forEach(System.out::println);
		System.out.println(dr1.getPatientList());

		// 2- 101 id li patientin get methodu ile dr larini getirirn

		Patient pt = session.get(Patient.class, 101);
		System.out.println(pt.getDoctors());

		// 3- dr ve patient bilgileriniz getiriniz hql iler
		String hqlQuery1 = "SELECT d FROM Doctor05 d JOIN FETCH d.patientList b";
		List<Doctor05> resultList1 = session.createQuery(hqlQuery1, Doctor05.class).getResultList();

		for (Doctor05 w : resultList1) {
			System.out.println(w);
		}
		
		
		
		
		
		
		
		
		

		tx.commit();
		session.close();
		sf.close();

	}
}
