package com.ticketbooking;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ticketbooking.dto.UserDTO;
import com.ticketbooking.entities.User;
import com.ticketbooking.services.UserService;
import com.ticketbooking.utils.FileUploadProperties;

@SpringBootApplication
@EntityScan("com.ticketbooking.entities")
@ComponentScan(basePackages="com.ticketbooking.*")
@EnableJpaRepositories("com.ticketbooking.repository")
@EnableConfigurationProperties({
    FileUploadProperties.class
})
public class TicketBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	
	@Bean
	public CommandLineRunner demo(UserService srv) {
	    return (args) -> {
	    	if(srv.listAll().size()==0) {
	    		User admin=new User();
	    		admin.setEmail("admin@example.com");
	    		admin.setPassword("admin");
	    		admin.setUserName("Administrator");
	    		admin.setAdmin(true);;
	    		srv.saveUser(admin);
	    		//log.info("Admin user created successfully");
	    	}
	    };
	}
 
}
	