/**
 * @author qybit
 * @create 2020-12-05 15:50
 * @Since 1.0.0
 */
public class Solution2 {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0 || tasks.length == 1) {
            return tasks.length;
        }
        // 剩余值
        int[] fre = new int[26];
        for (char c : tasks) fre[c - 'A']++;
        // 冷却队列
        int[] flag = new int[26];
        int len = tasks.length;
        int res = 0;
        while (len > 0) {
            int val = 0, best = -1;
            for (int i = 0; i < 26; i++) {
                if (fre[i] == 0 || flag[i] > 0) {
                    continue;
                }
                if (val < fre[i]) {
                    val = fre[i];
                    best = i;
                }
            }
            if (best > -1) {
                fre[best]--;
                flag[best] = n + 1;
                len--;
            }

            for (int i = 0; i < 26; i++) {
                if (flag[i] > 0) flag[i]--;
            }
            res++;
        }
        return res;
    }
}
