package com.ozorkin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String teacher_id;
    private String firstname;
    private String surname;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @ToString.Exclude
    private Subject subject;


    public Teacher() {
    }

    public Teacher(String name, String surname, int age) {
        this.firstname = name;
        this.surname = surname;
        this.age = age;
    }

}
