package day1.Task2;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] array = getArraySort(getArray());

        System.out.println(Arrays.toString(array));
    }

    public static int[] getArray() {
        return new int[]{5,6,3,2,5,1,4,9};
    }

    public static int[] getArraySort(int[] arr){
        var stepsCount = arr.length - 1;
        boolean swapped = true;
        while (swapped){
            swapped = false;
            for (var i = 0; i < stepsCount; i++) {
                if (arr[i] > arr[i + 1]) {
                    var temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            stepsCount--;
        }
        return arr;
    }
}
