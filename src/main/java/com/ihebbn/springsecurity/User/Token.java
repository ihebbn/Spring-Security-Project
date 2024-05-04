package com.ihebbn.springsecurity.User;

import jakarta.persistence.*;
import lombok.*;

import javax.sound.sampled.AudioFileFormat;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue
    private Integer id;

    private String Token;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private LocalDateTime ValidatedAt;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
