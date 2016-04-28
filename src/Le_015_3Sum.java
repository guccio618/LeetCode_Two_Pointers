import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Le_015_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return ans;
        }
        
        int left = 0, right = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            left = i + 1;
            right = nums.length - 1;
            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(new ArrayList<Integer>(list));
                    
                    int num1 = nums[left];
                    int num2 = nums[right];
                    
                    while(left < right && nums[left] == num1){   // 注意此处left和right指针移动以及去除重复的方法！！！
                        left++;
                    }
                    
                    while(left < right && nums[right] == num2){
                        right--;
                    }
                } else if(sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
            
            while(i + 1 < nums.length && nums[i] == nums[i + 1]){  // 去除重复
                i++;
            }
        }
        
        return ans;
    }
}
