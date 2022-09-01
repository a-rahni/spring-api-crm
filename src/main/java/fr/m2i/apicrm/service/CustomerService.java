
package fr.m2i.apicrm.service;

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
    public List<Customer> getAllCustomer() {
        
        List<Customer> listCustomers = repo.findAll();
        if(listCustomers == null){
            throw new NotFoundException("customer was not found");
        }
        return listCustomers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        if(id==null){
            throw new NotValidDataException("Id customer must be not null");
        }
        Customer customer;
        customer = repo.findById(id).orElseThrow( ()->
        {throw new NotFoundException("Customer with Id:"+id+ " was not found");});
        
        return customer;
        //throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Customer CreateCustomer(Customer customer) {
        if(customer == null){
            throw new NotValidDataException("custumer to create must be not null");
        }  
        return repo.save(customer);
    }

    @Override
    public Customer UpdateCustomer(Long id, Customer customer) {
        if(id == null || customer == null){
            throw new NotValidDataException("Id and customer to update must be not null");
        }
        Customer customerToUpdate = getCustomerById(id);
        //if(customer == null){ not needed, managed in findById}
        customerToUpdate.copy(customer);
        return repo.save(customerToUpdate);
    }

    @Override
    public void deleteCustomer(Long id) {  
        Customer customerToDelete = getCustomerById(id);
        repo.delete(customerToDelete); 
    }
    
}
