class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        int left = (int) Math.pow(10, (int) Math.log10(x));
        int right = 1;

        while(left >= right) {
            if((x / left % 10) != (x / right % 10)) return false;

            left /= 10;
            right *= 10;
        }

        return true;
    }
}