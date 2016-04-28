
public class Le_076_Minimum_Window_Substring {
	public String minWindow(String source, String target) {
        if(source == null || source.length() == 0 || target == null || target.length() == 0 || source.length() < target.length()){
             return new String();
        }
        
        int[] sourceHash = new int[256];
        int[] targetHash = new int[256];
        int len1 = source.length();
        int len2 = target.length();
        int min = Integer.MAX_VALUE;
        String ans = "";
        int faster = 0, slower = 0;
        
        for(int i = 0; i < len2; ++i){
            targetHash[target.charAt(i)]++;
        }
        
        for(; slower < len1; ++slower){
            while(faster < len1 && !isValid(sourceHash, targetHash)){
                sourceHash[source.charAt(faster)]++;
                faster++;
            }
            if(isValid(sourceHash, targetHash)){
                if(faster - slower < min){
                    min = faster - slower;
                    ans = source.substring(slower, faster);  // 因为faster 已经++过了，因此此处不需要＋1
                }
            }
            sourceHash[source.charAt(slower)]--;
        }
        
        return ans;
    }
    
    public boolean isValid(int[] sourceHash, int[] targetHash){
        for(int i = 0; i < 256; ++i){
            if(targetHash[i] > sourceHash[i]){
                return false;
            }
        }
        return true;
    }
}
