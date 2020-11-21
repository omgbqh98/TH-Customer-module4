package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService{

    static Map<Integer,Customer> customerList;
    static {
        customerList = new HashMap<>();
        customerList.put(1, new Customer(1, "huynh", "huynh@gmail.com", "HN"));
        customerList.put(2, new Customer(2, "tuan", "tuan@gmail.com", "HN"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public void add(Customer customer) {
        customerList.put(customer.getId(),customer);
    }

    @Override
    public void edit(int id, Customer customer) {
        customerList.put(id, customer);
    }

    @Override
    public void delete(int id) {
        customerList.remove(id);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

}
