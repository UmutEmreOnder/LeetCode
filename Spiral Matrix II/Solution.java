class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int num = 1, startRow = 0, startColumn = 0;

        while(num <= n*n) {
            /**
             * Reason of changing startColumn and startRow after every loop is, after the loops are finished,
             * the starting places are more or less than where they should be.
             * Because in each loop, first the values are changed and then the correctness is checked.
             * For example n = 5, startRow = 0, startColumn = 5 at the end of the first loop. But our array has 4 indexes.
             */

            // Going right
            for(; startColumn < n; startColumn++) {
                // If value is equal to zero, it is not set before.
                if(matrix[startRow][startColumn] == 0) {
                    matrix[startRow][startColumn] = num++;
                }
                else {
                    break;
                }
            }

            // Going down after go rigth, so we add 1 to row
            startColumn--; startRow++;

            // Going down
            for(; startRow < n; startRow++) {
                if(matrix[startRow][startColumn] == 0) {
                    matrix[startRow][startColumn] = num++;
                }
                else {
                    break;
                }
            }

            // Going left after going down, so we substract 1 from column
            startRow--; startColumn--;

            // Going left
            for(; startColumn >= 0; startColumn--) {
                if(matrix[startRow][startColumn] == 0) {
                    matrix[startRow][startColumn] = num++;
                }
                else {
                    break;
                }
            }

            // Going up after going left, so we substract 1 from row
            startColumn++; startRow--;

            // Going up
            for(; startRow >= 0; startRow--) {
                if(matrix[startRow][startColumn] == 0) {
                    matrix[startRow][startColumn] = num++;
                }
                else {
                    break;
                }
            }

            // Going right after going up, so we add 1 to column
            startRow++; startColumn++;
        }


        return matrix;
    }
}