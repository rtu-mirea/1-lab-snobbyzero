import java.io.Serializable;

public class Student implements Serializable {
    private String record_number;
    private String surname;
    private String name;
    private String birthday;
    private int phoneNumber;
    private String dateOfEnrollment;
    private String group;

    public Student(String record_number, String surname, String name, String birthday, int phoneNumber, String dateOfEnrollment, String group) {
        this.record_number = record_number;
        this.surname = surname;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.dateOfEnrollment = dateOfEnrollment;
        this.group = group;
    }

    public String getRecord_number() {
        return record_number;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public String getGroup() {
        return group;
    }
}
