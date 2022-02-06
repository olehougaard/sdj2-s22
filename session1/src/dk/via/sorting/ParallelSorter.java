package dk.via.sorting;

import java.util.Arrays;
import java.util.Random;

public class ParallelSorter {
    private static long[] randomArray(int size) {
        Random random = new Random();
        long[] array = new long[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextLong();
        }
        return array;
    }

    public static void main(String[] args) {
        long[] testArray = randomArray(200_000_000);
        long start = System.currentTimeMillis();
        Arrays.sort(testArray);
        System.out.println(System.currentTimeMillis() - start);
    }
}
