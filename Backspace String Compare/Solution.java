class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();

        int skip = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '#') {
                skip++;
            }

            else {

                if(skip == 0) {
                    sb.insert(0, s.charAt(i));
                }

                else {
                    skip--;
                }
            }
        }

        skip = 0;

        for(int i = t.length() - 1; i >= 0; i--) {
            if(t.charAt(i) == '#') {
                skip++;
            }

            else {

                if(skip == 0) {
                    tb.insert(0, t.charAt(i));
                }

                else {
                    skip--;
                }
            }
        }

        return tb.toString().equals(sb.toString());

    }
}