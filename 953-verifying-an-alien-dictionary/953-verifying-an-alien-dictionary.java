class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] dict = new int[26];
        for (int i=0; i<order.length(); i++){
            dict[order.charAt(i) - 'a'] = i;
        }
        
        for (int i=0; i<words.length-1; i++){
            if (compare(words[i], words[i+1], dict) > 0) return false;
            
        }
        
        return true;
        
    }
    
    public int compare(String w1, String w2, int[] dict){
        
        int l1 = w1.length();
        int l2 = w2.length();
        int min = Math.min(l1,l2);
        
        for (int i=0; i<min; i++){
            int c1 = w1.charAt(i) - 'a';
            int c2 = w2.charAt(i) - 'a';
            
            if (dict[c1] != dict[c2]) return dict[c1] - dict[c2];
        }
        
        return l1 == min ? -1 : 1;
    }
}