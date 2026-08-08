class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = left + 1;
        while (right < nums.length) {
            if (nums[left] == val) {
                if (nums[right] == val) {
                    right++;
                } else {
                    nums[left] = nums[right];
                    nums[right] = val;
                    left++;
                    right = left + 1;
                }
            } else {
                left++;
                right++;
            }
        }
        int k =0;
        for(int ele: nums){
            if(ele==val){
                break;
            }
            k++;
        }
        return k;
    }
}