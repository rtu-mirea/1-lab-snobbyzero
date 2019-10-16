import java.util.ArrayList;
import java.util.regex.Pattern;

public class Task3 {

    public boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z]+.[A-Za-z]+$");
        return pattern.matcher(email).matches();
    }

    public void checkEmails(ArrayList<String> list) {
        for (String email : list) {
            System.out.println(email + " : " + isEmailValid(email));
        }
    }
}
