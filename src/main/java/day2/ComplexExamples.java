package day2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Comparator;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

    }

    private static final Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
            new Person(8, "Amelia"),
            new Person(8, "Amelia"),
    };

        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
        printDisplayText("Raw data:");

        for (Person person : RAW_DATA) {
            if (person != null && person.getName() != null) {
                System.out.println(person.id + " - " + person.name);
            }
        }

        printDisplaySeparator();

        printDisplayText("Duplicate filtered, grouped by name, sorted by name and id:");

        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key: Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */

        printDisplayMap(getSortPerson(RAW_DATA));

        printDisplaySeparator();

         /*
        Task2

            [3, 4, 6, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */

        int[] arrayNumber = {3, 4, 6, 7};

        if (getValues(arrayNumber, 10).length != 0) {
            printDisplayText(Arrays.toString(getValues(arrayNumber, 10)));
        } else {
            printDisplayText("В массиве нет пары, которые дают задданую сумму, либо масcив равен null");
        }

        printDisplaySeparator();

        /*
       Task3
           Реализовать функцию нечеткого поиска

        */

        printDisplayText(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        printDisplayText(fuzzySearch("cwhl", "cartwheel")); // true
        printDisplayText(fuzzySearch("cwhee", "cartwheel")); // true
        printDisplayText(fuzzySearch("cartwheel", "cartwheel")); // true
        printDisplayText(fuzzySearch("cwheeel", "cartwheel")); // false
        printDisplayText(fuzzySearch("lw", "cartwheel")); // false
        printDisplayText(fuzzySearch(null, "ca6$$#_rtwheel")); // false
        printDisplayText(fuzzySearch("car", null)); // false
    }

    private static void printDisplayText(String text) {
        System.out.println(text);
    }

    private static void printDisplayText(boolean value) {
        System.out.println(value);
    }

    private static void printDisplaySeparator() {
        System.out.println();
        printDisplayText("**************************************************");
        System.out.println();
    }

    public static Map<String, Integer> getSortPerson(Person[] persons) {
        if (persons == null) {
            return null;
        }

        Map<String, Integer> personMap = new TreeMap<>();

        List<Person> personList = Arrays.stream(persons)
                .filter(Objects::nonNull)
                .filter(p -> Objects.nonNull(p.getName()))
                .distinct()
                .sorted(Comparator.comparing(Person::getName).thenComparing(Person::getId))
                .toList();

        personList.forEach(person -> {
            if (personMap.containsKey(person.name)) {
                personMap.put(person.name, personMap.get(person.name) + 1);
            } else {
                personMap.put(person.name, 1);
            }
        });

        return personMap;
    }

    private static void printDisplayMap(Map<String, Integer> map) {
        map.forEach((k, v) -> printDisplayText("Key: " + k + "\nValue:" + v));
    }

    public static int[] getValues(int[] array, int sum) {
        int[] ints = new int[0];

        if (array == null) {
            return ints;
        }

        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for (int element : array) {
            if (numberMap.containsKey(element)) {
                numberMap.put(element, numberMap.get(element) + 1);
            } else {
                numberMap.put(element, 1);
            }
        }

        for (int element : array) {
            int pair;
            pair = sum - element;
            if (numberMap.get(pair) != null) {
                if (element != pair) {
                    return new int[]{element, pair};
                }
                if (numberMap.get(pair) > 1) {
                    return new int[]{element, element};
                } else {
                    return ints;
                }
            }
        }
        return ints;
    }

    public static boolean fuzzySearch(String search, String text) {
        if (search == null || text == null || search.length() > text.length()) {
            return false;
        }

        char[] searchChars = search.toCharArray();
        char[] textChars = text.toCharArray();
        char[] result = new char[searchChars.length];

        int i = 0;
        int j = 0;
        while (i < searchChars.length && j < textChars.length) {
            if (searchChars[i] == textChars[j]) {
                    result[i] = searchChars[i];
                    i++;
                    j++;
                    continue;
                }
            j++;
        }

        return Arrays.equals(searchChars, result);
    }
}
