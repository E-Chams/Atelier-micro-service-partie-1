package com.example.customer_service.Web;

import com.example.customer_service.Dao.entities.Customer;
import com.example.customer_service.Dao.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/customers")
public class CustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/customerList")
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }
    @GetMapping("{id}")
    public Customer customerById(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    @PostMapping("/save")
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
