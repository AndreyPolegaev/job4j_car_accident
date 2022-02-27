package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

@Transactional
//@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Accident> getAllAccident() {
        try (Session session = sf.openSession()) {
            List<Accident> rsl = session.createQuery("select distinct ac from Accident ac join fetch ac.type t join fetch ac.rules", Accident.class).list();
            return rsl;
        }
    }

    public Accident save(Accident accident) {
        try (Session session = sf.openSession()) {
            Transaction txn = session.beginTransaction();
            session.save(accident);
            txn.commit();
            return accident;
        }
    }

    public List<AccidentType> getTypes() {
        try (Session session = sf.openSession()) {
            return session.createQuery("from AccidentType", AccidentType.class).list();
        }
    }

    public AccidentType getTypeById(int id) {
        try (Session session = sf.openSession()) {
            return session.get(AccidentType.class, id);
        }
    }

    public List<Rule> getRules() {
        try (Session session = sf.openSession()) {
            return session.createQuery("from Rule ", Rule.class).list();
        }
    }

    public Rule getRulesById(int id) {
        try (Session session = sf.openSession()) {
            return session.get(Rule.class, id);
        }
    }

    /**
     * почему Transactional не работает ???????
     */
    public void update(Accident accident) {
        try (Session session = sf.openSession()) {
            Transaction txn = session.beginTransaction();
            Query query = session.createQuery("update Accident a set " +
                    "a.name = :param1, a.text = :param2, a.address = :param3 where a.id = :param4");
            query.setParameter("param1", accident.getName());
            query.setParameter("param2", accident.getText());
            query.setParameter("param3", accident.getAddress());
            query.setParameter("param4", accident.getId());
            query.executeUpdate();
            txn.commit();
        }
    }

    public Accident getAccidentById(int id) {
        try (Session session = sf.openSession()) {
            Accident accident = session.get(Accident.class, id);
            return accident;
        }
    }
}
