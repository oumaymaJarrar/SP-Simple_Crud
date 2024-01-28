package com.fomationSpring.demo.Service;

import com.fomationSpring.demo.Dto.RequestUser;
import com.fomationSpring.demo.Dto.ResponseUser;
import com.fomationSpring.demo.Dto.RequestUserUpdate;
import com.fomationSpring.demo.Entities.User;

import java.util.List;

public interface UserService {
    List<ResponseUser> getAllUser();
    boolean deleteUser(Long id);
    void createUser(RequestUser userRequest);
    User updateUser(Long id, RequestUserUpdate userRequest);
    ResponseUser getUserById(Long id);
}
