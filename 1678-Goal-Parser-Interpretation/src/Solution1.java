/**
 * @author qybit
 * @create 2020-12-06 14:23
 * @Since 1.0.0
 */
public class Solution1 {

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length();) {
            if (command.charAt(i) == 'G') {
                sb.append("G");i++;
            }
            else if (command.charAt(i) == '(' && command.charAt(i+1)==')') {
                sb.append("o");
                i+=2;
            } else {
                sb.append("al");
                i+=4;
            }
        }
        return sb.toString();
    }
}
