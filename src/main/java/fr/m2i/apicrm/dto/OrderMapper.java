
package fr.m2i.apicrm.dto;

import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.model.Order;
import fr.m2i.apicrm.model.Status;
import java.util.ArrayList;
import java.util.List;


public class OrderMapper {
    
    public static OrderDTO buildOrderDTO(Order order){
        
        if(order == null){
            return new OrderDTO(); // pour eviter de retourner null au client
        }
        
        CustomerDTO customerDTO =null;
        if(order.getCustomer() != null){
            customerDTO = CustomerMapper.buildCustomerDTO(order.getCustomer());
        }
        // convert from enum type to string
        //String status = String.valueOf(order.getStatus());
        String status = (order.getStatus()).name();
        
        return new OrderDTO(
                order.getId(),
                customerDTO, //CustomerMapper.buildCustomerDTO(order.getCustomer()),
                order.getType(),
                order.getLabel(),
                order.getNumberOfDays(),
                order.getUnitPrice(),
                order.getTotalExcludeTaxe(),
                order.getTotalWithTaxe(),
                status
        );
        
    }
    
     public static Order buildOrder(OrderDTO dto){
         
         // on peut eviter de recopier l'ID, en cas de create avec un id existant
         // il fait la mise ajour dans la base (ou dans le create vérifier que l'objet n'extste pas déja
         if(dto == null){
             return null;  // pour eviter de creer des orders vides en cas où
         }
         
         Customer customer = null;
         if(dto.getCustomerDto() != null && dto.getCustomerDto().getId() != null){
             customer= new Customer();
             customer.setId(dto.getCustomerDto().getId());
             //CustomerMapper.buildCustomer(dto.getCustomerDto());
         }
         
         // converti status from string type to enum type
         Status status = Status.valueOf(dto.getStatus());
         
         return new Order(
                dto.getId(),
                customer, //CustomerMapper.buildCustomer(dto.getCustomerDto()),
                dto.getType(),
                dto.getLabel(),
                dto.getNumberOfDays(),
                dto.getUnitPrice(),
                dto.getTotalExcludeTaxe(),
                dto.getTotalWithTaxe(),
                status
        );
     
     }
     
     public static List<OrderDTO> buidListOrderDTO(List<Order> orders){
        
        List<OrderDTO> dtos = new ArrayList<>();
        for(Order o:orders){
            OrderDTO dto = OrderMapper.buildOrderDTO(o);
            dtos.add(dto);    
        }
        return dtos; 
    }
    
     public static List<Order> buidListOrder(List<OrderDTO> dtos){
        
        List<Order> orders = new ArrayList<>();
        for(OrderDTO dto:dtos){
            Order order = OrderMapper.buildOrder(dto);
            orders.add(order);    
        }
        return orders; 
        
        // to do: with stream
    }
     
     
     // copy content in customer to update
    public static Order copy(Order order, Order content){
        
        if (order == null || content == null) {
            return null;
        }
        
        // est ce qu'o test string vide "" ??
        //if(content.getLastname() != null && !content.getLastname().isEmpty()) 
        
        if(content.getCustomer()!= null ){  
            order.setCustomer(content.getCustomer());
        }
        
        if(content.getType()!= null ){  
            order.setType(content.getType());
        }
        
        if(content.getLabel()!= null ){  
            order.setLabel(content.getLabel());
        }
        
        if(content.getNumberOfDays()!= null ){  
            order.setNumberOfDays(content.getNumberOfDays());
        }
        
        if(content.getUnitPrice()!= null ){  
            order.setUnitPrice(content.getUnitPrice());
        }
        
        if(content.getTotalExcludeTaxe()!= null ){  
            order.setTotalExcludeTaxe(content.getTotalExcludeTaxe());
        }
        
        if(content.getTotalWithTaxe()!= null ){  
            order.setTotalWithTaxe(content.getTotalWithTaxe());
        }
        
        if(content.getStatus()!= null ){  
            order.setStatus(content.getStatus());
        }
        
        return order;
    }
    
}
