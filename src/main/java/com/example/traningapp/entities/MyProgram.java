package com.example.traningapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "MyProgram")
public class MyProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mpId;

    @Column(nullable = false)
    private String programName;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private MyTraining myTraining;

    public MyProgram(int mpId, String programName, MyTraining myTraining) {
        this.mpId = mpId;
        this.programName = programName;
        this.myTraining = myTraining;
    }
}
