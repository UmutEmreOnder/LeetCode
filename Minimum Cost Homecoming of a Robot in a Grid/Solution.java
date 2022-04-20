class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int sum = 0;

        // Going up or down
        if(startPos[0] < homePos[0]) {
            for(int i = startPos[0] + 1; i <= homePos[0]; i++) {
                sum += rowCosts[i];
            }
        }
        else {
            for(int i = startPos[0] - 1; i >= homePos[0]; i--) {
                sum += rowCosts[i];
            }
        }


        // Going left or right
        if(startPos[1] < homePos[1]) {
            for(int i = startPos[1] + 1; i <= homePos[1]; i++) {
                sum += colCosts[i];
            }
        }
        else {
            for(int i = startPos[1] - 1; i >= homePos[1]; i--) {
                sum += colCosts[i];
            }
        }



        return sum;
    }
}