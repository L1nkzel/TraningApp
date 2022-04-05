package com.example.traningapp.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "MyTraining")
public class MyTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String exercise;
    @Column(nullable = false)
    private int numRep;
    @Column(nullable = false)
    private int numSet;

    @ManyToOne
    @JoinColumn(name = "uId", nullable = false)
    private Users users;

    public MyTraining(String exercise, int numRep, int numSet, Users users) {
        this.exercise = exercise;
        this.numRep = numRep;
        this.numSet = numSet;
        this.users = users;
    }
}
