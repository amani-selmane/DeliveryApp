package com.example.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.entities.User.Role;
import com.example.payloads.UserPayload;
import com.example.repositry.UserRepository;
import com.example.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserPayload> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserPayload.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserPayload getUserById(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(user -> modelMapper.map(user, UserPayload.class)).orElse(null);
    }

    @Override
    public UserPayload createUser(UserPayload userPayload) {
        User user = modelMapper.map(userPayload, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserPayload.class);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserPayload> getUsersByRole(Role role) {
        List<User> users = userRepository.findByRole(role);
        return users.stream()
                .map(user -> modelMapper.map(user, UserPayload.class))
                .collect(Collectors.toList());
    }
}
