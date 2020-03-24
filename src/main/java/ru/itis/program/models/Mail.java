package ru.itis.program.models;

import lombok.*;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mail {
    private String mailTo;
    private Map<String, Object> model;
    private String mailContent;
    private String mailSubject;
}
