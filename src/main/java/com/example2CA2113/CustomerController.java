package com.example2CA2113;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }
    //Requests
    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return service.getCustomerById(id);
    }
    @PostMapping
    public void addCustomer(@RequestBody Customer customer){
        service.insertCustomer(customer);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id){
        service.deleteCustomer(id);
    }
    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable int id,
                               @RequestBody Customer customer){
        customer.setId(id);
        service.updateCustomer(customer);
    }
}
