class Solution {
    public String largestTimeFromDigits(int[] arr) {
        // Permute function from StackoverFlow
        // https://stackoverflow.com/a/40176683/14715055 - Thanks to qtopierw
        List<List<Integer>> results = permute(arr);

        int max = -1;

        for(int i = 0; i < results.size(); i++) {
            int num = 0;
            for(int j = 0; j < 4; j++) {
                num *= 10;
                num += results.get(i).get(j);
            }

            // conditions of being 24-hours formatted time, max of them will be returned
            if(num < 2400 && num % 100 < 60 && num > max) max = num;
        }

        // If no found, return empty string
        if(max == -1) return "";


        StringBuilder sb = new StringBuilder(String.valueOf(max));
        int count = 0;
        // Add 0`s to the front until 4 length
        while(sb.length() != 4) {
            sb.insert(0, "0");
        }

        // Return with semicolon
        return sb.toString().substring(0,2) + ":" + sb.toString().substring(2,4);
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int size = factorial(nums.length);

        List<Integer> seq = new ArrayList<Integer>();
        for(int a:nums){
            seq.add(a);
        }
        list.add(seq);

        for(int i = 0;i < size - 1;i++){
            seq = new ArrayList<Integer>();
            nextPermutation(nums);
            for(int a:nums){
                seq.add(a);
            }
            list.add(seq);
        }
        return list;
    }


    int factorial(int n){
        return (n==1)?1:n*factorial(n-1);
    }

    void nextPermutation(int[] nums){
        int i = nums.length -1;

        while(i > 0 && nums[i-1] >= nums[i]){
            i--;
        }

        if(i==0){
            reverse(nums,0,nums.length -1 );
        }else{
            int j = i;

            while(j < nums.length && nums[j] > nums[i-1]){
                j++;
            }

            int tmp = nums[i-1];
            nums[i-1] = nums[j-1];
            nums[j-1] = tmp;
            reverse(nums,i,nums.length-1);
        }
    }

    void reverse(int[] arr,int start, int end){
        int tmp;
        for(int i = 0; i <= (end - start)/2; i++ ){
            tmp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i ] = tmp;
        }
    }
}