package be.abis.assignment.main.model;

import be.abis.assignment.main.enumeration.TypeOfBread;
import java.util.List;

public class OfficeManager extends Person{
    public OfficeManager(String firstName, String lastName) {
        super(firstName, lastName);
    }


    //Sessions are hardcoded
    /*private List<Session> sessions;
    public void addSession(String sessionName){
        Session session = new Session(sessionName);
        sessions.add(session);
        }
    public void deleteSession(){}
     */

    public void printOutput(){}
}
