package onetoone;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerFetch03 {

	public static void main(String[] args) {

		

		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Doctor03.class)
				.addAnnotatedClass(Stethoscope.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		//1 - id 1001 olan dr u fetch ediniz get methodu kullanarak
		
		Doctor03 dr1=session.get(Doctor03.class,1001);
		System.out.println(dr1);
		System.out.println("---------------");
		
		//2 - id 101 olan stettoskpu fetch ediniz get methodu kullanarak
		Stethoscope ste1=session.get(Stethoscope.class, 101);
		System.out.println(ste1);
		System.out.println("---------------");
		
		
		System.out.println(dr1.getStethoscope());
		System.out.println("---------------");
		System.out.println(ste1.getDoctor());
		
		//3- steteskoplu dr lari getiren hql sorgusu yaziniz
		
//		String hqlQuery1="select d.name, s.name  from Doctor03 d "
//				+ "inner join fetch Stethoscope s on d.id=s.doctor";
//		List<Object[] > resultList1=session.createQuery(hqlQuery1)
//				.getResultList();
//		
//		for (Object[] objects : resultList1) {
//			System.out.println(Arrays.toString(objects));
//		}
//		
//		//4- steteskoplu dr lari getiren sql sorgusu yaziniz
//		String sqlQuery1="select d.doctor_name, s.name  from tbl_doctor d "
//				+ "inner join tbl_stethoscope s on d.id=s.dr_id";
//		List<Object[] > resultList1=session.createSQLQuery(sqlQuery1)
//				.getResultList();
//		for (Object[] objects : resultList1) {
//			System.out.println(Arrays.toString(objects));
//		}
//		
//		//5) Fetch doctor name, stet name and doctor grade of records from Doctor table
//		String sql4 = "SELECT d.doctor_name, s.name, d.grade "
//				+ "FROM tbl_doctor d LEFT JOIN tbl_stethoscope s "
//				+ "on d.id=s.dr_id";
//		List<Object[]> resultList4 = session.createSQLQuery(sql4).
//				getResultList();
//		
//		for(Object[] w : resultList4) {
//			System.out.println(Arrays.toString(w));
//		}
//		//hql ile
//		String sql4 = "SELECT d.name, s.name, d.grade "
//				+ "FROM Doctor03 d LEFT JOIN  Stethoscope s "
//				+ "on d.id=s.doctor";
//		List<Object[]> resultList4 = session.createQuery(sql4).getResultList();
//		for(Object[] w : resultList4) {
//			System.out.println(Arrays.toString(w));
//		}
//		
//		//6) fetch doctor name, stet name and doctor grade of records from Stethoscope table
//		String sql5 = "SELECT d.doctor_name, s.name, d.grade "
//				+ "FROM tbl_stethoscope s Right JOIN tbl_doctor d "
//				+ "on d.id=s.dr_id";
//		List<Object[]> resultList5 = session.createSQLQuery(sql5).getResultList();
//		for(Object[] w : resultList5) {
//			System.out.println(Arrays.toString(w));
//		}
//		
//		//hql ile
//		String sql4 = "SELECT d.name, s.name, d.grade "
//				+ "FROM Stethoscope s Right JOIN  Doctor03 d "
//				+ "on d.id=s.doctor";
//		List<Object[]> resultList4 = session.createQuery(sql4).getResultList();
//		for(Object[] w : resultList4) {
//			System.out.println(Arrays.toString(w));
//		}
//		
//		//7) Fetch doctor name, stet name and dr grade of all records from Doctor03 and Stethoscope table
//		String sql5 = "SELECT d.doctor_name, s.name, d.grade "
//				+ "FROM tbl_stethoscope s FULL JOIN tbl_doctor d "
//				+ "on d.id=s.dr_id";
//		List<Object[]> resultList5 = session.createSQLQuery(sql5).getResultList();
//		for(Object[] w : resultList5) {
//			System.out.println(Arrays.toString(w));
//		}
//		
//		//hql ile
//		String sql4 = "SELECT d.name, s.name, d.grade "
//				+ "FROM Stethoscope s FULL JOIN  Doctor03 d "
//				+ "on d.id=s.doctor";
//		List<Object[]> resultList4 = session.createQuery(sql4).getResultList();
//		for(Object[] w : resultList4) {
//			System.out.println(Arrays.toString(w));
//		}
//
//        //8) Fetch all doctors information of common records from doctor and stethoscope table
//		String sql5 = "SELECT d.id, d.doctor_name, d.grade, d.email, d.branch,"
//				+ " s.ste_id, s.name "
//				+ "FROM tbl_stethoscope s INNER JOIN tbl_doctor d "
//				+ "on d.id=s.dr_id";
//		List<Object[]> resultList5 = session.createSQLQuery(sql5).getResultList();
//		for(Object[] w : resultList5) {
//			System.out.println(Arrays.toString(w));
//		}
//		//hql ile
//		String sql4 = "FROM Doctor03 d INNER JOIN FETCH Stethoscope s "
//				+ "on d.id=s.doctor";
//		List<Object[]> resultList4 = session.createQuery(sql4).getResultList();
//		for(Object[] w : resultList4) {
//			System.out.println(Arrays.toString(w));
//		}
//		
//		 //9) Fetch all doctors information of all records from Doctor03 and Stethoscope table
//		//hql ile
//		String sql4 = "FROM Doctor03 d FULL JOIN FETCH Stethoscope s "
//				+ "on d.id=s.doctor";
//		List<Object[]> resultList4 = session.createQuery(sql4).getResultList();
//		for(Object[] w : resultList4) {
//			System.out.println(Arrays.toString(w));
//		}
//		
//		
		
		
		tx.commit();
		session.close();
		sf.close();

	}

}
