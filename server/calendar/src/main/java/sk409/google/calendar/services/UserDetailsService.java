package sk409.google.calendar.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sk409.google.calendar.models.User;
import sk409.google.calendar.repositories.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        if (username == null || "".equals(username)) {
            throw new UsernameNotFoundException("username is empty");
        }
        final User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User does not exist: " + username);
        }
        return user;
    }

}