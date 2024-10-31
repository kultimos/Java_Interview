package double_week_od_prepare.six;

import java.util.Scanner;

public class Six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();
        int v = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(a, b, v));
    }

    public static int getResult(String a, String b, int v) {
        int n = a.length();

        // a,b字符串的各位字符的ascii绝对值差距数组
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + Math.abs(a.charAt(i - 1) - b.charAt(i - 1));
        }

        for(int u : preSum) {
            System.out.print(u + " ");
        }



        // 记录题解
        int ans = 0;

        for (int l = 0; l <= n - 1; l++) {
            for (int r = l + 1; r <= n; r++) {
                // 区间 [l+1, r]的和 = preSum[r] - preSum[l]
                if (preSum[r] - preSum[l] <= v) {
                    ans = Math.max(ans, r - l);
                }
            }
        }

        return ans;
    }
}
