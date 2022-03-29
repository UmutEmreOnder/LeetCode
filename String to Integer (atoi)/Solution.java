class Solution {
    public int myAtoi(String s) {
        int index = 0;
        long number = 0;
        boolean numeric = false;
        boolean sign = false;
        boolean negative = false;

        while(index < s.length() && (s.charAt(index) == '.' || s.charAt(index) == ' ' || Character.isLetter(s.charAt(index)))) {
            if(s.charAt(index) == ' ') index++;
            else return 0;
        }

        while(index < s.length()) {
            if (!(Character.isDigit(s.charAt(index))) && (sign || numeric)) {
                return returnAnswer(number, negative);
            }

            if (s.charAt(index) == '-' || s.charAt(index) == '+') {
                sign = true;
                if (s.charAt(index) == '-') {
                    negative = true;
                }
            }

            else {
                numeric = true;
                number *= 10;
                number += (s.charAt(index) - '0');
                if(negative) {
                    if (-number < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                }
                else {
                    if (number > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                }
            }

            index++;
        }

        return returnAnswer(number, negative);
    }

    public static int returnAnswer(long number, boolean negative) {
        return negative ? (int) -number : (int) number;
    }
}