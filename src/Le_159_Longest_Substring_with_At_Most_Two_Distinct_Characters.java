
public class Le_159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        } else if(s.length() == 1){
            return 1;
        }
        
        int[] hash = new int[256];
        int maxLen = 0;
        int back = 0;
        int n = s.length();
        char[] letters = s.toCharArray();
        
        for(int front = 0; front < n; front++){
            hash[letters[front]]++;                 // 此题这句话必须写在这里，而不是后面
            while(back < n && !isValid(hash, 2)){   // 这部分的判断，必须用!isValid，因此需要注意里层和外层的循环顺序
                hash[letters[back]]--;              // 应该先用front还是back！！！
                back++;
            }
            if(isValid(hash, 2)){
                maxLen = Math.max(maxLen, front - back + 1);
            }
        }
        
        return maxLen;
    }
    
    public boolean isValid(int[] hash, int k){
        int count = 0;
        for(int i = 0; i < 256; i++){
            if(hash[i] > 0){
                count++;
            }
        }
        return count <= k;
    }
}
