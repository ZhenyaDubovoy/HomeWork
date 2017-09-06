package week1.stringTask;

/**
 * Created by Евгений Дубовой on 06.09.2017.
 */
public class StringClass {
   /* - создание на основе массива символов
    - вывод на экран
    - конкатенация
    - понижение регистра
    - повышение регистра
    - поиск подстроки
    - выделение подстроки
    - удаление пробелов
    - метод для сравнения с другой строкой*/
   public static void main(String[] args) {
       StringClass a = new StringClass();
       System.out.println(a.withoutSpaces("My name is Zhenya!"));
       System.out.println(a.olderByAlphabet("abcz", "abcd"));
       System.out.println(a.longer("abcd", "abc"));
   }

    public void showString(String message){
        System.out.println(message);
        return;
    }

    public String concatenate(String message1, String mesToAdd){
        return message1.concat(mesToAdd);
    }

    public String LowCase(String message){
        return message.toLowerCase();
    }

    public String UpCase(String message){
        return message.toUpperCase();
    }

    public int substringSearch(String message, String searchedSub){
        return message.indexOf(searchedSub);
    }

    public String highlightSubstring(String message, int startIndex, int endIndex){
        return message.substring(startIndex, endIndex+1);
    }

    public String withoutSpaces(String message) {
        String[] splittedMes = message.split(" ");
        String result = "";
        for (String mesPart:splittedMes) {
            result+=mesPart;
        }
        return result;
    }

    public boolean olderByAlphabet(String mainMes, String comparableMes){
        int compareResult = mainMes.compareTo(comparableMes);
        if (compareResult > 0 ) return true;
        else return false;
    }

    public boolean longer(String mainMes, String comparableMes){
        if (mainMes.length()>comparableMes.length()) return true;
        else return false;
    }
}
