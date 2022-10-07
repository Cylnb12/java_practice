package annotations;

import java.util.Arrays;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RunnerFetch01 {

	public static void main(String[] args) {
		
		Doctor01 dr1 = new Doctor01();
		Doctor01 dr2 = new Doctor01();
		Doctor01 dr3 = new Doctor01();
		
		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Doctor01.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s1 = sf.openSession();
		
		Transaction tx = s1.beginTransaction();
		
		
//		  dr1 = s1.get(Doctor01.class, 1001); 
//		  dr2 = s1.get(Doctor01.class, 1002);
//		  dr3 = s1.get(Doctor01.class, 1003);
		 
		
		
//		  System.out.println(dr1); 
//		  System.out.println(dr2); 
//		  System.out.println(dr3);
		 
		  
		
		/*
		 * String sqlQuery1="select * from tbl_doctor"; List<Object[]>
		 * resultList1=s1.createSQLQuery(sqlQuery1).getResultList();
		 * 
		 * for (Object[] str : resultList1) {
		 *  System.out.println(Arrays.toString(str));
		 * }
		 */
		  
		 //2.  yol 
		
			/*
			 * String sqlQuery2="select * from tbl_doctor"; Query
			 * query1=s1.createSQLQuery(sqlQuery2); List<Object[]>
			 * resultList2=query1.getResultList(); for (Object[] str : resultList2) {
			 * System.out.println(Arrays.toString(str)); }
			 */
		
		
		//hql query
		/*
		 * String hqlQuery1="FROM Doctor01";// fromdan sonra clss ismi kullanilmali
		 * List<Doctor01>
		 * resultList3=s1.createQuery(hqlQuery1,Doctor01.class).getResultList();
		 *  for
		 * (Doctor01 str : resultList3) { System.out.println(str); }
		 */
		 
		 //donecek kaydin unique ise uniqueResult() metodu kullanilabilir.
			
			  String sqlQuery2= "Select * from tbl_doctor where "
			  		+ "doctor_name='gel git'";
			  Object[] uniqueResult1 = (Object[])
			  s1.createSQLQuery(sqlQuery2).uniqueResult();
			  
			  System.out.println(Arrays.toString(uniqueResult1));
			  
			  //doctorun bransini getirin
			  
			  System.out.println(uniqueResult1[1]);
			 
		
			// HQL ile unique result sorgulama
			
			  String hqlQuery2="FROM Student01 where name='John Coffee'"; 
			  Doctor01 uniqueResult2= s1.createQuery(hqlQuery2,Doctor01.class).
					  uniqueResult();
			  System.out.println(uniqueResult2);
			 
			
			// HQL ile Alias kullanma örneği
			/*
			 * String hqlQuery2="FROM Student01 std where std.name='John Coffee'"; Doctor01
			 * uniqueResult2= s1.createQuery(hqlQuery2,Doctor01.class).uniqueResult();
			 * System.out.println(uniqueResult2);
			 */
			
			// HQL ile belirli değişkenleri alma
			// barnch kbb  olan dr leri getir.
		
			/*
			 * String hqlQuery3 = "SELECT d.id,d.name FROM Doctor01 d where d.branch='kbb'";
			 * List<Object[]> resulList4 = s1.createQuery(hqlQuery3).getResultList();
			 * 
			 * for (Object[] objects : resulList4) {
			 * 
			 * System.out.println(Arrays.toString(objects)); }
			 */
			
			
			//id ye gore terstten dirali getiren hql query yaziniz 
		
			  String hqlQuery4="FROM Doctor01 s order by s.id desc";
			  
			  List<Doctor01> resultList5=
					  s1.createQuery(hqlQuery4,Doctor01.class).getResultList();
			  
			  for (Doctor01 dr : resultList5) {
				  System.out.println(dr); }
			 
		  tx.commit(); 
		  s1.close(); 
		  sf.close();
		 
		
		
	}

}
