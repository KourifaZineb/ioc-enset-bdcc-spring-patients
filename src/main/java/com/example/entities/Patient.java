package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter @ToString
@Builder
@Table(name = "PATIENTS")
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private  int score;
    private  boolean malade;
}
