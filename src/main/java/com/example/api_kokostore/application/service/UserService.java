package com.example.api_kokostore.application.service;


import com.example.api_kokostore.application.dto.users.CustomerRequest;
import com.example.api_kokostore.application.dto.users.UserResponse;
import com.example.api_kokostore.domain.entities.CustomerEntity;
import com.example.api_kokostore.domain.repository.CustomerRepository;
import com.example.api_kokostore.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  CustomerRepository customerRepository;



    public UserResponse createOrUpdateCustomer(CustomerRequest request, UUID id){

        try{

            CustomerEntity customerEntity = customerRepository.findByUserId(id).orElseGet(()->
                    {
                        CustomerEntity newCustomer = new CustomerEntity();
                        newCustomer.setUser(userRepository.findById(id)
                                .orElseThrow(()-> new UsernameNotFoundException("User not found")));

                        return newCustomer;
                    }
            );

            if (request.address() != null) {
                customerEntity.setAddress(request.address());
            }
            if (request.city() != null) {
                customerEntity.setCity(request.city());
            }
            if (request.country() != null) {
                customerEntity.setCountry(request.country());
            }
            if (request.state() != null) {
                customerEntity.setState(request.state());
            }
            if (request.zipCode() != null) {
                customerEntity.setZipCode(request.zipCode());
            }

            CustomerEntity customer = customerRepository.save(customerEntity);


            return UserResponse.from(customer.getUser());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
