package com.example.traningapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


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

    @Column(name = "userName", unique = true)
    private String userName;

    @Column(name = "pass")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private Set<MyTraining> myTrainings;

 /*   @OneToMany(mappedBy = "users")
    @JsonIgnore
    private Set<MyProgram> myPrograms;*/

    public Users(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

}
