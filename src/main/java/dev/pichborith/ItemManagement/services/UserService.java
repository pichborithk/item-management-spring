package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.exception.BadRequestException;
import dev.pichborith.ItemManagement.exception.ConflictException;
import dev.pichborith.ItemManagement.exception.InternalException;
import dev.pichborith.ItemManagement.exception.UnauthorizedException;
import dev.pichborith.ItemManagement.models.User.User;
import dev.pichborith.ItemManagement.models.User.UserRequest;
import dev.pichborith.ItemManagement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

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

    public User getUser(UserRequest request) {
        String username = request.username();
        String password = request.password();
        if (username.isBlank() || password.length() < 3) {
            throw new BadRequestException("Missing Information");
        }

        User user = userRepo.findByUsername(username)
                       .orElseThrow(() -> new UnauthorizedException(
                           String.format("User with name: %s does not exist",
                                         username)));


        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException("Incorrect password");
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(
        String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                       .orElseThrow(() -> new UsernameNotFoundException(
                           "Username not found"));
    }
}
