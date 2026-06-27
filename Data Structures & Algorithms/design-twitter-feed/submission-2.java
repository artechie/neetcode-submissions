class Twitter {
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> followers;
    int cnt;

    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
        cnt = 1;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {tweetId, cnt++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        follow(userId, userId);

        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> Integer.compare(q[2], p[2]));
        
        for (int f : followers.get(userId)) {
            if (tweets.containsKey(f)) {
                List<int[]> t = tweets.get(f);
                pq.add(new int[] {f, t.size() - 1, tweets.get(f).get(t.size() - 1)[1]});
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty() && ans.size() < 10) {
            int[] rem = pq.poll();
            List<int[]> tws = tweets.get(rem[0]);
            int[] tweet = tws.get(rem[1]);

            ans.add(tweet[0]);

            if (--rem[1] >= 0) {
                rem[2] = tws.get(rem[1])[1];
                pq.add(rem);
            }
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers .containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}
