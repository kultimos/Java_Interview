package double_week_od_prepare.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *  2 4
 *  0 2 2 1
 *  1 2 3 1
 */

public class ThreeTest2 {
    public static int m;
    public static int n;
    public static int [][]array;
    public static int [][]dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        array = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                array[i][j] = sc.nextInt();
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0,1});
        list.add(new int[]{0,-1});
        list.add(new int[]{1,1});
        list.add(new int[]{1,0});
        list.add(new int[]{1,-1});
        list.add(new int[]{-1,1});
        list.add(new int[]{-1,0});
        list.add(new int[]{-1,-1});
        dist[0][0] = array[0][0];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while(queue.size()>0) {
            int[] ints = queue.removeFirst();
            int x = ints[0];
            int y = ints[1];
            for(int i=0;i<list.size();i++) {
                int newX = x + list.get(i)[0];
                int newY = y + list.get(i)[1];
                if(newX >= 0 && newY >= 0 && newX<m && newY < n) {
                    int newDist = dist[x][y] + array[newX][newY];
                    if(array[x][y] == array[newX][newY] && array[x][y] > 0) {
                        newDist--;
                    }
                    if(dist[newX][newY] > newDist) {
                        dist[newX][newY] = newDist;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
