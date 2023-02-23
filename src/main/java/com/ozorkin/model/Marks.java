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
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String mark_id;
    private int mark;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @ToString.Exclude
    private Subject subject;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @ToString.Exclude
    private Student student;

    public Marks() {
    }

    public Marks(int mark, Subject subject, Student student) {
        this.mark = mark;
        this.subject = subject;
        this.student = student;
    }
}
