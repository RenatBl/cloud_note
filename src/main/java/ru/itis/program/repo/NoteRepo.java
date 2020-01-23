package ru.itis.program.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.program.models.Note;
import ru.itis.program.models.User;

import java.time.LocalDateTime;
import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Long> {
    Note findByHeader(String header);

    List<Note> getAllByOwner(User owner);
    List<Note> findAllByOwnerAndDateTimeIsBefore(User owner, LocalDateTime dateTime);
    List<Note> findAllByOwnerAndDateTimeIsAfter(User owner, LocalDateTime dateTime);
}
