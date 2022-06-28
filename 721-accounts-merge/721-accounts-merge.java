class Solution {
     /*
        
        used treeSet to auto sort strings
        
        3 Maps:
        
        owner - <Email, Name>
        parent - <Email, EmailParent> first email on accounts string will be parent, of remaining emails on same row
        union  - <Parent, TreeSet Emails> merge - parent, children, essentially getting rid of duplicate parentValues on parent map
        
        IMPORTANT!!!
        findParent function - you are a parent only if in parent map EMAIL == EMAIL
        //if findParent returns self then parent is found, else recursively go up parent map unti EMAIL == EMAIL;
        
        accounts = 
        [
            ["John",    "A@mail.com","john_newyork@mail.com"],
            ["John",    "A@mail.com","john00@mail.com"],
            ["Mary",    "mary@mail.com"],
            ["John",    "johnnybravo@mail.com"]
        ]
            
            Maps        key: email               value: parent
            
            
                      ------------- 1st loop ---------
                      create/setup parentEMail map and owner 1:1
               
            parents 
                      Email                       parentEmail
                     [A@mail.com]               [A@mail.com]
                     [john_newyork@mail.com]    [john_newyork@mail.com]
                     [A@mail.com"]              [A@mail.com"] -- row does not exist, put again, removed duplicate 
                     [john00@mail.com]          [john00@mail.com]
                     [mary@mail.com]            [mary@mail.com]
                     [johnnybravo@mail.com]     [johnnybravo@mail.com]
                     
            
            owner   
                       Email                    Name
                     [A@mail.com]              [John]
                     [john_newyork@mail.com]   [John]
                     [A@mail.com"]             [John]
                     [mary@mail.com]           [Mary]
                     [johnnybravo@mail.com]    [John]
                     
                     
                     ----------------- 2nd loop -------------------
                     Make first email on each row parent of rest of emails on the same row
                     1st merge happens
 
            parents
                        Email                    parentEmail
                     [A@mail.com]               [A@mail.com]
                     [john_newyork@mail.com]    [A@mail.com] -- replaced parent
                     [john00@mail.com]          [A@mail.com] -- replaced parent -- merged emails that shared A@mail
                     [mary@mail.com]            [mary@mail.com] 
            
            
                         ---- 3rd loop ----
                         
                          Key: parentEmail               value: TreeSet
        
            unions       
                        [A@mail.com]                [A@mail.com][john_newyork@mail.com][john00@mail.com]
                        [mary@mail.com]             [mary@mail.com]
                        [johnnybravo@mail.com]      [johnnybravo@mail.com]
            
            
            
            - - - - - - -- - - -- - - edge case to help understand the row by row merge - - - - - - -- - - -- 
            
            given:
            [["Gabe","  Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],
            ["Gabe","   Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]


            initial
            "Gabe0@m.co"    "Gabe0@m.co"
            "Gabe3@m.co"    "Gabe3@m.co"
            "Gabe2@m.co"    "Gabe2@m.co"
            "Gabe4@m.co"    "Gabe4@m.co"


            if first "Gabe3@m.co" has a parent, merge "Gabe3@m.co" childs with "Gabe0@m.co",
            its really doing  
                "Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"  +   "Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"
                
            parent map:
            "Gabe3@m.co" "Gabe0@m.co"  
            "Gabe2@m.co" "Gabe0@m.co"
            "Gabe0@m.co" 
        
          */  
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        //      email,  name
        HashMap<String, String> owner = new HashMap();
        //      email, email
        HashMap<String, String> parents = new HashMap();
        HashMap<String, TreeSet<String>> unions = new HashMap();
        
        for (List<String> a : accounts){
            for (int i=1; i<a.size(); i++){
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        
        
        //makes first email on each row as parentEmail of rest emails on same row
        for (List<String> a : accounts){
            
            /*
                will not work!!!
                
                String parent = a.get(1); 
                [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],
                ["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]
                
                
                "Gabe0@m.co"    "Gabe0@m.co"
                "Gabe3@m.co      "Gabe0@m.co
                Gabe2@m.co       Gabe2@m.co
                Gabe4@m.co         Gabe4@m.co
                
                you need to find parent for each new first element of new row
                
                the first email of each row is not always the parent
                First we merge ROWS then we set row emails to parent
            */
                                    //"A@mail.com"
            String parent = findParent(a.get(1), parents);
            for (int i=2; i<a.size(); i++){
                //flipped        john_newyork@mail.com      A@mail.com 
                parents.put(findParent(a.get(i), parents), parent);
            } 
        }
            
        //sort and merge parents
        for (List<String> acc : accounts){
                                //A@mail.com
            String parent = findParent(acc.get(1), parents);
            if (!unions.containsKey(parent)) unions.put(parent, new TreeSet<>());
            //add itself as well so start at 1
            for (int i=1; i<acc.size(); i++){
                //A@mail.com
                unions.get(parent).add(acc.get(i));
            }
        }
        
        //return answer List<List<String>> from unions map
        List<List<String>> res = new ArrayList();
        for (String parent : unions.keySet()){
            List<String> emails = new ArrayList(unions.get(parent));
            emails.add(0, owner.get(parent));
            res.add(emails);
        }
        
        return res;
       }
    
        private String findParent(String email, Map<String, String> parents){
            //if s is the parent return or else traverse the parent map
            String parent = parents.get(email);
            return parent == email ? email : findParent(parent, parents);
        }
}