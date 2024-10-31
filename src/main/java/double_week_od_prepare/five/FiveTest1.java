package double_week_od_prepare.five;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

public class FiveTest1 {
    public static int n;
    public static String s;
    public static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string  = sc.nextLine();
        s = string.split(" ")[0];
        n = Integer.parseInt(string.split(" ")[1]);
        char []cArr = s.toCharArray();
        Arrays.sort(cArr);
        Boolean flag = false;
        for(char t: cArr) {
            if(!(t>='a' && t<='z')) {
                flag = true;
            }
        }
        if(cArr.length > 30) {
            flag = true;
        }
        if(flag) {
            System.out.println(0);
        } else {
            def(-1, cArr, new boolean[cArr.length], 0);
            System.out.println(count);
        }
    }

    public static void def(int pre, char[] cArr, boolean[] used, int length) {
        if(length == n){
            count++;
            return;
        }
        for(int i=0;i<cArr.length;i++) {
            if(used[i]) {
                continue;
            }
            if(pre>=0 && cArr[pre] == cArr[i]) {
                continue;
            }
            if(i >= 1 && cArr[i] == cArr[i-1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            def(i, cArr, used, length + 1);
            used[i] = false;
        }
    }
}

