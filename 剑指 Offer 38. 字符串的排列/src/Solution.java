class Solution {

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] used;

    public String[] permutation(String s) {
        used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(chars);
        return res.toArray(new String[res.size()]);
    }


    public void dfs(char[] s) {
        if (sb.length() == s.length) {
            res.add(sb.toString());
            return;
        }
        for (int i  = 0; i < s.length; i++) {
            if (i > 0 && s[i] == s[i-1] && used[i-1]) continue;
            if (!used[i]) {
                used[i] = true;
                sb.append(s[i]);
                dfs(s);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }
}