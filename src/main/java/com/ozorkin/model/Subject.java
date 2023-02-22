package com.ozorkin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String subject_id;
    private String subjectName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    @ToString.Exclude
    private Teacher teacher;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marks_id")
    private Marks mark;

    public Subject() {
    }

    public Subject(String subjectName, Teacher teacher, Marks mark) {
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.mark = mark;
    }




}
