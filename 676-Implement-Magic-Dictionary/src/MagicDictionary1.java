/**
 * @author qybit
 * @create 2020-12-03 16:14
 */
public class MagicDictionary1 {

    static class Trie {
        static class TrieNode {
            boolean isEnd;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.next[c-'a'] == null) {
                    node.next[c-'a'] = new TrieNode();
                }
                node = node.next[c-'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String s) {
//            TrieNode node = root;
//            for (char c: s.toCharArray()) {
//                node = node.next[c-'a'];
//                if (node == null) {
//                    return false;
//                }
//            }
//            return node.isEnd;
            return search(s, 0, 1, root);
        }

        /**
         *
         * @param word 待查单词
         * @param index 索引
         * @param num 修改与否，改或者不改
         * @param root 根节点
         * @return
         */
        private boolean search(String word, int index, int num, TrieNode root) {
            if (num < 0) return false;
            if (index == word.length()) return num==0&&root.isEnd;
            char ch = word.charAt(index);
            int idx = ch - 'a';
            for (int i = 0; i < 26; i++) {
                if (root.next[i] ==null) continue;
                if (index == i) {
                    //不改
                    if (search(word, index + 1, num, root.next[idx])) return true;
                    // 改了
                    else if (search(word, index +1 , num-1, root.next[i])) return true;
                }
            }
            return false;
        }
    }


    Trie trie = new Trie();
    /**
     * Initialize your data structure here.
     */
    public MagicDictionary1() {

    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            trie.insert(word);
        }
    }

    public boolean search(String searchWord) {
        return trie.search(searchWord);
    }
    /*'8
    public boolean search(String searchWord) {
        char[] array = searchWord.toCharArray();
        for (int i = 0; i < searchWord.length(); i++) {
            char c  = searchWord.charAt(i);
            for (char k = 'a'; k < 'z'; k++) {
                if (c == k) continue;
                array[i] = k;
                if (trie.search(String.valueOf(array))) return true;
            }
            array[i] = c;
        }
        return false;
    }*/
}

