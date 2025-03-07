package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      Car car1 = new Car("Ford Focus", 322);
      Car car2 = new Car("Chevrolet", 1);
      Car car3 = new Car("Porshe 2101", 1488);

      User user1 = new User("Axi", "Baxi", "axi@baxi.maxi");
      User user2 = new User("Vova", "P", "vova001@kremlin.gov");
      User user3 = new User("Tony", "Soprano", "king@garbage.ny");

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);

      carService.addCar(car1);
      carService.addCar(car2);
      carService.addCar(car3);

      userService.addUser(user1);
      userService.addUser(user2);
      userService.addUser(user3);

      List<User> users = userService.getAllUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      System.out.println(userService.findUserByCar("Chevrolet", 1));
      context.close();
   }
}
