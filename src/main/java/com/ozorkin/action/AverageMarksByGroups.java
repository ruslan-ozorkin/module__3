package com.ozorkin.action;

public class AverageMarksByGroups implements Action{
    @Override
    public void execute() {
        STUDENT_GROUP_SERVICE.avgMarksByGroup();
    }
}
