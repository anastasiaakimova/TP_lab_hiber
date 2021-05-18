package org.example;

import org.example.entity.Gruppyi;
import org.example.entity.Studentyi;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();


        // Вывести таблицу ФИО студента, название группы.
        session.beginTransaction();
        String hql = "FROM Studentyi ";
        Query query = session.createQuery(hql);

        List<Studentyi> studentyi = query.list();
        studentyi.size();
        try {
            for (int i = 0; i <= studentyi.size(); i++) {
                System.out.println("\t" + studentyi.get(i).getFamiliya() + "\t"
                        + studentyi.get(i).getImya() + "\t"
                        + studentyi.get(i).getOtchestvo() + "\t"
                        + studentyi.get(i).getGruppyi().getNazvanie());
            }
        } catch (Exception e) {

        }
//Вывести сведения о кол-ве студентов, обучающихся по каждой специальности

        List<Gruppyi> gruppyis = query.list();
        gruppyis.size();
        try {
            for (int i = 0; i <= gruppyis.size(); i++) {
                int k = 0;
                for (int n = 1; n <= studentyi.size(); n++) {
                    if (studentyi.get(n).getGruppyi().getShifr() == 1) {
                        k++;
                    }
                }
                System.out.println(gruppyis.get(i).getNazvanie() + ":" + k);
            }
        } catch (Exception e) {

        }
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
