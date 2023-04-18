package org.dmytrenko.lab3.model.People;

import org.dmytrenko.lab3.model.Organizations.Group;

public class Student extends Human {
    private Group group;
    private Human human;

    Student(Human human) {
        super(human);
        this.human = human;
    }

    Student(Sex sex, String firstName, String lastName, String fatherName) {
        super(sex, firstName, lastName, fatherName);
        this.human = this;
    }
}
