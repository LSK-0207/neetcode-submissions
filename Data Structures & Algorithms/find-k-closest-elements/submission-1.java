class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left =0;
        int right = arr.length-1;
        List<Integer> res = new ArrayList<>();
        if(arr[right] < x) {
            left=right-k+1;
            for (int i =left; i<arr.length; i++){
                res.add(arr[left]);
                left++;
            }
            return res;
        }

        while((right - left + 1) > k){
            int distFromLeft = Math.abs(arr[left]-x);
            int distFromRight = Math.abs(arr[right]-x);

            if(distFromLeft == distFromRight){
                right--;
            } else if(distFromLeft> distFromRight) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = left; i<= right; i++){
            res.add(arr[i]);
        }

        return res;
    }
}