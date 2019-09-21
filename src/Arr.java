import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Arr {
    private byte[] arr;

    // Конструктор, принимающий на вход длину массива
    Arr(int length) {
        this.arr = new byte[length];
    }

    // Ввод с клавиатуры
    public void input() {

        for (int i = 0; i < this.arr.length; i++) {
            byte num = -1;
            do {
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Введите число");
                    num = sc.nextByte();
                    this.arr[i] = num;
                } catch (InputMismatchException ime) {
                    System.out.println("Повторите ввод.");
                }
            } while (this.arr[i] != num);
        }
    }

    // Заполнение массива рандомными значениями
    public void random_input() {
        Random random = new Random();
        random.nextBytes(this.arr);
    }

    // Печать слева направо
    public void print() {
        for (byte el : arr) {
            System.out.println(el);
        }
    }

    // Печать справа налево
    public void print_backward() {
        for (int i = this.arr.length - 1; i >= 0; i--) {
            System.out.println(this.arr[i]);
        }
    }

    /*
     * Заменить в двоичном коде значения каждого
     * элемента массива заданный бит на заданное значение
     * (на 0 или на 1).
     */

    public void change_bit() {
        Scanner sc = new Scanner(System.in);
        String bit = "";
        String pos = "";
        do {
            try {
                System.out.println("Введите номер позиции (от 0 до 7)");
                pos = sc.next();
                try {
                    Integer.parseInt(pos);
                }
                catch (Exception e) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException ime) {
                System.out.println("Неверный ввод.");
            }
        } while (Integer.parseInt(pos) < 0 || Integer.parseInt(pos) > 7);
        do {
            try {
                System.out.println("Введите 0 или 1: ");
                bit = sc.next();
            } catch (InputMismatchException ime) {
                System.out.println("Неверный ввод.");
            }
            System.out.println(bit);
        } while (!bit.equals("0") && !bit.equals("1"));
        String[] temp = new String[this.arr.length];
        for (int i = 0; i < this.arr.length; i++) {
            int num = 7 - Integer.parseInt(pos);
            temp[i] = String.format("%8s", Integer.toBinaryString(arr[i] & 0xFF)).replace(' ', '0');
            temp[i] = temp[i].substring(0, num) + bit + temp[i].substring(num+1);
            System.out.println(temp[i]);
        }
    }

    /*
     * Выполнить конвертирование массива: сначала
     * первый элемент меняется значением с последним; затем
     * второй с предпоследним и т.д.
     */
    public void convert() {
        for (int i = 0; i < this.arr.length / 2; i++) {
            byte temp = arr[i];
            arr[i] = arr[this.arr.length - i - 1];
            arr[this.arr.length - i - 1] = temp;
        }
    }

    public void change_size(int length) {
        byte[] temp = new byte[length];
        System.arraycopy(this.arr, 0, temp, 0, this.arr.length);
        this.arr = temp;
    }
}
