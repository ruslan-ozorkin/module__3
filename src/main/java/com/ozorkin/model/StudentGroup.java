package com.ozorkin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
public class StudentGroup {
    @Id
    private String groupId;

    private String groupName;

    @OneToMany(mappedBy = "studentGroup", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Student> studentList;


    @SneakyThrows
    public StudentGroup() {
        this.groupId = UUID.randomUUID().toString();
        this.groupName="ZERO";
    }

}
