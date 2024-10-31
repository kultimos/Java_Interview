package double_week_od_prepare.two;

import java.util.Scanner;

public class TwoTest3 {
    public static int n;
    public static int m;
    public static int k;
    public static int[] array = new int[1000];
    public static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 2
        m = sc.nextInt(); // 5
        int minLength = Integer.MAX_VALUE;
        matrix = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        k = sc.nextInt();
        for(int i=0;i<k;i++) {
            int num = sc.nextInt();
            array[num]++;
        }
        int total = k;
        int left = 0;
        int right = 0;
        while (right < m) {
            // {0,0} , {1,0}
            for(int i=0;i<n;i++) {
                int value = matrix[i][right];
                if(array[value]-- > 0) {
                    total--;
                }
            }
            while(total == 0) {
                minLength = Math.min(minLength, right - left + 1);
                for(int i=0;i<n;i++) {
                    int leave = matrix[i][left];
                    if(array[leave]++ >= 0) {
                        total++;
                    }
                }
                left++;
            }
            right++;
        }
    }
}

// [0,0,0,0,0]  123
// [0,1,1,1,0]
// [0,0,0,1,0]
// [0,0,0,0,-1]
// [0,1,1,0,-1]