class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = -1;

        for(String sentence : sentences) {
            max = Math.max(max, countSpace(sentence) + 1);
        }

        return max;
    }

    public int countSpace(String sentence) {
        int count = 0;

        for(int i = 0; i < sentence.length(); i++) {
            if(sentence.charAt(i) == ' ') count++;
        }

        return count;
    }
}