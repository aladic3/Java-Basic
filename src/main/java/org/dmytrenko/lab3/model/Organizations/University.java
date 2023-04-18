package org.dmytrenko.lab3.model.Organizations;

import org.dmytrenko.lab3.model.People.Human;

import java.util.List;

public class University extends FirstInfoForOrganization {
    List<Faculty> facultyList;

    University(Human head, String name) {
        super(head, name);
    }
}
