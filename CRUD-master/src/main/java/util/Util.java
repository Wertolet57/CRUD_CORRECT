package util;

import com.mysql.cj.jdbc.Driver;
import models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.persistence.EntityManager;
import java.util.Properties;

public class Util {
    private final static String URL = "jdbc:mysql://127.0.0.1:3306/crud?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private static SessionFactory sessionFactory;
    public static EntityManager getEntityManager() {
        if(sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, new Driver());
                settings.put(Environment.URL, URL);
                settings.put(Environment.USER, USERNAME);
                settings.put(Environment.PASS, PASSWORD);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Something");
            }
        }
        return sessionFactory.createEntityManager();
    }
}
