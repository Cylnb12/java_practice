package onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
	public static void main(String[] args) {
		
		Patient pt1=new Patient();
		pt1.setId(1001);
		pt1.setName("ahdas katas");
		pt1.setProblem("kulak , bobrek");
		
		Patient pt2=new Patient();
		pt2.setId(1002);
		pt2.setName("katay yuyka");
		pt2.setProblem("goz , cild");
		
		Patient pt3=new Patient();
		pt3.setId(1003);
		pt3.setName("asder tas");
		pt3.setProblem("migde");
		
		
		Appointment app1=new Appointment();
		app1.setId(101);
		app1.setName("ahdas's ear appointment");
		
		Appointment app2=new Appointment();
		app2.setId(102);
		app2.setName("ahdas's kidney appointment");
		
		Appointment app3=new Appointment();
		app3.setId(103);
		app3.setName("katay's eyes appointment");
		
		Appointment app4=new Appointment();
		app4.setId(104);
		app4.setName("katay's leather appointment");
		
		Appointment app5=new Appointment();
		app5.setId(105);
		app5.setName("asder's gastro appointment");
		
		app1.setPatient(pt1);//many olana one olani set ediyoruz yoksa one olana many tane set zor olurdu
		app2.setPatient(pt1);
		app3.setPatient(pt2);
		app4.setPatient(pt2);
		app5.setPatient(pt3);
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Appointment.class)
				.addAnnotatedClass(Patient.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		
		session.save(pt1);
		session.save(pt2);
		session.save(pt3);

		session.save(app1);
		session.save(app2);
		session.save(app3);
		session.save(app4);
		session.save(app5);
		
		
		
		tx.commit();
		session.close();
		sf.close();
		
	}

}
