package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.entities.Customer;
import com.geekbrains.geek.market.exceptions.ResourceNotFoundException;
import com.geekbrains.geek.market.services.CustomerService;
import com.geekbrains.geek.market.services.OrderService;
import com.geekbrains.geek.market.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;
    private CustomerService customerService;

    @GetMapping
    public String firstRequest(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }


    @GetMapping("/finalorders/")
    public String finalOrder(Model model){
        Customer c = customerService.findById(1l).orElseThrow(() -> new ResourceNotFoundException("invalid id"));
        model.addAttribute("customer", c);
        return "finalorders";
    }
}
