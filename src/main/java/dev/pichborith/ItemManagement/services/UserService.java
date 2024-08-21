package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.exception.BadRequestException;
import dev.pichborith.ItemManagement.exception.ConflictException;
import dev.pichborith.ItemManagement.exception.InternalException;
import dev.pichborith.ItemManagement.models.User;
import dev.pichborith.ItemManagement.models.UserRequest;
import dev.pichborith.ItemManagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;

    public User createUser(UserRequest request) {
        String username = request.username();
        String password = request.password();
        if (username.isBlank() || password.length() < 3) {
            throw new BadRequestException("Missing Information");
        }

        if (userRepo.existsByUsername(username)) {
            throw new ConflictException(
                String.format("User with name: %s already exist", username));
        }

        try {
            User user = userMapper.toUser(request);
            return userRepo.save(user);
        } catch (Exception e) {
            throw new InternalException("Error occurred while create user");
        }

    }

    @Override
    public UserDetails loadUserByUsername(
        String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                       .orElseThrow(() -> new UsernameNotFoundException(
                           "Username not found"));
    }
}
