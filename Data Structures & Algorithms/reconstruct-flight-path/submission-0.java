class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> gph = new HashMap<>();

        for (List<String> tkt : tickets) {
            gph.computeIfAbsent(tkt.get(0), key -> new PriorityQueue<>()).add(tkt.get(1));
        }

        List<String> ans = new ArrayList<>();

        dfs("JFK", gph, ans);

        Collections.reverse(ans);

        return ans;
    }

    private void dfs(String src, Map<String, PriorityQueue<String>> gph, List<String> ans) {
        PriorityQueue<String> paths = gph.get(src);
        
        while (paths != null && !paths.isEmpty()) {
            dfs(paths.poll(), gph, ans);
        }

        ans.add(src);
    }
}