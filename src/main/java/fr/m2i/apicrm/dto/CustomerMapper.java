
package fr.m2i.apicrm.dto;

import fr.m2i.apicrm.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {
    
    public static CustomerDTO buildCustomerDTO(Customer customer){
        
        if(customer == null){
            return new CustomerDTO();
        }
        
        // transformer de type booelan a String pour l'attribut state
        String state = customer.getState()!=null && customer.getState()?"ACTIF":"INACTIF";
        return new CustomerDTO(
                customer.getId(),
                customer.getLastname(),
                customer.getFirstname(),
                customer.getCompany(),
                customer.getMail(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getZipCode(),
                customer.getCountry(),
                state);
        // on peut faire autrement: constructeur par defaut, et ensuite setter tous les attributs  
    }
    
    public static Customer buildCustomer(CustomerDTO dto){
        if(dto == null){
            return null; // pour eviter de creer des customer vide
        }
        
        Boolean state = (dto.getState()!=null) && ("ACTIF".equals(dto.getState())?true:false);
        
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setLastname(dto.getLastname());
        customer.setFirstname(dto.getFirstname());
        customer.setCompany(dto.getCompany());
        customer.setMail(dto.getMail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setZipCode(dto.getZipCode());
        customer.setCountry(dto.getCountry());
        customer.setState(state);
                
        return customer;
    }
    
    public static List<CustomerDTO> buidListCustomerDTO(List<Customer> customers){
        
        List<CustomerDTO> dtos = new ArrayList<>();
        for(Customer c:customers){
            CustomerDTO dto = CustomerMapper.buildCustomerDTO(c);
            dtos.add(dto);    
        }
        return dtos; 
    }
    
     public static List<Customer> buidListCustomer(List<CustomerDTO> dtos){
        
        List<Customer> customers = new ArrayList<>();
        for(CustomerDTO dto:dtos){
            Customer customer = CustomerMapper.buildCustomer(dto);
            customers.add(customer);    
        }
        return customers; 
        
        // to do
        //return dtos.stream().map(d->CustomerMapper.buildCustomer(d)).toList();
    }
  
    
    
    // copy content in customer to update
    public static Customer copy(Customer customer, Customer content){
         if(content.getLastname() != null){  // est ce que test chaine vide "" ??
            customer.setLastname(content.getLastname());
        }
        
        if(content.getFirstname() != null){  
            customer.setFirstname(content.getFirstname());
        }
        
        if(content.getCompany() != null){  
            customer.setCompany(content.getCompany());
        }
        
        if(content.getMail() != null){  
            customer.setMail(content.getMail());
        }
        
        if(content.getPhone() != null){  
            customer.setPhone(content.getPhone());
        }
        
        if(content.getAddress() != null){  
            customer.setAddress(content.getAddress());
        }
        
        if(content.getZipCode() != null){  
            customer.setZipCode(content.getZipCode());
        }
        
        if(content.getCountry() != null){  
            customer.setCountry(content.getCountry());
        }
        
        if(content.getState() != null){  
            customer.setState(content.getState());
        } 
        
        return customer;
    }
    
}
