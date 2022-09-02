
package fr.m2i.apicrm.dto;

import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.model.Order;
import fr.m2i.apicrm.model.OrderState;
import java.util.ArrayList;
import java.util.List;


public class OrderMapper {
    
    public static OrderDTO buildOrderDTO(Order order) {

        if (order == null) {
            return new OrderDTO();
        }

        CustomerDTO customerDTO = null;

        if (order.getCustomer() != null) {
            customerDTO = CustomerMapper.buildCustomerDTO(order.getCustomer());
        }

        String state = null;
        // converti enum to string
        if (order.getState() != null) {
            state = order.getState().name();
        }

        return new OrderDTO(
                order.getId(),
                customerDTO,
                order.getType(),
                order.getLabel(),
                order.getNumberOfDays(),
                order.getUnitPrice(),
                order.getTotalExcludeTaxe(),
                order.getTotalWithTaxe(),
                state
        );
    }
    
    public static Order buildOrder(OrderDTO dto) {
        
        if (dto == null) {
            return null;
        }
        
        Customer customer = null;

        if (dto.getCustomer() != null && dto.getCustomer().getId() != null) {
            customer = new Customer();
            customer.setId(dto.getCustomer().getId());
        }
        
        OrderState state = null;

        // converti string type to enum
        if (dto.getState() != null) {
            state = OrderState.valueOf(dto.getState());
        }

        return new Order(
                dto.getId(),
                customer,
                dto.getType(),
                dto.getLabel(),
                dto.getNumberOfDays(),
                dto.getUnitPrice(),
                dto.getTotalExcludeTaxe(),
                dto.getTotalWithTaxe(),
                state
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
     
     
    public static Order copy(Order order, Order content) {

        if (order == null || content == null) {
            return null;
        }

        if (content.getType() != null) {
            order.setType(content.getType());
        }

        if (content.getLabel() != null) {
            order.setLabel(content.getLabel());
        }

        if (content.getCustomer() != null && content.getCustomer().getId() != null) {
            Customer customer = new Customer();
            customer.setId(content.getCustomer().getId());
            order.setCustomer(customer);
        }

        if (content.getNumberOfDays() != null) {
            order.setNumberOfDays(content.getNumberOfDays());
        }

        if (content.getUnitPrice() != null) {
            order.setUnitPrice(content.getUnitPrice());
        }

        if (content.getTotalExcludeTaxe() != null) {
            order.setTotalExcludeTaxe(content.getTotalExcludeTaxe());
        }

        if (content.getTotalWithTaxe() != null) {
            order.setTotalWithTaxe(content.getTotalWithTaxe());
        }

        if (content.getState() != null) {
            order.setState(content.getState());
        }

        return order;
    }
    
}
