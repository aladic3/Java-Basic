package org.dmytrenko.lab3.model.Organizations;

import org.dmytrenko.lab3.model.People.Human;

import java.util.List;

public class Department extends FirstInfoForOrganization{

    private Faculty faculty;

    private List<Group> groupList;

    Department(Human head, String name) {
        super(head, name);
    }
}
