package com.application.login.service;

import com.application.login.model.User;
import com.application.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User save(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Bu kullanıcı adı zaten kullanılıyor.");
        }
        if (userRepository.findByUsername   (user.getMail()) != null) {
            throw new IllegalArgumentException("Bu mail adresi zaten kullanılıyor.");
        }
        if (userRepository.findByUsername(user.getPhone()) != null) {
            throw new IllegalArgumentException("Bu telefon nuamrası zaten kullanılıyor.");
        }
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
