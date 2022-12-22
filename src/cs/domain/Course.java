package cs.domain;

import java.util.ArrayList;

public class Course {
    private String number = null;
    private String name = null;
    private int maxNumbOfStudents;
    private ArrayList<Instructor> instructors;

    public Course() {
    }

    public Course(String number, String name, int maxNumbOfStudents, ArrayList<Instructor> instructors) {
        this.number = number;
        this.name = name;
        this.maxNumbOfStudents = maxNumbOfStudents;
        this.instructors = instructors;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxNumbOfStudents() {
        return maxNumbOfStudents;
    }

    public void setMaxNumbOfStudents(int maxNumbOfStudents) {
        this.maxNumbOfStudents = maxNumbOfStudents;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }
}
