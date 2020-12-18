import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qybit
 * @create 2020-12-18 16:58
 * @Since 1.0.0
 */
public class Solution2 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<Long> has =new HashSet<>();
        int p = 131;
        for (String word : dictionary) {
            long h = 0;
            for (char c : word.toCharArray()) h = h * p + c;
            has.add(h);
        }
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : split) {
            long h = 0;
            boolean f = true;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i);
                h = h * p + c;
                if (has.contains(h)) {
                    sb.append(word.substring(0, i+1)).append(" ");
                    f=  false;
                    break;
                }
            }
            if (f) sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }
}
