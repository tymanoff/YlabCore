package day1.Task1;

import day1.Task1.Task1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {

    @Test
    void getAverage() {
        Assertions.assertEquals(Task1.getAverage(getArray()),6);
    }

    @Test
    void getMax() {
        Assertions.assertEquals(Task1.getMax(getArray()),10);
    }

    @Test
    void getMin() {
        Assertions.assertEquals(Task1.getMin(getArray()),2);
    }

    private int[][] getArray(){

        int[][] arrays = {
                {2,2,2,2,2},
                {4,4,4,4,4},
                {6,6,6,6,6},
                {8,8,8,8,8},
                {10,10,10,10,10}
        };
        return arrays;
    }
}