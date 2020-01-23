package ru.itis.program.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.program.models.Storage;

public interface StorageRepo extends JpaRepository<Storage, Long> {
}
