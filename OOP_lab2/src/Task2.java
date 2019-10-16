import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Task2 {
    private StringBuilder sentences;
    private String[] sentencesArr;

    public Task2(StringBuilder sentences) {
        this.sentences = sentences;
        this.sentencesArr = sentences.toString().split("\\.");
    }

    public void findDoubleDigit() {
        System.out.println("Замена двузначных чисел на плюсы: ");
        for (String sentence : sentencesArr) {
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                try {
                    int num = Integer.parseInt(words[i]);
                    if (words[i].length() == 2) {
                        words[i] = "+".repeat(num);
                    }
                } catch (NumberFormatException ignored) {
                }
            }
            System.out.println(Arrays.toString(words));
        }
    }

    public void insertConec() {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < sentences.length()-1; i++) {
            int count = 0;
            while (!sentences.substring(i, i + 1).equals(".")) {
                count++;
                i++;
            }
            if(count < min) {
                min = count;
                index = i;
            }
        }
        sentences.insert(index, "КОНЕЦ");
        System.out.println("Добавлен конец: " + this.sentences);
    }

    public void numReverse() {
        System.out.println(sentences);
        System.out.println("Перевернутые числа: ");
        for (String sentence : sentencesArr) {
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                try {
                    int num = Integer.parseInt(words[i]);
                    StringBuilder temp = new StringBuilder();
                    temp.append(words[i]);
                    words[i] = temp.reverse().toString();
                } catch (NumberFormatException ignored) {
                }
            }
            System.out.println(Arrays.toString(words));
        }
    }
}
