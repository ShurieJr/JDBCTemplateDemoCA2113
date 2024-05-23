package com.example2CA2113;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final JdbcTemplate jdbcTemplate;
    String sqlQuery ="";
    public CustomerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //Operations
    //Get All Customers
    public List<Customer> getAllCustomers(){
         sqlQuery = "SELECT * FROM customer";
        return jdbcTemplate.query(sqlQuery,
                new BeanPropertyRowMapper<>(Customer.class));
    }

    //Get Customer By id
    public Customer getCustomerById(int id){
        sqlQuery = "SELECT * FROM customer WHERE id = ?";
        return jdbcTemplate.queryForObject(sqlQuery,
               new Object[]{id},
               new BeanPropertyRowMapper<>(Customer.class));
    }

    //insert Customer
    public void insertCustomer(Customer customer){
        sqlQuery= "INSERT INTO customer values (?, ?)";
        jdbcTemplate.update(sqlQuery,customer.getId(),customer.getName());
    }

    //update Customer
    public void updateCustomer(Customer customer){
        sqlQuery= "UPDATE customer SET name = ? WHERE id = ?";
        jdbcTemplate.update(sqlQuery,customer.getName(),customer.getId());
    }

    //delete Customer
    public void deleteCustomer(int id){
        sqlQuery= "DELETE FROM customer WHERE id = ?";
        jdbcTemplate.update(sqlQuery,id);
    }
}
