import java.util.Arrays;
import java.util.HashMap;

public class Task1 {
    private String text;
    private String[] textArr;

    public Task1(String text) {
        this.text = text;
    }

    public void textToLowerCase() {
        this.text = this.text.toLowerCase();
        System.out.println("Введенный текст прописными буквами: " + this.text);
    }

    public void textToArr() {
        this.textArr = this.text.split(" ");
        // System.out.println(this.textArr);
    }

    public void countEntries() {
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        for (String word : this.textArr) {
            if (temp.containsKey(word)) {
                temp.put(word, temp.get(word) + 1);
            }
            else {
                temp.put(word, 1);
            }
        }
        System.out.println("Количество вхождений: ");
        temp.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public void countByPrefix(String prefix) {
        int count = 0;
        prefix = prefix.toLowerCase();
        for (String word : this.textArr) {
            if (word.startsWith(prefix)) {
                count++;
            }
        }
        System.out.println("Количество слов, начинающихся с префикса " + prefix + " : " + count);
    }

}
