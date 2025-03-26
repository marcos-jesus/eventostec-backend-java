package com.example.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAWS {
    @Value("${aws.bucket.name}")
    private string bucketName;


    @Value("${aws.region}")
    private String awsRegion;

    @Bean
    public AmazonS3 createS3Instance() {
        return AmazonS3ClientBuilder.standard().withRegion(awsRegion).build();
    }
}
