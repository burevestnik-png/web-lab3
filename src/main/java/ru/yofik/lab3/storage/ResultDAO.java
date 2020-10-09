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

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.function.Consumer;

@ManagedBean(name = "dao")
@ApplicationScoped
public class ResultDAO {
    private static final LoggerAdapter loggerAdapter =
                    LoggerAdapter.createDefault(ResultDAO.class.getSimpleName());

    private SessionFactory sessionFactory;
    private String hqlString;


    public ResultDAO() {
        this.hqlString = "From Result";

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


    public List<Result> get() {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery(hqlString).list();
        }
    }

    public void create(List<Result> objects) {
        openTransactionFor(session -> objects.forEach(session::save));
    }

    public void update(List<Result> objects) {
        openTransactionFor(session -> objects.forEach(session::update));
    }

    public void delete(List<Result> objects) {
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
