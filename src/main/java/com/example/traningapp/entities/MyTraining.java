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
    @Column(name = "id")
    private int id;
    private String exercise;
    private int numRep;
    private int numSet;

    @ManyToOne
    @JoinColumn(name = "uId")

    private Users users;

    public MyTraining(String exercise, int numRep, int numSet, Users users) {
        this.exercise = exercise;
        this.numRep = numRep;
        this.numSet = numSet;
        this.users = users;
    }
}
