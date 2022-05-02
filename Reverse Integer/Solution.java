class Solution {
    public int reverse(int x) {
        boolean negative = x < 0;
        x = negative ? -x : x;

        int res = 0;
        int beforeRes = 0;

        while(x > 0) {
            res *= 10;
            res += x % 10;

            // If not equal, there is overflow, integer limits exceeded
            if(beforeRes != (res - x % 10) / 10) return 0;

            beforeRes = res;
            x /= 10;
        }

        return negative ? -res : res;
    }
}