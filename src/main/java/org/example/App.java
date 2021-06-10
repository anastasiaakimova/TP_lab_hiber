package org.example;

import org.example.entity.Gruppyi;
import org.example.entity.Studentyi;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Вывести таблицу ФИО студента, название группы.
        String hql = "FROM Studentyi ";
        Query query = session.createQuery(hql);

        List<Studentyi> studentyi = query.list();
        try {
            for (Studentyi student : studentyi) {
                System.out.println(student.toString() + "\t"
                        + student.getGruppyi().getNazvanie());
            }
        } catch (Exception e) {
        }

        HashMap map = Lab1.task2();
        System.out.println(map);
        Lab3.lab3();

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
