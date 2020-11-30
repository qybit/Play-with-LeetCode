import java.util.ArrayList;
import java.util.List;

/**
 * @author qybit
 * @create 2020-11-30 14:39
 */
public class FrontMiddleBackQueue {

    List<Integer> list = new ArrayList<>(5000);

    public FrontMiddleBackQueue() {

    }

    public void pushFront(int val) {
        if (!list.isEmpty()) {
            list.add(0, val);
        } else {
            list.add(val);
        }
    }

    public void pushMiddle(int val) {
        if (list.isEmpty()) {
            list.add(val);
        } else {
            int sz = list.size();
            if (sz % 2 != 0) {
                sz--;
            }
            int t = sz>>1;
            list.add(t, val);
        }
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        if (!list.isEmpty()) {
            return list.remove(0);
        }
        return -1;
    }

    public int popMiddle() {
        if (!list.isEmpty()) {
            int sz = list.size()-1;
            int t = sz>>1;
            return list.remove(t);
        }
        return -1;
    }

    public int popBack() {
        if (!list.isEmpty()) {
            return list.remove(list.size()-1);
        }
        return -1;
    }
}
