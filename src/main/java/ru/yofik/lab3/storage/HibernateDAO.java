package ru.yofik.lab3.storage;

import adapter.LoggerAdapter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.yofik.lab3.model.entities.Result;

import java.util.List;
import java.util.function.Consumer;

public final class HibernateDAO<T> implements DAO<T> {
    private static final LoggerAdapter loggerAdapter =
                    LoggerAdapter.createDefault(HibernateDAO.class.getSimpleName());

    private final SessionFactory sessionFactory;
    private String hqlString;


    public HibernateDAO(String hqlString) {
        this.hqlString = hqlString;

        try {
            Configuration configuration = new Configuration().configure();
            loggerAdapter.debug("The config of Hibernate loaded SUCCESSFULLY.");

            //adding @Entity classes
            configuration.addAnnotatedClass(Result.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            loggerAdapter.debug("SessionFactory for Hibernate was created SUCCESSFULLY");
        } catch (Exception e) {
            loggerAdapter.errorThrowable("An exception during configuring Hibernate.", e);
            throw new HibernateException(e);
        }
    }


    @Override
    public List<T> get() {
//        List<T> objects = new ArrayList<>();
//        openSessionFor((session) ->
//            session.createQuery(hqlString)
//                   .list()
//                   .forEach(object -> objects.add((T) object))
//        );
//
//        return objects;

        try(Session session = sessionFactory.openSession()) {
            return session.createQuery(hqlString).list();
        }
    }

    @Override
    public void create(List<T> objects) {
        openTransactionFor(session -> objects.forEach(session::save));
    }

    @Override
    public void update(List<T> objects) {
        openTransactionFor(session -> objects.forEach(session::update));
    }

    @Override
    public void delete(List<T> objects) {
        openTransactionFor(session -> objects.forEach(session::delete));
    }

    private void openTransactionFor(Consumer<Session> action) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            action.accept(session);
            transaction.commit();;
        }
    }
}
