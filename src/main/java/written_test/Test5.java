package written_test;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(method(7, nums));
    }

    public static int method(int target, int[] array){
        int sum = Arrays.stream(array).sum();
        System.out.println(sum);
        if(sum < target) {
            return 0;
        } else if(sum == target) {
            return array.length;
        }
        if(judge(target, array)) {
            return 1;
        }
        int left = 0;
        int right = 1;
        int minLength = Integer.MAX_VALUE;
        //  2 3 1 2 4 3
        //  7

        // left = 0, lengthCount=1 valueCount=5
        // left = 0, lengthCount=2
        while(left < array.length - 1) {
            int value = Arrays.stream(array, left, right+1).sum();
            if (value == target) {
               minLength = Math.min(minLength, right - left + 1);
               left ++;
            } else if(value > target) {
                left ++;
            } else {
                if(right < array.length - 1) {
                    right++;
                }
            }

        }
        return minLength;
    }

    public static boolean judge(int target, int[] array) {
        boolean flag = false;
        for(int i=0;i<array.length; i++) {
            if(array[i] == target) {
                flag = true;
            }
        }
        return flag;
    }
}

//  2 3 1 2 4 3
//  7
// 2
// 2 3
// 2 3 1
// 2 3 1 2
// 3 1 2
// 3 1 2 4
// 1 2 4
// 2 4
// 2 4 3
// 4 3
//
