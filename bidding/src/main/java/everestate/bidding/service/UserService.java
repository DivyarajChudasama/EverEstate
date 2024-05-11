package everestate.bidding.service;

import  everestate.bidding.model.User;
import  everestate.bidding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Save the user's password directly without encryption
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        // Retrieve user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Validate password (No encryption required for comparison)
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
