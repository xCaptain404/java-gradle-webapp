package com.example.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UserService - Business logic for user operations
 * Note: Using in-memory storage for demo purposes (no database)
 */
public class UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static Map<Integer, User> users = new HashMap<>();
    private static int nextUserId = 1;
    
    static {
        // Initialize with sample data
        users.put(1, new User(1, "John Doe", "john@example.com", "New York", LocalDateTime.now()));
        users.put(2, new User(2, "Jane Smith", "jane@example.com", "Los Angeles", LocalDateTime.now()));
        users.put(3, new User(3, "Bob Johnson", "bob@example.com", "Chicago", LocalDateTime.now()));
        nextUserId = 4;
    }
    
    /**
     * Get all users
     */
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return new ArrayList<>(users.values());
    }
    
    /**
     * Get user by ID
     */
    public User getUserById(int id) {
        logger.info("Fetching user with ID: " + id);
        return users.get(id);
    }
    
    /**
     * Create a new user
     */
    public User createUser(User user) {
        user.setId(nextUserId++);
        user.setCreatedAt(LocalDateTime.now());
        users.put(user.getId(), user);
        logger.info("User created with ID: " + user.getId());
        return user;
    }
    
    /**
     * Update user
     */
    public User updateUser(User user) {
        if (users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            logger.info("User updated with ID: " + user.getId());
            return user;
        }
        return null;
    }
    
    /**
     * Delete user
     */
    public boolean deleteUser(int id) {
        if (users.containsKey(id)) {
            users.remove(id);
            logger.info("User deleted with ID: " + id);
            return true;
        }
        return false;
    }
    
    /**
     * Get users by city
     */
    public List<User> getUsersByCity(String city) {
        logger.info("Fetching users from city: " + city);
        List<User> result = new ArrayList<>();
        for (User user : users.values()) {
            if (city.equalsIgnoreCase(user.getCity())) {
                result.add(user);
            }
        }
        return result;
    }
}
