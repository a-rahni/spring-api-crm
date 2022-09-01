
package fr.m2i.apicrm.service;

import fr.m2i.apicrm.dto.CustomerMapper;
import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.exception.NotValidDataException;
import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements ICustomerService {
    
    private final CustomerRepository repo;
    
    @Autowired
    public CustomerService(CustomerRepository repository){
        this.repo = repository;
    }

    @Override
    public List<Customer> findAll() {    
        return repo.findAll();
    }

    @Override
    public Customer findById(Long id) {
       
        return repo.findById(id).orElseThrow( ()->
        {throw new NotFoundException("Customer with Id:"+id+ " was not found");});

    }

    @Override
    public Customer save(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public Customer update(Long id, Customer content) {
        Customer customerToUpdate = findById(id);
        CustomerMapper.copy(customerToUpdate, content);
        return repo.save(customerToUpdate);
    }

    @Override
    public void delete(Long id) {  
        Customer customerToDelete = findById(id);
        repo.delete(customerToDelete); 
    }
    
}
