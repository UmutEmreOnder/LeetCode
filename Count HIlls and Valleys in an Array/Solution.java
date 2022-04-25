class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;

        for(int i = 1; i < nums.length - 1;) {
            int leftIndex = goLeft(nums, i, nums[i]);
            int rightIndex = goRight(nums, i, nums[i]);

            if((leftIndex != -1 && rightIndex != -1) &&
                    ((nums[i] < nums[leftIndex] && nums[i] < nums[rightIndex])
                    || (nums[i] > nums[leftIndex] && nums[i] > nums[rightIndex]))) {

                count++;

                // The reason for returning indexes rather than the value of that index is, after we found a hill or valley, there cant be any hill or valley
                // In the same range of i to RightIndex, because it is the exactly same valley or the hill of the this valley/hill, which will not be counted as a new one
                i = rightIndex;
            } else {
                i++;
            }
        }

        return count;
    }

    // Go left until find a number not equal to the current number and return its index, if such number not exist return -1
    public int goLeft(int[] nums, int i, int eq) {
        for(int j = i - 1; j >= 0; j--) {
            if(nums[j] != eq) {
                return j;
            }
        }

        return -1;
    }

    // Go right until find a number not equal to the current number and return its index, if such number not exist return -1
    public int goRight(int[] nums, int i, int eq) {
        for(int j = i + 1; j < nums.length; j++) {
            if(nums[j] != eq) {
                return j;
            }
        }

        return -1;
    }
}