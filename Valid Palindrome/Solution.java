/*

The brute force solution: (It tooks 900ms to solve)

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;

            i++;
            j--;
        }

        return true;
    }
}
*/




class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {

            if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            else {
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;

                i++;
                j--;
            }

        }

        return true;
    }
}