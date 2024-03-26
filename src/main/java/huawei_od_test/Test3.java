package huawei_od_test;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        method1(str);
        int count = 0;
        int x = 0;
        int y = 0;
        for(int i=0;i<str.length();i++) {
            char temp = str.charAt(i);
            if(temp == 'o') {
                count++;
                if(count == 1) {
                    x = i;
                }
                y = i;
            }
        }
        if(count % 2 == 0) {
            System.out.println(str.length());
            return;
        }
        //计算出第一个o的索引和最后一个o的索引 分别是x和y
        int xLength = x - 0;
        int yLength = str.length()-1-y;
        String result = "";
        String soe = "";
        if(xLength-yLength<0) {
            result = str.substring(x+1);
            soe = str.substring(0,x);
        }
        if(xLength-yLength>=0) {
            result = str.substring(0,y);
            soe = str.substring(y,str.length()-1);
        }

        System.out.println(result.length() + soe.length());
    }
    public static void method(String s){
        int n = s.length();

        // s中'o'的个数
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'o') zeroCount++;
        }

        if (zeroCount % 2 == 0) {
            System.out.println(n);
        } else {
            System.out.println(n-1);
        }
    }

    public static void method1(String str) {
        int count = 0;
        int x = 0;
        int y = 0;
        for(int i=0;i<str.length();i++) {
            char temp = str.charAt(i);
            if(temp == 'o') {
                count++;
                if(count == 1) {
                    x = i;
                }
                y = i;
            }
        }
        if(count % 2 == 0) {
            System.out.println(str.length());
            return;
        }
        //计算出第一个o的索引和最后一个o的索引 分别是x和y
        int xLength = x - 0;
        int yLength = str.length()-1-y;
        String result = "";
        String soe = "";
        if(xLength-yLength<0) {
            result = str.substring(x+1);
            soe = str.substring(0,x);
        }
        if(xLength-yLength>=0) {
            result = str.substring(0,y);
            soe = str.substring(y,str.length()-1);
        }

        System.out.println(result.length() + soe.length());
    }
}
