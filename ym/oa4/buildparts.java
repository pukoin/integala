class Solution {
    public int minCost(int numParts, List<Integer> parts) {

        if (parts.length != numParts) 
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Integer a : parts) {
            pq.offer(a);
        }

        while (pq.size() > 1) {
            int t1 = pq.poll();

            int t2 = pq.poll();
 
            int t3 = t1 + t2;
            pq.offer(t3);
        }
        if (pq.size() != 1)
            return 0;


        return pq.poll();
            

    }
}