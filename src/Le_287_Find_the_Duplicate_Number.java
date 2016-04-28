/*****************************************************************************
 * 	按照链表找圆的方法来处理
 * 	(1).可以套用此法的条件为：每个nums[i]数值为1-n, 因此不会超出数组的取值范围i.
 *  (2).将i看作listnode, nums[i]视为listnode.next
 *   
 *****************************************************************************/
public class Le_287_Find_the_Duplicate_Number {
	public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            
            return slow;
        }
        
        return -1;
    }
}
