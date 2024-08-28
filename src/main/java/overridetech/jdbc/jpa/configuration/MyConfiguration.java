package overridetech.jdbc.jpa.configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import overridetech.jdbc.jpa.util.Util;


@Configuration
@ComponentScan(basePackages = "overridetech.jdbc.jpa")
//@PropertySource("classpath:application.properties")
public class MyConfiguration {
    @Bean
    public ServiceRegistry getServiceRegistryInstance(){
        return Util.getServiceRegistryInstance();
    }

    @Bean
    public MetadataSources getMetadataSourcesInstance(@Autowired ServiceRegistry serviceRegistry){
        return Util.getMetadataSourcesInstance(serviceRegistry);
    }

    @Bean
    public SessionFactory sessionFactory(@Autowired MetadataSources metadataSources){
        return Util.getSessionFactoryInstance(metadataSources.buildMetadata());
    }
}
