package week1.task1.testing;


import week1.task1.model.Adress;

/**
 * Created by Евгений Дубовой on 06.09.2017.
 */
public class Utils {
    public static Adress generateAdress() {
        return new Adress("Kiev", "Starokievska", String.valueOf(generateNum(1,100)));
    }

    private static int generateNum(int left, int right) {
        return left + (int)(Math.random()*(right-left));
    }
}
