import java.util.LinkedList;

/**
 * @author qybit
 * @create 2020-12-15 9:07
 * @Since 1.0.0
 */
public class RLEIterator {

    int[] arr;
    int index = 0;

    public RLEIterator(int[] arr) {
        this.arr = arr;
    }

    public int next(int n) {
        while (index < arr.length) {
            if (arr[index] <= 0) {
                index += 2;
                continue;
            }
            arr[index] -= n;
            if (arr[index] >= 0) return arr[index+1];
            n = -arr[index];
        }
        return -1;
    }
}
