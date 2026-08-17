class Solution {
    public int maxProfit(int[] prices) {
        int cooldown = 0, haveStock = Integer.MIN_VALUE / 4, noStock = 0;
        int max = 0;

        for (int p : prices) {
            int prevHaveStock = haveStock;
            haveStock = Math.max(haveStock, noStock - p);
            noStock = Math.max(noStock, cooldown);
            cooldown = prevHaveStock + p;

            max = Math.max(haveStock, Math.max(noStock, cooldown));
        }

        return max;
    }
}