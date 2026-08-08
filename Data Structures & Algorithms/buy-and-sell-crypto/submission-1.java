class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int min = prices[0];
        int maxProfit=0;
        for (int i = 0; i<prices.length;i++){
            if(prices[i] < min) {
                min = prices[i];
            }

            int sum = prices[i] - min;

            if(sum>maxProfit){
                maxProfit=sum;
            }

        }
        return maxProfit;
    }
}
