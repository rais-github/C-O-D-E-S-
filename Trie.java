class TrieNode{
    TrieNode [] childNode;
    boolean wordEnd;
    public TrieNode()
    {
        this.childNode = new TrieNode[26];
        for(int i = 0 ; i <26;i++)
        {
            childNode[i]=null;
        }
        this.wordEnd = false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currentNode = root;
        for(int i = 0 ; i < word.length() ; i++)
        {
            int index = word.charAt(i)-'a';
            if(currentNode.childNode[index]==null)
            {
                currentNode.childNode[index] = new TrieNode();
                currentNode = currentNode.childNode[index];
            }
            else currentNode = currentNode.childNode[index];
        }
        currentNode.wordEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode currentNode = root;
        for(int i = 0 ;  i < word.length() ; i++)
        {
            int index = word.charAt(i)-'a';
            if(currentNode.childNode[index]!=null)
            {
                currentNode=currentNode.childNode[index];
            }
            else return false;
        }
        return currentNode.wordEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for(int i = 0 ; i < prefix.length() ; i++)
        {
            int index = prefix.charAt(i)-'a';
            if(currentNode.childNode[index]!=null)
            {
                currentNode=currentNode.childNode[index];
            }
            else return false;
        }
        return true;
    }   
}


public class Main {
    public static void main(String[] args)
    {
        Trie trie = new Trie();
        String[] inputStrings
            = { "and", "ant", "do", "geek", "dad", "ball" };
        // Insert each string into the Trie
        for (String str : inputStrings) {
            trie.insert(str);
        }
        String[] searchQueryStrings
            = { "do", "geek", "bat" };
        // Search for each string and print whether it is
        // found in the Trie
        for (String query : searchQueryStrings) {
            System.out.println("Query String: " + query);
            if (trie.search(query)) {
                System.out.println(
                    "The query string is present in the Trie");
            }
            else {
                System.out.println(
                    "The query string is not present in the Trie");
            }
        }
    }
}
