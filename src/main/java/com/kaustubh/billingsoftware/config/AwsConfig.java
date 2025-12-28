//package com.kaustubh.billingsoftware.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.swing.plaf.synth.Region;
//
//@Configuration
//public class AwsConfig {
//
//    @Value("${aws.acess.key}")
//    private String acessKey;
//    @Value("${aws.secret.key}")
//    private String secretKey;
//
//    @Value("${aws.region}")
//    private String region;
//
//    @Bean
//    public S3Client s3Client(){
//        return S3Client.builder()
//                .region(Region.of(region)) // add proper region
//                .credentialsProvider(
//                        StaticCredentialsProvider.create(
//                                AwsBasicCredentials.create(acessKey, secretKey)))
//                .build();
//    }
//}
