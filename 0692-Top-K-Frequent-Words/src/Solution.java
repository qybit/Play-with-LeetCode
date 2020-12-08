import java.util.*;

/**
 * @author qybit
 * @create 2020-12-03 16:46
 */
public class Solution {

    static class Trie {
        static class TrieNode {
            boolean isEnd;
            int cnt;
            String word;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.word = s;
            node.cnt++;
            node.isEnd = true;
        }

        public int query(String s) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    return 0;
                }
                node = node.next[c - 'a'];
            }
            node.cnt++;
            return node.cnt;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Trie.TrieNode> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.cnt == o2.cnt) return o1.word.compareTo(o2.word);
            return Integer.compare(o2.cnt, o1.cnt);
        }));
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        dfs(trie.root, pq, k);
//        while (!pq.isEmpty()) {
//            System.out.println(pq.poll().word);
//        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(Objects.requireNonNull(pq.poll()).word);
        }
        return res;
    }

    private void dfs(Trie.TrieNode root, PriorityQueue<Trie.TrieNode> pq, int k) {
        if (root == null) return;
        if (root.isEnd) {
            pq.offer(root);
        }
        for (Trie.TrieNode node : root.next) {
            if (node != null) dfs(node, pq, k);
        }
    }
}
