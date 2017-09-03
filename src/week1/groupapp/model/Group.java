package week1.groupapp.model;

/**
 * Created by Евгений Дубовой on 03.09.2017.
 */
public class Group {
    public Student[] groupList = new Student[10];
    public int countOfStudents;

    public void addStudent(Student student) {
        groupList[countOfStudents] = student;
        countOfStudents++;
    }

    public Student getStudent(int num) {
        for (Student student: groupList)
        {
            if (student==null)
            {
                return null;
            }
            if (student.id == num)
            {
                return student;
            }
        }
         return null;
    }


    public void showAll() {
        for (int i = 0; i<groupList.length; i++)
        {
            if (groupList[i] == null)
            {
                return;
            }
            System.out.printf("%d %s\n", i+1, groupList[i].showStudent());
        }
    }

}

