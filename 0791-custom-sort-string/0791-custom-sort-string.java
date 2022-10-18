class Solution {
    
    //count
    //go through order and append
    //append things not in order
    
    public String customSortString(String order, String s) {
        
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap();
        
        //count s chars
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //append chars that exist in string order
        for (int i=0; i<order.length(); i++){
            
            char c = order.charAt(i);
            
            //s might have chars that order doesnt has
            if (map.containsKey(c)){
                int freq = map.get(c);

                for (int j=0; j<freq; j++){
                    sb.append(c);
                }
                map.remove(c);
            }
        
        }
        
        //append char that only exist in string s
        for (Character key : map.keySet()){
            int freq = map.get(key);
            for (int i=0; i<freq; i++){
                sb.append(key);
            }
        }
        
        
        return sb.toString();
    }
}