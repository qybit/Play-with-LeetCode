/**
 * @author qybit
 * @create 2020-12-01 9:33
 */
public class Solution {

    public int findJudge(int N, int[][] trust) {
        // 入度
        int[] in = new int[N+1];
        // 出度
        int[] out = new int[N+1];
        for (int[] t : trust) {
            in[t[1]]++;
            out[t[0]]++;
        }
        // 法官的出度应该是0, 入度是N-1
        for (int i = 1; i <= N; i++) {
            if (out[i] == 0 && in[i] == N-1) {
                return i;
            }
        }
        return -1;
    }
}
