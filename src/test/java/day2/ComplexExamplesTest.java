package day2;

import org.junit.jupiter.api.*;

class ComplexExamplesTest {

    private static int[] ints;
    private static int[] ints1;
    private static int[] ints2;
    private static int[] ints3;
    private static int[] ints4;

    private static ComplexExamples.Person[] persons;

    @BeforeEach
    void setup() {
        ints = new int[]{3, 4, 6, 7};
        ints1 = null;
        ints2 = new int[]{3, 5, 5};
        ints3 = new int[]{3, 5, 6};
        ints4 = new int[]{-3, 4, 6, 13};
        persons = new ComplexExamples.Person[]{
                new ComplexExamples.Person(8, null)
        };
    }

    @Test
    void getValues() {
        Assertions.assertArrayEquals(ComplexExamples.getValues(ints, 10), new int[]{3, 7});
        Assertions.assertArrayEquals(ComplexExamples.getValues(ints1, 10), new int[0]);
        Assertions.assertArrayEquals(ComplexExamples.getValues(ints2, 10), new int[]{5, 5});
        Assertions.assertArrayEquals(ComplexExamples.getValues(ints3, 10), new int[0]);
        Assertions.assertArrayEquals(ComplexExamples.getValues(ints4, 10), new int[]{-3, 13});
    }

    @Test
    void fuzzySearch() {
        Assertions.assertTrue(ComplexExamples.fuzzySearch("car", "ca6$$#_rtwheel"));
        Assertions.assertTrue(ComplexExamples.fuzzySearch("cwhl", "cartwheel"));
        Assertions.assertTrue(ComplexExamples.fuzzySearch("cwhee", "cartwheel"));
        Assertions.assertTrue(ComplexExamples.fuzzySearch("cartwheel", "cartwheel"));
        Assertions.assertTrue(ComplexExamples.fuzzySearch("qwe", "qwe"));
        Assertions.assertFalse(ComplexExamples.fuzzySearch("cwheeel", "cartwheel"));
        Assertions.assertFalse(ComplexExamples.fuzzySearch("lw", "cartwheel"));
        Assertions.assertFalse(ComplexExamples.fuzzySearch(null, "cartwheel"));
        Assertions.assertFalse(ComplexExamples.fuzzySearch("lw", null));
        Assertions.assertFalse(ComplexExamples.fuzzySearch("lww", "lw"));
        Assertions.assertFalse(ComplexExamples.fuzzySearch(null, null));
        Assertions.assertFalse(ComplexExamples.fuzzySearch("car", "caaa"));
    }

    @Test
    void getSortPerson() {
        Assertions.assertNull(ComplexExamples.getSortPerson(null));
        Assertions.assertTrue(ComplexExamples.getSortPerson(persons).isEmpty());
    }
}
