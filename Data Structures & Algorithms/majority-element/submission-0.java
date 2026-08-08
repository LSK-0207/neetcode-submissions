class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele: nums){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > (nums.length)/2){
                return entry.getKey();
            }
        }
        return 0;
    }
}