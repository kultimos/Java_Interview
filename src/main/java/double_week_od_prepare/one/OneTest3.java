package double_week_od_prepare.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class OneTest3 {
    /**
     * 0b000 都出现偶数次
     * 0b001 l 出现奇数次
     * 0b010 o 出现奇数次
     * 0b011 l,o 出现奇数次
     * 0b100 x 出现奇数次
     * 0b101 x,l出现奇数次
     * 0b110 x,o出现奇数次
     * 0b111 都出现奇数次
     * @param args
     */
    // alolobo
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();

        List<LinkedList<Integer>> list = new ArrayList<>();
        for(int i=0;i<8;i++) {
            list.add(new LinkedList<>());
        }
        list.get(0).add(-1);
        int minValue = -1;
        int status = 0b000; // 初始状态
        for(int i=0; i<string.length() * 2 ; i++) {
            char c = string.charAt(i%string.length());
            switch(c) {
                case 'x':
                    status ^= 0b100;
                    break;
                case 'l':
                    status ^= 0b001;
                    break;
                case 'o':
                    status ^= 0b010;
                    break;
            }
            if(i < string.length()) {
                list.get(status).add(i);
            }
            while(list.get(status).size() > 0) {
                Integer first = list.get(status).getFirst();
                if (i - first > string.length()) {
                    //说明i的值太小了,需要调整
                    list.get(status).removeFirst();
                } else {
                    minValue = Math.max(minValue, i - first);
                    break;
                }
            }
        }
    }
}
