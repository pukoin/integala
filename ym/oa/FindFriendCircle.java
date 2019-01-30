import java.util.*;

public class FindFriendCircle {
    public static void main(String[] args) {

        boolean comp = Arrays.equals(
            new String[] {"f3", "f4", "f5"}
            , new FindFriendCircle().findLargestCircle(new String[][]{
                    {"f1", "f2"},
                    {"f3", "f4"},
                    {"f4", "f5"},
            }));
        System.out.println(comp);

        assert true == Arrays.equals(
            new String[] {"f1", "f2"}
            , new FindFriendCircle().findLargestCircle(new String[][]{
                    {"f1", "f2"},
                    {"f3", "f4"},
            }));


//        String[][] input = {
//                {"f1", "f2"},
//                {"f3", "f4"},
//                {"f1", "f3"},
//
//        };
//
//        String[] output = new FindFriendCircle().findLargestCircle(input);

    }

    private String[] findLargestCircle(String[][] inputArray) {

        Arrays.sort(inputArray, new Comparator<String[]>() {
            @Override
            //arguments to this method represent the arrays to be sorted
            public int compare(String[] string1, String[] string2) {
                //get the item ids which are at index 0 of the array
                String itemOne = string1[0];
                String itemTwo = string2[0];
                // sort on item id
                return itemOne.compareTo(itemTwo);
            }
        });

        Map<String, String> unionKeys = new HashMap<>();
        for(String[] eachPair:inputArray) {
            unionKeys.put(eachPair[0],eachPair[0]);
            unionKeys.put(eachPair[1],eachPair[1]);
        }



        for(String[] eachPair: inputArray) {
            String unionKey = null, other = null;
            String key0 = unionKeys.get(eachPair[0]), key1 = unionKeys.get(eachPair[1]);
            
            if(key0.compareTo(key1) < 0) {
                unionKey = key0;
                other = eachPair[1];
            } else {
                unionKey = key1;
                other = eachPair[0];
            }
            unionKeys.put(other, unionKey);
        }

        Map<String, Integer> keyCounts = new HashMap<>();
        for(Map.Entry<String, String> item : unionKeys.entrySet()) {
            keyCounts.put(item.getValue(), keyCounts.getOrDefault(item.getValue(), 0) + 1);
        }


        int max = -1;
        String maxKey = null;
        for(Map.Entry<String, Integer> item : keyCounts.entrySet()) {
            if(item.getValue() > max || (item.getValue() == max && item.getKey().compareTo(maxKey) < 0)) {
                max = item.getValue();
                maxKey = item.getKey();
            }
        }

        String[] results = new String[max];
        for(Map.Entry<String, String> item : unionKeys.entrySet()) {
            if(item.getValue().equals(maxKey)) {
                results[--max] = item.getKey();
            }
        }

        Arrays.sort(results);
        System.out.println(Arrays.toString(results));

        return results;
    }

}
