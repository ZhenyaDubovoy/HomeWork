package week1.task1.model;


import javax.swing.plaf.synth.SynthFormattedTextFieldUI;

/**
 * Created by Евгений Дубовой on 06.09.2017.
 */
public class Subject {

    private String name;

    private int hoursDuringSemestr;

    private static final int DEFAULT_COUNT_STUDENTS = 50;

    private Student[] studentsInWork = new Student[DEFAULT_COUNT_STUDENTS];
    private int[] studensWorkedHours = new int[DEFAULT_COUNT_STUDENTS];
    private int countEnrolled;

    private Student[] studentsWhoPassed = new Student[DEFAULT_COUNT_STUDENTS];
    private int[] studentsRating = new int[DEFAULT_COUNT_STUDENTS];
    private int countPassed;

    public Subject(String name, int hoursDuringSemestr) {
        this.name = name;
        this.hoursDuringSemestr = hoursDuringSemestr;
    }

    public String getName() {
        return name;
    }

    public int getHoursDuringSemestr() {
        return hoursDuringSemestr;
    }

    public Student[] getStudentsInWork() {

        return studentsInWork;
    }

    public Student[] getStudentsWhoPassed() {

        return studentsWhoPassed;
    }

    public int[] getStudentsRating() {
        return studentsRating;
    }

    public int[] getStudensWorkedHours() {
        return studensWorkedHours;
    }

    public int getCountPassed() {
        return countPassed;
    }

    public int getCountEnrolled() {
        return countEnrolled;
    }

    public void passTheExam(Student student, int rating) {
        if (student == null) {
            return;
        }

        if (rating > 5 || rating < 3) {
            return;
        }

        for (int i = 0; i < countEnrolled; i++) { //run and find student and if he worked needed count of hours, let him pass exam
            if (student == studentsInWork[i] && (studensWorkedHours[i] >= hoursDuringSemestr)) {

                studentsWhoPassed[countPassed] = student;
                studentsRating[countPassed++] = rating;

                deleteFromEnrolledAfterPassing(student);

                return;
            }
        }
    }

    private void deleteFromEnrolledAfterPassing(Student student) {
        for (int i = 0; i < countEnrolled; i++) { //run
            if (student == studentsInWork[i]) {   //find right student

                studentsInWork[i] = null; //deleting from enrolled
                studensWorkedHours[i] = 0;

                for (int k = i; k < countEnrolled; k++) { //run for remain part of list

                    studentsInWork[k] = studentsInWork[k + 1];//moving the other part of list back for 1
                    studensWorkedHours[k] = studensWorkedHours[k + 1];
                }

                studentsInWork[countEnrolled] = null; //deleting last not to dublicate him(he is now on penultimate position)
                studensWorkedHours[countEnrolled] = 0;

                countEnrolled--;
            }
        }
        return;
    }

    public void enrollStudent(Student student) {
        if (student == null) {
            return;
        }

        studentsInWork[countEnrolled] = student;
        studensWorkedHours[countEnrolled++] = 0;

        return;
    }

    public String subjInfo() {

        return String.format("Subject: %s Hours during semester: %d", name, hoursDuringSemestr);
    }

    public void showSubjInfo() {

        System.out.println(this.subjInfo());
        return;
    }

    public void studentLearning(Student student, int hours) {
        if (hours < 0) return;
        //not checking student, because will call method from existing student
        for (int i = 0; i < countEnrolled; i++) {
            if (student == studentsInWork[i]) {
                studensWorkedHours[i] += hours;
                return;
            }
        }
    }


    public int getStudentRate(Student student) {
        for (int i = 0; i < countPassed; i++) {
            if (studentsWhoPassed[i] == student) {
                return studentsRating[i];
            }
        }
        for (int i = 0; i < countEnrolled; i++) {
            if(studentsInWork[i] == student){
               // System.out.println("Student is still enrolled, did not pass exam!");
                return -1;
            }
        }
        return 0;
    }


}
