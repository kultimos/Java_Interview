package huawei_od_test;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int familyNum = sc.nextInt();
        int[] family = new int[familyNum];
        for(int i=0;i<familyNum;i++) {
            family[i] = sc.nextInt();
        }
        int[] wealthy = family;

        for(int i=0;i<familyNum-1;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            wealthy[a-1] += family[b-1];
        }
        int max = 0;
        for(int i=0;i<wealthy.length;i++) {
            if(wealthy[i] > max) {
                max = wealthy[i];
            }
        }
        System.out.println(Arrays.stream(wealthy).max().orElse(0));
    }
}
