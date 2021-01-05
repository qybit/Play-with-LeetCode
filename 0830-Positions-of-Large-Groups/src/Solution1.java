class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < s.length(); ){
            int j = i + 1;
            while (i < s.length()&& j < s.length() &&s.charAt(i) == s.charAt(j)) j++;
            if (j - i + 1 > 3) res.add(new ArrayList<>(Arrays.asList(i, j-1)));
            i = j;
        }
        return res;
    }
}