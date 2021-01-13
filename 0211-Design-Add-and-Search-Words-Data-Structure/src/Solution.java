class WordDictionary {

    class Trie{
        class TrieNode {
            boolean isEnd;
            TrieNode[] next = new TrieNode[26];
            public TrieNode get(char c) {return next[c-'a'];}
            public void put(char c, TrieNode node) {next[c-'a'] = node;}
            public boolean has(char c) {return next[c-'a'] != null;}
        }

        TrieNode root = new TrieNode();
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.get(c) == null) node.put(c, new TrieNode());
                node = node.get(c);
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            return dfs(node, word, 0);
        }

        public boolean dfs(TrieNode node, String word, int idx) {
            if (idx >= word.length()) return node.isEnd;
            if (node == null) return false;
            char c = word.charAt(idx);
            if (c != '.') {
                if (node.has(c)) return dfs(node.get(c), word, idx +1);
                return false;
            }
            for (char k = 'a'; k <= 'z'; k++){
                if (node.has(k) && dfs(node.get(k), word, idx+1)) {
                    return true;
                }
            }
            return false;
        }
    }

    Trie trie = new Trie();

    /** Initialize your data structure here. */
    public WordDictionary() {

    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}
