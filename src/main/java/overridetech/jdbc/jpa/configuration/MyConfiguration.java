package overridetech.jdbc.jpa.configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.util.Util;
import overridetech.jdbc.jpa.dao.*;
import overridetech.jdbc.jpa.service.*;

@Configuration
@ComponentScan(basePackages = "overridetech.jdbc.jpa")
@PropertySource("classpath:my.properties")
public class MyConfiguration {
    @Bean
    public ServiceRegistry getServiceRegistryInstance(){
        return Util.getServiceRegistryInstance();
    }

    @Bean
    public MetadataSources getMetadataSourcesInstance(@Autowired ServiceRegistry serviceRegistry){
        System.out.println(serviceRegistry);
        return Util.getMetadataSourcesInstance(serviceRegistry);
    }

    @Bean
    public SessionFactory sessionFactory(@Autowired MetadataSources metadataSources){
        metadataSources.addAnnotatedClass(User.class);
        return Util.getSessionFactoryInstance(metadataSources.buildMetadata());
    }

    @Bean
    public UserDao getUserDaoHibernateImpl(){
        return new UserDaoHibernateImpl();
    }

    @Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }
}
