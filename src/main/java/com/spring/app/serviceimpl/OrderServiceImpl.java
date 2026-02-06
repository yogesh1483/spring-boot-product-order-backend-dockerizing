package com.spring.app.serviceimpl;

import com.spring.app.dto.OrderDto;
import com.spring.app.entity.Order;
import com.spring.app.exception.BusinessValidationException;
import com.spring.app.exception.ResourceNotFoundException;
import com.spring.app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl {

    @Autowired
    private final OrderRepository repo;
    @Autowired
    private final ModelMapper mapper;

    public List<OrderDto> findAll() {
        return repo.findAll()
                .stream()
                .map(o -> mapper.map(o, OrderDto.class))
                .toList();
    }

    public OrderDto findById(Long id) {
        Order order = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order", id)
                );

        return mapper.map(order, OrderDto.class);
    }

    public OrderDto save(OrderDto dto) {

        if (dto.getProducts() == null || dto.getProducts().isEmpty()) {
            throw new BusinessValidationException(
                    "Order must contain at least one product"
            );
        }

        Order order = mapper.map(dto, Order.class);

        order.getProducts()
                .forEach(p -> p.setOrder(order));

        Order saved = repo.save(order);
        return mapper.map(saved, OrderDto.class);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Order", id);
        }
        repo.deleteById(id);
    }
}
