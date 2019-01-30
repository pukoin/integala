import java.util.*;


public class MazeSolution {
    public static int minSteps(int[][] maze, int[] start, int[] dest) {
        int[][] steps = new int[maze.length][maze[0].length];
        for (int[] step: steps)
            Arrays.fill(step, Integer.MAX_VALUE);
        steps[start[0]][start[1]] = 0;
        depthFirstSearch(maze, start, steps);
        return steps[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : steps[dest[0]][dest[1]];
    }

    public static void depthFirstSearch(int[][] maze, int[] start, int[][] steps) {
        int[][] directions={{0,1}, {0,-1}, {-1,0}, {1,0}};
        for (int[] direction: directions) {
            int x = start[0] + direction[0]; // x-axis for next position
            int y = start[1] + direction[1]; //y-axis for next position
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += direction[0];
                y += direction[1];
                count++;
            }
            if (steps[start[0]][start[1]] + count < steps[x - direction[0]][y - direction[1]]) {
                steps[x - direction[0]][y - direction[1]] = steps[start[0]][start[1]] + count;
                depthFirstSearch(maze, new int[]{x - direction[0],y - direction[1]}, steps);
            }
        }
    }

    public static void main(String[] args){
        int[][] input = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
        };

        int[] start = {0, 3};
        int[] dest = {4, 0};
        int steps = minSteps(input, start, dest);
        System.out.println(steps);
    }
}