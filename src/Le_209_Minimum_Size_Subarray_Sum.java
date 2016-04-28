
public class Le_209_Minimum_Size_Subarray_Sum {
	public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int faster = 0;
        int sum = 0;
        
        for(int slower = 0; slower < n; ++slower){
            while(faster < n && sum < s){
                sum += nums[faster];
                faster++;
            }
            if(sum >= s){
                ans = Math.min(ans, faster - slower);
            }
            sum -= nums[slower];
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
