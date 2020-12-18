import java.util.List;
import java.util.Locale;

/**
 * @author qybit
 * @create 2020-12-18 15:36
 * @Since 1.0.0
 */
public class Solution1 {

    static class Trie {
        static class TrieNode {
            boolean isEnd = false;
            TrieNode[] next = new TrieNode[26];

            public TrieNode() {

            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isEnd = true;
        }
        
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c-'a'] == null) return false;
                node =node.next[c-'a'];
            }
            return true;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        Trie trie = new Trie();
        for (String dy : dictionary)  trie.insert(dy);
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            boolean f=  true;
            String word = split[i];
            for (int j = 1; j < word.length(); j++) {
                String sub = word.substring(0, j);
                if (trie.search(sub)) {
                    sb.append(sub).append(" ");
                    f=false;
                    break;
                }
            }
            if (f) sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }


}
