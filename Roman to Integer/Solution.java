class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;
        fillMap(map);

        for(int i = 0; i < s.length(); i++) {
            boolean negative = false;
            char key = s.charAt(i);
            int value = map.get(key);

            switch(key) {
                case 'I':
                    negative = i < s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X');
                    break;
                case 'X':
                    negative = i < s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C');
                    break;
                case 'C':
                    negative = i < s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M');
                    break;
            }

            sum += negative ? -value : value;
        }

        return sum;
    }

    public void fillMap(Map<Character, Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}