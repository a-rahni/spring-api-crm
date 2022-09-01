
package fr.m2i.apicrm.service;

import fr.m2i.apicrm.model.Customer;
import java.util.List;

public interface ICustomerService {
    
    public List<Customer> findAll();
    
    public Customer findById(Long id);
    
    public Customer save(Customer customer);
    
    public Customer update (Long id, Customer customer);
    
    public void delete(Long id);
    
}
