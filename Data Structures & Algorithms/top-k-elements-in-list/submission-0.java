class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // ==========================================
        // STEP 1: Count Frequencies
        // ==========================================
        // Map will store: Number -> Frequency
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // ==========================================
        // STEP 2: Configure the Min-Heap
        // ==========================================
        // We will store integer arrays of size 2 in the heap: [number, frequency]
        // The lambda (a, b) -> a[1] - b[1] tells the PriorityQueue to act as a 
        // Min-Heap comparing the frequencies (index 1 of our arrays).
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // ==========================================
        // STEP 3: Maintain Heap of Size K
        // ==========================================
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            
            // Push the current number and its frequency into the heap
            minHeap.offer(new int[]{number, frequency});
            
            // If the heap grows larger than k, extract the minimum (the root).
            // This ensures we ONLY keep the top k most frequent elements!
            if (minHeap.size() > k) {
                minHeap.poll(); // O(log k) operation
            }
        }

        // ==========================================
        // STEP 4: Extract the Results
        // ==========================================
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // poll() removes the root. We only care about the number (index 0).
            result[i] = minHeap.poll()[0]; 
        }
        
        return result;
    }
}