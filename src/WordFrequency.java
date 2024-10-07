import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {
        String[] words = {"яблоко", "яблоко", "апельсин","апельсин", "яблоко","яблоко", "банан", "апельсин", "яблоко", "апельсин", "апельсин", "банан", "банан", "банан"};

        String result = Arrays.stream(words)
                //группируем слова по их значению и подсчитываем количество каждого слова.
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                //сортируем слова по частоте (от большего к меньшему), а затем по алфавиту
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                //группируем слова по частоте, сохраняя порядок вставки
                .collect(Collectors.groupingBy(Map.Entry::getValue, LinkedHashMap::new, Collectors.toList()))
                //берем первую группу слов с самой высокой частотой.
                .entrySet().stream()
                .findFirst()
                //если в группе больше одного слова, берем второе по алфавиту, иначе берем первое
                .map(entry -> entry.getValue().size() > 1 ? entry.getValue().get(1).getKey() : entry.getValue().get(0).getKey())
                .orElse(null);

        System.out.println(result);
    }
}

