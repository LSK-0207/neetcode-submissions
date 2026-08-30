class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int r = 0;
        for (int l = 1; l<nums.length; l++){
            if(nums[r] != nums[l]){
                r++;
                nums[r] = nums[l];
            }
        }
        return r+1;
    }
}