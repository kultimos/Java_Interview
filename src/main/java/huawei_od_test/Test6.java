package huawei_od_test;

import java.util.*;
import java.util.stream.Collectors;

public class Test6{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] array = new int[m][n];
        List<Integer> list = new ArrayList();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int num = sc.nextInt();
                array[i][j] = num;
                if(!list.contains(num) && num != 0) {
                    list.add(num);
                }
            }
        };
        List<Integer> sizeList = new ArrayList();
        // 到此为止都搞到一个二维数组里了;
        list.forEach(l -> {
            int minX = 0;
            int minY = 0;
            int maxX = 0;
            int maxY = 0;
            int maxSize = 0;
            int count = 0;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(array[i][j] == l) {
                        if(count == 0) {
                            minX = i;
                            minY = j;
                            maxX = i;
                            maxY = j;
                            count++;
                        } else {
                            minX = minX>i?i:minX;
                            minY = minY>j?j:minY;
                            maxX = maxX<i?i:maxX;
                            maxY = maxY<j?j:maxY;
                        }
                    }
                }
            }
            // System.out.println("现在是"+l+"的结果:" + minX + "," + minY + "," + maxX + "," + maxY);
            sizeList.add((maxX-minX+1)*(maxY-minY+1));
        });
        int biggest = 0;
        for(int i=0;i<sizeList.size();i++) {
            if(sizeList.get(i) > biggest) {
                biggest = sizeList.get(i);
            }
        }
        System.out.println(sizeList.stream().max(Integer::compareTo).get());
    }
}


