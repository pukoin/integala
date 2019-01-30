import java.util.*;


class CutOffTrees {
    static int[][] directions = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        int rowSize= forest.size();
        int colSize = forest.get(0).size();

        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (forest.get(i).get(j) > 1) {
                    pQueue.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }

        int[] start = new int[2];
        int totalSteps = 0;
        while (!pQueue.isEmpty()) {
            int[] tree = pQueue.poll();
            int step = minStep(forest, start, tree, rowSize, colSize);

            if (step < 0) return -1;
            totalSteps += step;

            start[0] = tree[0];
            start[1] = tree[1];
        }

        return totalSteps;
    }

    private static int minStep(List<List<Integer>> forest, int[] start, int[] tree, int rowSize, int colSize) {
        int step = 0;
        boolean[][] visited = new boolean[rowSize][colSize];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;

                for (int[] dir : directions) {
                    int nextRow = curr[0] + dir[0];
                    int nextCol = curr[1] + dir[1];
                    if (nextRow < 0 || nextRow >= rowSize|| nextCol < 0 || nextCol >= colSize
                            || forest.get(nextRow).get(nextCol) == 0 || visited[nextRow][nextCol]) continue;
                    queue.add(new int[] {nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
            step++;
        }

        return -1;
    }

    public static void main(String[] args){
        int[][] input1 = {
                {1, 2, 3},
                {0, 0, 4},
                {7, 6, 5}
        };

        int[][] input2 = {
                {1, 2, 3},
                {0, 0, 0},
                {7, 6, 5}
        };
        int[][] input3 = {
                {2, 3, 4},
                {0, 0, 5},
                {8, 7, 6}
        };

        int[][] input = input1;

        List<List<Integer>> forest = new ArrayList<List<Integer>>();

        for (int i = 0; i < input.length; i++){
            List<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j < input[i].length; j++){
                tmp.add(input[i][j]);
            }
            forest.add(tmp);
        }

        int steps = cutOffTree(forest);
        System.out.println(steps);
    }
}