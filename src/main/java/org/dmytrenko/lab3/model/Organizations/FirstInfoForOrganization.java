package org.dmytrenko.lab3.model.Organizations;

import org.dmytrenko.lab3.model.People.Human;
import org.dmytrenko.lab3.model.People.Student;

import java.util.List;

abstract class FirstInfoForOrganization {
    protected Human head;
    protected String name;
    protected List<Student> studentList;
    protected int countOfStudents;

    FirstInfoForOrganization(Human head, String name){
        this.head = head;
        this.name = name;
    }
}
