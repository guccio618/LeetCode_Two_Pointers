import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Le_016_3Sum_Closest {
	public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int sum = 0;
        int n = nums.length;
        int left = 0, right = 0;
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < n - 2; ++i){
            left = i + 1;
            right = n - 1;
            
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(minDiff > Math.abs(target - sum)) {
                    minDiff = Math.abs(target - sum);
                    ans = sum;
                }
                if(sum > target){
                    right--;
                } else if(sum < target){
                    left++;
                } else {
                    return target;
                }
            }
        }
        
        return ans;
    }
}
