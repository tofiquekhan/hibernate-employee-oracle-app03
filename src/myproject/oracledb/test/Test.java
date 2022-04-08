package myproject.oracledb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import myproject.oracledb.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
		Configuration configuration = new Configuration();
		configuration.configure("/myproject/oracledb/resources/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Employee emp = new Employee();
		emp.setEno(101);
		emp.setEname("Tofique");
		emp.setEsal(78956.520f);
		emp.setEaddr("Indore");
		session.save(emp);
		tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
