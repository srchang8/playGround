/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*

    1,2,3,4,5,6
    
    1,6,2,5,3,4
    
    1,2,3, 4,5
    1,2,3  5,4
    
    
    
    dummy -> 1 -> 5 -> 2 -> 4 -> 3
                                 D
   null <- 1 <- 2 <- 3 null
    
    1. find half
    2. reverse starting from half
    3. two pointer tie them together
    
    
*/
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        
        ListNode l1 = head;
        
        ListNode l2 = reverse(slow.next);
        slow.next = null;
        
        //1,2,3, 4,5
        //
        while (l1 != null || l2 != null){
            
            if (l1 != null){
                dummy.next = l1;
                l1 = l1.next;
                dummy = dummy.next;
            }
            
            
            if (l2 != null){
                dummy.next = l2;
                l2 = l2.next;
                dummy = dummy.next;
            }
        }
        
        
    }
    
    public ListNode reverse(ListNode head){
        
        ListNode curr = head;
        ListNode future = head;
        ListNode bef = null;
        
        while (curr != null){
            future = future.next;
            curr.next = bef;
            bef = curr;
            curr = future;
        }
        
        return bef;
    }
}



