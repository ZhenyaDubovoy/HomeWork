package week1.task1.model;

import week1.groupapp.model.*;

/**
 * Created by Евгений Дубовой on 06.09.2017.
 */
public class Student {
    private String name;
    private Adress adress;

    private Subject[] subjects = new Subject[50];
    private int numberOfSubjects;

    public Student(String name, Adress adress) {
        this.name = name;
        this.adress = adress;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public int getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public void learn(Subject subject, int hours)
    {
        subject.studentLearning(this, hours);
        return;
    }

    public boolean addSubject(Subject subject)
    {
        if(subject == null)
        {
            return false;
        }
        else
        {
            subjects[numberOfSubjects]=subject;
            numberOfSubjects++;
            subject.enrollStudent(this);
            return true;
        }

    }

    public void deleteLastSubject()
    {
        subjects[numberOfSubjects-1] = null;
        numberOfSubjects--;
        return;
    }

    public void showAllSubjects() {

        if(numberOfSubjects == 0){
            return;
        }
        for (Subject subject:subjects
             ) {if(subject == null){
            return;
        }
            subject.showSubjInfo();
        }
        return;
    }

    public double getMiddleRate(){
        double total = 0;

        for (int i=0; i<numberOfSubjects; i++){
            total += subjects[i].getStudentRate(this);
        }

        return total/numberOfSubjects;
    }
}
