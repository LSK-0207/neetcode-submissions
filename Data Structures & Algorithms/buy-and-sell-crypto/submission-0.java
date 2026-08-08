class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit=0;
        for (int i = 0; i<prices.length;i++){
            if(prices[i] < min) {
                min = prices[i];
            }

            int sum = prices[i] - min;

            if(sum>maxProfit && sum>=0){
                maxProfit=sum;
            }

        }
        return maxProfit;
    }
}
