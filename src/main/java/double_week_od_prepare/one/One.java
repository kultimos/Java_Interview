package double_week_od_prepare.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getResult(s));
    }

    public static int getResult(String s) {
        int status = 0b000;
        // aloloboalolobo
        // map.get(i) 用于记录 状态i 出现的过的所有位置
        // 之所以包含8个linkedList是因为我们需要记录8种不同的状态,这些状态代表字符'l'、'o'、'x'在子字符串中出现的次数的奇偶性组合
        // 000 -> 0 (所有字符都出现偶数次) key为0
        // 001 -> 1 ('x' 出现奇数次，其他偶数次) key为1
        // 010 -> 2 ('o' 出现奇数次，其他偶数次) key为2
        // 011 -> 3 ('o' 和 'x' 出现奇数次，'l' 偶数次)  key为3
        // 100 -> 4 ('l' 出现奇数次，其他偶数次)  key为4
        // 101 -> 5 ('l' 和 'x' 出现奇数次，'o' 偶数次)  key为5
        // 110 -> 6 ('l' 和 'o' 出现奇数次，'x' 偶数次)  key为6
        // 111 -> 7 (所有字符都出现奇数次)  key为7
        // 这里之所以每个状态都进行一次判断,是因为相同的status之间的子串,所有一定都是偶数,因为奇-奇也是偶,偶-偶还是偶
        ArrayList<LinkedList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new LinkedList<>());
        }
        //  aloloboal olobo
        list.get(0).add(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length() * 2; i++) {
            // 第二轮时，i>=subject_four.length()，此时i需要对s.length()求余，避免后面越界
            char c = s.charAt(i % s.length());

            switch (c) {
                case 'l':
                    status ^= 0b100;
                    break;
                case 'o':
                    status ^= 0b010;
                    break;
                case 'x':
                    status ^= 0b001;
                    break;
            }

            if (i < s.length()) {
                // 第一轮时，i ∈ [0, subject_four.length()), 左闭右开
                // 记录该状态出现过的所有位置
                list.get(status).add(i);
            }

            while (list.get(status).size() > 0) {
                // status状态最早出现的位置
                int earliest = list.get(status).getFirst();

                // i 是当前位置，和 earliest 位置的状态相同
                if (i - earliest > s.length()) {
                    // 如果 (earliest, i] 范围子串长度超过s串长度，则说明earliest左越界，应该尝试更大一点的earliest
                    list.get(status).removeFirst();
                } else {
                    // 如果 (earliest, i] 范围子串长度未超过s串长度，则该范围子串就是一个符合要求的子串，记录此时子串长度
                    maxLen = Math.max(maxLen, i - earliest);
                    break;
                }
            }
        }

        return maxLen;
    }
}


