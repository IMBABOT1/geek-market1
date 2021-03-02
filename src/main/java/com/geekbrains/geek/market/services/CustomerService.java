package com.geekbrains.geek.market.services;
import com.geekbrains.geek.market.entities.Customer;
import com.geekbrains.geek.market.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }
}
