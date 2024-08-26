package overridetech.jdbc.jpa;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import overridetech.jdbc.jpa.service.*;
import overridetech.jdbc.jpa.configuration.*;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        UserService userService = context.getBean("getUserService", UserService.class);

        userService.createUsersTable();
    }
}
