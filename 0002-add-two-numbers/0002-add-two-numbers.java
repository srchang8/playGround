/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry =0, sum=0;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        
        while (l1 != null || l2 !=null){
            
            if ( l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += carry;
            
            if (sum > 9){
                carry = 1;
                sum = sum%10;
            }else{
                carry = 0;
            }
            
            ListNode node = new ListNode(sum);
            head.next = node;
            head = node;
            
            sum =0;

        }
        
        if (carry != 0){
            ListNode node = new ListNode(1);
            head.next = node;
        }
        
        return dummy.next;
    }
}