package read;

import java.io.File;
import java.util.*;

public class WordsCounter {
    private final Map<String, Integer> list = new HashMap<>();

    public void main(File file) {

        String content = read(file).toLowerCase();
        countAndAddToList(content);
        sort(list);
    }

    private String read(File file) {

        return new FileContentReader().read(new File(file, "words.txt"));
    }

    private void countAndAddToList(String content) {

        String[] words = content.replaceAll("\\p{Space}+", " ").split(" ");
        Arrays.sort(words);
        int counter;

        for (int j = 0; j < words.length; j++) {
            counter = 1;
            for (int i = j + 1; i < words.length; i++) {
                if (words[j].equals(words[i])) {
                    j++;
                    counter++;
                } else {
                    list.put(words[j], counter);
                    break;
                }
            }
        }
    }

    private void sort(Map list) {

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(list.entrySet());
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
