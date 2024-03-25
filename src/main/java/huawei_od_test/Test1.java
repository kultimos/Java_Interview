package huawei_od_test;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 需要在螺旋矩阵中填入 1 ~ n 数字
        int n = sc.nextInt();
        // 螺旋矩阵行数
        int m = sc.nextInt();

        int every_line_num = n%m == 0?n/m : n/m +1;

        int num = 1;
        int x = 0;
        int y = 0;
        int array[][] = new int[m][every_line_num];
        while(num <= n) {
            while(y < every_line_num && array[x][y] == 0 && num <= n) { //  1 2 3
                array[x][y++] = num++;
            }
            x++;
            y--;

            while(x < m && array[x][y] == 0 && num <= n) {
                array[x++][y] = num++;
            }
            x--;
            y--;

            while(y >= 0 && array[x][y] == 0 && num <= n ) {
                array[x][y--] = num++;
            }
            x--;
            y++;

            while(x >= 0 && array[x][y] == 0 && num <= n) {
                array[x--][y] = num++;
            }
            x++;
            y++;
        }

        for(int i=0;i<array.length;i++) {
            StringBuilder a = new StringBuilder();
            for(int j=0;j<array[0].length;j++) {
                if(array[i][j] == 0) {
                    a.append("* ");
                } else {
                    a.append(array[i][j] + " ");
                }
            }
            System.out.print(a);
            System.out.println();
        }
    }
}

