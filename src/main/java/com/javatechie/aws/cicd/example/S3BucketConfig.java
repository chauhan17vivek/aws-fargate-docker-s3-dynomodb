// Copyright 2023 NXGN Management, LLC. All Rights Reserved.

package com.javatechie.aws.cicd.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3BucketConfig {

    @Bean
    public AmazonS3 getStorageService() {
        return AmazonS3ClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
    }
}
