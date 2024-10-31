package double_week_od_prepare.three;

import java.util.LinkedList;
import java.util.Scanner;

public class ThreeTest1 {
    public static int m;
    public static int n;

    public static int[][] dist; // 该数组用于记录原点到各个点的距离的最小值,所以初始化时,默认都是最大值
    public static int[][] allowChoose = {{0,1},{0,-1},{1,0},{1,-1},{-1,0},{-1,1},{1,1},{-1,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int matrix[][] = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j =0;j<n;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        dist = new int[m][n];
        for(int i=0;i<dist.length;i++) {
            for(int j=0;j<dist[i].length;j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int result = getResult(matrix);
        System.out.println(result);
    }

    public static int getResult(int [][]matrix){
        LinkedList<int[]> queue = new LinkedList<>();
        dist[0][0] = matrix[0][0];
        queue.add(new int[]{0, 0});
        while(queue.size() > 0) {
            int[] ints = queue.removeFirst();
            int x = ints[0];
            int y = ints[1];
            for(int i =0;i< allowChoose.length;i++) {
                int newX = x + allowChoose[i][0];
                int newY = y + allowChoose[i][1];
                if(newX>=0 && newX<n && newY >=0 && newY < m) {
                    int addLength = dist[x][y] + matrix[newX][newY];
                    if(matrix[x][y] == matrix[newX][newY] && matrix[x][y] > 0 ){
                        addLength -= 1;
                    }
                    if(dist[newX][newY] > addLength) {
                        dist[newX][newY] = addLength;
                        queue.add(new int[]{newX,newY});
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }


}
