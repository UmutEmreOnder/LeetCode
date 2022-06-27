class Solution {
    public int minPartitions(String n) {
        /* The answer is max digit of n.
           To find this, the brute force algorithm is scanning the n and find the max
           But this solution depends on n's length.
           1111111111111111111119 <- If n is something like this, it will be worst case of the solution

           Better aproach is checking if n contains 9, 8, 7, ..., 1 <- If any of them is in n, return it.
           If not then return 0
        */

        for(int i = 9; i > 0; i--) {
            if(n.contains(String.valueOf(i))) {
                return i;
            }
        }

        return 0;
    }
}