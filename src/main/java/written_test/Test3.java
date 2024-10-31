package written_test;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,0,0,0};
        int[] array2 = {2,5,6};
        method(array1, 3, array2, 3);
    }

    public static void method(int[] array1, int m, int[] array2, int n) {
        for(int i=0; i<n; i++) {
            array1[m+i] = array2[i];
        }
        Arrays.sort(array1);
        for(int i: array1) {
            System.out.println(i);
        }
    }
}
