
public class Le_042_Trapping_Rain_Water {  
	public int trap(int[] height) {
		if(height == null || height.length == 0){
            return 0;
        }
        
        int n = height.length;
        int left = 0, right = n - 1;
        int count = 0;
        
        while(left < right){
            int smaller = Math.min(height[left], height[right]);  // 定一个最低／最高值，低于它的往中间跑
            while(left < right && height[left] <= smaller){
                count += smaller - height[left++];
            }
            while(left < right && height[right] <= smaller){
                count += smaller - height[right--];
            }
        }
        
        return count;
     }
}
