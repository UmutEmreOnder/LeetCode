class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int index = -1;
        int indexLeft, indexRight;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                index = mid;
                break;
            }

            else if (nums[mid] >= target) {
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }

        indexRight = indexLeft = index;
        int[] answer = {-1, -1};

        if (index == -1) return answer;

        try {
            while(nums[indexLeft - 1] == target) {
                indexLeft--;
            }
        }
        catch (Exception ignored) {}

        try {
            while(nums[indexRight + 1] == target) {
                indexRight++;
            }
        }
        catch (Exception ignored) {}

        answer[0] = indexLeft;
        answer[1] = indexRight;

        return answer;
    }
}