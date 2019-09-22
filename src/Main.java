import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    private static int len;
    public static void main(String[] args) {

        len = inputLength();
        Arr arr = new Arr(len);
        int operationNumber = 0;
        do {
            System.out.println(
                    "1. Ввод с клавиатуры\n" +
                            "2. Рандомный ввод\n" +
                            "3. Вывод слева направо\n" +
                            "4. Вывод справа налево\n" +
                            "5. Заменить в двоичном коде значения каждого элемента массива заданный бит на заданное значение\n" +
                            "6. Выполнить конвертирование массива\n" +
                            "7. Изменить длину массива\n" +
                            "8. Выход из программы\n"
            );
            System.out.println("Введите номер операции: ");
                Scanner sc = new Scanner(System.in);
                operationNumber = sc.nextInt();
                if (operationNumber < 1 || operationNumber > 8)
                {
                }
                else {
                    switch (operationNumber) {
                        case (1):
                            arr.input();
                            break;
                        case (2):
                            arr.randomInput();
                            break;
                        case (3):
                            arr.print();
                            break;
                        case (4):
                            arr.printBackward();
                            break;
                        case (5):
                            arr.changeBit();
                            break;
                        case (6):
                            arr.convert();
                            break;
                        case (7):
                            len = inputLength();
                            arr.changeSize(len);
                    }
                }
            } while(operationNumber != 8);
    }

    private static int inputLength() {
        do {
            System.out.println("Введите длину массива: ");
            Scanner sc = new Scanner(System.in);
            len = sc.nextInt();
        } while (len <= 0);
        return len;
    }
}
