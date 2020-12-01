/**
 * @author qybit
 * @create 2020-12-01 16:48
 */
public class Solution {

    public int rand7() {
        // 此方法由题目给出
        return 0;
    }

    public int rand10() {
        int a = rand7(), b = rand7();
        // 确保不大于7
        while (a == 7) {
            a = rand7();
        }
        // 确保 <= 5
        while (b > 5) {
            b = rand7();
        }
        // 如果 a = 6 时，a=0 否则为5
        return (a % 2 == 1 ? 0 : 5) + b;
    }
}
