package overridetech.jdbc.jpa.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.metamodel.*;
import org.hibernate.service.ServiceRegistry;

//import java.util.HashMap;
//import java.util.Map;
import java.util.Properties;

import overridetech.jdbc.jpa.model.User;

public class Util {
    // реализуйте настройку соеденения с БД
    static public SessionFactory getSessionFactoryInstance(Metadata metadata) {
        return metadata.getSessionFactoryBuilder().build();
    }

    public static ServiceRegistry getServiceRegistryInstance(){
        Properties settings = new Properties();
        settings.put("connection.driver_class", "com.mysql.cj.jdbc.Driver");
        settings.put("dialect", "org.hibernate.dialect.MySQLDialect");
        settings.put("hibernate.connection.url",
                "jdbc:mysql://localhost:3306/luchik_db");
//                "jdbc:mysql://localhost:3306/my_db");
        settings.put("hibernate.connection.username", "luchik");
        settings.put("hibernate.connection.password", "luchik");
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put("hibernate.show_sql", true);
        settings.put("hibernate.format_sql", true);
//        settings.put("hibernate.hbm2ddl.auto", "create-drop");


        System.out.println(settings);

        return new StandardServiceRegistryBuilder().applySettings(settings).build();
    }

    public static MetadataSources getMetadataSourcesInstance(ServiceRegistry serviceRegistry){
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        return metadataSources;
    }
}
