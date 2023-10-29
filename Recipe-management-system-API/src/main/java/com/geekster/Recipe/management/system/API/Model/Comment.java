package com.geekster.Recipe.management.system.API.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String commentBody;
    private LocalDateTime commentCreationTimeStamp;

    @ManyToOne
    @JoinColumn(name = "Recipe_fk")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "commenter_id_fk")
    private User commenter;
}
