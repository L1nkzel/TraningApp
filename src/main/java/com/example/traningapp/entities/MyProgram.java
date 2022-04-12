//package com.example.traningapp.entities;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@NoArgsConstructor
//@Getter
//@Setter
//@Entity
//@Table(name = "MyProgram")
//public class MyProgram {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int mpId;
//
//    @Column(nullable = false)
//    private String programName;
//
//    @OneToMany(mappedBy = "myProgram")
//    @JsonIgnore
//    private Set<MyTraining> myTraining;
//
//    @ManyToOne
//    @JoinColumn(name = "uId", nullable = false)
//    private Users users;
//
//    public MyProgram(int mpId, String programName, Users users) {
//        this.mpId = mpId;
//        this.programName = programName;
//        this.users = users;
//
//    }
//}
