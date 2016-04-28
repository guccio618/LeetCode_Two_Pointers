
public class Le_011_Container_With_Most_Water {
	public int maxArea(int[] height) {
		if(height == null || height.length == 0){
            return 0;
        }
        
        int n = height.length;
        int left = 0, right = n - 1;
        int maxArea = 0;
        
        while(left < right){
            int H = Math.min(height[left], height[right]);  // 定一个最低／最高值，低于它的往中间跑
            int W = right - left;
            maxArea = Math.max(maxArea, H * W);
            
            while(left < right && height[left] <= H){
                left++;
            } 
            while(left < right && height[right] <= H){
                right--;
            }
        }
        
        return maxArea;
     }
}
