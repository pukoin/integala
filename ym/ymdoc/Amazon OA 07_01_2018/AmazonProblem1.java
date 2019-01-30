import java.util.*;
public class AmazonProblem1{

    // 频率最高的词，我写的是有除了英文字母以外，都当作空白，不分大小写
     public static void main(String []args){
        String text = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";
        List<String> exclude = new ArrayList<>();
        exclude.add("and");
        exclude.add("he");
        exclude.add("the");
        exclude.add("to");
        exclude.add("is");
        exclude.add("Jack");
        exclude.add("Jill");
        for(String s : mostFrequent(text, exclude)){
          System.out.println(s);   
        }
     }
     
     private static List<String> mostFrequent(String text, List<String> exclude){
         Set<String> ex = new HashSet<>();
         Map<String,Integer> map = new HashMap<>();
         for(String s : exclude){
             // if don't add this check, it will have a null error.
             if( s!= null){
               ex.add(s.toLowerCase());   
             }
         }
         String[] words = text.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split(" +");
         int max = 0;
         for(String sw : words){
             if(ex.contains(sw)) continue;
             if(!map.containsKey(sw)){
                 map.put(sw,0);
             }
             map.put(sw,map.get(sw)+1);
             if(map.get(sw) > max){
                 max = map.get(sw);
             }
         }
         List<String> re = new ArrayList<>();
         for(Map.Entry<String, Integer> en : map.entrySet()){
             if(en.getValue() == max){
                 re.add(en.getKey());
             }
         }
         return re;
     }
}
