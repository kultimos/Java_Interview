package double_week_od_prepare.two;

import java.util.Scanner;

public class TwoTest1 {

    public static int n;
    public static int m;
    public static int k;
    public static int[] array = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] z = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                z[i][j] = sc.nextInt();
            }
        }
        k = sc.nextInt();
        for(int i=0;i< array.length;i++) {
            array[sc.nextInt()]++;
        }
    }

    public static int method(int [][]z){
        int left = 0;
        int right = 0;
        int total = k;
        int minLength = Integer.MAX_VALUE;
        while(right<m) {
            for(int i=0;i<n;i++) {
                int num = z[i][right];
                if(array[num]-- > 0) {
                    total--;
                }
            }
            while (total == 0) {
                minLength = Math.min(minLength, right - left + 1);
                for(int i=0;i<n;i++) {
                    int num = z[i][left];
                    if (array[num]++>=0){
                       total++;
                    }
                }
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minLength;
        }
    }
}
