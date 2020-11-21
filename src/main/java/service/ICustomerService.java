package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void add(Customer customer);

    void edit(int id,Customer customer);

    void delete(int id);

    Customer findById(int id);
}
