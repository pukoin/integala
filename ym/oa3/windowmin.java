import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 12, 11, -5};
        int[] result = minWindow(arr, 2);
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static int[] minWindow(int[] nums, int k){
        if (nums == null || k <= 0)
            return new int[0];

        int n = nums.length;
        int[] r = new int[n-k+1];
        int ri = 0;

        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            // remove number out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1){
                q.poll();
            }

            // remove larger numbers in k range as they are useless
            while(!q.isEmpty() && nums[q.peekLast()] > nums[i]){
                q.pollLast();
            }

            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1){
                r[ri++] = nums[q.peek()];
            }
        }
        return r;
    }
} 