package double_week_od_prepare.two;

import java.util.Scanner;

public class TwoTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int array[][] = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                array[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int values[] = new int[1000];
        for(int i=0;i<1000;i++) {
            values[sc.nextInt()]++;
        }
        // 1 2 2 3 1          00 01 02 03 04
        // 2 3 2 3 2          10 11 12 13 14
        int minValue = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int free = k;
        while(left  < m) {
            for(int i=0;i<n;i++) {
                int num = array[i][right];
                if(values[num]-- > 0) {
                    free--;
                }
            }
            while( free == 0) {
                minValue = Math.min(minValue, right - left + 1);
            }
            right++;
        }
    }
}
