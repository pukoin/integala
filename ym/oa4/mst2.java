import java.util.List;
import java.util.*;

class Solution {
    int getMinimumCostToConstruct(int numTotalAvailableCities,
                                  int numTotalAvailableRoads,
                                List<List<Integer>> roadsAvailable,
                            int numNewRoadsConstruct,
                            List<List<Integer>> costNewRoadsConstruct) {

    if (numTotalAvailableCities < 2 || numTotalAvailableRoads >= numTotalAvailableCities - 1) {
        return 0;
    }

    UnionFind uf = new UnionFind(numTotalAvailableCities);
    int existingRoadCount = 0;
    for (List<Integer> pair : roadsAvailable) {
        int city1 = pair.get(0);
        int city2 = pair.get(1);
        if (!uf.find(city1, city2)) {
            uf.union(city1, city2);
            existingRoadCount++;
        }
    }

    PriorityQueue<Connection> pq = new PriorityQueue<>(numNewRoadsConstruct, (a, b) -> (
        Integer.compare(a.cost, b.cost)
    ));
    for (List<Integer> newRoad : costNewRoadsConstruct) {
        Connection cn = new Connection(newRoad.get(0), newRoad.get(1), newRoad.get(2));
        pq.offer(cn);
    }

    List<Connection> mst = new ArrayList<>();

    while (pq.size() > 0 && mst.size() + existingRoadCount < numTotalAvailableCities - 1) {
        Connection tmpCn = pq.poll();
        int city1 = tmpCn.city1;
        int city2 = tmpCn.city2;
        if (!uf.find(city1, city2)) {
            uf.union(city1, city2);
            mst.add(tmpCn);
        }
    }

    if (mst.size() + existingRoadCount < numTotalAvailableCities - 1)
        return -1;

    int sum = 0;

    for (Connection cn : mst){
        sum += cn.cost;
    }

    return sum;

   }

   class Connection {
       int city1;
       int city2;
       int cost;
       public Connection(int city1, int city2, int cost) {
           this.city1 = city1;
           this.city2 = city2;
           this.cost = cost;
       }

   }

   class UnionFind {
       private int[] ids;
       public UnionFind(int size) {
           this.ids = new int[size + 1];
           for (int i = 0; i < size + 1; i++) {
               this.ids[i] = i;
           }
       }
       public int root(int i ) {
           while (ids[i] ! = i) {
               i = ids[i];
           }
           return i;
       }
       public boolean find(int i, int j) {
           return root(i)==root(j);
       }
       public void union(int i, int j) {
           int rooti = root(i);
           int rootj = root(j);
           ids[rooti] = rootj;
       }
   }


}