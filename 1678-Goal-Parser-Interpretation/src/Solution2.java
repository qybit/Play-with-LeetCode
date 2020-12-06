/**
 * @author qybit
 * @create 2020-12-06 14:23
 * @Since 1.0.0
 */
public class Solution2 {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
