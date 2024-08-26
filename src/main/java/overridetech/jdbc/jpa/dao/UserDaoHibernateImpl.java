package overridetech.jdbc.jpa.dao;

import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import overridetech.jdbc.jpa.model.User;

;
import java.util.EnumSet;
import java.util.List;

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
        schemaExport.setFormat(true);
        schemaExport.setOutputFile("create.sql");

        schemaExport.execute(EnumSet.of(TargetType.SCRIPT), SchemaExport.Action.CREATE,  metadataSources.buildMetadata());
    }

    @Override
    @Transactional
    public void dropUsersTable() {

    }

    @Override
    @Transactional
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    @Transactional
    public void removeUserById(long id) {

    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    @Transactional
    public void cleanUsersTable() {

    }
}
