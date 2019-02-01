public class Solution {
    /**
     * @param restaurant: 
     * @param n: 
     * @return: nothing
     */
     
    class Point implements Comparable<Point> {
        int distance;
        int idx;
        public Point(int distance, int idx) {
            this.distance = distance;
            this.idx = idx;
        }
        
        public int compareTo(Point o) {
            int diff = o.distance - this.distance;
            return diff;
        }
    }
    public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
        // Write your code here
         if (restaurant == null || restaurant.size() == 0 || restaurant.size() < n)
            return new ArrayList<>();
        
        if (restaurant.size() == n) return restaurant;
        
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for (int i = 0; i < restaurant.size(); i++){
            int distance = calculateDistance(restaurant.get(i));
            Point currPoint = new Point(distance, i);
            pq.offer(currPoint);
            while (pq.size() > n) {
                pq.poll();
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> idxList = new ArrayList<>();
        while ( !pq.isEmpty()) {
            Point curr = pq.poll();
            
            idxList.add(curr.idx);
        }
        Collections.sort(idxList);
        for (int i = 0; i < idxList.size(); i++) {
            result.add(restaurant.get(idxList.get(i)));
        }
        
        return result;
            
    }
    
    private int calculateDistance(List<Integer> point) {
        return point.get(0) * point.get(0) + point.get(1) * point.get(1);
    }
}