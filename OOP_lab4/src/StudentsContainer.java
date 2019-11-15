

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentsContainer {
    private static ArrayList<Student> students;

    public StudentsContainer() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getSurnameAndDate(String record_number) {
        for (Student student : students) {
            if (student.getRecord_number().equals(record_number)) {
                return String.format("Surname: %s\nBirthday:%s", student.getSurname(), student.getBirthday());
            }
        }
        return "Student wasn't found";
    }

    public boolean areEnrolled(String record_number1, String record_number2) {
        Student student1 = null;
        Student student2 = null;
        for (Student student : students) {
            if (student.getRecord_number().equals(record_number1)) {
                student1 = student;
            } else if (student.getRecord_number().equals(record_number2)) {
                student2 = student;
            }
        }
        if (student1 != null && student2 != null) {
            if (student1.getDateOfEnrollment().equals(student2.getDateOfEnrollment())) {
                return true;
            }
        }
        return false;
    }

    public String save(String filename) {
        if (new File(filename).exists()) {
            return "File already exists";
        }
        try (
                FileOutputStream file = new FileOutputStream(filename, false);
                ObjectOutputStream oosStudent = new ObjectOutputStream(file)) {
            oosStudent.writeObject(students);
            return "File was saved successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @SuppressWarnings("unchecked")
    public String load(String filename, String group) {
        ArrayList<Student> temp;
        try (ObjectInputStream oisUsers = new ObjectInputStream(new FileInputStream(filename))) {
            temp = (ArrayList<Student>) oisUsers.readObject();
            for (Student student : temp) {
                if (student.getGroup().equals(group)) {
                    students.add(student);
                }
            }
            return String.format("%s was loaded successfully!", group);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void createRandomAccessFile(String filename, int length) {
        try {
            RandomAccessFile file = new RandomAccessFile(filename, "rw");
            for (int i = 0; i < students.size(); i++) {
                try {
                    file.seek(i * length);
                    Student student = students.get(i);
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < length - student.getSurname().length() - student.getGroup().length(); j++) {
                        sb.append(" ");
                    }
                    String data = student.getSurname() + " " + student.getGroup() + sb.toString();
                    file.write(data.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void deleteFromRandomAccessFile(String filename, int length, String record_number) {
        try {
            int index = -1;
            RandomAccessFile file = new RandomAccessFile(filename, "rw");
            for (Student s : students) {
                index++;
                if (s.getRecord_number().equals(record_number)) {
                    break;
                }
            }
            try {
                file.seek((students.size() - 1) * length);
                byte[] chars = new byte[length];
                file.read(chars);
                file.seek(index * length);
                file.write(chars);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
