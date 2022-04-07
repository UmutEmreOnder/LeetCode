class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return 1;

        int n = stones.length;
        quickSort(stones, 0, n - 1);

        /**
         At the end of the game, there is at most one stone left.
         I use 0 as a represent of destoryed stone
         So, since (last - 1)th element is not equal to 0 game can be played
         **/

        while(stones[n - 2] != 0) {
            int y = stones[n - 1];
            int x = stones[n - 2];

            /**
             Since I use 0 as destroyed stone, I dont need to check whether y == x or not.
             If it they are equal, (n-1)th index will be destroyed = set to 0 = y - x
             If they are not eequal, (n-1)th index will be set to y-x
             In both case, (n-1)th index will be set to y-x
             **/

            stones[n - 1] = y - x;
            stones[n - 2] = 0;

            quickSort(stones, 0, n - 1);
        }

        /**
         Result is the weight of the last element
         If every stone is destroyed, result is 0, which is stones[n-1]
         If not, result is the weight of last standing stone, which is stones[n-1]
         **/
        return stones[n - 1];
    }

    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}