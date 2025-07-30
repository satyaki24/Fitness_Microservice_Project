package com.fitness.userservice.Entity;

import com.fitness.userservice.Entity.Enum.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    @Column(unique = true, nullable = false)
    private String email;

    private String keycloakId;

    private String password;

    private String firstName;

    private String lastName;

    @Enumerated
    private UserRole userRole= UserRole.USER;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;
}
