class Solution {

    class DSU {
        int n;
        int[] f;
        public DSU(int _n) {
            n = _n;
            f = new int[n];
            for (int i = 0; i < n; i++) f[i] = i;
        }
        public int find(int x) {
            if (x != f[x]) {
                f[x] = find(f[x]);
            }
            return f[x];
        }
        public void merge(int x, int y) {
            int fx = find(x), fy = find(y);
            f[fx] = fy;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIdex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int idx = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int sz =account.size();
            for (int i = 1; i < sz; i ++) {
                String email = account.get(i);
                emailToIdex.put(email, idx++);
                emailToName.put(email, name);
            }
        }
        DSU dsu = new DSU(idx);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int index = emailToIdex.get(firstEmail);
            int sz = account.size();
            for (int i = 2; i < sz; i ++) {
                String email = account.get(i);
                int nextIdx = emailToIdex.get(email);
                dsu.merge(index, nextIdx);
            }
        }

        Map<Integer, List<String>> indexToEmail = new HashMap<>();
        for (String email : emailToIdex.keySet()) {
            int index = dsu.find(emailToIdex.get(email));
            List<String> account = indexToEmail.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmail.put(index, account);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : indexToEmail.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            res.add(account);
        }
        return res;
    }
}