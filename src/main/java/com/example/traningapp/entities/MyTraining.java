package com.example.traningapp.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "mpId", nullable = false)
    private MyProgram myProgram;

    public MyTraining(String exercise, int numRep, int numSet, Users users, MyProgram myProgram) {
        this.exercise = exercise;
        this.numRep = numRep;
        this.numSet = numSet;
        this.users = users;
        this.myProgram = myProgram;
    }
}
