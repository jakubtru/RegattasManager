package com.sailing.regattas.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore // Exclude 'id' from JSON serialization
    private Long id;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Regatta> regattas = new ArrayList<>();
}
