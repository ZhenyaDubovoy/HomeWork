package week1.groupapp.model;

/**
 * Created by Евгений Дубовой on 03.09.2017.
 */
public class Student {
    private String name;
    private String phone;
    private String email = "none";

    public int id;

    private MyDate myDate = new MyDate();

    private Adress adress;

    private int TaskCount;
    private double paidMoney;

    //return this
    public Student(){
        System.out.println("Default constructor");
    }

    public Student(String name, String phone, String email, int id, MyDate myDate,
                   Adress adress, int taskCount, double paidMoney) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.id = id;
        this.myDate = myDate;
        this.adress = adress;
        TaskCount = taskCount;
        this.paidMoney = paidMoney;
    }

    public void shortInit(String name)
    {
        this.name = name;
    }

    public Student(String nm, String phn, double money){
        name = nm;
        phone= phn;
        paidMoney = money;
    }

    public String showStudent() {

        return String.format("Name: %s Phone: %s id: %d money: %f\n",  name, phone, id, paidMoney);

    }

    public void setName(String name){

        if(name == null || name.isEmpty()) {
            System.out.println("wrong name");
            return;
        }
        this.name = name;

    }

    public String getName(){

        return name;
    }

    public Adress getAdress() {
        return adress;
    }
}
