package com.kaustubh.billingsoftware.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsConfig {

    @Value("${aws.access.key}")
    private String acessKey;
    @Value("${aws.secret.key}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;

    @Bean
    public S3Client s3Client(){

        if (acessKey == null || acessKey.isBlank()
                || secretKey == null || secretKey.isBlank()) {

            throw new RuntimeException(
                    "AWS credentials not found. Set AWS_ACCESS_KEY and AWS_SECRET_KEY as environment variables."
            );
        }

        return S3Client.builder()
                .region(Region.of(region)) // add proper region
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create(acessKey, secretKey)))
                .build();
    }
}
