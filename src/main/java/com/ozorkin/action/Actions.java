package com.ozorkin.action;

import lombok.Getter;

@Getter
public enum Actions {
    AVG_MARK_BY_GROUP("Get average marks by group", new AverageMarksByGroups()),
    CREATE_RANDOM_STUDENT("Create random student", new CreateRandomStudent()),
    FIND_TEACHER_BY_NAME("Find teacher by name", new FindTeacherByName()),
    GET_STUDENTS_WITH_HIGHER_AVG_MARKS("Getting students with higher avg marks", new GetStudentsWithHigherAvgMarks()),
    GET_SUBJECTS_STATISTICS("Get subjects statistics", new GetSubjectStatistics()),
    EXIT("Finish program", new ExitAction());

    private final String name;
    private final Action action;

    Actions(final String name, final Action action) {
        this.name = name;
        this.action = action;
    }

    public void execute() {
        action.execute();
    }
}
