import java.util.*;


public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for(char ch : s.toCharArray()) hashMap.put(ch, 0);
        for(char ch : t.toCharArray()){
            if(hashMap.containsKey(ch))
                hashMap.put(ch, hashMap.get(ch) + 1);
            else
                return result;
        }
        int start = 0, end = 0;
        int counter = t.length();
        while(end < s.length()){
            char curChar = s.charAt(end);
            if(hashMap.get(curChar) > 0) counter--;
            hashMap.put(curChar, hashMap.get(curChar) - 1);
            while (counter == 0){
                if(end - start + 1 == t.length()) result.add(start);
                char nextChar = s.charAt(start);
                hashMap.put(nextChar, hashMap.get(nextChar) + 1);
                if(hashMap.get(nextChar) > 0) counter++;
                start++;
            }
            end++;
        }
        return result;
    }

    public static void main(String[] args){
        String source = "";
        String pan = "";
        String s1= "cbaebabacd";
        String p1 = "abc";
        String s2 = "abab";
        String p2 = "ab";
        List<Integer> result = findAnagrams(s2, p2);
        System.out.println(result);
    }
}
