class MyHashMap {
    private static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    public int hash(int key){
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        } 
        
        Node cur = buckets[index];
        while (true) {
            // Check if the current node has the key (this covers the head node too)
            if (cur.key == key) {
                cur.value = value; // Update existing key
                return;
            }
            // If we reached the end, append the new node
            if (cur.next == null) {
                cur.next = new Node(key, value);
                return;
            }
            cur = cur.next;
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        Node cur = buckets[index];
        
        // Traverse the entire list, including the head node
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        
        return -1; // Key not found
    }
    
    public void remove(int key) {
        int index = hash(key);
        
        if (buckets[index] == null) return;
        
        // Special case: The key to remove is at the head of the linked list
        if (buckets[index].key == key) {
            buckets[index] = buckets[index].next;
            return;
        }
        
        Node cur = buckets[index];
        
        // General case: The key to remove is somewhere in the middle or end
        while (cur.next != null) {
            if (cur.next.key == key) {
                // Bypass the deleted node
                cur.next = cur.next.next; 
                return; // Stop searching once removed
            }
            cur = cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */