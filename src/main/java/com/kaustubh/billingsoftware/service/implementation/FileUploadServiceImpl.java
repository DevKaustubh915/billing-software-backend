//package com.kaustubh.billingsoftware.service.implementation;
//
//import com.kaustubh.billingsoftware.service.FileUploadService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.io.IOException;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class FileUploadServiceImpl implements FileUploadService {
//
//    @Value("${aws.bucketname}")
//    private String bucketName;
//
//    private final S3Client s3Client;
//
//    @Override
//    public String uploadFile(MultipartFile file) {
//        String fileNameExtention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//        String key = UUID.randomUUID().toString()+"."+fileNameExtention;
//
//        try {
//            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
//                    .bucket(bucketName)
//                    .key(key)
//                    .acl("public-read")
//                    .contentType(file.getContentType())
//                    .build();
//
//            PutObjectResponse putObjectResponse = s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));
//
//            if (putObjectRequest.sdkHttpResponse().isSuccessful()){
//                return  "https://"+bucketName+".s3.amazonaws.com/"+key;
//            }else {
//                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occured while uploading the image");
//            }
//
//        }catch (IOException e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"An error occured while uploading file");
//        }
//    }
//
//    @Override
//    public boolean deleteFile(String imgUrl) {
//        String filename = imgUrl.substring(imgUrl.lastIndexOf("/"));
//        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
//                .bucket(bucketName)
//                .key(filename)
//                .build();
//
//        s3Client.deleteObject(deleteObjectRequest);
//        return true;
//    }
//}
