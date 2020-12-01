import java.util.*;

/**
 * @author qybit
 * @create 2020-12-01 15:11
 */
public class Solution {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = watchedVideos.size();
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.offerLast(id);
        vis[id] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int x = q.pollFirst();
                for (Integer nes : friends[x]) {
                    if (!vis[nes]) {
                        vis[nes] = true;
                        q.offerLast(nes);
                    }
                }
            }
            cnt++;
            if (cnt == level) {
                break;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (Integer x : q) {
            List<String> list = watchedVideos.get(x);
            for (String s : list) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> mm = new ArrayList<>(map.entrySet());
        mm.sort((o1, o2) -> {
            if (Integer.compare(o1.getValue(), o2.getValue()) == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return Integer.compare(o1.getValue(), o2.getValue());
        });
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mm) {
            res.add(entry.getKey());
        }
        return res;
    }
}


