/**
 * To compare 1D array by it`s power (number of 1 it has) I consturcted a new class that implements Comparable interface
 * The problem wants the indexes of the weakest k array, so we need to store their index and compare them by their power
 */
class comparableArray implements Comparable<comparableArray> {
    private int[] row;
    public int sum;
    public int index;

    // Constructor
    public comparableArray(int[] row, int index) {
        this.row = row;
        this.index = index;
        this.sum = count();
    }

    /**
     * Finding the first index of 0, it is guaranteed that all 1`s comes before 0`s
     * First index of 0 = Count of 1`s
     * O(logn)
     */

    public int count() {
        int lo = 0;
        int hi = this.row.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }

    @Override
    public int compareTo(comparableArray otherArray) {
        return this.sum < otherArray.sum ? -1 : this.sum > otherArray.sum ? 1 : this.index < otherArray.index ? -1 : 1;
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // To store them on a ascending list, we need default priorityQueue, since its size is fixed we can declare its size
        PriorityQueue<comparableArray> rowList = new PriorityQueue<>(mat.length);
        /**
         * PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
         * This question can be cone with that pq, this solution and my solution are litteraly same.
         * I chose this way to make it more understandable when reviewed
         */

        for(int i = 0; i < mat.length; i++) { // O(m), m is the length of mat
            comparableArray newArray = new comparableArray(mat[i], i);  // O(logn)
            rowList.add(newArray); // O(logn)
        }

        // Putting the first k elements` indexes to an array and return it
        int[] answer = new int[k];

        for(int i = 0; i < k; i++) { // O(k)
            answer[i] = rowList.poll().index;  // O(1)
        }

        return answer;

        // Time Complexity = O(mlogn)
    }
}