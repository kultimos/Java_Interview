package double_week_od_prepare.six;

import java.util.Scanner;

public class SixTest1 {
    public static String a;
    public static String b;
    public static int theN;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine();
        b = sc.nextLine();
        theN = sc.nextInt();
        System.out.println(getResult());
    }

    public static int getResult() {
        int n = a.length();
        int []array = new int[n+1];
        for(int i=0;i<=n;i++) {
            if(i!=0) {
                array[i] = array[i-1] + Math.abs(a.charAt(i-1) - b.charAt(i-1));
            }
        }
        int anx = -1;
        for(int i=0;i<n+1;i++) {
            for(int j=i+1;j<n+1;j++) {
                if(array[j] - array[i] <= theN) {
                    anx = Math.max(anx, j-i);
                } else {
                    break;
                }
            }
        }
        return anx;
    }
}
