class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for(String str:strs){
            char[] arr=str.toCharArray(); 
            Arrays.sort(arr);
            String sortedS=new String(arr);
            ans.putIfAbsent(sortedS, new ArrayList<>());
            ans.get(sortedS).add(str);
        }
        return new ArrayList<>(ans.values());
    }
}
