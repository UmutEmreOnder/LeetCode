class Solution {
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for(int i = 0; i< nums.length; i++){
            if(nums[i] > firstMax){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            }

            else if(nums[i] > secondMax && nums[i] < firstMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            }

            else if(nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
            }
        }

        // If 3rd max is equal to minval, this means we don't have 3 distinctive numbers. Return the firstMax (max).
        return thirdMax != Long.MIN_VALUE ? (int) thirdMax : (int) firstMax;
    }
}