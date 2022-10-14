
class Solution {
    
    //Question clarification - a distance to b, b distance to c, in ASCII table
    //similar to group anagrams
    //Map<unique word ID, List<words> with same unique word ID
    //corner case az,ba - need to add 26
     /*
                 c    b
    abc = "1,1"  99 - 98
    a = 97
    
    edge case
    bac = 97 - 98 = -1 + 26
    
    */
    
    public List<List<String>> groupStrings(String[] strings) {
        
        HashMap<String, List<String>> map = new HashMap();
        
        for (int i=0; i<strings.length; i++){
            String key = getKey(strings[i]);
            
            if (!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(strings[i]);
        }
     
        return new ArrayList(map.values());
    }
    
    public String getKey(String s){
        //a b c
        StringBuilder key = new StringBuilder();
        
        for (int i=1; i<s.length(); i++){
            
            int diff = s.charAt(i) - s.charAt(i-1);
            if (diff < 0){
                diff += 26;
            }
            key.append(diff);
            key.append(",");
        }
        
        
        return key.toString();
    }
}
