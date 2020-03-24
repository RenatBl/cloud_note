package ru.itis.program.models;

import lombok.*;
import ru.itis.program.models.enums.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "hashed_password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Storage> storages;

    @Column(name = "user_role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name = "user_status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "last_active")
    private LocalDateTime lastActive;

    @Column(name = "registration_date")
    private LocalDateTime dateOfRegistration;

    @Column(name = "user_credential")
    private Credential credential;
}
