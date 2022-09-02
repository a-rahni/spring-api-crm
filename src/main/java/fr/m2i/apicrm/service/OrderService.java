
package fr.m2i.apicrm.service;

import fr.m2i.apicrm.dto.CustomerMapper;
import fr.m2i.apicrm.dto.OrderMapper;
import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Order;
import fr.m2i.apicrm.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService implements IOrderService {
    
    private final OrderRepository repo;

    @Autowired
    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }
    
    

    @Override
    public List<Order> findAll() {
        return repo.findAll();
    }

    @Override
    public Order findById(Long id) {
        return repo.findById(id).orElseThrow( ()->
        {throw new NotFoundException("Order with id: "+id+ " was not found"); }  );
    }

    @Override
    public Order save(Order order) {
        // to do: vérifier si l'objet n'existe pas déja dans la base
        // dans mapper dto enlever l'id
        return repo.save(order);
    }

    @Transactional
    @Override
    public Order update(Long id, Order orderContent) {
        Order orderToUpdate = findById(id);
        OrderMapper.copy(orderToUpdate, orderContent);
        return repo.save(orderToUpdate);
    }

    @Override
    public void delete(Long id) {
        Order orderToDelete = findById(id);
        repo.delete(orderToDelete);
    }
    
}
