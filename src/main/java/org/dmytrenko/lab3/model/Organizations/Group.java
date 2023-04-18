package org.dmytrenko.lab3.model.Organizations;

import org.dmytrenko.lab3.model.People.Human;

public class Group extends FirstInfoForOrganization {
    private Faculty faculty;

    Group(Human head, String name) {
        super(head, name);
    }
}
