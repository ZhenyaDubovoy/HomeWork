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

    public void learn(Subject subject, int hours) {
        subject.studentLearning(this, hours);
        return;
    }

    public boolean addSubject(Subject subject) {
        if (subject == null) {
            return false;
        } else {
            subjects[numberOfSubjects] = subject;
            numberOfSubjects++;
            subject.enrollStudent(this);
            return true;
        }

    }

    public void deleteLastSubject() {
        subjects[numberOfSubjects - 1] = null;
        numberOfSubjects--;
        return;
    }

    public void showAllSubjects() {

        if (numberOfSubjects == 0) {
            return;
        }
        for (int i = 0; i < numberOfSubjects; i++) {
            for (int j = 0; j < subjects[i].getCountPassed(); j++) {
                if (this==subjects[i].getStudentsWhoPassed()[j]){
                    System.out.printf("Subject %s passed with mark %d\n", subjects[i].getName(), subjects[i].getStudentRate(this));
                }
            }
            for (int j = 0; j <subjects[i].getCountEnrolled() ; j++) {
                if (this == subjects[i].getStudentsInWork()[j]){
                    System.out.printf("Subject %s is still at work, worked hours %d / %d\n", subjects[i].getName(),
                            subjects[i].getStudensWorkedHours()[j], subjects[i].getHoursDuringSemestr());
                }
            }
        }
        return;
    }

    public double getMiddleRate() {
        double total = 0;
        int count = numberOfSubjects;

        for (int i = 0; i < numberOfSubjects; i++) {
            if (subjects[i].getStudentRate(this) == -1) {
                count--; //student is now enrolled, do not have mark
            } else {
                total += subjects[i].getStudentRate(this);
            }
        }

        return total / count;
    }
}
