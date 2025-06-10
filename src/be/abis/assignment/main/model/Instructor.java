package be.abis.assignment.main.model;

import be.abis.assignment.main.enumeration.TypeOfBread;

public class Instructor extends Person {

    Session session;
    public Instructor(String firstName, String lastName, Session session) {
        super(firstName, lastName);
        this.session = session;
    }
}
