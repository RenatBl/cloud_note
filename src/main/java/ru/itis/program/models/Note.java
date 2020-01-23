package ru.itis.program.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "storage")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @Column(name = "note_header")
    private String header;

    @Column(name = "note_content")
    private String content;

    @Column(name = "changing_date")
    private LocalDateTime dateTime;
}
