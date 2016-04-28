import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Le_030_Substring_with_Concatenation_of_All_Words {
	public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ans = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) {
            return ans;
        }
        
        int n = L.length;
        int len = S.length();
        int wordLen = L[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word : L){
            if(!map.containsKey(word)){
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        
        for(int i = 0; i <= len - n * wordLen; ++i){
            HashMap<String, Integer> copy = new HashMap<String, Integer>(map);
            for(int j = 0; j < n; ++j){
                String newWord = S.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if(copy.containsKey(newWord)){
                    int num = copy.get(newWord);
                    if(num == 1){
                        copy.remove(newWord);
                        if(copy.isEmpty()){
                            ans.add(i);
                            break;
                        }
                    } else {
                        copy.put(newWord, num - 1);
                    }
                } else {
                    break;
                }
            }
        }
        
        return ans;
    }
	
	
	
	
	// by Jackie
	public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || words == null || words[0].length() == 0){
            return ans;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        int sLen = s.length();
        int wLen = words[0].length();
        int n = words.length;
        
        for(String str : words){
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        
        for(int i = 0; i <= sLen - n * wLen; i++){
             Map<String, Integer> copy = new HashMap<String, Integer>(map);
             for(int j = 0; j < n; j++){
                 String str = s.substring(i + j * wLen, i + (j + 1) * wLen);
                 if(copy.containsKey(str)){
                    int count = copy.get(str);
                    if(count == 1){
                        copy.remove(str);
                    } else {
                        copy.put(str, count - 1);
                    }
                 } else {
                    break;
                 }
             }
             
             if(copy.size() == 0){
                 ans.add(i);
             }
        }
        
        return ans;
    }
}
