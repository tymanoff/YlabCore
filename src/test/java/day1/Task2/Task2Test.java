package day1.Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task2Test {

    @Test
    void getArraySort() {
        Assertions.assertEquals(Arrays.toString(Task2.getArraySort(getArray())), Arrays.toString(new int[]{1, 1, 3, 3, 4, 5, 5, 7, 7, 7, 8}));
    }

    private int[] getArray(){
        return new int[]{5,4,7,8,3,3,5,1,1,7,7};
    }
}