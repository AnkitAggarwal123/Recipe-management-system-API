package com.geekster.Recipe.management.system.API.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String tokenValue;
    private LocalDateTime tokenCreationDateTime;

    @OneToOne
    @JoinColumn(name = "fk_user_Id")
    User user;

    public Authentication(User existingUser) {
        this.user = existingUser;
        tokenValue = UUID.randomUUID().toString();
        tokenCreationDateTime = LocalDateTime.now();
    }
}
