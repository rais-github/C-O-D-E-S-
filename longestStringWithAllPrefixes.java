class Solution {
    public String longestWord(String[] words) {
        Trie t = new Trie();
        for (String word : words) {
            t.insert(word);
        }
        String result = "";
        for (String word : words) {
            if (t.search(word)) {
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }
}

class TrieNode {
    TrieNode[] childNode;
    boolean wordEnd;

    public TrieNode() {
        this.childNode = new TrieNode[26];
        this.wordEnd = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String key) {
        TrieNode currentNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.childNode[index] == null) {
                currentNode.childNode[index] = new TrieNode();
            }
            currentNode = currentNode.childNode[index];
        }
        currentNode.wordEnd = true;
    }

    public boolean search(String key) {
        TrieNode currentNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.childNode[index] == null || !currentNode.childNode[index].wordEnd) {
                return false;
            }
            currentNode = currentNode.childNode[index];
        }
        return true; 
    }
}
