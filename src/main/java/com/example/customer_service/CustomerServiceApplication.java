package com.example.customer_service;

import com.example.customer_service.Dao.entities.Customer;
import com.example.customer_service.Dao.repositories.CustomerRepository;
import com.example.customer_service.Web.CustomerRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.example.customer_service.Dao.repositories")
@EntityScan(basePackages="com.example.customer_service.Dao.entities")
public class CustomerServiceApplication {


	public static void main(String[] args)
	{

		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository , CustomerRestController customerRestController) {
		return args -> {
			customerRepository.save(Customer.builder().name("X").email("X@gmail.com").build());
			customerRepository.save(Customer.builder().name("Y").email("Y@gmail.com").build());



			// Appeler les méthodes du contrôleur
			List<Customer> customers = customerRestController.customerList();
			System.out.println("Liste des clients : " + customers);

			Long id=1L;
			Customer customer = customerRestController.customerById(id);
			System.out.println("Le client numéros : "+id+" est "+customer);
			Customer newCustomer = new Customer();
			newCustomer.setName("Alice");
			newCustomer.setEmail("alice@example.com");
			Customer savedCustomer = customerRestController.saveCustomer(newCustomer);
			System.out.println("Client ajouté : " + savedCustomer);


		};
	}

}
