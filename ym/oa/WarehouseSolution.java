import java.util.*;


public class WarehouseSolution {

    public static Point globalOrigin = null;
    public static Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here

        globalOrigin = origin;
        PriorityQueue<Point> pQueue = new PriorityQueue<Point>(k, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                int diff = getDistance(b, globalOrigin) - getDistance(a, globalOrigin);
                if(diff == 0) {
                    diff = b.x - a.x;
                }
                if (diff == 0) {
                    diff = b.y - a.y;
                }
                return diff;
            }
        });

        for (Point pt : points) {
            pQueue.add(pt);
            if (pQueue.size() > k)
                pQueue.poll();
        }


        Point[] result = new Point[k];
        while (k - 1 >= 0) {
            result[--k] = pQueue.poll();
        }

        return result;
    }

    public static int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public static class Point {
        int x;
        int y;

        Point(){
            this.x = 0;
            this.y = 0;
        }

        Point(int a , int b){
            this.x = a;
            this.y = b;
        }
    }

    public static void main(String[] args){
        int[][] input = {
                {4, 6}, {4, 7}, {4, 4}, {2, 5}, {1, 1}
        };
//        int[] origin = {0, 0};
        int k = 3;

//        List<Point> pointsL = new ArrayList<Point>();
//        for (int[] p: input){
//            Point tmp = new Point(p[0], p[1]);
//            pointsL.add(tmp);
//        }

        Point[] points = new Point[5];
        for (int i = 0; i < input.length; i++){
            points[i] = new Point(input[i][0], input[i][1]);
        }


//        for (Point p: points){
//            System.out.println(Integer.toString(p.x) + ' ' + Integer.toString(p.y));
//        }

        Point origin = new Point(0, 0);

        Point[] result = kClosest(points, origin, k);

        for (Point p: result){
            System.out.println(Integer.toString(p.x) + ' ' + Integer.toString(p.y));
        }

    }


}