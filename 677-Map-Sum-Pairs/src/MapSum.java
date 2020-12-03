/**
 * @author qybit
 * @create 2020-12-03 18:10
 */
public class MapSum {

    public static void main(String[] args) {
        MapSum sum = new MapSum();
        sum.insert("a", 3);
        sum.sum("ap");
        sum.insert("b", 2);
        sum.sum("a");
    }

    static class Trie {
        static class TrieNode {
            boolean isEnd;
            int val;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode root = new TrieNode();

        public void insert(String s, int sum) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.val = sum;
            node.isEnd = true;
        }

        public int query(String s) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.next[c - 'a'] == null) return 0;
                node = node.next[c - 'a'];
            }
            return dfs(node);
        }

        private int dfs(TrieNode node) {
            if (node == null) {
                return 0;
            }
            int sum = node.val;
            for (TrieNode x : node.next) {
                sum += dfs(x);
            }
            return sum;
        }


    }

    /**
     * Initialize your data structure here.
     */
    public MapSum() {

    }

    Trie trie = new Trie();

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        return trie.query(prefix);
    }
}
