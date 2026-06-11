class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int l = 1, r = max;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (!isPossible(piles, mid, h)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if (isPossible(piles, l, h)) {
            return l;
        }
        return -1;
    }

    private boolean isPossible(int[] arr, int k, int h) {
        for (int n : arr) {
            h -= (n + k - 1) / k;
        }
        return h >= 0;
    }
}
