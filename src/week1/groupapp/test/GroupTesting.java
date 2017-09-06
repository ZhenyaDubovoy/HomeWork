package week1.groupapp.test;

import week1.groupapp.model.Adress;
import week1.groupapp.model.Group;
import week1.groupapp.model.MyDate;
import week1.groupapp.model.Student;
import week1.groupapp.studentUtils.StudentUtils;

/**
 * Created by Евгений Дубовой on 03.09.2017.
 */
public class GroupTesting {
    /*public static void main(String[] args) {
        studAddTest();
        searchByIdTest();
       // showingStudentTest();

        Student student1 = new Student();
        Student st2 = new Student();

        System.out.println(student1.showStudent());

        MyDate myDate = new MyDate(1996, 12, 15);
        Student student3 = new Student("Ivan", "phone", "@gmail.com",
                111, myDate, new Adress("Kiev","Kreshatik", "1"), 15, 1000);

        Adress adress = student3.getAdress();

        Student[] group = new Student[10];

        for (int i = 0; i < group.length; i++) {

        }
    }*/


    static void studAddTest()
    {
        Student student1 = new Student();
        student1.shortInit("Vasya");

        Student student2 = new Student();
        student2.shortInit("Petya");

        Group k1 = new Group();

        k1.addStudent(student1);
        k1.addStudent(student2);

        //System.out.printf("test adding student %s \n", k1.countOfStudents == 2 && k1.groupList[1].name.equals("Petya") );
    }
    static void  searchByIdTest()
    {
        Student student1 = new Student();
        student1.id = 111;

        Student student2 = new Student();
        student2.id = 112;

        Group k1 = new Group();

        k1.addStudent(student1);
        k1.addStudent(student2);

        System.out.printf("test search by Id %s\n", k1.getStudent(112)==student2);

    }
    /*static void showingStudentTest()
    {
        Group aco21 = new Group();

        Student stud1 = new Student("Vasya", "0931111111", "Kyiv", 111);
        aco21.addStudent(stud1);

        Student stud2 = new Student("Petya", "0931212121", "Kyiv", 112);
        aco21.addStudent(stud2);

        Student stud3 = new Student("Kolya", "0931212121", "Kyiv", 113);
        aco21.addStudent(stud3);

        aco21.showAll();
    }*/
}
