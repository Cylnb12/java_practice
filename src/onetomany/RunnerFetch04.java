package onetomany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {
	public static void main(String[] args) {

		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Appointment.class)
				.addAnnotatedClass(Patient.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
	
		
		//1- 1001 id li patient in get methodu kullanarak appointmentlerini yazdirin
		Patient pt1=session.get(Patient.class, 1001);
				pt1.getAppointmentList().forEach(System.out::println);
		
				
		// 2- SQL query hasta ve randevu bilgilerini getirelim
//		 String sqlQuery1="SELECT p.patient_name ,a.name FROM Patient p INNER JOIN Appointment a ON p.id=a.pt_id";           
//		 List<Object[]> resultList1= session.createSQLQuery(sqlQuery1).getResultList();
//		
//		 for (Object[] objects : resultList1) {
//					System.out.println(Arrays.toString(objects));
//				}
		
		//3- hql ile
//		 String hqlQuery1="SELECT p.name,a.name FROM Patient p INNER JOIN fetch Appointment a ON p.id=a.patient";
//		List<Object[]> resultList2= session.createQuery(hqlQuery1).getResultList();
//		resultList2.forEach(oa->System.out.println(Arrays.toString(oa)));
		
		
		
		// 4- patient table siliniz 
//		String sqlQuery2="DELETE FROM Patient";
//		int numOfRec= session.createSQLQuery(sqlQuery2).executeUpdate();
//		System.out.println("Effected Row count:"+numOfRec);
		
		// 5- Appointment table siliniz 
//		String sqlQuery3="DELETE FROM Appointment";
//		int numOfRec2= session.createSQLQuery(sqlQuery3).executeUpdate();
//		System.out.println("Effected Row count:"+numOfRec2);
		

		//6- 
//		String sqlQuery3="select * FROM Appointment";
//		 List<Object[]> resultList1= session.createSQLQuery(sqlQuery3).getResultList();
//		 for (Object[] objects : resultList1) {
//					System.out.println(Arrays.toString(objects));
//					}
		
		
		
		//7- 1001 id li patient in randevusunu siliniz
			String hqlQuery3="delete FROM Appointment b WHERE b.patient=1001";
			int numOfRec5= session.createQuery(hqlQuery3).executeUpdate();
			System.out.println("Effected Row count:"+numOfRec5);
		
		
		
		 //8- 1003 id li patient i siliniz
		Patient pt = session.get(Patient.class, 1003);
		session.delete(pt);
		
		//9- Fetch the owner of a appointment whose id is 101 by using get() method
		Appointment app = session.get(Appointment.class, 101);
		Patient pt = session.get(Patient.class, app.getPatient().getId());
		System.out.println(pt);
		
		
		
		
		
		
		
		
		
		
	}
}
