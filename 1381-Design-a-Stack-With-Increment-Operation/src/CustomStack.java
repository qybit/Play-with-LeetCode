import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-07 14:30
 * @Since 1.0.0
 */
public class CustomStack {

    int[] data;
    int top = -1;
    int maxSize;

    public CustomStack(int _maxSize) {
        maxSize = _maxSize;
        data = new int[maxSize];
    }

    public void push(int x) {
        if (top == maxSize-1) return;
        data[++top] = x;
        // System.out.println(Arrays.toString(data));
    }

    public int pop() {
        if (top == -1) return -1;
        int res = data[top];
        data[top--] = 0;
        // System.out.println(Arrays.toString(data));
        return res;
    }

    public void increment(int k, int val) {
        for (int i = 0; i <= Math.min(k-1, top); i++) {
            data[i] += val;
        }
        // System.out.println(Arrays.toString(data));
    }
}
