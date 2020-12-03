import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qybit
 * @create 2020-12-03 10:57
 */
public class Solution {

    public static void main(String[] args) {
        String[] s = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        new Solution().longestWord(s);
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        String res = "";
        for (String word : words) {
            if (trie.search(word)) {
                if (word.length() > res.length()) res = word;
                else if (word.length() == res.length() && res.compareTo(word) < 0) res = word;
            }
        }
        return res;
    }


}

class Trie {

    static class TrieNode {
        boolean isEnd;
        TrieNode[] next = new TrieNode[26];

        public boolean containsKey(char c) {
            return next[c - 'a'] != null;
        }

        public void put(char c, TrieNode node) {
            next[c - 'a'] = node;
        }

        public TrieNode get(char c) {
            return next[c - 'a'];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    public boolean search(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.get(c) == null || !node.get(c).isEnd) {
                return false;
            }
            node = node.get(c);
        }
        return node.isEnd;
    }

}
