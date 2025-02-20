package io.datajek.springmvc.junit;

public class ArrayMethods {
    int findIndex(int[] array, int number) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number)
                index = i;
        }
        return index;
    }

    void printNumber(int[] array, int index) {
        System.out.println(array[index]);
    }
}
