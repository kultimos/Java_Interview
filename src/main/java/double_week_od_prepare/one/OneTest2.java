package double_week_od_prepare.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test2 {
    /**
     * 0x00
     * 所有都出现了偶数次,0b000
     * l出现单数次, 0b001
     * o出现单数次,0b010
     * o和l都出现了单数次, 0b011
     * x出现了单数次,0b100
     * x和l出现了单数次,0b101
     * xol都出现了单数次,0b111
     * @param args
     */


    public static void main(String[] args) {
        String s = "alolobo";
        int maxLength = -1;
        int status = 0b000;
        List<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
        for(int i =0 ; i < 8 ; i++) {
            list.add(new LinkedList<>());
        }
        list.get(0).add(-1); //
        for(int i=0 ; i<s.length()*2 ; i++) {
            char c = s.charAt(i % s.length());
            switch (c) {
                case 'l':
                    status ^= 0b001;
                case 'o':
                    status ^= 0b010;
                case 'x':
                    status ^= 0b111;
            }
            if( i < s.length()) {
                list.get(status).add(i); //记录这个状态出现的第一个位置
            }
            while(list.get(status).size() > 0) {
                Integer earlyIndex = list.get(status).get(0);
                if(i-earlyIndex > s.length()) {
                    list.get(status).removeFirst();
                }  else {
                    maxLength = Math.max(maxLength, i - earlyIndex);
                    break;
                }
            }
        }
        System.out.println(maxLength);
    }
}
