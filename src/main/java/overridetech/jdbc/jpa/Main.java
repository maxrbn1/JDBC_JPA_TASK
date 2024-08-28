package overridetech.jdbc.jpa;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.service.*;
import overridetech.jdbc.jpa.configuration.*;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        UserService userService = context.getBean("userServiceImpl", UserService.class);

        userService.dropUsersTable();
        userService.createUsersTable();

        IntStream.range(0,10).forEach((i)->{
            userService.saveUser("userName " + i, "userLastName " + i, (byte)i);
       });

        List<User> users = userService.getAllUsers();
        System.out.println(users);

        User user = users.get(1);
        if (user != null){
            userService.removeUserById(user.getId());
        }

        userService.cleanUsersTable();

       context.close();


    }
}
