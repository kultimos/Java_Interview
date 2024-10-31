package double_week_od_prepare.one;


import java.util.*;

/**
 * 给你一个字符串s,字符串s首尾相连成一个环形,请你在环中找出"l"、"o"、"x"字符都恰好出现了偶数次最长子字符串的长度
 */
public class OneTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        getValue(line);
    }

    /**
     * 001 表示只有x出现奇数次,o和l都出现偶数次
     * @param line
     */
    public static void getValue(String line) {
        int status = 0b000;

        System.out.println(status);
    }
}
