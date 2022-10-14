class Solution {
    
    
    /*
        IMPORTANT: trick because there can be duplicate elements ex:
        
        [3,3,5]
            0
            
         
         head is already pointing to self, max = 1, min also = 1
        [1]
         2
    
    */
    
    //head = 3
    //1,3,4 ----- 2 inside
    //1,3,4 ----- 5 outside
    
    //find max
    //min = max.next
    //insert outside min-max
    //insert inside min-max
    /*
    
    IMPORTANT: check outside first to make implementation much easier!!
    
    Key: since sorted, once number decreaes, we have found max and min
    
    3 -> 4 -> 1    insertVal = 2
    
    biggest = 4
    smallest = 1
    
    1 -> 3 -> 4
    
    
    
    empty
    
    */
    public Node insert(Node head, int insertVal) {
        
        //create cycle if only 1
        if (head == null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        
        //find max to get min
        Node max = head;

        
        while (max.next != head && max.val <= max.next.val){
            max = max.next;
        }
        Node min = max.next;
        
        //insert outside of min-max 
        //can be on either side
        //Insert-- 1--3--4 -- Insert
        //Insert-- 1 -- Insert
        if (insertVal <= min.val || insertVal >= max.val){
            max.next = new Node(insertVal, min);
        }else{
            //insert inside of min-max
            
            //find first val < insertVal        or keep iterating
            while (min.next.val <= insertVal) min = min.next;
            
            //insert the val
            min.next = new Node(insertVal, min.next);
        }
        
        return head;
    }
}









