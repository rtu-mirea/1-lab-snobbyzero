import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static StudentsContainer studentsContainer = new StudentsContainer();
    public static void main(String[] args) {
        // Упражнение 1
        System.out.println("TASK ONE");
        System.out.println(createFile(".", "MyFile1.txt"));
        /*
         Отказывает в доступе
         Зато без проблем можно создавать файлы в папке с таким путем - C:/folder/
        */
        System.out.println(createFile("C:\\", "MyFile2.txt"));
        System.out.println(createFile("C:\\Users\\ildar\\", "MyFile3.txt"));
        System.out.println(createDir("folder1\\folder2\\folder3"));

        // Упражнение 2
        System.out.println("TASK TWO");
        System.out.println(fileInformation("", "test.txt"));

        // Упражнение 3
        System.out.println("TASK THREE");
        System.out.println(Arrays.toString(getFiles1(".")));
        File[] files = getFiles2(".");
        System.out.println(Arrays.toString(files));
        System.out.println(getFoldersCount(files));
        System.out.println(deleteFile(".", "MyFile1.txt"));
        System.out.println(deleteFile("C:\\Users\\ildar\\", "MyFile3.txt"));
        System.out.println(deleteDir("folder1\\folder2\\folder3"));
        // Упражнение 4
        int operationNumber = 0;
        do {
            System.out.println(
                    "1. Добавить студента\n" +
                            "2. Вывод фамилии и даты рождения\n" +
                            "3. Зачислены ли в один день\n" +
                            "4. Сохранить\n" +
                            "5. Загрузить группу\n" +
                            "6. Вывести студентов\n" +
                            "7. Создать Random Access File\n" +
                            "8. Удалить по номеру зачетной книжки из RAF\n" +
                            "9. EXIT"
            );
            System.out.println("Введите номер операции: ");
            Scanner sc = new Scanner(System.in);
            String filename;
            operationNumber = sc.nextInt();
            if (operationNumber >= 1 && operationNumber <= 8) {
                switch (operationNumber) {
                    case (1):
                        studentsContainer.addStudent(inputStudent());
                        break;
                    case (2):
                        System.out.println("Введите номер зачетки: ");
                        String record_number = sc.next();
                        System.out.println(studentsContainer.getSurnameAndDate(record_number));
                        break;
                    case (3):
                        System.out.println("Введите номер зачетки первого студента");
                        String record_number1 = sc.next();
                        System.out.println("Введите номер зачетки второго студента");
                        String record_number2 = sc.next();
                        System.out.println(studentsContainer.areEnrolled(record_number1, record_number2));
                        break;
                    case (4):
                        System.out.println("Введите название файла");
                        filename = sc.next();
                        System.out.println(studentsContainer.save(filename));
                        break;
                    case (5):
                        System.out.println("Введите название файла");
                        filename = sc.next();
                        System.out.println("Введите номер группы");
                        String group = sc.next();
                        System.out.println(studentsContainer.load(filename, group));
                        break;
                    case (6):
                        ArrayList<Student> studentArrayList = studentsContainer.getStudents();
                        for (Student student : studentArrayList) {
                            System.out.println(String.format("Surname: %s\nGroup: %s\n", student.getSurname(), student.getGroup()));
                        }
                        break;
                    case (7):
                        studentsContainer.createRandomAccessFile("raf.txt", 100);
                        break;
                    case (8):
                        studentsContainer.deleteFromRandomAccessFile("raf.txt", 100, "123");
                        break;
                }
            }

        } while (operationNumber != 9);
    }

    private static String createFile(String filepath, String name) {
        File file = new File(filepath, name);
        file.getParentFile().mkdir();
        if (!file.exists()) {
            try {
                file.createNewFile();
                return "File is created!";
            } catch (IOException e) {
                return e.getMessage();
            }
        } else {
            return "File already exists!";
        }
    }

    private static String createDir(String filepath) {
        File file = new File(filepath);
        if (!file.exists()) {
            file.mkdirs();
            return "Directory is created!";
        } else {
            return "Directory already exists";
        }
    }

    private static String fileInformation(String filepath, String name) {
        File file = new File(name);
        file = new File(filepath, name);
        return String.format(
                "Name: %s\nFilepath: %s\nSize: %s bytes\nType: %s",
                file.getName(),
                file.getAbsolutePath(),
                file.length(),
                file.isDirectory() ? "Dir" : "File"
        );
    }

    private static String[] getFiles1(String pathname) {
        File file = new File(pathname);
        return file.list();
    }

    private static File[] getFiles2(String pathname) {
        File file = new File(pathname);
        return file.listFiles();
    }

    private static int getFoldersCount(File[] files) {
        int count = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                count++;
            }
        }
        return count;
    }

    private static String deleteFile(String filepath, String name) {
        File file = new File(filepath, name);
        if (file.delete()) {
            return String.format("File %s was deleted successfully!", file.getName());
        }
        return String.format("Failed to delete file %s", file.getName());
    }

    private static String deleteDir(String filepath) {
        File file = new File(filepath);
        if (file.delete()) {
            return String.format("Dir %s was deleted successfully!", file.getName());
        }
        return String.format("Failed to delete dir %s", file.getName());
    }

    private static Student inputStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер зачетной книжки");
        String record_number = sc.next();
        System.out.println("Введите фамилию");
        String surname = sc.next();
        System.out.println("Введите имя");
        String name = sc.next();
        System.out.println("Введите день рождения");
        String birthday = sc.next();
        System.out.println("Введите номер телефона");
        int phoneNumber = sc.nextInt();
        System.out.println("Введите дату зачисления");
        String dateOfEnrollment = sc.next();
        System.out.println("Введите номер группы");
        String group = sc.next();
        return new Student(record_number, surname, name, birthday, phoneNumber, dateOfEnrollment, group);
    }
}
