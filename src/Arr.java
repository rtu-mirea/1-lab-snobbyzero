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
    public void randomInput() {
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
    public void printBackward() {
        for (int i = this.arr.length - 1; i >= 0; i--) {
            System.out.println(this.arr[i]);
        }
    }

    /*
     * Заменить в двоичном коде значения каждого
     * элемента массива заданный бит на заданное значение
     * (на 0 или на 1).
     */

    public void changeBit() {
        Scanner sc = new Scanner(System.in);
        int bit;
        int pos;
        do {
            System.out.println("Введите номер позиции (от 0 до 7): ");
            pos = sc.nextInt();
        } while (pos < 0 || pos > 7);
        do {
            System.out.println("Введите бит (0 или 1): ");
            bit = sc.nextInt();
            System.out.println(bit);
        } while (bit != 0 && bit != 1);
        byte[] temp = new byte[this.arr.length];
        for (int i = 0; i < this.arr.length; i++) {
            int num = 7 - pos;
            temp[i] = (byte) ((byte) bit == 1 ? arr[i] | (1 << pos) : arr[i] & ~(1<<pos));
            System.out.println(Integer.toBinaryString(temp[i]));
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

    public void changeSize(int length) {
        byte[] temp = new byte[length];
        System.arraycopy(this.arr, 0, temp, 0, this.arr.length);
        this.arr = temp;
    }
}
