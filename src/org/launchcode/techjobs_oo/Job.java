package org.launchcode.techjobs_oo;

import javax.swing.text.Position;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

   // Two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        if (!name.isEmpty()){
            this.name = name;
        } else {
            this.name = "Data not available";
        }
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString (){
        return " \nID: " + this.id + "\nName: " + this.name
                +"\nEmployer: " + this.employer.toString() + "\nLocation " + this.location.toString() +
                "\nPosition Type: " + this.positionType.toString() + "\nCore Competency: " + this.coreCompetency.toString() +"\n ";
    }

    // Custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals (Object o){
        if(this == o) return true;
        if (!(o instanceof Job)) return false;
        Job that = (Job) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode(){ return Objects.hash(getId());}

    // Getters for each field EXCEPT nextId, and setters for each field EXCEPT nextID
    //  and id.
    public int getId() {
        return id;
    }
    public String getName()  {
        return name;
    }
    public void setName(String name)   {
        this.name = name;
    }
    public Employer getEmployer()   {
        return employer;
    }
    public void setEmployer(Employer employer)   {
        this.employer = employer;
    }
    public Location getLocation()   {
        return location;
    }
    public void setLocation(Location location)   {
        this.location = location;
    }
    public PositionType getPositionType()   {
        return positionType;
    }
    public void setPositionType(PositionType positionType)   {
        this.positionType = positionType;
    }
    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
