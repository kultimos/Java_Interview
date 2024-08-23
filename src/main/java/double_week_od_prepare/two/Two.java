package double_week_od_prepare.two;

import java.util.Scanner;

public class Two {
    static int n; // 矩阵行数
    static int m; // 矩阵列数
    static int[][] matrix; // 矩阵

    static int k; // 目标数组长度
    static int[] cnts; // cnts[num] 记录的是 目标数组中num元素的个数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        k = sc.nextInt();

        cnts = new int[1000];
        for (int i = 0; i < k; i++) {
            int num = sc.nextInt();
            cnts[num]++;
        }

        System.out.println(getResult());
    }

    public static int getResult() {
        // 未完成匹配的元素的个数
        int total = k;

        // 记录最小子矩阵的宽度
        int minLen = Integer.MAX_VALUE;

        // 当前子矩阵的左边界（列号）
        int l = 0;
        // 当前子矩阵的右边界（列号）
        int r = 0;

        // 如果右边界未越界，则可以继续尝试找最小子矩阵
        while (r < m) {

            // 将第r列所有元素纳入子矩阵
            for (int i = 0; i < n; i++) {
                // 第r列的元素num
                int num = matrix[i][r];
                // cnts[num] 记录的是 目标数组中num元素的个数，也可以理解为：目标数组中num元素剩余未匹配的个数
                // 如果num不是目标数组元素，则cnts[num]初始时必然为0，对于非目标数组元素num, 即使进行了 cnts[num]--， 也不影响总的未匹配数量 total
                // 如果num是目标数组元素，则cnts[num]初始时必然大于0，且随着子矩阵扩大范围，如果子矩阵中包含num元素个数超过了初始cnts[num]数量，则超出部分起不到匹配效果，即不能影响总的未匹配数量
                if (cnts[num]-- > 0) {
                    total--;
                }
            }

            // 纳入r列后，看看总的未匹配元素数量total还有几个，如果total为0，则说明当前子矩阵匹配到了所有目标数组元素
            while (total == 0) {
                // 若此时子矩阵宽度 r - l + 1 更小，则更新最小子矩阵宽度
                minLen = Math.min(minLen, r - l + 1);

                // 由于当前子矩阵已经匹配到所有目标数组元素，因此下一步应该将 l 右移，尝试更小宽度的子矩阵
                for (int i = 0; i < n; i++) {
                    // l 右移，相当于当前子矩阵移除了第 l 列所有元素，被移除的元素num如果是目标数组元素，则对应的未匹配数量应该被恢复
                    int num = matrix[i][l];

                    // 如果当前num不是目标数组元素，或者当前num是目标数组元素，但是属于超出部分（这两种情况必然cnts[num] < 0），
                    //    则对应num元素的恢复，不能影响到整体未匹配数量total，
                    // 如果当前num是目标数组元素，且不是超出部分（此时必然cnts[num] >= 0），则对应num元素的恢复，会影响到整体未匹配数量total
                    if (cnts[num]++ >= 0) {
                        total++;
                    }
                }

                // l右移，且下一轮要继续检查l右移后的子矩阵是否依旧能覆盖目标数组所有元素
                l++;
            }

            // r右移
            r++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minLen;
        }
    }
}