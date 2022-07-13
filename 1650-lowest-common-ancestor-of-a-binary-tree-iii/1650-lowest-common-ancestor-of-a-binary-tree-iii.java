/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

/*
        Time: o(n)
        Space: o(1)
    
    */

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        
        //var to make cycle
        Node pStart = p;
        Node qStart = q;
        
        while (p != q){
            
            //keep running until you reach the end, then start other track, to create cycle
            p = (p == null) ? qStart : p.parent;
            q = (q == null) ? pStart : q.parent;
        }
        
        return p;
    }
}


/*
    parent is already given so no need to do map
        
    IMPORTANT: p & q definitely exist in tree

    A + x + B == B + x + A 

    fast and slow runner
    create a cycle between p and q 
        
             p        
             6 -> 5 -> 3
        4 -> 2 ->
        q
        
        A + B + x = x + B + A
        
        p distance + q distance = intersection in a cycle

    if p runs the same distance as q, they will intersect,  assuming there is a cycle
create cycle by making p and q run on each others track
explanation https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!

*/


//note p and q are guaranteed not null, so answer is always exist
// class Solution {
//     public Node lowestCommonAncestor(Node p, Node q) {
        
//         List<Node> pAncest = new ArrayList();
//         while (p != null){
//             pAncest.add(p);
//             p = p.parent;
//         }
     
//         //return the first common ancestor found
        
//         while (q != null){
            
//             for (Node pNode : pAncest){
//                 if (pNode == q) return q;
//             }
//             q = q.parent;
//         }
        
        
//         //likely will not reach this line
//         return p;
//     }
// }