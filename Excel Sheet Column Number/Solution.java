class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for(int i = 0; i < columnTitle.length(); i++) {
            result *= 26;
            result += charToInt(columnTitle.charAt(i));
        }

        return result;
    }

    public int charToInt(char c) {
        return c - 'A' + 1;
    }
}