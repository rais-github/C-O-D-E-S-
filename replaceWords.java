class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        
        // Insert all roots from dictionary into the Trie
        for (String root : dictionary) {
            trie.insert(root);
        }
        
        String[] words = sentence.split(" ");
        StringBuilder replacedSentence = new StringBuilder();
        
        // Replace each word in the sentence with its root if found
        for (String word : words) {
            String root = trie.getShortestRoot(word);
            if (replacedSentence.length() > 0) {
                replacedSentence.append(" ");
            }
            replacedSentence.append(root != null ? root : word);
        }
        
        return replacedSentence.toString();
    }
}

class TrieNode {
    TrieNode[] childNode;
    boolean wordEnd;

    TrieNode() {
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
                currentNode.childNode[index] = new TrieNode();
            }
            currentNode = currentNode.childNode[index];
        }
        currentNode.wordEnd = true;
    }

    // Function to get the shortest root for a given word
    String getShortestRoot(String word) {
        TrieNode currentNode = root;
        StringBuilder root = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentNode.childNode[index] == null) {
                return null;  // No root found
            }
            root.append(word.charAt(i));
            currentNode = currentNode.childNode[index];
            if (currentNode.wordEnd) {
                return root.toString();  // Shortest root found
            }
        }
        return null;  // No root found
    }
}
