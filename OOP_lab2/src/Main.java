import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int operationNumber;
        String tempStr;
        do {
            System.out.println(
                    "1. Задание 1\n" +
                            "2. Задание 2\n" +
                            "3. Задание 3\n" +
                            "4. Выход из программы\n"
            );
            System.out.println("Введите номер операции: ");
            Scanner sc = new Scanner(System.in);
            Scanner textSc = new Scanner(System.in);
            operationNumber = sc.nextInt();
            if (operationNumber >= 1 && operationNumber <= 4) {
                switch (operationNumber) {
                    case (1):
                        ArrayList<String> tempArr1 = new ArrayList<>();
                        System.out.println(
                                "Введите текст (можно построчно)." +
                                        " Когда закончите, оставьте строку пустой и нажмите ENTER");
                        while (textSc.hasNextLine()) {
                            tempStr = textSc.nextLine();
                            if (textSc.nextLine().isEmpty()) {
                                break;
                            }
                            tempArr1.add(tempStr);
                        }
                        String text = tempArr1.toString();
                        Task1 task1 = new Task1(text);
                        task1.textToLowerCase();
                        task1.textToArr();
                        task1.countEntries();
                        System.out.println("Введите префикс");
                        String prefix = sc.next();
                        task1.countByPrefix(prefix);
                        break;
                    case (2):
                        StringBuilder temp = new StringBuilder();
                        System.out.println(
                                "Введите текст (можно построчно)." +
                                        " Когда закончите, оставьте строку пустой и нажмите ENTER");
                        while (textSc.hasNextLine()) {
                            tempStr = textSc.nextLine();
                            if (tempStr.isEmpty()) {
                                break;
                            }
                            temp.append(tempStr);

                        }
                        Task2 task2 = new Task2(temp);
                        task2.findDoubleDigit();
                        task2.insertConec();
                        task2.numReverse();
                        break;
                    case (3):
                        Task3 task3 = new Task3();
                        System.out.println("Введите email: ");
                        String email = sc.next();
                        System.out.println(task3.isEmailValid(email));
                        ArrayList<String> tempArr2 = new ArrayList<>();
                        System.out.println(
                                "Введите текст с почтовыми ящиками построчно." +
                                        " Когда закончите, оставьте строку пустой и нажмите ENTER");
                        while (textSc.hasNextLine()) {
                            tempStr = textSc.nextLine();
                            if (tempStr.isEmpty()) {
                                break;
                            }
                            tempArr2.add(tempStr);
                        }
                        task3.checkEmails(tempArr2);
                        break;
                    case (4):
                        break;
                }
            }
        } while(operationNumber != 4);
    }
}
