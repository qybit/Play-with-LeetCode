import java.util.HashMap;
import java.util.Map;

/**
 * @author qybit
 * @create 2020-12-16 10:51
 * @Since 1.0.0
 */
public class Solution {

    public boolean wordPattern(String pattern, String s){
        return isPossible1(pattern, s) && isPossible2(s, pattern);
    }

    // word -> char
    private boolean isPossible2(String s, String pattern) {
        String[] split = s.split(" ");
        if (split.length != pattern.length()) return false;
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            char c = pattern.charAt(i);
            if (map.containsKey(word)) {
                if (map.get(word) != c) return false;
            }
            map.put(word, c);
        }
        return true;
    }
    // char -> word
    private boolean isPossible1(String pattern, String s) {
        String[] split = s.split(" ");
        if (split.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) return false;
            }
            map.put(c, word);
        }
        return true;
    }
}
