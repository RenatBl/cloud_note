package ru.itis.program.models;

import lombok.*;
import ru.itis.program.models.enums.Credential;
import ru.itis.program.models.enums.Role;
import ru.itis.program.models.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne
    @JoinColumn(name = "fk_storage_id", referencedColumnName = "storage_id")
    private Storage storage;

    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Note> notes;

    @Column(name = "user_role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name = "user_status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "lastActive")
    private LocalDateTime lastActive;

    @Column(name = "dateOfRegistration")
    private LocalDateTime dateOfRegistration;

    @Column(name = "user_credential")
    private Credential credential;
}
