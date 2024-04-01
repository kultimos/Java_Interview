package huawei_od_test;
import java.util.*;
public class Test5 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int x=0;
        Stack stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '<' && !stack.isEmpty()) {
                stack.pop();
            } else {
                if(str.charAt(i) != '<')
                    stack.push(str.charAt(i) + "");
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(a -> {
            sb.append(a);
        });
        String result = sb.toString();
        Boolean flag = false;
        int countTiny = 0;
        int countBig = 0;
        int countNum = 0;
        int countStrange = 0;
        for(int i=0;i<result.length();i++) {
            char theC = result.charAt(i);
            if(theC >= 'a' && theC <= 'z') {
                countTiny++;
            }
            else if(theC >= 'A' && theC <= 'Z') {
                countBig++;
            }
            else if(theC >= '0' && theC <= '9' ) {
                countNum++;
            }
            else  {
                countStrange++;
            }
        }
        if(countTiny > 0 && countBig > 0 && countNum > 0 && countStrange > 0 && result.length() >= 8) {
            flag = true;
        }
        System.out.println(result+","+flag);
    }
}
