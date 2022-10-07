package manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class RunnerSave05 {

	public static void main(String[] args) {
		Doctor05 dr1 = new Doctor05();
		dr1.setId(1001);
		dr1.setName("rick rich");
		dr1.setGrade(12);
		dr1.setBranch("genel cerrah");
		dr1.setEmail("email");
	
		Doctor05 dr2 = new Doctor05();
		dr2.setId(1002);
		dr2.setName("kemal cek");
		dr2.setBranch("goz");
		dr2.setEmail("aeemail.com");
		dr2.setGrade(14);
		
		Doctor05 dr3 = new Doctor05();
		dr3.setId(1003);
		dr3.setName("cihan set");
		dr3.setBranch("kalp");
		dr3.setEmail("aeaaemail.com");
		dr3.setGrade(15);
		
		Patient pt1=new Patient();
		pt1.setId(101);
		pt1.setName("artemis");
		pt1.setProblem("tibia fraktur");
		
		Patient pt2=new Patient();
		pt2.setId(102);
		pt2.setName("semiramis");
		pt2.setProblem("frontalde fraktur");
		
		//patintleri listte tutucam
		List<Patient> patientList1=new ArrayList<>();
		patientList1.add(pt1);
		patientList1.add(pt2);
		dr1.setPatientList(patientList1);//hastalari listte topladik ve ilgili doktora bu list i verdik
		
		List<Patient> patientList2=new ArrayList<>();
		patientList2.add(pt1);
		patientList2.add(pt2);
		dr2.setPatientList(patientList2);
		
		List<Patient> patientList3=new ArrayList<>();
		patientList3.add(pt1);
		dr3.setPatientList(patientList2);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Doctor05.class)
				.addAnnotatedClass(Patient.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dr1);
		session.save(dr2);
		session.save(dr3);
		session.save(pt1);
		session.save(pt2);
		
		
		tx.commit();
		session.close();
		sf.close();


	}

}
