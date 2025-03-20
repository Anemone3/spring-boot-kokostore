package com.example.api_kokostore.application.service;

import com.example.api_kokostore.application.dto.order.DetailOrderRequest;
import com.example.api_kokostore.application.dto.order.OrderRequest;
import com.example.api_kokostore.application.dto.order.PayloadProduct;
import com.example.api_kokostore.domain.entities.*;
import com.example.api_kokostore.domain.repository.CustomerRepository;
import com.example.api_kokostore.domain.repository.DetailOrderRepository;
import com.example.api_kokostore.domain.repository.OrderRepository;
import com.example.api_kokostore.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DetailOrderRepository detailOrderRepository;


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;


    private OrderEntity createOrder(OrderRequest request) {
        OrderEntity order = new OrderEntity();

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setId(1);

        CustomerEntity customer = customerRepository.findById(request.customerId()).orElseThrow(()->new RuntimeException("Customer not found"));


        order.setCustomer(customer);
        order.setPayment(paymentEntity);
        order.setTotal(0);

        return orderRepository.save(order);
    }



    @Transactional
    public OrderEntity createDetailOrder(DetailOrderRequest request) {

        OrderEntity order = createOrder(request.order());


        List<DetailOrderEntity> detailsOrders = new ArrayList<>();

        double montoTotal = 0;
        int quantity = 0;


        for (PayloadProduct item : request.cart()){

            ProductEntity product = productRepository.findById(item.id())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            DetailOrderEntity orderItem = new DetailOrderEntity();

            orderItem.setProduct(product);
            orderItem.setDescription(product.getName());
            orderItem.setQuantity(item.quantity());
            orderItem.setPrice(item.price());
            orderItem.setOrder(order);
            orderItem.setSubtotal(item.price() * item.quantity());

            montoTotal += (item.price() * item.quantity());
            quantity+= item.quantity();

            detailsOrders.add(orderItem);
        }

        order.setTotal(montoTotal);
        order.setQuantity(quantity);
        order.setDetailOrders(detailsOrders);


        OrderEntity resultOrder = orderRepository.save(order);
        detailOrderRepository.saveAll(detailsOrders);

        return resultOrder;
    }


}
