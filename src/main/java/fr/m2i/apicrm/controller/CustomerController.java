
package fr.m2i.apicrm.controller;

import fr.m2i.apicrm.dto.CustomerDTO;
import fr.m2i.apicrm.dto.CustomerMapper;
import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.exception.NotValidDataException;
import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.service.ICustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }
    
    //@GetMapping(path = {"","/"}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    //@RequestMapping(value ="/all" method = RequestMethod.GET )
    public ResponseEntity<Object> getCutomers(){
 
        List<Customer> customers = customerService.getAllCustomer();
        return ResponseEntity.status(HttpStatus.OK).body(CustomerMapper.buidListCustomerDTO(customers));
        //List<CustomerDTO> dtos = new ArrayList<>();
        //for(Customer c:customers){
        //    CustomerDTO dto = CustomerMapper.buildCustomerDTO(c);
        //    dtos.add(dto);    
        //}
        //return ResponseEntity.status(HttpStatus.OK).body(dtos);
        //return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);

    }
    
    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> getCutomerbyId(@PathVariable("id") Long id){
 
        try{
            Customer customer = customerService.getCustomerById(id);
            CustomerDTO dto = CustomerMapper.buildCustomerDTO(customer);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
            //return new ResponseEntity<>(dto,HttpStatus.OK);
        }catch(NotValidDataException nvde){
            throw new ResponseStatusException(
           HttpStatus.BAD_REQUEST, "Invalid Id ", nvde);
            
        }catch(NotFoundException nfe){
            throw new ResponseStatusException(
           HttpStatus.NOT_FOUND, "Customer Not Found", nfe);
            
        }catch(Exception e){
            throw new ResponseStatusException(
           HttpStatus.BAD_REQUEST, "An error occurred", e);
            
        }       

    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDTO customerDto){
        try{
            Customer customerToCreate = CustomerMapper.buildCustomer(customerDto);
            Customer savedCustomer = customerService.CreateCustomer(customerToCreate);
            CustomerDTO dto = CustomerMapper.buildCustomerDTO(savedCustomer);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
            //return new ResponseEntity<>(dto,HttpStatus.OK);
        }catch(NotValidDataException nvde){
            throw new ResponseStatusException(
           HttpStatus.BAD_REQUEST, "customer must be not null ", nvde);
        }catch(Exception e){
            throw new ResponseStatusException(
           HttpStatus.BAD_REQUEST, "An error occurred", e);
            
        }       
    }
    
    @PutMapping(path="/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long id,@RequestBody CustomerDTO customerDto){
        try{
            Customer customerToUpdate = CustomerMapper.buildCustomer(customerDto);
            Customer updateCustomer = customerService.UpdateCustomer(id, customerToUpdate);
            CustomerDTO dto = CustomerMapper.buildCustomerDTO(updateCustomer);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
           
        }catch(NotValidDataException nvde){
            throw new ResponseStatusException(
           HttpStatus.BAD_REQUEST, "customer must be not null ", nvde);
        }catch(NotFoundException nfe){
            throw new ResponseStatusException(
           HttpStatus.NOT_FOUND, "Customer Not Found", nfe);
            
        }catch(Exception e){
            throw new ResponseStatusException(
           HttpStatus.BAD_REQUEST, "An error occurred", e);
            
        }       
    }
    
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") Long id){
        try{
            
            customerService.deleteCustomer(id);
            return ResponseEntity.status(HttpStatus.OK).body("");
           
        }catch(NotValidDataException nvde){
            throw new ResponseStatusException(
           HttpStatus.BAD_REQUEST, "customer must be not null ", nvde);
        }catch(NotFoundException nfe){
            throw new ResponseStatusException(
           HttpStatus.NOT_FOUND, "Customer Not Found", nfe);
            
        }catch(Exception e){
            throw new ResponseStatusException(
           HttpStatus.BAD_REQUEST, "An error occurred", e);
            
        }       
    }
    
    
    
}
