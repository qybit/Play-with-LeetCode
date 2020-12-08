import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-08 10:09
 * @Since 1.0.0
 */
public class Solution {

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] players = new int[n][2];
        for (int i = 0; i < n; i++) {
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }
        // 按年龄升序，分数升序 然后对与每个球员i，在前i个球员中选出任意一个比
        // 当前年龄小而且分数是不大于当前球员的情况下，即可解决矛盾
        Arrays.sort(players, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = players[i][1];
            // 在前 i 个球员中选出比当前球员分数低的球员来避免矛盾
            for (int j = 0; j < i; j++) {
                if (players[j][1] <= players[i][1]) {
                    f[i] = Math.max(f[i], f[j] + players[i][1]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
