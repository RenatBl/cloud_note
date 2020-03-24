package ru.itis.program.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "note_header")
    private String header;

    @Column(name = "note_content")
    private String content;

    @Column(name = "changing_date")
    private LocalDateTime dateTime;

}
