package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Veritabanı bağlantısını açan ve kapatan sınıftır.
public class HibernateUtil {

    //SessionFactory sınıfından bir değişken oluşturuyoruz.
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            Configuration cfg = new Configuration();

            //cfg.addAnnotatedClass(Kategori.class);

            SessionFactory sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();

            return sessionFactory;

        } catch (Exception exception) {
            System.out.println("Session factory oluşturulurken hata oluştu: " + exception);
            throw new ExceptionInInitializerError(exception);
        }

    }

    //Private tanımlanan buildSessionFactory metodundan return alabilmek için yazılan getter metodu.
    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    //Açılan sessionfactory'i kapatmak için kullanılan metod.
    public static void shutdown() {

        getSessionFactory().close();
    }

}