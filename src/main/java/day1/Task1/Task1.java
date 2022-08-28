package day1.Task1;

public class Task1 {
    public static void main(String[] args) {

        int[][] array = getRandomNumber();

        int max = getMax(array);
        int min = getMin(array);
        int average = getAverage(array);

        System.out.println("Максимальное значение в массиве " + max);
        System.out.println("Минимальное значение в массиве " + min);
        System.out.println("Среднее арехметическое значение в массиве " + average);
    }

    public static int[][] getRandomNumber() {

        int[][] array = new int[5][5];

        for (int i = 0; i < array.length; i++) {
            for (int y = 0; y < array[i].length; y++) {
                array[i][y] = randomNumber();
            }
        }
        return array;
    }

    public static int getMax(int[][] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int y = 0; y < arr[i].length; y++) {
                if (arr[i][y] > max) {
                    max = arr[i][y];
                }
            }
        }
        return max;
    }

    public static int getMin(int[][] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int y = 0; y < arr[i].length; y++) {
                if (arr[i][y] < min) {
                    min = arr[i][y];
                }
            }
        }
        return min;
    }

    public static int getAverage(int[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int y = 0; y < arr[i].length; y++) {
                sum = sum + arr[i][y];
            }
        }
        return sum/(arr.length*arr[0].length);
    }

    private static int seed = 3819;
    public static int randomNumber(){
        int MULTIPLIER_A = 11035;
        int INCREMENT_C = 123;
        int MODULUS = 2147;
        seed = (seed * MULTIPLIER_A + INCREMENT_C) % MODULUS;
        if (seed < 0) {
            seed = seed * -1;
        }
        return seed;
    }
}
