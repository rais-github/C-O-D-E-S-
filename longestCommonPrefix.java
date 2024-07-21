class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        
        Trie t = new Trie();
        for (String s : strs) {
            t.insert(s);
        }
        
        return t.lcp(strs[0], new StringBuilder());
    }
}

class TrieNode {
    TrieNode[] childNode;
    boolean wordEnd;
    int childCount;
    
    public TrieNode() {
        childCount = 0;
        childNode = new TrieNode[26];
        wordEnd = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Function to insert a key into the Trie
    void insert(String key) {
        TrieNode currentNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.childNode[index] == null) {
                currentNode.childCount++;
                currentNode.childNode[index] = new TrieNode();
            }
            currentNode = currentNode.childNode[index];
        }
        currentNode.wordEnd = true;
    }

    // Function to search for the longest common prefix in the Trie
    String lcp(String key, StringBuilder sb) {
        TrieNode currentNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.childCount == 1 && !currentNode.wordEnd) {
                currentNode = currentNode.childNode[index];
                sb.append(key.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
