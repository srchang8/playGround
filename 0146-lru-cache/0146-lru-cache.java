class LRUCache {
    
    //head newNode oldNode tail
    //LRU = rack of clothes, used clothes in front, lest used clothes in back, least used gets removed
    //Algo: use a queue and just keep moving to front when used, add new to front,remove last in queue
    //need hashmap so we can look up the node at O(1);
    //double linkedlist is cleaner than singly, singly we have to manage before node
    //hashmap to know if new node exist already at O(1) speed, bonus we get the curr capacity as well
    
    /*
        Time: 
            put = o(1)
            get = o(1)
        
        Space:
            o(capacity)
            
            
            IMPORTANT its a cycle doubly linkedlist
            head -> tail
    
    
    
    
    
- - -  - --   --  - Test Cases - - - - -- - - -- - -- - -- -
    ["LRUCache","put","put","get","put","get","put","get","get","get"]
    [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    ["LRUCache","put","get"]
    [[1],[2,1],[2]]
    ["LRUCache","put","put","get","put","get","put","get","get","get"]
    [[2],[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    
    */
    
    class CacheNode{
        int val;
        int key;
        CacheNode next;
        CacheNode prev;
        
        CacheNode(int key, int value){
            this.val = value;
            this.key = key;
        }
    }
    
    //given int Key, node
    HashMap<Integer, CacheNode> map = new HashMap();
    CacheNode head = new CacheNode(-1, -1);
    CacheNode tail = new CacheNode(-1, -1);
    int cacheLim = 0;

    //given
    public LRUCache(int capacity) {
        this.cacheLim = capacity;
        head.next = tail;
        tail.prev = head;
        
    }
    //given
    public int get(int key) {
        
        if (!map.containsKey(key)) return -1;
        
        CacheNode node = map.get(key);
        
        moveToFront(node);
        return node.val;
        
    }
    //given
    public void put(int key, int value) {
        
        if (map.containsKey(key)){
            CacheNode node = map.get(key);
            node.val = value;
            node.key = key;
            moveToFront(node);
        }else{
            CacheNode node = new CacheNode(key, value);
            map.put(key, node);
            addNode(node);
            
            if (map.size() > cacheLim){
                CacheNode lastN = removeTailNode();
                map.remove(lastN.key);
            }
        }
        
//         if (!map.containsKey(key)){
//             CacheNode node = new CacheNode(value, key);
//             map.put(key, node);
//             addNode(node);
//             if (map.size() > cacheLim){
// 				CacheNode nodeRemove = removeTailNode();
//                 map.remove(nodeRemove.key);
                
//             }
//         }else{
//             CacheNode updateNode = map.get(key);
//             updateNode.val = value;
// 			updateNode.key = key;
//             moveToFront(updateNode);
//         }
        
    }
    
    //helpers start here
    public void addNode(CacheNode node){
        
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
        
    }
    
    public void removeNode(CacheNode node){
        
        CacheNode before = node.prev;
        CacheNode after = node.next;
        
        before.next = after;
        after.prev = before;
        
    }
    
    public CacheNode removeTailNode(){
        CacheNode node = tail.prev;
		removeNode(tail.prev);
		return node;
    }
    
    public void moveToFront(CacheNode node){
        removeNode(node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */