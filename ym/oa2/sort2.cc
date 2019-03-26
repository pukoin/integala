class Solution {
public:
    /**
     * @param A: an integer array
     * @return: nothing
     */
    void sortIntegers2(vector<int> &A) {
        // write your code here
        quickSort(A, 0, A.size() - 1);
    }
    
private:
    void quickSort(vector<int> &A, int l, int r) {
        if (l >= r) {
            return;
        }
        
        int i = l, j = r;
        int pivot = A[(l + r) / 2];
        
        while (i <= j) {
            while (i <= j && A[i] < pivot) {
                i++;
            }
            while( i <= j && A[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(A, i, r);
        quickSort(A, l, j);
    }
};