package week1.groupapp.model;

/**
 * Created by Евгений Дубовой on 03.09.2017.
 */
public class Student {
    public String name;
    public String phone;

    public int id;


    public int birthYear;
    public int birthMonth;
    public int birthDay;


    public String city;

    private int TaskCount;

    public void shortInit(String name)
    {
        this.name = name;
    }

    public void init(String nm, String phn, int brthYear, String cty, int num){
        name = nm;
        phone= phn;
        birthYear = brthYear;
        city = cty;
        id = num;
    }
    public String showStudent()
    {
        return String.format("Name: %s Phone: %s Year: %d id: %d \n",  name, phone, birthYear, id);
    }

}
