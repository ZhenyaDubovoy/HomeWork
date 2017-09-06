package week1.groupapp.studentUtils;

import week1.groupapp.model.Adress;
import week1.groupapp.model.MyDate;
import week1.groupapp.model.Student;

/**
 * Created by Евгений Дубовой on 04.09.2017.
 */
public class StudentUtils {
   /* public static String convertStudent(Student student) {

        if (student == null){
            return "null";
        }
        return String.format("name %s phone %s money %.2f birthYear %d", student.name, student.phone, student.paidMoney, student.birthYear);
    }*/
    public static Student generateStudent(){
        String name = generateName();
        String phone = generatePhone();
        String mail = generateMail(name);

        MyDate myDate = generateDate();
        Adress adress = generateAdress();
        double paidMoney = generateMoney();

        return new Student();
    }

    private static double generateMoney() {
        return Math.random()*5000;
    }

    private static Adress generateAdress() {
        return new Adress("Kiev", "Starokievska", String.valueOf(generateNum(1,100)));
    }

    private static MyDate generateDate() {
        return new MyDate(generateNum(1970, 1998), generateNum(1, 13), generateNum(1, 32));

    }

    private static int generateNum(int left, int right) {

        return left + (int)(Math.random()*(right-left));
    }

    private static String generateMail(String name) {
        String email = "@gmail.com";
        return name + email;
    }

    private static String generatePhone() {
        String phone = "+380";
        for (int i = 0; i < 7; i++) {
            phone+= (int)(Math.random()*10);
        }
        return phone;
    }

    private static String generateName() {
    String[] names = {"Andrey", "Vasiliy",
            "Serhey", "Ivan", "Petro", "Vladimir"};
        return names[(int)(Math.random()*5)];


    }

}
