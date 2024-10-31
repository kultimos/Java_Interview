package double_week_od_prepare.seven;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        turnDice(sc.nextLine().toCharArray());
    }

    public static void turnDice(char[] directives) {
        Dice dice = new Dice();

        for (char directive : directives) {
            switch (directive) {
                case 'L':
                    dice.turnL();
                    break;
                case 'R':
                    dice.turnR();
                    break;
                case 'F':
                    dice.turnF();
                    break;
                case 'B':
                    dice.turnB();
                    break;
                case 'A':
                    dice.turnA();
                    break;
                case 'C':
                    dice.turnC();
                    break;
            }
        }

        dice.print();
    }
}

class Dice {
    int left = 1;
    int right = 2;
    int front = 3;
    int back = 4;
    int top = 5;
    int bottom = 6;

    public void turnL() {
        // 前后不变，上变左，左变下，下变右，右变上
        int tmp = this.right;
        this.right = this.bottom;
        this.bottom = this.left;
        this.left = this.top;
        this.top = tmp;
    }

    public void turnR() {
        // 前后不变，上变右，右变下，下变左，左变上
        int tmp = this.left;
        this.left = this.bottom;
        this.bottom = this.right;
        this.right = this.top;
        this.top = tmp;
    }

    public void turnF() {
        // 左右不变，上变前，前变下，下变后，后变上
        int tmp = this.front;
        this.front = this.top;
        this.top = this.back;
        this.back = this.bottom;
        this.bottom = tmp;
    }

    public void turnB() {
        // 左右不变，前变上，上变后，后变下，下边前
        int tmp = this.top;
        this.top = this.front;
        this.front = this.bottom;
        this.bottom = this.back;
        this.back = tmp;
    }

    public void turnA() {
        // 上下不变， 前变右，右变后，后变左，左变前
        int tmp = this.right;
        this.right = this.front;
        this.front = this.left;
        this.left = this.back;
        this.back = tmp;
    }

    public void turnC() {
        // 上下不变， 右变前，前变左，左变后，后变右
        int tmp = this.front;
        this.front = this.right;
        this.right = this.back;
        this.back = this.left;
        this.left = tmp;
    }

    public void print() {
        String sb =
                String.valueOf(this.left) + this.right + this.front + this.back + this.top + this.bottom;
        System.out.println(sb);
    }
}
