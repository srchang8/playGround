/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    
    /*
        Time: o(n)
        Space: o(1)
    
    */
    public Node copyRandomList(Node head) {
        
        if (head == null) return null;

        Node iter = head;
        //clone next to each other 1->1c  ->  2->2c  ->  3->3c
        while (iter != null){
            
            Node clone = new Node(iter.val);
            clone.next = iter.next;
            iter.next = clone;
            iter = clone.next;
        }
        

        iter = head;
        Node cloneHead = iter.next;
        
        //assign clone random to real random.next is pointing to
        //we are not pointing to real random node, we should point to the cloned one
        // which is real.random.next
        while (iter != null){
               
            Node clone = iter.next;
            Node real = iter;
            
            if (real.random != null){
                //real.random.next is the clone
                clone.random = real.random.next;
            }
            
            iter = clone.next;
        }
        
        iter = head;
        
        //seperate the clone list and real list
        while (iter != null){
            
            Node clone = iter.next;
            
            //reconnect real
            iter.next = clone.next;

            //reconnect clone, avoid null.next on last node
            if (clone.next != null){
                clone.next = clone.next.next;    
            }
            
            
            iter = iter.next;
        }
        
        
        
        return cloneHead;
    }
}