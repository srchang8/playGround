class Solution {
    public boolean isPalindrome(String s) {
        
        
        int left=0;
        int right=s.length()-1;
//         boolean noChar = false;
        
//         for (int i=0; i<s.length(); i++){
//             if (Character.isLetterOrDigit(s.charAt(i))) noChar = false;
//         }
//         if (noChar) return false;
        
        while (left < right){
            
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) left++;
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) right--;
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        
        return true;
    }
}