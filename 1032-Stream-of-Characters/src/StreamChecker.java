/**
 * @author qybit
 * @create 2020-12-31 17:22
 */
public class StreamChecker {

    static class Trie {
        static class TrieNode {
            boolean isEnd;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode root = new TrieNode();

        public void insert(String s) {
            TrieNode node = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String s) {
            TrieNode node = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (node.next[c-'a'] == null) return false;
                node = node.next[c-'a'];
                if (node.isEnd) return true;
            }
            return false;
        }
    }

    Trie trie = new Trie();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for (String word : words) trie.insert(word);
    }

    public boolean query(char letter) {
        return trie.search(sb.append(letter).toString());
    }
}
