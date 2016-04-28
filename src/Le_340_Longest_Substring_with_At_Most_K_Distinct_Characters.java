/*****************************************************************************
 * 	此题为159题的follow up
 *   
 *****************************************************************************/

public class Le_340_Longest_Substring_with_At_Most_K_Distinct_Characters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k <= 0){
            return 0;
        }
        
        int n = s.length();
        int[] hash = new int[256];
        int slower = 0;
        int ans = 0;
        
        for(int faster = 0; faster < n; faster++){
            hash[s.charAt(faster)]++;
            while(slower < n && !isValid(hash, k)){
                hash[s.charAt(slower)]--;
                slower++;
            }
            if(isValid(hash, k)){
                ans = Math.max(ans, faster - slower + 1);
            }
        }
        
        return ans;
    }
    
    public boolean isValid(int[] hash, int k){
        int count = 0;
        for(int i = 0; i < 256; i++){
            if(hash[i] > 0){
                count++;
            }
            if(count > k){
                return false;
            }
        }
        return true;
    }
}
