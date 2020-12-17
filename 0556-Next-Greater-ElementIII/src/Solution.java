/**
 * @author qybit
 * @create 2020-12-17 10:13
 * @Since 1.0.0
 */
public class Solution {

    public int nextGreaterElement(int n) {
        char[] array = String.valueOf(n).toCharArray();
        int i = array.length-2;
        while (i >= 0 && array[i] >= array[i+1])
            i--;
        if (i < 0)
            return -1;
        int j = array.length-1;
        while (j >= 0 && array[j] <= array[i])
            j--;
        swap(array, i, j);
        reverse(array, i+1, array.length-1);
        long res = Long.parseLong(String.valueOf(array));
        if (res > Integer.MAX_VALUE)
            return -1;
        return (int)res;
    }

    private void reverse(char[] array, int x, int y) {
        while (x < y) {
            swap(array, x, y);
            x++;
            y--;
        }
    }

    private void swap(char[] array, int i, int j) {
        char t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
