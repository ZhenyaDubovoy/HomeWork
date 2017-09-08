package week1.task1.testing;

import week1.task1.model.Adress;
import week1.task1.model.Student;
import week1.task1.model.Subject;
import week1.task1.testing.Utils;


/**
 * Created by Евгений Дубовой on 06.09.2017.
 */
public class TestLearning {

    public static void main(String[] args) {
        testAddingSubject();
        testStudentLearn();
        testDeletingLastSubject();
        testPassingExam();
        testMiddleRate();
        testGettingStudentsMark();
        testShowingInfoAboutStudsSubs();
    }

    private static void testAddingSubject() {
        Student student = new Student("Ivan", Utils.generateAdress());
        Subject math2 = new Subject("Geometry", 15);

        student.addSubject(math2);

        System.out.printf("Adding subject test : %s\n", student.getSubjects()[0]==math2 && student.getNumberOfSubjects()==1);
        System.out.printf("Adding subject test 2 : %s\n", math2.getStudentsInWork()[0] == student && math2.getStudensWorkedHours()[0] == 0);
        return;
    }

    private static void testShowingInfoAboutStudsSubs(){
        Student student1 = new Student("Petro", Utils.generateAdress());

        Subject oop = new Subject("OOP", 25);
        Subject math1 = new Subject("Algebra", 20);

        student1.addSubject(oop);
        student1.addSubject(math1);

        student1.learn(oop, 25);
        student1.learn(math1, 10);

        oop.passTheExam(student1, 5);

        System.out.println("Test showing information about students :\n");
        student1.showAllSubjects();
    }

    private static void testGettingStudentsMark (){

        Student student1 = new Student("Petro", Utils.generateAdress());

        Subject oop = new Subject("OOP", 25);
        Subject math1 = new Subject("Algebra", 20);
        Subject math2 = new Subject("Geometry", 15);

        student1.addSubject(oop);
        student1.addSubject(math1);

        student1.learn(oop, 25);
        oop.passTheExam(student1, 4);

        System.out.printf("Test getting students rate: %s\n", oop.getStudentRate(student1)==4 &&
                math1.getStudentRate(student1)==-1 && math2.getStudentRate(student1)==0);
    }


    private static void testStudentLearn() {

        Student student = new Student("Ivan", Utils.generateAdress());
        Subject math2 = new Subject("Geometry", 15);

        Student student2 = new Student("Vasyl", Utils.generateAdress());

        student.addSubject(math2);
        student2.addSubject(math2);

        student.learn(math2, 5);
        student2.learn(math2, 3);

        System.out.printf("Test students learning method: %s\n", math2.getStudensWorkedHours()[0]==5 && math2.getStudensWorkedHours()[1]==3);
    }

    private static void testDeletingLastSubject() {

        Student student = new Student("Petro", Utils.generateAdress());

        Subject oop = new Subject("OOP", 25);
        Subject math1 = new Subject("Algebra", 20);
        Subject math2 = new Subject("Geometry", 15);

        student.addSubject(oop);
        student.addSubject(math1);
        student.addSubject(math2);

        Subject[] subsBefore = student.getSubjects();
        int numOfSubsBefore = student.getNumberOfSubjects();

        student.deleteLastSubject();

        Subject[] subsAfter = student.getSubjects();
        int numOfSubsAfter = student.getNumberOfSubjects();

        System.out.printf("Test deleting last subject: %s\n", subsBefore[0]==subsAfter[0] && subsBefore[1]==subsAfter[1]
                && subsAfter[2] == null && numOfSubsBefore==3 && numOfSubsAfter==2);
    }

    private static void testPassingExam() {

        Student student = new Student("Petro", Utils.generateAdress());
        Student student2 = new Student("Denis", Utils.generateAdress());
        Student student3 = new Student("Evgen", Utils.generateAdress());

        Subject oop = new Subject("OOP", 25);

        student.addSubject(oop);
        student2.addSubject(oop);
        student3.addSubject(oop);

        int enrolledBefore = oop.getCountEnrolled();

        student.learn(oop, 15);
        student.learn(oop, 10);
        student2.learn(oop, 30);
        student3.learn(oop, 15);

        oop.passTheExam(student, 4);
        oop.passTheExam(student2, 5);
        oop.passTheExam(student3, 3);

        int enrolledAfter = oop.getCountEnrolled();

        int petroMark = oop.getStudentRate(student);
        int denisMark = oop.getStudentRate(student2);


        System.out.printf("Test passing exam and getting students mark: %s\n", petroMark == 4 && denisMark == 5 && oop.getCountPassed()==2);
        System.out.printf("Test deleting from enrolled after passing exam : %s\n", enrolledBefore ==3 && enrolledAfter == 1);
    }

    public static void testMiddleRate() {

        Student student = new Student("Petro", Utils.generateAdress());

        Subject oop = new Subject("OOP", 25);
        Subject math1 = new Subject("Algebra", 20);
        Subject math2 = new Subject("Geometry", 15);

        student.addSubject(oop);
        student.addSubject(math1);
        student.addSubject(math2);

        student.learn(oop, 25);
        student.learn(math1, 20);
        student.learn(math2, 15);

        oop.passTheExam(student, 5);
        math1.passTheExam(student, 3);
        math2.passTheExam(student, 3);

        double petroMidRate = student.getMiddleRate();

        System.out.printf("Middle rate must be 3.66: %.2f\n", petroMidRate);
    }

}
