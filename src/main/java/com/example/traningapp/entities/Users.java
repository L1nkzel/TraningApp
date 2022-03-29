package com.example.traningapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uId")
    private int uId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private Set<MyTraining> myTrainings;
}
