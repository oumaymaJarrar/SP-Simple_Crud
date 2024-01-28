package com.fomationSpring.demo.ServiceImpl;

import com.fomationSpring.demo.Dto.RequestUser;
import com.fomationSpring.demo.Dto.RequestUserUpdate;
import com.fomationSpring.demo.Dto.ResponseUser;
import com.fomationSpring.demo.Entities.Department;
import com.fomationSpring.demo.Entities.User;
import com.fomationSpring.demo.Repository.DepartmentRepository;
import com.fomationSpring.demo.Repository.UserRepository;
import com.fomationSpring.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public List<ResponseUser> getAllUser() {
        List<User> users = userRepository.findAll();
        List<ResponseUser> userFormated =new ArrayList<>();
        for(User user : users){
            ResponseUser member = ResponseUser.makeUser(user);
            userFormated.add(member);
        }
        return userFormated;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return false;
    }

    @Override
    public void createUser(RequestUser userRequest) {
        Department department = departmentRepository.findById(userRequest.getDepartmentId()).orElseThrow();
        User user = User.builder()
                .lastName(userRequest.getLastName())
                .firstName(userRequest.getFirstName())
                .phoneNumber(userRequest.getPhoneNumber())
                .email(userRequest.getEmail())
                .department(department)
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .status(true)
                .build();
        userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, RequestUserUpdate userRequest) {
        User user = userRepository.findById(id).orElseThrow();
        if(userRequest.getEmail() !=null){
            user.setEmail(userRequest.getEmail());
        }
        if(userRequest.getLastName() !=null){
            user.setLastName(userRequest.getLastName());
        }
        if(userRequest.getPhoneNumber() !=0){
            user.setPhoneNumber(userRequest.getPhoneNumber());
        }
        if(userRequest.getDepartmentId() !=null){
            Department department = departmentRepository.getById(userRequest.getDepartmentId());
            user.setDepartment(department);
        }

        return userRepository.save(user);
    }

    @Override
    public ResponseUser getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return ResponseUser.makeUser(user.get());
    }
}
