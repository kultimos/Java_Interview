package double_week_od_prepare.seven;

import java.util.LinkedList;
import java.util.Scanner;

public class Seven {

    public static void main(String[] args) {
        TouZi touZi = new TouZi();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            switch (c) {
                case 'A':
                    touZi.turnA();
                    break;
                case 'C':
                    touZi.turnC();
                    break;
                case 'B':
                    touZi.turnB();
                    break;
                case 'F':
                    touZi.turnF();
                    break;
                case 'L':
                    touZi.turnL();
                    break;
                case 'R':
                    touZi.turnR();
                    break;
            }
        }
        System.out.print(touZi.left);
        System.out.print(touZi.right);
        System.out.print(touZi.front);
        System.out.print(touZi.behind);
        System.out.print(touZi.up);
        System.out.print(touZi.down);
    }
}

class TouZi{
    public int left = 1;
    public int right = 2;
    public int up = 5;
    public int down = 6;
    public int front = 3;
    public int behind = 4;
    public LinkedList<Integer> list = new LinkedList<>();


    public void turnL(){
        list.add(up);
        list.add(left);//
        list.add(down);//
        list.add(right);//
        this.left = list.removeFirst();
        this.down = list.removeFirst();
        this.right = list.removeFirst();
        this.up = list.removeFirst();
    }

    public void turnR() {
        // 1 6 2 5
        // 6 2 5 1
        list.add(down);
        list.add(right);
        list.add(up);
        list.add(left);
        this.left = list.removeFirst();
        this.down = list.removeFirst();
        this.right = list.removeFirst();
        this.up = list.removeFirst();
    }

    public void turnF() {
        // 3 6 4 5
        // 5 3 6 4
        list.add(up);
        list.add(front);
        list.add(down);
        list.add(behind);
        this.front = list.removeFirst();
        this.down = list.removeFirst();
        this.behind = list.removeFirst();
        this.up = list.removeFirst();
    }

    public void turnB(){
        // 3 6 4 5
        // 6 4 5 3
        list.add(down);
        list.add(behind);
        list.add(up);
        list.add(front);
        this.front = list.removeFirst();
        this.down = list.removeFirst();
        this.behind = list.removeFirst();
        this.up = list.removeFirst();
    }

    public void turnA() {
        // 1 3 2 4
        // 4 1 3 2
        list.add(behind);
        list.add(left);
        list.add(front);
        list.add(right);
        this.left = list.removeFirst();
        this.front = list.removeFirst();
        this.right = list.removeFirst();
        this.behind = list.removeFirst();
    }

    public void turnC(){
        // 1 3 2 4
        // 3 2 4 1
        list.add(front);
        list.add(right);
        list.add(behind);
        list.add(left);
        this.left = list.removeFirst();
        this.front = list.removeFirst();
        this.right =list.removeFirst();
        this.behind = list.removeFirst();
    }
}
