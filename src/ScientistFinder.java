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
                new Scientist("Иванов", 1980, "Мужчина", "Физика"),
                new Scientist("Петрова", 1975, "Женщина", "Химия"),
                new Scientist("Сидоров", 1990, "Мужчина", "Биология"),
                new Scientist("Кузнецова", 1985, "Женщина", "Физика"),
                new Scientist("Смирнов", 1982, "Мужчина", "Химия"),
                new Scientist("Кузнецов", 1973, "Мужчина", "Физика"),
                new Scientist("Балабанова", 1997, "Женщина", "Физика")
        );

        String fieldOfScience = "Физика";
        int N = 4;

        Stream.concat(
                        //фильтрация по году рождения
                        scientists.stream().filter(s -> s.fieldOfScience.equals(fieldOfScience) &&
                                s.gender.equals("Женщина")).sorted(Comparator.comparingInt(s -> s.birthYear)),
                        scientists.stream().filter(s -> s.fieldOfScience.equals(fieldOfScience) &&
                                s.gender.equals("Мужчина")).sorted(Comparator.comparingInt(s -> s.birthYear))
                )
                .limit(N)
                .map(Scientist::toString)
                //вывод
                .collect(Collectors.collectingAndThen(
                        Collectors.joining(", ", N + " ученых зовут: ", ";"),
                        result -> {
                            System.out.println(result);
                            return result;
                        }
                ));
    }
}



