import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {
        String[] words = {"������", "������", "��������","��������", "������","������", "�����", "��������", "������", "��������", "��������", "�����", "�����", "�����"};

        String result = Arrays.stream(words)
                //���������� ����� �� �� �������� � ������������ ���������� ������� �����.
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                //��������� ����� �� ������� (�� �������� � ��������), � ����� �� ��������
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                //���������� ����� �� �������, �������� ������� �������
                .collect(Collectors.groupingBy(Map.Entry::getValue, LinkedHashMap::new, Collectors.toList()))
                //����� ������ ������ ���� � ����� ������� ��������.
                .entrySet().stream()
                .findFirst()
                //���� � ������ ������ ������ �����, ����� ������ �� ��������, ����� ����� ������
                .map(entry -> entry.getValue().size() > 1 ? entry.getValue().get(1).getKey() : entry.getValue().get(0).getKey())
                .orElse(null);

        System.out.println(result);
    }
}

