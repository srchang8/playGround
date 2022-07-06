/*
    
    Exmaples 1:
    
        /a/b/c
        
        root ""  Children
                   a, FileNode  Children
                                    b,     FileNode
                   
              
    Exmaples 2: 
    
        /a/b/c
        /a/b/d
        
        
        root ""  Children
                   a, FileNode  Children
                                    b,   FileNode
                                    c,   FileNode  
                                    
                                    
                                    
    Edited Test case:
    
    ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
    [[],["/"],["/a/b/c"],["/a/b/d","hello"],["/a/b"],["/a/b/d"]]
          
    */


public class FileSystem {
    private FileNode root;

    public FileSystem() {
        root = new FileNode("");
    }

    public List<String> ls(String path) {
        return findNode(path).getList();
    }

    public void mkdir(String path) {
        findNode(path);
    }

    public void addContentToFile(String filePath, String content) {
        findNode(filePath).addContent(content);
    }

    public String readContentFromFile(String filePath) {
        return findNode(filePath).getContent();
    }


    
    //-- private method section --//
    
    // main algorithm
    // 1. return the the last fileNode
    // 2. creates path and fileNodes if they dont exist
    private FileNode findNode(String path){
        String[] files = path.split("/");

        FileNode cur = root;
        for(String file : files){
            
            //skip empty dir
            if(file.length() == 0) continue;

            cur.children.putIfAbsent(file, new FileNode(file));
            cur = cur.children.get(file);

            //cant traverse if its a file
            if(cur.isFile()) break;
        }

        return cur;
    }

   // Private class
   private class FileNode{
       // answer should be in lexicographic order so we use treemap
       //order is based on key for treemap
        private TreeMap<String, FileNode> children;
        private StringBuilder fileContent;
        private String name;

        public FileNode(String name) {
            children = new TreeMap<>();
            fileContent = new StringBuilder();
            this.name = name;
        }

        public String getContent(){
            return fileContent.toString();
        }

        public String getName(){
            return name;
        }

        public void addContent(String content){
            fileContent.append(content);
        }

        public boolean isFile(){
            return fileContent.length() > 0;
        }

        public List<String> getList(){
            List<String> list = new ArrayList<>();
            if(isFile()){
                list.add(getName());
            }else{
                list.addAll(children.keySet());
            }

            return list;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */