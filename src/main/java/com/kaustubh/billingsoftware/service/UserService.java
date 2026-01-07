package com.kaustubh.billingsoftware.service;

import com.kaustubh.billingsoftware.io.UserRequest;
import com.kaustubh.billingsoftware.io.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    String getUserRole(String email);

    List<UserResponse> readUsers();

    void deleteUser(String id);
}
