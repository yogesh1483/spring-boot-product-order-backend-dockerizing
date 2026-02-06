package com.spring.app.controller;

import com.spring.app.dto.OrderDto;
import com.spring.app.serviceimpl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private final OrderServiceImpl service;

    @GetMapping
    public List<OrderDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OrderDto get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public OrderDto create(@RequestBody OrderDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public OrderDto update(
            @PathVariable Long id,
            @RequestBody OrderDto dto
    ) {
        return service.save(
                new OrderDto(id, dto.getCustomerName(), dto.getProducts())
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}