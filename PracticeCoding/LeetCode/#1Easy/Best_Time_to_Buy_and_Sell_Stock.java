public class Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int cheapestPrice = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (cheapestPrice > prices[i]) {
                cheapestPrice = prices[i];
            } else {
                profit = prices[i] - cheapestPrice;
                if (max < profit) {
                    max = profit;
                }
            }
        }
        return max;
    }
}
