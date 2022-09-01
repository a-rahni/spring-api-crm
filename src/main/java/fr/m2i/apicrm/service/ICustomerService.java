
package fr.m2i.apicrm.service;

import fr.m2i.apicrm.model.Customer;
import java.util.List;

public interface ICustomerService {
    
    public List<Customer> getAllCustomer();
    
    public Customer getCustomerById(Long id);
    
    public Customer CreateCustomer(Customer customer);
    
    public Customer UpdateCustomer(Long id, Customer customer);
    
    public void deleteCustomer(Long id);
    
}
