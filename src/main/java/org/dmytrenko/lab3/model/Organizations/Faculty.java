package org.dmytrenko.lab3.model.Organizations;

import org.dmytrenko.lab3.model.People.Human;

import java.util.List;

public class Faculty extends FirstInfoForOrganization {
    private University university;

    private List<Department> departmentList;


    Faculty(Human head, String name) {
        super(head, name);
    }
}
