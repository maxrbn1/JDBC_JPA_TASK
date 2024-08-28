package overridetech.jdbc.jpa.dao;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import overridetech.jdbc.jpa.model.User;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class UserDaoHibernateImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private MetadataSources metadataSources;
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        SchemaExport schemaExport = new SchemaExport();
//        schemaExport.setFormat(true);
//        schemaExport.setOutputFile("export.sql");
        schemaExport.create(EnumSet.of(TargetType.DATABASE), metadataSources.buildMetadata());
    }

    @Override
    public void dropUsersTable() {
        SchemaExport schemaExport = new SchemaExport();
//        schemaExport.setFormat(true);
//        schemaExport.setOutputFile("export.sql");
        schemaExport.drop(EnumSet.of(TargetType.DATABASE), metadataSources.buildMetadata());
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        sessionFactory.getCurrentSession().persist(new User(name, lastName, age));
        session.getTransaction().commit();
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
       User user =  sessionFactory.getCurrentSession().get(User.class, id);
       if (user != null){
           sessionFactory.getCurrentSession().remove(user);
       }
        session.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();
        session.getTransaction().commit();

        return list;
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        sessionFactory.getCurrentSession().createMutationQuery("delete from User" ).executeUpdate();
        session.getTransaction().commit();
    }
}
