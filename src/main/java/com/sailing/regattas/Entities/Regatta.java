package com.sailing.regattas.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Regatta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String regattaName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private String location;

    @ElementCollection
    @CollectionTable(name = "boat_classes", joinColumns = @JoinColumn(name = "regatta_id"))
    @Column(name = "boat_class")
    private List<String> boatClasses = new ArrayList<>();

    private String startDate;
    private String endDate;
    private String description;
    private String imageUrl;
    private Double joiningFee;
    @OneToMany(mappedBy = "regatta", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Team> teams = new ArrayList<>();

}