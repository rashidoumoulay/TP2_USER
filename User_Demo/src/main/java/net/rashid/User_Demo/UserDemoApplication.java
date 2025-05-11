package net.rashid.User_Demo;

import net.rashid.User_Demo.entities.Role;
import net.rashid.User_Demo.entities.User;
import net.rashid.User_Demo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UserDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner start(UserService userService){
		return args -> {
			User u = new User();
			u.setUsername("user1");
			u.setPassword("12345");
			userService.addNewUser(u);

			User u2 = new User();
			u2.setUsername("admin");
			u2.setPassword("12345");
			userService.addNewUser(u2);

			Stream.of("STUDENT" , "USER" , "ADMIN").forEach(r->{
				Role role = new Role();
				role.setRoleName(r);
				userService.addNewRole(role);
			});

			userService.addRoleToUser("user1" , "STUDENT");
			userService.addRoleToUser("user1" , "USER");
			userService.addRoleToUser("admin" , "ADMIN");
			userService.addRoleToUser("admin" , "USER");

			try{
				User user = userService.authentificate("user1" , "12345");
				System.out.println(user.getId());
				System.out.println(user.getUsername());
				System.out.println("Roles : ");
				user.getRoles().forEach(r->{
					System.out.println("role => "+r);
				});
			}catch(Exception e){
				e.printStackTrace();
			}
		};
	}
}
