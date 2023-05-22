package com.hcl.loginRegister.model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name must not be empty")
    private String firstName;

    @NotNull(message = "Last name is mandatory")
    @NotBlank(message = "Last name must not be empty")
    private String lastName;

    @NotNull(message = "Username is mandatory")
    @NotBlank(message = "Username must not be empty")
    @Size(min = 4)
    private String username;

    @NotNull(message = "Email is mandatory")
    @NotBlank(message = "Email must not be empty")
    @Size(min = 4)
    private String email;

    @NotNull(message = "Password is mandatory")
    @NotBlank(message = "Password must not be empty")
    @Size(min = 4)
    private String password;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}