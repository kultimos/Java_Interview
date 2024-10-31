package double_week_od_prepare.three;

import java.util.LinkedList;
import java.util.Scanner;

public class Three {
    // 地图矩阵
    static int[][] matrix;

    // 最短路径矩阵，即dist[i][j]记录的是坐标(i,j)到(0,0)的最短距离
    static int[][] dist;

    // 地图矩阵行数
    static int m;
    // 地图矩阵列数
    static int n;

    // 八个方向偏移量
    static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        matrix = new int[m][n];
        dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
                // 最短路径矩阵初始化，假设每个点到(0,0)距离无穷大
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(spfa());
    }

    public static int spfa() {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        dist[0][0] = matrix[0][0];

        while (queue.size() > 0) {
            int[] tmp = queue.removeFirst();
            int x = tmp[0], y = tmp[1];

            for (int[] offset : offsets) {
                int newX = x + offset[0];
                int newY = y + offset[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newDist = dist[x][y] + matrix[newX][newY];

                    // 题目说：连续两个相同时延可以减少一个时延值
                    // 但是需要注意的是，应该不能产生负的时延值，比如前一个时延是0，当前时延也是0，则减少1个时延值，不应该变为-1
                    if (matrix[newX][newY] == matrix[x][y] && matrix[newX][newY] >= 1) {
                        newDist -= 1;
                    }

                    if (newDist < dist[newX][newY]) {
                        dist[newX][newY] = newDist;
                        queue.add(new int[] {newX, newY});
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
