package org.example;

import org.example.entity.Gruppyi;
import org.example.entity.Studentyi;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;

public class Lab1 {
    private static Session session;

    public Lab1(Session session) {
        this.session = session;
    }

    //Вывести сведения о кол-ве студентов, обучающихся по каждой специальности
    public static HashMap task2() {
        String sql = "from Gruppyi g";
        Query query = session.createQuery(sql);

        List<Gruppyi> gruppyis = query.list();

        HashMap gr = new HashMap();
        try {
            for (Gruppyi gruppyi : gruppyis) {
                sql = "from Studentyi s where s.gruppyi.shifr = :param";
                query = session.createQuery(sql);
                query.setParameter("param", gruppyi.getShifr());
                List<Studentyi> studentyis = query.list();
                String[] words = gruppyi.getNazvanie().split("-");
                if (gr.containsKey(words[0])) {
                    int amount = (int) gr.get(words[0]);
                    gr.remove(words[0]);
                    gr.put(words[0], gruppyis.size() + amount);
                } else if (words.length != 0) gr.put(words[0], gruppyis.size());
            }

        } catch (Exception e) {

        }
        return gr;
    }
}
