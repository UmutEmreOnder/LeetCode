class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) res[head++] = nums[i];
            else res[tail--] = nums[i];
        }

        return res;
    }
}