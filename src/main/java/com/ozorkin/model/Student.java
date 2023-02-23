package com.ozorkin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Table(name = "student")
@javax.persistence.Entity(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String student_id;
    private String firstname;
    private String surname;
    private int age;
    @Column(name = "rep_date")
    private LocalDateTime entryDateTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "groupId")
    private StudentGroup studentGroup;

    @OneToMany (mappedBy = "student",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Marks> marks;

    public Student() {

    }

    public Student(String student_id, String firstname, String surname, int age, LocalDateTime entryDateTime) {
        this.student_id = student_id;
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.entryDateTime = entryDateTime;
        this.studentGroup=new StudentGroup();
    }

    @PrePersist
    public void prePersist() {
        if (entryDateTime == null) {
            entryDateTime = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        }

    }
    public static class StudentBuilder {
        private String student_id;
        private String firstname;
        private String surname;
        private int age;
        private LocalDateTime entryDateTime;


        public StudentBuilder withId() {
            this.student_id = UUID.randomUUID().toString();
            return this;
        }
        public StudentBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public StudentBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder withDateTime(LocalDateTime entryDateTime) {
            this.entryDateTime = entryDateTime;
            return this;
        }



        public Student build() {
            return new Student(student_id, firstname, surname, age, entryDateTime);
        }
    }

    }
