class Solution {
    public String reverseParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.addLast(i);
            
            if (c == ')') reverse(chars, stack.pollLast(), i-1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '(' && c != ')') sb.append(c);
        }
        return sb.toString();
    }

    public void reverse(char[] chars, int i, int j) {
        int l = i, r = j;
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
    }
}