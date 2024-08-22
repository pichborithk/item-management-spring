package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.models.User.User;
import dev.pichborith.ItemManagement.models.User.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User toUser(UserRequest request) {
        String password = passwordEncoder.encode(request.password());
        return new User(request.username(), password);
    }

}
