package com.sailing.regattas.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "regatta_id")
    private Regatta regatta;

    private String yachtName;
    private String boatClass;
    private String country;
    private Integer sailNumber;
    private String skipper;
    private Integer licenseNumber;
    private String sailClub;
    private String birthdate;
    @ElementCollection
    @CollectionTable(name = "crew_members", joinColumns = @JoinColumn(name = "team_id"))
    @Column(name = "crew_members")
    private List<String> crewMembers = new ArrayList<>();
    private Integer points;
}
