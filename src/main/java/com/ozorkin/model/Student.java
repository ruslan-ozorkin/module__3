package com.ozorkin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    private LocalDateTime dateTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "groupId")
    private StudentGroup studentGroup;

    @OneToMany (mappedBy = "student",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Marks> marks;

    public Student() {

    }

    @PrePersist
    public void prePersist() {
        if (dateTime == null) {
            dateTime = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        }

    }
}
