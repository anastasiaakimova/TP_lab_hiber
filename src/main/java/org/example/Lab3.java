package org.example;

import org.example.entity.Gruppyi;
import org.example.entity.Studentyi;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Lab3 {
    private static Session session;

    public Lab3(Session session) {
        this.session = session;
    }

    public static void lab3() {
        String sql = "from Gruppyi g";
        Query query = session.createQuery(sql);

        List<Gruppyi> groups = query.list();
        for (Gruppyi g : groups) {
            Date dt = new Date();
            if (dt.getYear() - g.getDataFormir().getYear() >= 4) {
                g.setStatus("rasform");
                g.setStatusDate(dt);
                Set<Studentyi> studs = (Set<Studentyi>) g.getStudentyis();
                for (Studentyi s : studs) {
                    s.setStatus("vipusk");
                    s.setStatusDate(dt);
                    session.update(s);
                }
                session.update(g);
            }
        }
    }
}
