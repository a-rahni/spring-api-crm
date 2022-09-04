
package fr.m2i.apicrm.controller;

import fr.m2i.apicrm.dto.OrderDTO;
import fr.m2i.apicrm.dto.OrderMapper;
import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Order;
import fr.m2i.apicrm.response.ErrorResponseEntity;
import fr.m2i.apicrm.service.IOrderService;
import io.swagger.annotations.ApiOperation;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    
    private final IOrderService orderService;
    
    @Autowired
    public OrderController(IOrderService orderService){
        this.orderService = orderService;
    }
    
    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns the list of all orders", nickname = "Get all orders", response = OrderDTO.class)
    ResponseEntity<Object> getAllOrder(){
        List<Order> orders = orderService.findAll();
        List<OrderDTO> dtos = OrderMapper.buidListOrderDTO(orders);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    
    // consumes est a specifier pour le body, donc
    // pour le Get lorsque consumes est specifié on peut avoir erreur media type not supported 
//    @GetMapping(value="/{id}", 
//            produces=MediaType.APPLICATION_JSON_VALUE,
//            consumes=MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Return a order", nickname = "Get a order by id", response = OrderDTO.class)
    ResponseEntity<Object> getOrderById(@PathVariable("id") String id){
        try{
            Long idOrder = Long.parseLong(id);
            Order order= orderService.findById(idOrder);
            return ResponseEntity.status(HttpStatus.OK).body(OrderMapper.buildOrderDTO(order));
        }catch(NumberFormatException ne){
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/orders/" + id, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("Order was not found", 404, "/v1/orders/" + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/orders/" + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }      
    }
    
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Create an order", nickname = "Create an order", response = OrderDTO.class)
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO dto) {
        try {
            Order toCreate = OrderMapper.buildOrder(dto);
            Order created = orderService.save(toCreate);
            OrderDTO createdDTO = OrderMapper.buildOrderDTO(created);

            return ResponseEntity.status(HttpStatus.OK).body(createdDTO);

        } catch (Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/orders", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "update a order", nickname = "Update an order by id", response = OrderDTO.class)
    public ResponseEntity<Object> updateOrder(@PathVariable("id") String id,@RequestBody OrderDTO dto) {
        try {
            Long idOrder = Long.parseLong(id);
            Order orderContent = OrderMapper.buildOrder(dto);
            Order updatedOrder = orderService.update(idOrder, orderContent);
            OrderDTO updateddDTO = OrderMapper.buildOrderDTO(updatedOrder);

            return ResponseEntity.status(HttpStatus.OK).body(updateddDTO);

        } catch(NumberFormatException ne){
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/orders/" + id, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("Order was not found", 404, "/v1/orders/" + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/orders/"+ id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "delete an order", nickname = "Delete an order by id", code = 204)
    public ResponseEntity<Object> deleteOrder(@PathVariable("id") String id) {
        try {
            Long idOrder = Long.parseLong(id);
            orderService.delete(idOrder);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch(NumberFormatException ne){
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/orders/" + id, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("Order was not found", 404, "/v1/orders/" + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/orders/"+ id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
}
