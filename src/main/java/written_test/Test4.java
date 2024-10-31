package written_test;

import java.security.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) {
        System.out.println(method(40));
    }

    /**
     * 斐波那契数列
     * p1表示 到达n阶,下一次迈两阶台阶的情况,一共有多少种方案
     * p2表示 到达n阶,下一次迈一阶台阶的情况,一共有多少种方案
     * r表示  到达n阶,一共有多少种方案
     */

    public static int method(int n) {
        int p1 = 0;
        int p2 = 0;
        int r = 1;
        for(int i=1;i<n;i++) {
            p1 = p2;
            p2 = r;
            r = p1+p2;
        }
        return r;
    }
}
