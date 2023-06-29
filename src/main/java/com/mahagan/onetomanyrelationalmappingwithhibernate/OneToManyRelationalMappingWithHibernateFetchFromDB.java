/**
 * Created By Krishna Shinde
 * Date : 29-06-2023
 * Time : 17:35
 * Project: OneToManyRelationalMappingWithHibernate
 **/

package com.mahagan.onetomanyrelationalmappingwithhibernate;

import com.mahagan.onetomanyrelationalmappingwithhibernate.model.Classroom;
import com.mahagan.onetomanyrelationalmappingwithhibernate.model.Students;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class OneToManyRelationalMappingWithHibernateFetchFromDB {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        TypedQuery typedQuery=session.createQuery("from Classroom classroom");
        List<Classroom> list=typedQuery.getResultList();
        Iterator<Classroom> iterator= list.listIterator();



        while (iterator.hasNext()){
            Classroom classroom=iterator.next();
            System.out.println("Classroom Details:>>>>>>>>>"+classroom.getClassroom_Floor()+" "+classroom.getTotal_Count());

            List<Students> list1=classroom.getStudents();
            Iterator<Students> iterator1=list1.iterator();


            while (iterator1.hasNext()){
                Students students=iterator1.next();

                System.out.println(students.getStudent_Name()+" "+students.getStudent_Address()
                        +" "+students.getRoll_No());
            }

        }
        session.close();
        System.out.println("Data successfully retrive from database");
    }
}


