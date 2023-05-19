package com.javatechie.aws.cicd.example;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.services.s3.AmazonS3;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
@Log4j2
public class OrderServiceApplication {

    @Autowired
    private OrderDao orderDao;


    @Autowired
    private  AmazonS3 s3client;


    @GetMapping
    public List<Order> fetchOrders() {
        if (s3client.doesBucketExist("bucketName")) {
            log.info("Bucket name is not available."
                    + " Try again with a different Bucket name.");
            return null;
        }


    }

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
