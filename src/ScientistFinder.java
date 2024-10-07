import java.util.*;
import java.util.stream.*;

class Scientist {
    String lastName;
    int birthYear;
    String gender;
    String fieldOfScience;

    Scientist(String lastName, int birthYear, String gender, String fieldOfScience) {
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
        this.fieldOfScience = fieldOfScience;
    }

    @Override
    public String toString() {
        return lastName;
    }
}

public class ScientistFinder {
    public static void main(String[] args) {
        List<Scientist> scientists = Arrays.asList(
                new Scientist("������", 1980, "�������", "������"),
                new Scientist("�������", 1975, "�������", "�����"),
                new Scientist("�������", 1990, "�������", "��������"),
                new Scientist("���������", 1985, "�������", "������"),
                new Scientist("�������", 1982, "�������", "�����"),
                new Scientist("��������", 1973, "�������", "������"),
                new Scientist("����������", 1997, "�������", "������")
        );

        String fieldOfScience = "������";
        int N = 4;

        Stream.concat(
                        //���������� �� ���� ��������
                        scientists.stream().filter(s -> s.fieldOfScience.equals(fieldOfScience) &&
                                s.gender.equals("�������")).sorted(Comparator.comparingInt(s -> s.birthYear)),
                        scientists.stream().filter(s -> s.fieldOfScience.equals(fieldOfScience) &&
                                s.gender.equals("�������")).sorted(Comparator.comparingInt(s -> s.birthYear))
                )
                .limit(N)
                .map(Scientist::toString)
                //�����
                .collect(Collectors.collectingAndThen(
                        Collectors.joining(", ", N + " ������ �����: ", ";"),
                        result -> {
                            System.out.println(result);
                            return result;
                        }
                ));
    }
}



