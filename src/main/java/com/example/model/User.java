package com.example.model;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * User model class
 */
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private String email;
    private String city;
    private LocalDateTime createdAt;
    
    public User() {
    }
    
    public User(int id, String name, String email, String city, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.createdAt = createdAt;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
