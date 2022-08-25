package com.example.reservation.controller;

import com.example.reservation.Exception.MyException;
import com.example.reservation.pojo.Customer;
import com.example.reservation.service.CustomerService;
import com.example.reservation.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/customer")
public class HomeController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TableService tableService;

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/email")
    public Customer getCustomerByEmail(@RequestParam(name = "email") String email){
        return customerService.findByEmail(email);
    }

    @PostMapping
    public String saveCustomer(@RequestBody Customer customer) throws MyException {
        customerService.saveCustomer(customer);
        return "Customer Object Saved successfully";
    }

    @DeleteMapping("/{email}")
    public String deleteCustomer(@PathVariable("email") String email){
        customerService.deleteCustomer(email);
        return "Customer Object delete successfully";
    }

/*    @DeleteMapping("/{id}")
    public String deleteCustomerById(@PathVariable Integer id){
        customerService.deleteCustomerById(id);
        return "Customer Object delete successfully";
    }*/

    @PutMapping
    public String updateCustomer(@RequestParam String email,@RequestBody Customer customer){
        customerService.updateByEmail(email,customer);
        return "Customer Object update successfully";
    }

    @GetMapping("/table")
    public List<String> findAll(){
        return tableService.findTableNum();
    }

    @GetMapping("/tablenum")
    public Integer countTable(){
        return tableService.countTable();
    }




}
