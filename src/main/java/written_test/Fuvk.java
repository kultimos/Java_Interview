package written_test;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;

public class Fuvk {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(method(7, nums));
    }

    public static int method(int target, int[] array) {
        int len = array.length;
        if(len == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while(right < len) {
            sum += array[right];
            while(sum >=target) {
                result = Math.min(result, right - left + 1);
                sum -= array[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
