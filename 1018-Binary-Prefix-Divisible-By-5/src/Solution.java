class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int x = 0;
        for (int a : A) {
            x <<= 1;
            x += a;
            x %= 10;
            res.add(x % 5 == 0);
        }
        return res;
    }
}