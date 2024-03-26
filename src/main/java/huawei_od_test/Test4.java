package huawei_od_test;

import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        int x = 0;
        int count = 0;
        int preType = 0;
        if(len == 1) {
            if(str.charAt(0) == '1') {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }else {
            //10010
            for(int i=0;i<len;i++) {
                if(i==0) {
                    if(str.charAt(i) == '0' && str.charAt(i+1) == '0') {
                        count++;
                    }
                    preType = 1;
                } else if(i == len-1) {
                    if(str.charAt(i) == '0' && preType == 0) {
                        count++;
                    }
                } else {
                    if(str.charAt(i) == '0' && preType == 0 && str.charAt(i+1) == '0') {
                        count++;
                        preType = 1;
                    } else if(str.charAt(i) == '0') {
                        preType = 0;
                    } else if(str.charAt(i) == '1') {
                        preType = 1;
                    }
                }
            }
            System.out.println(count);
        }

    }
}

// 0
// 1 x=0; / 0 x=1; / 0 x=0;c++ 1 x=0
// 0 x=1; 1x=0 0=0
//
//