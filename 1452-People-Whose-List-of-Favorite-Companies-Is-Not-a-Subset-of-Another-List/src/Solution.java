import java.util.*;

/**
 * @author qybit
 * @create 2020-12-21 8:51
 * @Since 1.0.0
 */
public class Solution {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        int n = favoriteCompanies.size();
        for (int i = 0; i < n; i++) {
            // i 不能是 j 的子集
            List<String> list = favoriteCompanies.get(i);
            boolean f = true;
            for (int j = 0; j < n; j++) {
                List<String> list1 = favoriteCompanies.get(j);
                if (i == j || list.size() > list1.size()) continue;
                if (new HashSet<>(list1).containsAll(list)) {
                    f = false;
                    break;
                }
            }
            if (f) res.add(i);
        }
        return res;
    }

}

