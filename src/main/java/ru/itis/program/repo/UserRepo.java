package ru.itis.program.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.program.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
