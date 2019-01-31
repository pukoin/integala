public List<Integer> GetSum(List<Integer> A, int k) {
    ArrayList<Integer> result  = new ArrayList<>();
    if (A == null || A.size() == 0 || k <= 0) return result;
    int count = 0;
    for (int i = 0; i < A.size(); i++) {
        count++;
        if (count >= k) {
            int sum = 0;
            for (int j = i; j >= i - k + 1; j--) {
                sum += A.get(j);
            }
            result.add(sum);
        }
    }
    return result;
 }

 public class SumOfWindow {
    public int[] Solution(int[] array, int k) {
        if (array == null || array.length < k || k <= 0)    return null;
        int[] rvalue = new int[array.length - k + 1];
        for (int i = 0; i < k; i++)
            rvalue[0] += array[i];
        for (int i = 1; i < rvalue.length; i++) {
            rvalue[i] = rvalue[i-1] - array[i-1] + array[i+k-1];
        }
        return rvalue;
    }
}