package com.mahagan.onetomanyrelationalmappingwithhibernate;


import com.mahagan.onetomanyrelationalmappingwithhibernate.model.Classroom;
import com.mahagan.onetomanyrelationalmappingwithhibernate.model.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class OneToManyRelationalMappingWithHibernateApplication {

	public static void main(String[] args) {
		StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();



		Students students=new Students();
		students.setStudent_Name("Krishna Shinde");
		students.setStudent_Address("Pune");
		students.setRoll_No("21");

		Students students1=new Students();
		students1.setStudent_Name("Ajay Dholepatil");
		students1.setStudent_Address("Sangli");
		students1.setRoll_No("24");

		Students students2=new Students();
		students2.setStudent_Name("Vijay Kumar");
		students2.setStudent_Address("Kholhapur");
		students2.setRoll_No("22");

		List<Students> list=new ArrayList<>();
		list.add(students);
		list.add(students1);
		list.add(students2);

		Classroom classroom=new Classroom();
		classroom.setClassroom_Floor("second");
		classroom.setTotal_Count("65");
		classroom.setStudents(list);

		session.persist(classroom);

		transaction.commit();
		session.close();

		System.out.println("Data has been successfully saved in database");
	}

}
