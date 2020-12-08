import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qybit
 * @create 2020-12-03 16:31
 */
public class MagicDictionary2 {

    /** Initialize your data structure here. */
    public MagicDictionary2() {

    }

    Set<String> vis = new HashSet<>();

    public void buildDict(String[] dictionary) {
        vis.addAll(Arrays.asList(dictionary));
    }

    public boolean search(String searchWord) {
        char[] array = searchWord.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            for (char k = 'a'; k <= 'z'; k++) {
                array[i] = k;
                if (vis.contains(String.valueOf(array))) return true;
            }
        }
        return false;
    }
}
