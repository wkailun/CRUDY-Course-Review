package edu.virginia.sde.reviews;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Column(name = "username")
    private String username1;
    @Column(name = "password")
    private String password1;
    @Id
    @Column(name = "StudentID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // This was the only way to get rid of an error - not sure what this constructor actually does lol
    public Student() {

    }

    // Defining name and password
    public Student(String name, String password) {
        this.username1 = name;
        this.password1 = password;
    }

    // Student ID that is associated with student
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    // Username setters and getters
    public String setUsername(String name) {
        return this.username1 = name;
    }
    public String getUsername() {
        return username1;
    }
    // Password setters and getters
    public String setPassword(String password) {
        return this.password1 = password;
    }
    public String getPassword() {
        return password1;
    }
}