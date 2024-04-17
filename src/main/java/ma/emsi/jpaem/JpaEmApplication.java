package ma.emsi.jpaem;

import ma.emsi.jpaem.entities.Role;
import ma.emsi.jpaem.entities.User;
import ma.emsi.jpaem.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class JpaEmApplication {

	public static void main(String[] args) {
	SpringApplication.run(JpaEmApplication.class, args);
	}

@Bean
CommandLineRunner start(UserService userService){
	return args -> {
		User u=new User();
		u.setUsername("user1");
		u.setPassword("123456");
		userService.addNewUser(u);


		User u2=new User();
		u2.setUsername("user2");
		u2.setPassword("123456");
		userService.addNewUser(u2);

		Stream.of("STUDENT","USER","ADMIN").forEach(r->{
			Role role1=new Role();
			role1.setRoleName(r);
			userService.addNewRole(role1);

		});

		userService.addRoleToUser("user1","STUDENT");
		userService.addRoleToUser("user1","USER");
		userService.addRoleToUser(" admin","USER");
		userService.addRoleToUser("admin","ADMIN");


		try{
        User user=userService.authentification("user1","123456");
		System.out.println(user.getUserId());
		System.out.println(user.getUsername());
		user.getRoles().forEach(r->{
			System.out.println("Role=>"+r.toString());
		});
		}
		catch (Exception e){
			e.printStackTrace();
		}
	};

}


}
