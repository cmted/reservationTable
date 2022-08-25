package com.example.reservation.service;

import com.example.reservation.Exception.MyException;
import com.example.reservation.pojo.Customer;
import com.example.reservation.pojo.Retable;
import com.example.reservation.repo.CustomerRepo;
import com.example.reservation.repo.RetableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private RetableRepo retableRepo;

    public void saveCustomer(Customer customer) throws MyException {
            int flag = isFull();
            if (flag == 1) {
                customerRepo.save(customer);
            } else {
                throw new MyException("The Reservation is full.");
            }
    }

    public Integer isFull(){
        if( retableRepo.countTable() < 10){return 1;}
        return 0;
    }



    // cascade delete 是根据主表ID主键进行级联删除，对于根据非主表ID主键，要实现级联删除需先删除主表数据，再删除从表数据
    public void deleteCustomer(String email){
        //对email进行非空判断后得到主表相关记录
        Optional<Customer> customerOptional = customerRepo.findByEmail(email);
        Customer customer = customerOptional.orElseThrow(()->new RuntimeException("Email not found " + email));
        //得到从表相关记录
        Retable retable = customer.getRetable();
        //删除主表记录
        customerRepo.deleteByEmail(customer.getEmail());
        //删除从表记录
        retableRepo.deleteByTableId(retable.getTableId());
    }
/*    public void deleteCustomerById(Integer id){
        customerRepo.deleteById(id);
    }*/

    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    public Customer findByEmail(String email){
        Optional<Customer> customerOptional = customerRepo.findByEmail(email);
        return customerOptional.orElseThrow(()->new RuntimeException("Email not found " + email));
    }

    public Customer updateByEmail(String email, Customer customer){
        Optional<Customer> customerOptional = customerRepo.findByEmail(email);
        Customer customer1 = customerOptional.orElseThrow(()->new RuntimeException("Email not found " + email));
        customer1.setEmail(customer.getEmail());
        customer1.setName(customer.getName());
        customer1.setPhone(customer.getPhone());
        customer1.setPeople(customer.getPeople());
        customer1.setRetable(customer.getRetable());
        return customerRepo.save(customer1);
    }


}
